package com.springboot.blog.mapper;


import com.springboot.blog.dto.Base.CommentDto;
import com.springboot.blog.dto.request.Comment.CreateCommentDto;
import com.springboot.blog.dto.request.Post.CreatePostDto;
import com.springboot.blog.dto.request.Post.UpdatePostDto;
import com.springboot.blog.dto.response.Post.ResponseCreatePostDto;
import com.springboot.blog.dto.response.Post.ResponseDetailPostDto;
import com.springboot.blog.dto.response.Post.ResponseUpdatePostDto;
import com.springboot.blog.entity.Comment;
import com.springboot.blog.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Component
public class PostMapper {
    private final ModelMapper modelMapper;
    private final CommentMapper commentMapper;

    public Post convertCreatePostDtoToPost(CreatePostDto request) {
        Post result = modelMapper.map(request, Post.class);
        return result;
    }

    public Post convertUpdatePostDtoToPost(UpdatePostDto request) {
        Post result = modelMapper.map(request, Post.class);
        return result;
    }

    public ResponseCreatePostDto convertPostToResponseCreatePostDto(Post request) {
        ResponseCreatePostDto result = modelMapper.map(request, ResponseCreatePostDto.class);
        return result;
    }

    public ResponseUpdatePostDto convertPostToResponseUpdatePostDto(Post request, List<Comment> comments) {
        ResponseUpdatePostDto result = modelMapper.map(request, ResponseUpdatePostDto.class);
        List<CommentDto> commentDtoList = comments.stream().map(this.commentMapper::convertCommentToCommentDto).collect(Collectors.toList());
        result.setComments(commentDtoList);
        return result;
    }

    public ResponseDetailPostDto convertPostToResponseDetailPostDto(Post request, List<Comment> comments) {
        ResponseDetailPostDto result = modelMapper.map(request, ResponseDetailPostDto.class);
        List<CommentDto> commentDtoList = comments.stream().map(this.commentMapper::convertCommentToCommentDto).collect(Collectors.toList());
        result.setComments(commentDtoList);
        return result;
    }

//    public ResponseDetailPostDto convertPostToResponseDetailPostDto(Post request, List<Comment> comments) {
//        ResponseDetailPostDto result = modelMapper.map(request, ResponseDetailPostDto.class);
//        List<CommentDto> commentDtoList = comments.stream().map(this.commentMapper::convertCommentToCommentDto).collect(Collectors.toList());
//        result.setComments(commentDtoList);
//        return result;
//    }
}
