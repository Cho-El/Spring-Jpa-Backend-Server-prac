package com.sparta.assignment.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sparta.assignment.dto.PostRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(nullable = false)
    private String author;

    @JsonIgnore
    @Column(nullable = false)
    private String password;


    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)  //부모가 삭제될 때 자식들도 다 삭제되는 어노테이션
    @JsonManagedReference //DB연관관계 무한회귀 방지
    private List<Comment> commentList;

    public Post(PostRequestDto postRequestDto) {
        this.title = postRequestDto.getTitle();
        this.content = postRequestDto.getContent();
        this.author = postRequestDto.getAuthor();
        this.password = postRequestDto.getPassword();
    }
    public void addComment(Comment comment){
        this.commentList.add(comment);
    }
    public void deleteComment(Comment comment){
        commentList.remove(comment);
        // commentId로 받고 commentList.removeIf(comment -> comment.getId().equals(commentId)); 해도 제거는 된다.
    }
    public void update(PostRequestDto postRequestDto) {
        this.title = postRequestDto.getTitle();
        this.content = postRequestDto.getContent();
        this.author = postRequestDto.getAuthor();
        this.password = postRequestDto.getPassword();
    }

}
