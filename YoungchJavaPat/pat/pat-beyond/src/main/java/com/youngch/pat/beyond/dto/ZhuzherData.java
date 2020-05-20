package com.youngch.pat.beyond.dto;

import java.util.List;

public class ZhuzherData {
    private String hotel_id;
    private String order_id;
    private String reserve_member_id;
    private String reserve_name;
    private String reserve_tel;
    private String reserve_email;
    private List<ZhuzherOrder> order;

    public String getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(String hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getReserve_member_id() {
        return reserve_member_id;
    }

    public void setReserve_member_id(String reserve_member_id) {
        this.reserve_member_id = reserve_member_id;
    }

    public String getReserve_name() {
        return reserve_name;
    }

    public void setReserve_name(String reserve_name) {
        this.reserve_name = reserve_name;
    }

    public String getReserve_tel() {
        return reserve_tel;
    }

    public void setReserve_tel(String reserve_tel) {
        this.reserve_tel = reserve_tel;
    }

    public String getReserve_email() {
        return reserve_email;
    }

    public void setReserve_email(String reserve_email) {
        this.reserve_email = reserve_email;
    }

    public List<ZhuzherOrder> getOrder() {
        return order;
    }

    public void setOrder(List<ZhuzherOrder> order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "ZhuzherData{" +
                "hotel_id=" + hotel_id +
                ", order_id=" + order_id +
                ", reserve_member_id='" + reserve_member_id + '\'' +
                ", reserve_name='" + reserve_name + '\'' +
                ", reserve_tel='" + reserve_tel + '\'' +
                ", reserve_email='" + reserve_email + '\'' +
                ", order=" + order +
                '}';
    }
}
