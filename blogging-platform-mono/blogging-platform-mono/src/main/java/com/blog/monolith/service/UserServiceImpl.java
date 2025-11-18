package com.blog.monolith.service;

import com.blog.monolith.entity.User;
import com.blog.monolith.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public User createUser(User user) {
        return repo.save(user);
    }

    @Override
    public User getUser(Long id) {
        return repo.findById(id).orElse(null);
    }
}
