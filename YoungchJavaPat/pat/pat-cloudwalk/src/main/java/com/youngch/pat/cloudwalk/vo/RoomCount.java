package com.youngch.pat.cloudwalk.vo;

import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * @author: yexudong
 * @Date: 2020/5/26 16:11
 */
@Data
@AllArgsConstructor
public class RoomCount {
    private RoomType roomType;
    private int count;
    private int[] detailCounts;
    private int overbookingCount;
}
