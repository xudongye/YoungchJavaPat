package com.youngch.pat.chat.service.impl;

import com.youngch.pat.chat.service.ChatServerService;
import com.youngch.pat.dao.ChatServerMapper;
import com.youngch.pat.entity.ChatServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author: yexudong
 * @Date: 2020/1/14 17:06
 */
@Service
public class ChatServerServiceImpl implements ChatServerService {

    @Autowired
    private ChatServerMapper chatServerMapper;

    @Override
    public ChatServer findById(Long id) {
        return chatServerMapper.selectByPrimaryKey(id);
    }
}
