package com.blog.post_service.controller;

import com.blog.post_service.entity.Post;
import com.blog.post_service.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Post> create(@RequestBody Post post) {
        return ResponseEntity.ok(service.create(post));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> get(@PathVariable Long id) {
        Post p = service.getById(id);
        return p != null ? ResponseEntity.ok(p) : ResponseEntity.notFound().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Post>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getByUser(userId));
    }
}
