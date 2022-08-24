package com.sparta.assignment.controller;


import com.sparta.assignment.dto.PasswordDto;
import com.sparta.assignment.dto.PostRequestDto;
import com.sparta.assignment.dto.ResponseDto;
import com.sparta.assignment.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @PostMapping("/api/post")
    public ResponseDto<?> createPost(@RequestBody PostRequestDto requestDto) {
        return postService.createPost(requestDto);
    }

    @GetMapping("/api/post/{id}")
    public ResponseDto<?> getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @GetMapping("/api/post")
    public ResponseDto<?> getAllPosts() {
        return postService.getAllPost();
    }

    @PutMapping("/api/post/{id}")
    public ResponseDto<?> updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto) {
        return postService.updatePost(id, postRequestDto);
    }

    @DeleteMapping("/api/post/{id}")
    public ResponseDto<?> deletePost(@PathVariable Long id) {
        return postService.deletePost(id);
    }

    @PostMapping("/api/post/{id}")
    public ResponseDto<?> validateAuthorByPassword(@PathVariable Long id, @RequestBody PasswordDto password) {
        return postService.validateAuthorByPassword(id, password);
    }

}
