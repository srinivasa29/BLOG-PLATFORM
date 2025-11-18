package com.blog.comment_service.service;

import com.blog.comment_service.entity.Comment;
import com.blog.comment_service.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repo;

    public CommentServiceImpl(CommentRepository repo) {
        this.repo = repo;
    }

    @Override
    public Comment create(Comment comment) {
        return repo.save(comment);
    }

    @Override
    public List<Comment> getByPost(Long postId) {
        return repo.findByPostId(postId);
    }
}
