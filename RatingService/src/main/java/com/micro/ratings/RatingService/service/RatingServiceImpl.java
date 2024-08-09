package com.micro.ratings.RatingService.service;

import com.micro.ratings.RatingService.entity.Rating;
import com.micro.ratings.RatingService.exception.NoReferenceFound;
import com.micro.ratings.RatingService.repo.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    private RatingRepo repo;

    @Override
    public Rating createRating(Rating rate) {
        String ratingId= UUID.randomUUID().toString();
        rate.setRatingId(ratingId);
        return repo.save(rate);
    }

    @Override
    public List<Rating> getRatings() {
        return repo.findAll();
    }

    @Override
    public List<Rating> getRatingsByUserId(String userId) {
        return repo.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingsByHotelId(String hotelId) {
        return repo.findByHotelId(hotelId);
    }
}
