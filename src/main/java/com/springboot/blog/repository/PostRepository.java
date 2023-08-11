package com.springboot.blog.repository;

import com.springboot.blog.entity.Post;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends BaseRepository<Post, Long> {
    Post findByTitle(String title);
}
