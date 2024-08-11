package com.micro.ratings.RatingService.controller;

import com.micro.ratings.RatingService.entity.Rating;
import com.micro.ratings.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {


    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> createRatings(@RequestBody Rating rating) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getRatings(){
          return ResponseEntity.ok(ratingService.getRatings());
    }

    @GetMapping("/user/{userID}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userID){
        return ResponseEntity.ok(ratingService.getRatingsByUserId(userID));
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
        return ResponseEntity.ok(ratingService.getRatingsByHotelId(hotelId));
    }




}
