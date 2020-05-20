package com.youngch.pat.beyond.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.youngch.pat.beyond.repository.HotelDao;
import com.youngch.pat.beyond.domain.Hotel;
import com.youngch.pat.beyond.dto.HotelParam;
import com.youngch.pat.beyond.service.BeyondConstant;
import com.youngch.pat.beyond.service.HotelService;
import com.youngch.pat.common.utils.mapper.Mapper;
import com.youngch.pat.mapper.BeyondHotelMapper;
import com.youngch.pat.model.BeyondHotel;
import com.youngch.pat.model.BeyondHotelExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author: yexudong
 * @Date: 2020/5/19 15:16
 */
@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private BeyondHotelMapper hotelMapper;

    @Autowired
    private HotelDao hotelDao;

    @Override
    public BeyondHotel create(HotelParam hotelParam) {
        BeyondHotel beyondHotel = new BeyondHotel();
        BeanUtils.copyProperties(hotelParam, beyondHotel);
        beyondHotel.setCreateTime(new Date());
        //查询是否有相同id
        BeyondHotelExample example = new BeyondHotelExample();
        example.createCriteria().andHotelIdEqualTo(hotelParam.getHotelId());
        List<BeyondHotel> beyondHotels = hotelMapper.selectByExample(example);
        if (CollectionUtil.isNotEmpty(beyondHotels)) {
            return beyondHotels.get(0);
        }
        hotelMapper.insert(beyondHotel);
        return beyondHotel;
    }

    @Override
    public List<Hotel> getAll() {
        BeyondHotelExample example = new BeyondHotelExample();
        example.createCriteria().andStatusEqualTo(BeyondConstant.HotelJoinStatus.JOINED.getCode());
        List<BeyondHotel> all = hotelMapper.selectByExample(example);
        if (CollectionUtil.isNotEmpty(all)) {
            List<Hotel> hotels = new ArrayList<>();
            for (BeyondHotel beyondHotel : all) {
                Hotel hotel = Mapper.Default().map(beyondHotel, Hotel.class);
                hotel.setRoomNoList(roomNos2List(beyondHotel.getRoomNos()));
                hotelDao.create(hotel);
                hotels.add(hotel);
            }
            return hotels;
        }
        return null;
    }

    private List<String> roomNos2List(String roomNos) {
        return Arrays.asList(roomNos.split(","));
    }
}
