package com.youngch.pat.beyond.repository;

import com.youngch.pat.beyond.domain.RoomKeyParameter;
import com.youngch.pat.common.dao.BaseRedisValueDao;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: yexudong
 * @Date: 2020/5/20 8:58
 */
public interface RoomCheckStatusRefreshLockDao extends BaseRedisValueDao<RoomKeyParameter> {

    //room checkIn
    void lock(RoomKeyParameter roomKeyParameter, long timeout, TimeUnit timeUnit);

    void lockAll(List<RoomKeyParameter> roomKeyParameters, long timeout, TimeUnit timeUnit);

    boolean isLocked(RoomKeyParameter roomKeyParameter);

    boolean isAllLocked(List<RoomKeyParameter> roomKeyParameters);

    //room checkOut
    void unlock(RoomKeyParameter roomKeyParameter);

    void unlockAll(List<RoomKeyParameter> roomKeyParameters);

}
