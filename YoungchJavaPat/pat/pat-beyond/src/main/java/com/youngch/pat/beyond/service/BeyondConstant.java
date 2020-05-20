package com.youngch.pat.beyond.service;

import com.youngch.pat.common.utils.enums.EnumName;

/**
 * @author: yexudong
 * @Date: 2020/5/19 15:26
 */
public class BeyondConstant {

    public enum HotelJoinStatus implements EnumName {

        JOINED(1, "已介入"),

        UNJOINED(2, "未介入");

        HotelJoinStatus(int code, String name) {
            this.code = code;
            this.name = name;
        }

        private int code;

        private String name;

        @Override
        public int getCode() {
            return this.code;
        }

        @Override
        public String getName() {
            return this.name;
        }
    }
}
