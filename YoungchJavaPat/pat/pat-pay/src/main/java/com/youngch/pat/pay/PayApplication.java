package com.youngch.pat.pay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: yexudong
 * @Date: 2020/6/2 15:32
 */
@SpringBootApplication
public class PayApplication {

    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        SpringApplication.run(PayApplication.class, args);
    }
}
