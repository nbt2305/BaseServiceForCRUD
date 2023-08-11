package com.springboot.blog.service.impl;

import com.springboot.blog.dto.request.Comment.CreateCommentDto;
import com.springboot.blog.entity.Comment;
import com.springboot.blog.mapper.CommentMapper;
import com.springboot.blog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;
    @Override
    public Comment create(Object createDto) {
        CreateCommentDto request = (CreateCommentDto) createDto;
        return null;
    }

    @Override
    public Object update(Long commentId, Object updateDto) {
        return null;
    }

    @Override
    public Object getDetail(Long commentId) {
        return null;
    }

    @Override
    public List<Object> getAll() {
        return null;
    }

    @Override
    public void delete(Long commentId) {

    }
}
