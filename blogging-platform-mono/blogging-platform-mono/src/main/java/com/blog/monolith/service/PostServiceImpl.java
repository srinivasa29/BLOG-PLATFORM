package com.blog.monolith.service;

import com.blog.monolith.entity.Post;
import com.blog.monolith.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository repo;

    public PostServiceImpl(PostRepository repo) {
        this.repo = repo;
    }

    @Override
    public Post createPost(Post post) {
        return repo.save(post);
    }

    @Override
    public Post getPost(Long id) {
        return repo.findById(id).orElse(null);
    }
}
