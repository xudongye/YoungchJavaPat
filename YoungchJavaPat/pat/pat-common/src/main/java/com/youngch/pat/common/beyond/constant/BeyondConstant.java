package com.youngch.pat.common.beyond.constant;

import com.youngch.pat.common.utils.enums.EnumName;

public class BeyondConstant {

    public enum BeyondMethod implements EnumName {
        Hotel_SearchHotelWithRoomPriceAndRoomCount(1, "Hotel.SearchHotelWithRoomPriceAndRoomCount"),//查询酒店房量房价
        Hotel_GetOrgInfo(2, "Hotel.GetOrgInfo"),//查询某个酒店信息
        Hotel_GetOrgs(3, "Hotel.GetOrgs"),//查询酒店信息
        Hotel_GetRoomStatus(4, "Hotel.GetRoomStatus"),
        Order_Add(5, "Order.Add"),
        Order_Query_CheckIns(6, "Order.QueryCheckins"),
        Hotel_GetAvailableRooms(7, "Hotel.GetAvailableRooms"),
        Hotel_SearchOrgWithRoomPriceAndRoomCount(8, "Hotel.SearchOrgWithRoomPriceAndRoomCount"),
        Hotel_GetOrgRoomTypes(9, "Hotel.GetOrgRoomTypes"),
        Hotel_GetMemberHourRentPrice(10, "Hotel.GetMemberHourRentPrice"),
        Member_SearchMembers(11, "Member.SearchMembers"),
        Order_QueryOrders(12, "Order.QueryOrders"),
        Order_QuerySingleOrder(13, "Order.QuerySingleOrder"),
        Order_AddCheckin(14, "Order.AddCheckin");

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

    public enum RoomStatus implements EnumName {
        VD(1, "空脏"),
        VC(2, "空净"),
        OOO(3, "维修房"),
        OD(4, "住脏"),
        OC(5, "住净");

        private int code;

        private String name;

        RoomStatus(int code, String name) {
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
