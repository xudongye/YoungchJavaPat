package com.youngch.pat.cloudwalk.service;

import com.youngch.pat.cloudwalk.vo.Liaison;
import lombok.Data;

/**
 * @author: yexudong
 * @Date: 2020/6/1 11:22
 */
@Data
public class OrderParam {

    private String checkInType;

    private String hotelId;

    private String estimatedArriveTime;

    private String estimatedDepartureTime;

    private String memberId;

    private Liaison[] liaisons;

    private String expireKeepTime;


}
