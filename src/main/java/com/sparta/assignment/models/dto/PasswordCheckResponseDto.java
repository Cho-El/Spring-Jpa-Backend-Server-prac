package com.sparta.assignment.models.dto;

import lombok.Getter;

@Getter
public class PasswordCheckResponseDto {
    private boolean success = true;
    private boolean data;
    private String error = null;
    public PasswordCheckResponseDto(boolean r){
        this.data = r;
    }
}
