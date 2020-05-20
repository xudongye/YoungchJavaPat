package com.youngch.pat.beyond.domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: yexudong
 * @Date: 2020/5/19 16:10
 */
public class Hotel implements Serializable {
    private Long id;

    private String hotelName;

    private String hotelId;

    private Date createTime;

    private Integer status;

    private List<String> roomNoList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<String> getRoomNoList() {
        return roomNoList;
    }

    public void setRoomNoList(List<String> roomNoList) {
        this.roomNoList = roomNoList;
    }
}
