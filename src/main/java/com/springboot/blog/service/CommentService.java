package com.springboot.blog.service;

import com.springboot.blog.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService extends BaseService<Comment, Long> {
}
