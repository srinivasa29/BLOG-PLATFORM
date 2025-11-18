package com.blog.user_service.service;

import com.blog.user_service.entity.User;

public interface UserService {
    User createUser(User user);
    User getUser(Long id);
}
