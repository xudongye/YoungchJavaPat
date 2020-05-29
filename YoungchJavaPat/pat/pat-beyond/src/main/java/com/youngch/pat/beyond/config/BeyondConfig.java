package com.youngch.pat.beyond.config;

import com.youngch.pat.common.beyond.service.BeyondService;
import com.youngch.pat.common.beyond.service.impl.BeyondServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: yexudong
 * @Date: 2020/5/26 11:00
 */
@Configuration
public class BeyondConfig {

    @Bean
    public BeyondService beyondService() {
        return new BeyondServiceImpl();
    }
}
