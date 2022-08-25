package com.sparta.innovation03.service;

import com.sparta.innovation03.dto.PostRequestDto;
import com.sparta.innovation03.dto.ResponseDto;
import com.sparta.innovation03.dto.passwordDto;
import com.sparta.innovation03.entity.Post;
import com.sparta.innovation03.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public ResponseDto<?> createPost(PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        this.postRepository.save(post);
        return ResponseDto.success(post);
    }

    @Transactional(
            readOnly = true
    )
    public ResponseDto<?> getPost(Long id) {
        Optional<Post> optionalPost = this.postRepository.findById(id);
        return optionalPost.isEmpty() ? ResponseDto.fail("NULL_POST_ID", "post id isn't exist") : ResponseDto.success((Post)optionalPost.get());
    }

    @Transactional(
            readOnly = true
    )
    public ResponseDto<?> getAllPost() {
        return ResponseDto.success(this.postRepository.findAllByOrderByModifiedAtDesc());
    }

    @Transactional
    public ResponseDto<Post> updatePost(Long id, PostRequestDto requestDto) {
        Optional<Post> optionalPost = this.postRepository.findById(id);
        if (optionalPost.isEmpty()) {
            return ResponseDto.fail("NULL_POST_ID", "post id isn't exist");
        } else {
            Post post = (Post)optionalPost.get();
            post.update(requestDto);
            return ResponseDto.success(post);
        }
    }

    @Transactional
    public ResponseDto<?> deletePost(Long id) {
        Optional<Post> optionalPost = this.postRepository.findById(id);
        if (optionalPost.isEmpty()) {
            return ResponseDto.fail("NOT_FOUND", "post id is not exist");
        } else {
            Post post = (Post)optionalPost.get();
            this.postRepository.delete(post);
            return ResponseDto.success(true);
        }
    }

    @Transactional(
            readOnly = true
    )
    public ResponseDto<?> validateAuthorByPassword(Long id, passwordDto password) {
        Optional<Post> optionalPost = this.postRepository.findById(id);
        if (optionalPost.isEmpty()) {
            return ResponseDto.fail("NOT_FOUND", "post id is not exist");
        } else {
            Post post = (Post)optionalPost.get();
            return !post.getPassword().equals(password.getPassword()) ? ResponseDto.fail("PASSWORD_NOT_CORRECT", "password is not correct") : ResponseDto.success(true);
        }
    }

    public PostService(final PostRepository postRepository) {
        this.postRepository = postRepository;
    }
}

