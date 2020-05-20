package com.youngch.pat.beyond.repository.impl;

import com.youngch.pat.beyond.repository.HotelDao;
import com.youngch.pat.beyond.domain.Hotel;
import com.youngch.pat.common.dao.impl.BaseRedisJsonHashDaoImpl;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

/**
 * @author: yexudong
 * @Date: 2020/5/19 17:42
 */
@Repository
public class HotelDaoImpl extends BaseRedisJsonHashDaoImpl<String, Hotel> implements HotelDao {

    private static final String HOTEL_KEY = "beyond:hotel:{{hotelId}}";


    @Override
    protected Class<Hotel> getEntityClass() {
        return Hotel.class;
    }

    @Override
    public void create(Hotel hotel) {
        super.setEntity(hotel.getHotelId(), hotel);
        super.expire(hotel.getHotelId(), 7, TimeUnit.DAYS);
    }

    @Override
    public void update(Hotel hotel) {
        super.setEntity(hotel.getHotelId(), hotel);
    }

    @Override
    public Hotel get(String hotelId) {
        return super.getEntity(hotelId);
    }

    @Override
    protected String convertKey(String key) {
        return HOTEL_KEY.replace("{{hotelId}}", key);
    }

}
