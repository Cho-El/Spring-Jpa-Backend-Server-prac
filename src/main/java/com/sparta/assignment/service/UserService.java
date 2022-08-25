package com.sparta.assignment.service;

import com.sparta.assignment.models.Users;
import com.sparta.assignment.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    // 인증된 사용자 id 뽑기
    public String getUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
