package com.sparta.assignment.service;

import com.sparta.assignment.dto.CommentRequestDto;
import com.sparta.assignment.dto.ResponseDto;
import com.sparta.assignment.models.Comment;
import com.sparta.assignment.models.Post;
import com.sparta.assignment.repository.CommentRepository;
import com.sparta.assignment.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final PostService postService;
    private final UserService userService;
    @Secured("ROLE_USER")
    @Transactional
    public ResponseDto<?> createComment(Long id, CommentRequestDto commentRequestDto) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isEmpty()) {
            return ResponseDto.fail("NULL_POST_ID", "해당 게시물이 존재하지 않습니다.");
        }
        Post post = optionalPost.get();
        String username = userService.getUsername(); // 현재 사용자 Username 뽑아내기
        Comment comment = new Comment(commentRequestDto, username, post); // Comment 생성
        commentRepository.save(comment); // DB에 저장
        post.addComment(comment);
        return ResponseDto.success(comment);
    }

    public ResponseDto<?> getAllComment(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isEmpty()) {
            return ResponseDto.fail("NULL_POST_ID", "해당 게시물이 존재하지 않습니다.");
        }
        Post post = optionalPost.get();
        return ResponseDto.success(post.getCommentList());
    }

    @Secured("ROLE_USER")
    @Transactional
    public ResponseDto<?> updateComment(Long id, Long commentId, CommentRequestDto commentRequestDto) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isEmpty()) {
            return ResponseDto.fail("NULL_POST_ID", "해당 게시물이 존재하지 않습니다.");
        }
        Optional<Comment> optionalComment = commentRepository.findById(commentId);
        if(optionalComment.isEmpty()){
            return ResponseDto.fail("NULL_COMMENT_ID", "해당 댓글이 존재하지 않습니다.");
        }
        Comment comment = optionalComment.get();
        if(!userService.getUsername().equals(comment.getUsername())){
            return ResponseDto.fail("NOT_YOURS_COMMENT", "해당 댓글 작성자만 수정할 수 있습니다.");
        }
        // post의 comment도 업데이트가 되었는지 테스트 해본다.
        comment.update(commentRequestDto);
        return ResponseDto.success(comment);
    }

    @Secured("ROLE_USER")
    @Transactional
    public ResponseDto<?> deleteComment(Long id, Long commentId) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isEmpty()) {
            return ResponseDto.fail("NULL_POST_ID", "해당 게시물이 존재하지 않습니다.");
        }
        Optional<Comment> optionalComment = commentRepository.findById(commentId);
        if(optionalComment.isEmpty()){
            return ResponseDto.fail("NULL_COMMENT_ID", "해당 댓글이 존재하지 않습니다.");
        }
        Post post = optionalPost.get();
        Comment comment = optionalComment.get();
        if(!userService.getUsername().equals(comment.getUsername())){
            return ResponseDto.fail("NOT_YOURS_COMMENT", "해당 댓글 작성자만 수정할 수 있습니다.");
        }
        post.deleteComment(comment);
        return ResponseDto.success(true);
    }
}
