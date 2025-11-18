package com.blog.post_service.service;

import com.blog.post_service.entity.Post;
import com.blog.post_service.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository repo;

    public PostServiceImpl(PostRepository repo) {
        this.repo = repo;
    }

    @Override
    public Post create(Post post) {
        return repo.save(post);
    }

    @Override
    public Post getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Post> getByUser(Long userId) {
        return repo.findByUserId(userId);
    }
}
