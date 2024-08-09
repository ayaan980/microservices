package com.micro.ratings.RatingService.service;

import com.micro.ratings.RatingService.entity.Rating;

import java.util.List;

public interface RatingService {

    Rating createRating(Rating rate);

    List<Rating> getRatings();

    List<Rating> getRatingsByUserId(String userId);

    List<Rating> getRatingsByHotelId(String hotelId);



}
