package com.blog.monolith.service;

import com.blog.monolith.entity.Post;

public interface PostService {
    Post createPost(Post post);
    Post getPost(Long id);
}
