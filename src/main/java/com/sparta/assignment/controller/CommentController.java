package com.sparta.assignment.controller;

import com.sparta.assignment.dto.CommentRequestDto;
import com.sparta.assignment.dto.PasswordDto;
import com.sparta.assignment.dto.PostRequestDto;
import com.sparta.assignment.dto.ResponseDto;
import com.sparta.assignment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/post/")
public class CommentController {
    private final CommentService commentService;

    // 댓글 작성
    @PostMapping("/{id}")
    public ResponseDto<?> createComment(@PathVariable Long id, @RequestBody CommentRequestDto commentRequestDto){
        return commentService.createComment(id, commentRequestDto);
    }

    // 댓글 목록 조회
    @GetMapping("/{id}")
    public ResponseDto<?> getAllComment(@PathVariable Long id){
        return commentService.getAllComment(id);
    }
    // 댓글 수정
    @PutMapping("/{id}/{commentId}")
    public ResponseDto<?> updateComment(@PathVariable Long id,  @PathVariable Long commentId, @RequestBody CommentRequestDto commentRequestDto){
        return commentService.updateComment(id, commentId, commentRequestDto);
    }

    // 댓글 삭제
    @DeleteMapping("/{id}/{commentId}")
    public ResponseDto<?> deleteComment(@PathVariable Long id, @PathVariable Long commentId) {
        return commentService.deleteComment(id, commentId);
    }


}
