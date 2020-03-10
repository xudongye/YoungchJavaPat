package com.youngch.pat.dao;

import com.youngch.pat.entity.ChatServer;
import com.youngch.pat.entity.ChatServerCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ChatServerMapper {
    long countByExample(ChatServerCriteria example);

    int deleteByExample(ChatServerCriteria example);

    int deleteByPrimaryKey(Long id);

    int insert(ChatServer record);

    int insertSelective(ChatServer record);

    List<ChatServer> selectByExampleWithRowbounds(ChatServerCriteria example, RowBounds rowBounds);

    List<ChatServer> selectByExample(ChatServerCriteria example);

    ChatServer selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ChatServer record, @Param("example") ChatServerCriteria example);

    int updateByExample(@Param("record") ChatServer record, @Param("example") ChatServerCriteria example);

    int updateByPrimaryKeySelective(ChatServer record);

    int updateByPrimaryKey(ChatServer record);
}