package com.blog.monolith.service;

import com.blog.monolith.entity.Comment;
import com.blog.monolith.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repo;

    public CommentServiceImpl(CommentRepository repo) {
        this.repo = repo;
    }

    @Override
    public Comment addComment(Comment c) {
        return repo.save(c);
    }

    @Override
    public List<Comment> getCommentsByPost(Long postId) {
        return repo.findByPostId(postId);
    }
}
