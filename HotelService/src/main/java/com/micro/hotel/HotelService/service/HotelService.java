package com.micro.hotel.HotelService.service;

import com.micro.hotel.HotelService.entity.Hotel;

import java.util.List;

public interface HotelService {
    Hotel create(Hotel hotel);

    List<Hotel> getAll();

    Hotel get(String id);

}

