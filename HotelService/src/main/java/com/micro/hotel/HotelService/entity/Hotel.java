package com.micro.hotel.HotelService.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "hotels")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

    @Id
    @Column(name ="Hotel_ID")
    private String id;

    @Column(name ="Hotel_name")
    private String name;

    @Column(name ="LOCATION")
    private String location;

    @Column(name="About")
    private String about;
}
