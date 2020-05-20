package com.youngch.pat.beyond.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author: yexudong
 * @Date: 2020/4/21 14:38
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.youngch.pat.mapper", "com.youngch.pat.beyond.dao"})
public class MyBatisConfig {
}
