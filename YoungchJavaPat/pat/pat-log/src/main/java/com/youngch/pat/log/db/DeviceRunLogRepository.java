package com.youngch.pat.log.db;

import com.youngch.pat.log.model.DeviceRunLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: yexudong
 * @Date: 2020/4/23 14:21
 */
@Repository
public interface DeviceRunLogRepository extends MongoRepository<DeviceRunLog, String> {

    List<DeviceRunLog> findByDevId(String devId);
}
