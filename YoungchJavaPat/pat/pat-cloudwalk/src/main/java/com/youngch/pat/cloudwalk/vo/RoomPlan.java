package com.youngch.pat.cloudwalk.vo;

import lombok.Data;

/**
 * @author: yexudong
 * @Date: 2020/6/1 15:31
 */
@Data
public class RoomPlan {
    private String[] roomNos;
    private String roomTypeId;
    private int count;
    private RoomPrice[] prices;
}
