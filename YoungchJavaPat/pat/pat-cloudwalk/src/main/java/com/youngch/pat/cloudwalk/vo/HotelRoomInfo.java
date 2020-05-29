package com.youngch.pat.cloudwalk.vo;

import lombok.Data;

/**
 * @author: yexudong
 * @Date: 2020/5/27 11:20
 */
@Data
public class HotelRoomInfo {

    private String hotelName;
    private String brand;
    private String address;
    private String phone;
    private String fax;
    private int star;
    private String description;

    private String[] serviceTags;
    private String[] imageUris;
    private String[] panoramicPics;

    private RoomCount[] roomCounts;
    private RoomPrice[] roomPrices;
    private RoomPrice[] lowestRoomPrices;


}
