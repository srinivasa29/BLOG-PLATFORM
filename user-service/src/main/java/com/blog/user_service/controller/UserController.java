package com.blog.user_service.controller;
import com.blog.user_service.entity.User;
import com.blog.user_service.service.UserService;
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
    public ResponseEntity<User> create(@RequestBody User user) {
        return ResponseEntity.ok(service.createUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Long id) {
        User u = service.getUser(id);
        return u != null ? ResponseEntity.ok(u) : ResponseEntity.notFound().build();
    }
}
