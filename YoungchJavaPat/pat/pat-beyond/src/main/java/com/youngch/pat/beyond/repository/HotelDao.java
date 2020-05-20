package com.youngch.pat.beyond.repository;


import com.youngch.pat.beyond.domain.Hotel;

/**
 * @author: yexudong
 * @Date: 2020/5/19 17:39
 */
public interface HotelDao {

    void create(Hotel hotel);

    void delete(String hotelId);

    void update(Hotel hotel);

    Hotel get(String hotelId);
}
