package com.youngch.pat.beyond.repository.impl;

import com.youngch.pat.beyond.repository.RoomCheckStatusRefreshLockDao;
import com.youngch.pat.beyond.domain.RoomKeyParameter;
import com.youngch.pat.common.dao.impl.BaseRedisValueDaoImpl;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author: yexudong
 * @Date: 2020/5/20 9:00
 */
@Repository
public class RoomCheckStatusRefreshLockDaoImpl extends BaseRedisValueDaoImpl<RoomKeyParameter> implements RoomCheckStatusRefreshLockDao {

    private static final String ROOM_KEY = "beyond:hotel:{{hotelId}}:room:{{roomNo}}";

    @Override
    public void lock(RoomKeyParameter roomKeyParameter, long timeout, TimeUnit timeUnit) {
        this.set(roomKeyParameter, RoomCheckStatusRefreshLockDaoImpl.getRightNow(), timeout, timeUnit);
    }

    @Override
    public void lockAll(List<RoomKeyParameter> roomKeyParameters, long timeout, TimeUnit timeUnit) {
        if (!roomKeyParameters.isEmpty()) {
            lock(getWholeLockKey(roomKeyParameters.get(0)), timeout, timeUnit);
        }
    }

    @Override
    public boolean isLocked(RoomKeyParameter roomKeyParameter) {
        return this.isAllLocked(getRoomKeyParameters(roomKeyParameter)) || this.hasKey(roomKeyParameter);
    }

    @Override
    public boolean isAllLocked(List<RoomKeyParameter> roomKeyParameters) {
        return !roomKeyParameters.isEmpty() && this.hasKey(getWholeLockKey(roomKeyParameters.get(0)));
    }

    @Override
    public void unlock(RoomKeyParameter roomKeyParameter) {
        this.delete(roomKeyParameter);
    }

    @Override
    public void unlockAll(List<RoomKeyParameter> roomKeyParameters) {
        if (!roomKeyParameters.isEmpty()) {
            unlock(getWholeLockKey(roomKeyParameters.get(0)));
        }

        for (RoomKeyParameter roomKeyParameter : roomKeyParameters) {
            unlock(roomKeyParameter);
        }
    }

    @Override
    protected String convertKey(RoomKeyParameter key) {
        return ROOM_KEY.replace("{{hotelId}}", key.getHotelId()).replace("{{roomNo}}", key.getRoomNo());
    }

    public static String getRightNow() {
        return DateFormatUtils.format(System.currentTimeMillis(), DateFormatUtils.ISO_DATETIME_FORMAT.getPattern());
    }

    private RoomKeyParameter getWholeLockKey(RoomKeyParameter roomKeyParameter) {
        return new RoomKeyParameter(roomKeyParameter.getHotelId(), 0 + "");
    }

    private List<RoomKeyParameter> getRoomKeyParameters(RoomKeyParameter roomKeyParameter) {
        List<RoomKeyParameter> parameters = new ArrayList<>(1);
        parameters.add(roomKeyParameter);
        return parameters;
    }
}
