package com.micro.user.UserService.service;

import com.micro.user.UserService.entity.Hotel;
import com.micro.user.UserService.entity.Rating;
import com.micro.user.UserService.entity.User;
import com.micro.user.UserService.exception.ResourceNotFoundException;
import com.micro.user.UserService.external.services.HotelService;
import com.micro.user.UserService.repo.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

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
        //now using RestTemplate get the ratings given by that particular user from the API Call at RatingService
                                                             // API Call URL                                               kis type ka data chahiy
        Rating[] ratings = restTemplate.getForObject("http://RATINGSERVICE/ratings/user/"+user.getUserId(),Rating[].class );
        logger.info("{} ",ratings);
        //We got all the Ratings given by the user
        List<Rating> ratings1 = Arrays.stream(ratings).toList();
        //now we will itterate the ratings and fetch the hotel ID as well from the Hotel service
       List<Rating> listOfRatings = ratings1.stream().map(rating -> {
           // ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
            //api get call to hotelservice to get hotel
            Hotel hotel =hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            //set hotel to rating
            //return the rating
            return rating;

        }).collect(Collectors.toList());

        user.setRatings(listOfRatings);
        return user;
        //fetch rating for above user from RATING SERVICE
    }
}
