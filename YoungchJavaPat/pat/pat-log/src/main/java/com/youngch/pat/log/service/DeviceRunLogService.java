package com.youngch.pat.log.service;

import com.youngch.pat.common.dao.PageQueryResult;
import com.youngch.pat.log.model.DeviceRunLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author: yexudong
 * @Date: 2020/4/23 10:16
 */
public interface DeviceRunLogService {

    void save(DeviceRunLog runLog);

    List<DeviceRunLog> query(String devId);

    PageQueryResult<DeviceRunLog> page(String devId, int pageNum, int pageSize);

}
