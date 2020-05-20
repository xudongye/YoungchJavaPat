package com.youngch.pat.beyond.dto;

import java.util.List;

public class ZhuzherOrder {
    private long reserve_order_id;
    private long check_in_id;
    private String room_no;
    private String check_in_date;
    private String check_out_date;
    private int house_type_id;
    private String house_type;
    private int status;
    private List<ZhuzherGuest> guest;

    @Override
    public String toString() {
        return "ZhuzherOrder{" +
                "reserve_order_id=" + reserve_order_id +
                ", check_in_id=" + check_in_id +
                ", room_no='" + room_no + '\'' +
                ", check_in_date='" + check_in_date + '\'' +
                ", check_out_date='" + check_out_date + '\'' +
                ", house_type_id=" + house_type_id +
                ", house_type='" + house_type + '\'' +
                ", status=" + status +
                ", guest=" + guest +
                '}';
    }

    public long getReserve_order_id() {
        return reserve_order_id;
    }

    public void setReserve_order_id(long reserve_order_id) {
        this.reserve_order_id = reserve_order_id;
    }

    public long getCheck_in_id() {
        return check_in_id;
    }

    public void setCheck_in_id(long check_in_id) {
        this.check_in_id = check_in_id;
    }

    public String getRoom_no() {
        return room_no;
    }

    public void setRoom_no(String room_no) {
        this.room_no = room_no;
    }

    public String getCheck_in_date() {
        return check_in_date;
    }

    public void setCheck_in_date(String check_in_date) {
        this.check_in_date = check_in_date;
    }

    public String getCheck_out_date() {
        return check_out_date;
    }

    public void setCheck_out_date(String check_out_date) {
        this.check_out_date = check_out_date;
    }

    public int getHouse_type_id() {
        return house_type_id;
    }

    public void setHouse_type_id(int house_type_id) {
        this.house_type_id = house_type_id;
    }

    public String getHouse_type() {
        return house_type;
    }

    public void setHouse_type(String house_type) {
        this.house_type = house_type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<ZhuzherGuest> getGuest() {
        return guest;
    }

    public void setGuest(List<ZhuzherGuest> guest) {
        this.guest = guest;
    }
}
