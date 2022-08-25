package com.sparta.innovation03.controller;

import com.sparta.innovation03.dto.PostRequestDto;
import com.sparta.innovation03.dto.ResponseDto;
import com.sparta.innovation03.dto.passwordDto;
import com.sparta.innovation03.service.PostService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    private final PostService postService;

    @PostMapping({"/api/post"})
    public ResponseDto<?> createPost(@RequestBody PostRequestDto requestDto) {
        return this.postService.createPost(requestDto);
    }

    @GetMapping({"/api/post/{id}"})
    public ResponseDto<?> getPost(@PathVariable Long id) {
        return this.postService.getPost(id);
    }

    @GetMapping({"/api/post"})
    public ResponseDto<?> getAllPosts() {
        return this.postService.getAllPost();
    }

    @PutMapping({"/api/post/{id}"})
    public ResponseDto<?> updatePost(@PathVariable Long id, @RequestBody PostRequestDto postRequestDto) {
        return this.postService.updatePost(id, postRequestDto);
    }

    @DeleteMapping({"/api/post/{id}"})
    public ResponseDto<?> deletePost(@PathVariable Long id) {
        return this.postService.deletePost(id);
    }

    @PostMapping({"/api/post/{id}"})
    public ResponseDto<?> validateAuthorByPassword(@PathVariable Long id, @RequestBody passwordDto password) {
        return this.postService.validateAuthorByPassword(id, password);
    }

    public PostController(final PostService postService) {
        this.postService = postService;
    }
}

