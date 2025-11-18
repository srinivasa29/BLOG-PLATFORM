package com.blog.comment_service.service;

import com.blog.comment_service.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment create(Comment comment);
    List<Comment> getByPost(Long postId);
}
