package com.youngch.pat.cloudwalk.constant;

import com.youngch.pat.common.utils.enums.EnumName;

/**
 * @author: yexudong
 * @Date: 2020/5/26 10:40
 */
public class CloudWalkConstant {

    public enum CheckInType implements EnumName {
        Normal(1, "Normal"),
        LongTerm(2, "LongTerm"),
        Trip(3, "Trip"),
        Conference(4, "Conference"),
        Free(5, "Free");

        private int code;

        private String name;

        CheckInType(int code, String name) {
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
