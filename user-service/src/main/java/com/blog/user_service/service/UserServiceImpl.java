package com.blog.user_service.service;


import com.blog.user_service.entity.User;
import com.blog.user_service.repository.UserRepository;
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