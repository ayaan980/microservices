package com.micro.user.UserService.service;

import com.micro.user.UserService.entity.Rating;
import com.micro.user.UserService.entity.User;
import com.micro.user.UserService.exception.ResourceNotFoundException;
import com.micro.user.UserService.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

   private Logger logger=  LoggerFactory.getLogger(UserServiceImp.class);

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
        //get single user from db
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException());
        ArrayList<Rating> ratings = restTemplate.getForObject("http://localhost:8082/ratings/user/"+user.getUserId(), ArrayList.class);
        logger.info("{} ",ratings);
        user.setRatings(ratings);
        return user;
        //fetch rating for above user from RATING SERVICE
    }
}
