package com.youngch.pat.common.dao;

import java.util.concurrent.TimeUnit;


public interface BaseRedisValueDao<K> extends BaseRedisDao<K> {
    void set(K key, String value);

    void set(K key, String value, long timeout, TimeUnit unit);

    String get(K key);
}
