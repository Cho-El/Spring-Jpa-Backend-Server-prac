package com.sparta.assignment.dto;

import com.sparta.assignment.models.UserRoleEnum;
import com.sparta.assignment.models.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    private String username;

    private String password;

    private String passwordConfirm;

    public Users toUser(PasswordEncoder passwordEncoder) {
        return Users.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .role(UserRoleEnum.ROLE_USER)
                .build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(username, password);
    }
}