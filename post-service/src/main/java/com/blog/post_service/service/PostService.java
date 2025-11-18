package com.blog.post_service.service;

import com.blog.post_service.entity.Post;
import java.util.List;

public interface PostService {
    Post create(Post post);
    Post getById(Long id);
    List<Post> getByUser(Long userId);
}
