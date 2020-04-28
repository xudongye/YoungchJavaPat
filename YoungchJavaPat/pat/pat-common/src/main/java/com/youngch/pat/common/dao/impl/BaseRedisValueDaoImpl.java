package com.youngch.pat.common.dao.impl;


import com.youngch.pat.common.dao.BaseRedisValueDao;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;


public abstract class BaseRedisValueDaoImpl<K> extends BaseRedisDaoImpl<K, String> implements BaseRedisValueDao<K> {
    protected ValueOperations<String, String> getOps() {
        return redisTemplate.opsForValue();
    }

    @Override
    public void set(K key, String value) {
        getOps().set(convertKey(key), value);
    }

    @Override
    public void set(K key, String value, long timeout, TimeUnit unit) {
        getOps().set(convertKey(key), value, timeout, unit);
    }

    @Override
    public String get(K key) {
        return String.valueOf(getOps().get(convertKey(key)));
    }
}
