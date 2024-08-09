package com.micro.user.UserService.service;

import com.micro.user.UserService.entity.User;
import com.micro.user.UserService.exception.ResourceNotFoundException;
import com.micro.user.UserService.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public User saveUser(User user) {
        //generate Unique user id
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getUser(String userId) {
        return userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException());
    }
}
