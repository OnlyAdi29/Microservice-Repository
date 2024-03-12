package com.rating.service;

import com.rating.entity.Rating;

import java.util.List;

public interface RatingService {


    Rating saveRating(Rating rating);


    List<Rating> getAllRatings();

    List<Rating> getRatingByUserId(String userId);

    List<Rating> getRatingByHotelId(String hotelId);
}
