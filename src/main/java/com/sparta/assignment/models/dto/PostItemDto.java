package com.sparta.assignment.models.dto;

import com.sparta.assignment.models.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostItemDto {
    private String title;
    private String username;
    private LocalDateTime createdAt;

    public PostItemDto(Post post) {
        this.title = post.getTitle();
        this.username = post.getUsername();
        this.createdAt = post.getCreatedAt();
    }
}
