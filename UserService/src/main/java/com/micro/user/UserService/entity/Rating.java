package com.micro.user.UserService.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {

    private String ratingId;
    private String userId;
    private String hotelId;
    private int ratings;
    private String remark;
    private Hotel hotel;
}
