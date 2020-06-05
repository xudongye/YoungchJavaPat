package com.youngch.pat.pay.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author: yexudong
 * @Date: 2020/6/4 16:04
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.youngch.pat.mapper", "com.youngch.pat.pay.dao"})
public class MybatisConfig {

}
