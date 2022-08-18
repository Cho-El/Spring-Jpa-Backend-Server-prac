package com.sparta.assignment.controller;

import com.sparta.assignment.models.Post;
import com.sparta.assignment.models.PostRepository;
import com.sparta.assignment.models.dto.PasswordCheckResponseDto;
import com.sparta.assignment.models.dto.PasswordRequestDto;
import com.sparta.assignment.models.dto.PostItemDto;
import com.sparta.assignment.models.dto.PostRequestDto;
import com.sparta.assignment.service.PostService;
import com.sparta.assignment.utils.AllPostsGet;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostRestController {

    private final PostRepository postRepository;
    private final PostService postService;
    private final AllPostsGet allPostsGet;

    // 게시글 작성
    @PostMapping("/api/posts")
    public Post createPost(@RequestBody PostRequestDto requestDto) {
        Post product = new Post(requestDto);
        return postRepository.save(product);
    }

    // 전체 게시글 목록 조회 - 제목, 작성자명, 작성 날짜
    @GetMapping("/api/posts")
    public List<PostItemDto> getAllPosts() {
        return allPostsGet.postsItems();
    }

    // 게시글 조회
    @GetMapping("/api/posts/{id}")
    public Post getPosts(@PathVariable Long id) {
        return postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다.")
        );
    }
    // 게시글 수정
    @PutMapping("/api/posts/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody PostRequestDto requestDto){
        return postService.update(id, requestDto);
    }
    // 게시글 삭제
    @DeleteMapping("/api/posts/{id}")
    public Long deletePost(@PathVariable Long id){
        postRepository.deleteById(id);
        return id;
    }
    // 게시글 비밀번호 확인
    @PostMapping("api/posts/{id}")
    public PasswordCheckResponseDto passwordCheck(@PathVariable Long id, @RequestBody PasswordRequestDto requestDto){
        return new PasswordCheckResponseDto(postService.passwordCheck(id, requestDto));
    }
}
