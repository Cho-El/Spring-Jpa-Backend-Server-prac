package com.sparta.assignment.models.dto;

import lombok.Getter;

@Getter
public class PostRequestDto {
    private String title;
    private String password;
    private String contents;
    private String username;
}
