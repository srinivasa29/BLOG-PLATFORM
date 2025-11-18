package com.blog.comment_service.controller;

import com.blog.comment_service.dto.CommentDTO;
import com.blog.comment_service.entity.Comment;
import com.blog.comment_service.service.CommentService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService service;

    public CommentController(CommentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Comment> create(@Valid @RequestBody CommentDTO dto) {

        Comment c = new Comment();
        c.setPostId(dto.getPostId());
        c.setUserId(dto.getUserId());
        c.setContent(dto.getContent());

        return ResponseEntity.ok(service.create(c));
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<Comment>> getByPost(@PathVariable Long postId) {
        return ResponseEntity.ok(service.getByPost(postId));
    }
}
