package com.youngch.pat.cloudwalk.vo;

import lombok.Data;

/**
 * @author: yexudong
 * @Date: 2020/5/27 14:12
 */
@Data
public class RoomTypeInfo {

    private String roomTypeId;
    private String roomTypeName;
    private int bedAmount;
    private float originPrice;
    private float actualPrice;
    private String abbreviation;
    private String[] imageUris;
    private int residueCount;

}
