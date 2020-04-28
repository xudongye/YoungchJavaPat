package com.youngch.pat.log.constant;

import com.youngch.pat.common.utils.enums.EnumName;

/**
 * @author: yexudong
 * @Date: 2020/4/22 13:49
 */
public class LogConstant {

    public enum LogType implements EnumName {

        admin(1, "admin"),
        device(2, "device"),
        wifi_device(3, "wifi_device");

        private int code;

        private String name;

        LogType(int code, String name) {
            this.code = code;
            this.name = name;
        }

        @Override
        public int getCode() {
            return code;
        }

        @Override
        public String getName() {
            return name;
        }
    }
}
