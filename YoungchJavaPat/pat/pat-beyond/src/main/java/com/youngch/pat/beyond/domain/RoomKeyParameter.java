package com.youngch.pat.beyond.domain;

/**
 * @author: yexudong
 * @Date: 2020/5/20 9:05
 */
public class RoomKeyParameter {
    private String hotelId;
    private String roomNo;

    public RoomKeyParameter() {
    }

    public RoomKeyParameter(String hotelId, String roomNo) {
        this.hotelId = hotelId;
        this.roomNo = roomNo;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }
}
