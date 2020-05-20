package com.youngch.pat.mapper;

import com.youngch.pat.model.BeyondHotel;
import com.youngch.pat.model.BeyondHotelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BeyondHotelMapper {
    long countByExample(BeyondHotelExample example);

    int deleteByExample(BeyondHotelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BeyondHotel record);

    int insertSelective(BeyondHotel record);

    List<BeyondHotel> selectByExample(BeyondHotelExample example);

    BeyondHotel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BeyondHotel record, @Param("example") BeyondHotelExample example);

    int updateByExample(@Param("record") BeyondHotel record, @Param("example") BeyondHotelExample example);

    int updateByPrimaryKeySelective(BeyondHotel record);

    int updateByPrimaryKey(BeyondHotel record);
}