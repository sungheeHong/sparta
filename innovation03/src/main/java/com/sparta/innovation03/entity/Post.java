package com.sparta.innovation03.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.innovation03.dto.PostRequestDto;

import javax.persistence.*;

@Entity
public class Post extends Timestamped {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column(
            nullable = false
    )
    private String title;
    @Column(
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String content;
    @Column(
            nullable = false
    )
    private String author;
    @JsonIgnore
    @Column(
            nullable = false
    )
    private String password;

    public Post(PostRequestDto postRequestDto) {
        this.title = postRequestDto.getTitle();
        this.content = postRequestDto.getContent();
        this.author = postRequestDto.getAuthor();
        this.password = postRequestDto.getPassword();
    }

    public void update(PostRequestDto postRequestDto) {
        this.title = postRequestDto.getTitle();
        this.content = postRequestDto.getContent();
        this.author = postRequestDto.getAuthor();
        this.password = postRequestDto.getPassword();
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getPassword() {
        return this.password;
    }

    public Post() {
    }

    public Post(final Long id, final String title, final String content, final String author, final String password) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.password = password;
    }
}

