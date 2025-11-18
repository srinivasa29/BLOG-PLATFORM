package com.blog.monolith.service;

import com.blog.monolith.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment addComment(Comment c);
    List<Comment> getCommentsByPost(Long postId);
}
