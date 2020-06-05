package com.youngch.pat.mapper;

import com.youngch.pat.model.PmsOrder;
import com.youngch.pat.model.PmsOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PmsOrderMapper {
    long countByExample(PmsOrderExample example);

    int deleteByExample(PmsOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PmsOrder record);

    int insertSelective(PmsOrder record);

    List<PmsOrder> selectByExample(PmsOrderExample example);

    PmsOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PmsOrder record, @Param("example") PmsOrderExample example);

    int updateByExample(@Param("record") PmsOrder record, @Param("example") PmsOrderExample example);

    int updateByPrimaryKeySelective(PmsOrder record);

    int updateByPrimaryKey(PmsOrder record);
}