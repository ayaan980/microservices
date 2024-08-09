package com.micro.hotel.HotelService.service;

import com.micro.hotel.HotelService.entity.Hotel;
import com.micro.hotel.HotelService.exception.NoReferenceFound;
import com.micro.hotel.HotelService.repo.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepo hotelRepo;


    @Override
    public Hotel create(Hotel hotel) {
        String hotelID= UUID.randomUUID().toString();
        hotel.setId(hotelID);
        return hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepo.findAll();
    }

    @Override
    public Hotel get(String id) {
        return hotelRepo.findById(id).orElseThrow(() -> new NoReferenceFound());
    }
}
