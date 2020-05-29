package com.youngch.pat.cloudwalk.vo;

import lombok.Data;


/**
 * @author: yexudong
 * @Date: 2020/5/26 16:07
 */
@Data
public class RoomType {

    private String roomTypeName;
    private String description;
    private int bedAmount;
    private String bedType;
    private Boolean isActive;
    private String[] imageUris;



}
