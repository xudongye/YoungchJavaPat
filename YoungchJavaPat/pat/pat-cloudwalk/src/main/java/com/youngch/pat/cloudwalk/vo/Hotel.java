package com.youngch.pat.cloudwalk.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: yexudong
 * @Date: 2020/5/26 10:46
 */
@Data
public class Hotel {

    private String hotelId;
    private String hotelName;
    private String hotelBrand;
    private String hotelAddress;
    private String hotelPhone;
    private String hotelDesc;
    private Long hotelStar;
    private float longitude;
    private float latitude;
    private String[] serviceTags;
    private String[] imageUris;
    private String[] panoramicPics;
    private String cityName;

}
