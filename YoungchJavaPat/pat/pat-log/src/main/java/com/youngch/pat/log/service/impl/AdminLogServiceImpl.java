package com.youngch.pat.log.service.impl;

import com.youngch.pat.log.service.AdminLogService;
import com.youngch.pat.log.model.AdminLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * @author: yexudong
 * @Date: 2020/4/22 13:30
 */
@Service
public class AdminLogServiceImpl implements AdminLogService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminLogServiceImpl.class);

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void saveLog(AdminLog log) {
        mongoTemplate.save(log);
        LOGGER.info("[管理员日志]：{}", log.getContents());
    }
}
