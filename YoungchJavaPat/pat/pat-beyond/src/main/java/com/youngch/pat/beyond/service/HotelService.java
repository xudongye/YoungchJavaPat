package com.youngch.pat.beyond.service;

import com.youngch.pat.beyond.domain.Hotel;
import com.youngch.pat.beyond.dto.HotelParam;
import com.youngch.pat.model.BeyondHotel;

import java.util.List;

/**
 * @author: yexudong
 * @Date: 2020/5/19 15:05
 */
public interface HotelService {

    BeyondHotel create(HotelParam hotelParam);


    List<Hotel> getAll();


}
