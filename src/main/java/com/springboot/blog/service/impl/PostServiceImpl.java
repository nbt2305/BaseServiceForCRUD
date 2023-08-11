package com.springboot.blog.service.impl;

import com.springboot.blog.common.exception.RecordAlreadyExistedException;
import com.springboot.blog.common.exception.RecordNotFoundException;
import com.springboot.blog.dto.Base.CommentDto;
import com.springboot.blog.dto.request.Post.CreatePostDto;
import com.springboot.blog.dto.request.Post.UpdatePostDto;
import com.springboot.blog.dto.response.Post.ResponseCreatePostDto;
import com.springboot.blog.dto.response.Post.ResponseDetailPostDto;
import com.springboot.blog.dto.response.Post.ResponseUpdatePostDto;
import com.springboot.blog.entity.Comment;
import com.springboot.blog.entity.Post;
import com.springboot.blog.mapper.CommentMapper;
import com.springboot.blog.mapper.PostMapper;
import com.springboot.blog.repository.CommentRepository;
import com.springboot.blog.repository.PostRepository;
import com.springboot.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    private final PostMapper postMapper;
    private final CommentMapper commentMapper;

    @Override
    public ResponseCreatePostDto create(Object createDto) {
        CreatePostDto request = (CreatePostDto) createDto;
        Post foundPost = this.postRepository.findByTitle(request.getTitle());
        if (foundPost != null) {
            throw new RecordAlreadyExistedException("Post not found!");
        }
        Post savePost = this.postMapper.convertCreatePostDtoToPost(request);
        this.postRepository.save(savePost);
        ResponseCreatePostDto response = this.postMapper.convertPostToResponseCreatePostDto(savePost);
        return response;
    }

    @Override
    public ResponseUpdatePostDto update(Long postId, Object updateDto) {
        UpdatePostDto request = (UpdatePostDto) updateDto;
        // Check Object existed!
        Post foundPost = this.postRepository.findById(postId).orElseThrow(() -> new RecordAlreadyExistedException("Post not found!"));
        Post updatePost = this.postMapper.convertUpdatePostDtoToPost(request);
        updatePost.setId(foundPost.getId());
        List<Comment> comments = this.commentRepository.findAllByPost(updatePost);
        updatePost.setComments(comments);
        this.postRepository.save(updatePost);
        ResponseUpdatePostDto result = this.postMapper.convertPostToResponseUpdatePostDto(updatePost, comments);
        return result;
    }

    @Override
    public ResponseDetailPostDto getDetail(Long postId) {
        Post foundPost = this.postRepository.findById(postId).orElseThrow(() -> new RecordNotFoundException("Post not found!"));
        List<Comment> comments = this.commentRepository.findAllByPost(foundPost);
        ResponseDetailPostDto result = this.postMapper.convertPostToResponseDetailPostDto(foundPost, comments);
        return result;
    }

    @Override
    public List<Object> getAll() {
        return null;
    }

    @Override
    public void delete(Long aLong) {

    }
}
