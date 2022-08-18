package com.sparta.assignment.service;

import com.sparta.assignment.models.Post;
import com.sparta.assignment.models.PostRepository;
import com.sparta.assignment.models.dto.PasswordRequestDto;
import com.sparta.assignment.models.dto.PostRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;
    @Transactional
    public Long update(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        post.update(requestDto);
        return id;
    }

    public boolean passwordCheck(Long id, PasswordRequestDto requestDto){
        Post post = postRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        if (post.getPassword().equals(requestDto.getPassword())){
            return true;
        }
        return false;
    }


}
