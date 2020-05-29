package com.youngch.pat.cloudwalk.vo;

import lombok.Data;

import java.util.List;

/**
 * @author: yexudong
 * @Date: 2020/5/26 10:29
 */
@Data
public class Room {

    private String roomTypeId;

    private String roomNo;
    private String status;
    private Boolean isActive;
    private String floorNo;
    private String[] imageUris;
    private String[] panoramicPics;

}
