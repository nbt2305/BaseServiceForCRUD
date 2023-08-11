package com.springboot.blog.dto.response.Post;

import com.springboot.blog.dto.Base.CommentDto;
import com.springboot.blog.dto.Base.PostDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUpdatePostDto extends PostDto {
    private List<CommentDto> comments;
}
