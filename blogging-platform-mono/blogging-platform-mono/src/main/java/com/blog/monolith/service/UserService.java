package com.blog.monolith.service;

import com.blog.monolith.entity.User;

public interface UserService {
    User createUser(User user);
    User getUser(Long id);
}
