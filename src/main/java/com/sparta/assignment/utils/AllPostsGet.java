package com.sparta.assignment.utils;

import com.sparta.assignment.models.Post;
import com.sparta.assignment.models.PostRepository;
import com.sparta.assignment.models.dto.PostItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class AllPostsGet {
    private final PostRepository postRepository;
    public List<PostItemDto> postsItems(){
        List<Post> postList = postRepository.findAllByOrderByCreatedAtDesc();
        List<PostItemDto> itemDtoList = new ArrayList<>();
        for (int i = 0; i < postList.size(); i++){
            Post temp = postList.get(i);
            PostItemDto postItemDto = new PostItemDto(temp);
            itemDtoList.add(postItemDto);
        }
        return itemDtoList;
    }
//    public boolean PasswordCheck(){
//
//    }
}
