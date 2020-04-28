package com.youngch.pat.log.service;

import com.youngch.pat.log.model.AdminLog;

/**
 * @author: yexudong
 * @Date: 2020/4/22 13:29
 */
public interface AdminLogService {

    void saveLog(AdminLog logDto);
}
