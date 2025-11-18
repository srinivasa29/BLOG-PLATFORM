package com.blog.monolith.controller;

import com.blog.monolith.dto.CommentDTO;
import com.blog.monolith.entity.Comment;
import com.blog.monolith.entity.Post;
import com.blog.monolith.entity.User;
import com.blog.monolith.service.CommentService;
import com.blog.monolith.service.PostService;
import com.blog.monolith.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private final CommentService commentService;
    private final UserService userService;
    private final PostService postService;

    public CommentController(CommentService commentService, UserService userService, PostService postService) {
        this.commentService = commentService;
        this.userService = userService;
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<?> addComment(@RequestBody CommentDTO dto) {

        User user = userService.getUser(dto.getUserId());
        if (user == null) return ResponseEntity.badRequest().body("Invalid userId");

        Post post = postService.getPost(dto.getPostId());
        if (post == null) return ResponseEntity.badRequest().body("Invalid postId");

        Comment c = new Comment();
        c.setText(dto.getText());
        c.setUser(user);
        c.setPost(post);

        return ResponseEntity.ok(commentService.addComment(c));
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<?> getComments(@PathVariable Long postId) {
        return ResponseEntity.ok(commentService.getCommentsByPost(postId));
    }
}
