package com.sparta.assignment.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sparta.assignment.dto.CommentRequestDto;
import com.sparta.assignment.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Comment extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String username;

    // fjeijfiejfie
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "POST_ID", nullable = false)
    private Post post;

    public Comment(CommentRequestDto commentRequestDto, String username, Post post){
        this.content = commentRequestDto.getContent();
        this.username = username;
        this.post = post;
    }
    public void update(CommentRequestDto commentRequestDto) {
        this.content = commentRequestDto.getContent();
    }
}
