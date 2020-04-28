package com.youngch.pat.log.service.impl;

import com.youngch.pat.common.dao.PageQueryResult;
import com.youngch.pat.log.db.DeviceRunLogRepository;
import com.youngch.pat.log.service.DeviceRunLogService;
import com.youngch.pat.log.model.DeviceRunLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.domain.Sort.by;

/**
 * @author: yexudong
 * @Date: 2020/4/23 10:17
 */
@Service
public class DeviceRunLogServiceImpl implements DeviceRunLogService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeviceRunLogServiceImpl.class);

    @Autowired
    private DeviceRunLogRepository repository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void save(DeviceRunLog runLog) {
        repository.save(runLog);
        LOGGER.info("[设备运行中]：{} , {}", runLog.getDevId(), runLog.getPropertyValue());
    }

    @Override
    public List<DeviceRunLog> query(String devId) {
        return repository.findByDevId(devId);
    }

    @Override
    public PageQueryResult<DeviceRunLog> page(String devId, int pageNum, int pageSize) {
        Query query = new Query();
        query.with(by(Sort.Direction.DESC, "createTime"));
        if (devId != null) {
            query.addCriteria(Criteria.where("devId").is(devId));
        }
        query.skip((pageNum - 1) * pageSize).limit(pageSize);
        long count = mongoTemplate.count(query, DeviceRunLog.class);
        List<DeviceRunLog> deviceRunLogs = mongoTemplate.find(query, DeviceRunLog.class);
        return new PageQueryResult<>(pageNum, pageNum, deviceRunLogs, count);
    }
}
