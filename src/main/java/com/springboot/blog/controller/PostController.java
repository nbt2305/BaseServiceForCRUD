package com.springboot.blog.controller;


import com.springboot.blog.common.BaseResponse;
import com.springboot.blog.dto.request.Post.CreatePostDto;
import com.springboot.blog.dto.request.Post.UpdatePostDto;
import com.springboot.blog.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
@Slf4j
public class PostController {
    private final PostService postService;

    @PostMapping("/create")
    public BaseResponse<?> create(@RequestBody CreatePostDto request) {
        log.info("Create post");
        return BaseResponse.created(postService.create(request));
    }

    @PutMapping("/update/{id}")
    public BaseResponse<?> update(@PathVariable("id") Long id, @RequestBody UpdatePostDto request) {
        log.info("Update post");
        return BaseResponse.created(postService.update(id, request));
    }

    @GetMapping("/get-detail/{id}")
    public BaseResponse<?> getDetail(@PathVariable("id") Long id) {
        log.info("Get detail post");
        return BaseResponse.created(postService.getDetail(id));
    }
}
