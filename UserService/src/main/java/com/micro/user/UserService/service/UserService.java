package com.micro.user.UserService.service;

import com.micro.user.UserService.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> getAllUser();

    User getUser(String userId);
}
