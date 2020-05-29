package com.youngch.pat.cloudwalk.vo;

import lombok.Data;


/**
 * @author: yexudong
 * @Date: 2020/5/26 15:27
 */
@Data
public class RoomPrice {
    private String date;
    private float originPrice;
    private float actualPrice;
    private int roomCount;
    private String description;
}
