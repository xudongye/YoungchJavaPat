package com.youngch.pat.beyond.constant;

import com.youngch.pat.common.base.utils.enums.EnumName;

public class BeyondConstant {

    public enum BeyondMethod implements EnumName {
        Hotel_SearchHotelWithRoomPriceAndRoomCount(1, "Hotel.SearchHotelWithRoomPriceAndRoomCount"),//查询酒店房量房价
        Hotel_GetOrgInfo(2, "Hotel.GetOrgInfo"),//查询某个酒店信息
        Hotel_GetOrgs(3, "Hotel.GetOrgs"),//查询酒店信息
        ;

        private int code;

        private String name;

        BeyondMethod(int code, String name) {
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
