package com.sparta.innovation03.dto;

public class PostRequestDto {
    private String title;
    private String content;
    private String author;
    private String password;

    public PostRequestDto() {
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

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
}
