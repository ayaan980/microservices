package com.micro.ratings.RatingService.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Table(name = "ratings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

    @Id
    @Column(name="Rating_ID")
    private String ratingId;

    @Column(name="User_id")
    private String userId;

    @Column(name="hotel_ID")
    private String hotelId;

    @Column(name="Rating")
    private int ratings;

    @Column(name="Remark")
    private String remark;
}
