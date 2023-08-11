package com.springboot.blog.mapper;


import com.springboot.blog.dto.Base.CommentDto;
import com.springboot.blog.dto.Base.PostDto;
import com.springboot.blog.dto.request.Comment.CreateCommentDto;
import com.springboot.blog.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
public class CommentMapper {
    private final ModelMapper modelMapper;

    public Comment convertCreateCommentDtoToComment(CreateCommentDto request){
        Comment result = modelMapper.map(request, Comment.class);
        return result;
    }

    public CommentDto convertCommentToCommentDto(Comment request){
        CommentDto result = modelMapper.map(request, CommentDto.class);
        return result;
    }
}
