package com.blog.monolith.controller;

import com.blog.monolith.dto.UserDTO;
import com.blog.monolith.entity.User;
import com.blog.monolith.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setBio(dto.getBio());
        return ResponseEntity.ok(service.createUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = service.getUser(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }
}
