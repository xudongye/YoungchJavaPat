package com.youngch.pat.mapper;

import com.youngch.pat.model.PayConfig;
import com.youngch.pat.model.PayConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PayConfigMapper {
    long countByExample(PayConfigExample example);

    int deleteByExample(PayConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PayConfig record);

    int insertSelective(PayConfig record);

    List<PayConfig> selectByExample(PayConfigExample example);

    PayConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PayConfig record, @Param("example") PayConfigExample example);

    int updateByExample(@Param("record") PayConfig record, @Param("example") PayConfigExample example);

    int updateByPrimaryKeySelective(PayConfig record);

    int updateByPrimaryKey(PayConfig record);
}