package com.blog.monolith.controller;

import com.blog.monolith.dto.PostDTO;
import com.blog.monolith.entity.Post;
import com.blog.monolith.entity.User;
import com.blog.monolith.service.PostService;
import com.blog.monolith.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;
    private final UserService userService;

    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody PostDTO dto) {
        User author = userService.getUser(dto.getAuthorId());
        if (author == null) return ResponseEntity.badRequest().body("Invalid authorId");

        Post post = new Post();
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setAuthor(author);

        return ResponseEntity.ok(postService.createPost(post));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable Long id) {
        Post post = postService.getPost(id);
        return post != null ? ResponseEntity.ok(post) : ResponseEntity.notFound().build();
    }
}
