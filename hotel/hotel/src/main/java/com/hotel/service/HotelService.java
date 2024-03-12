package com.hotel.service;

import com.hotel.entity.Hotel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HotelService {
    Hotel saveHotel(Hotel hotel);

    List<Hotel> getAllHotel();

    Hotel getHotelById(String hotelId);
}
