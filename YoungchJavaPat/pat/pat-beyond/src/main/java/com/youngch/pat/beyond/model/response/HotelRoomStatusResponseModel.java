package com.youngch.pat.beyond.model.response;

import lombok.Data;

import java.util.Date;

@Data
public class HotelRoomStatusResponseModel {

    private String RoomNo;
    private String RoomTypeId;
    private String Status;
    private Boolean Locked;
    private Boolean IsActive;
    private Date MaintainBeginTime;
    private Date MaintainEndTime;
    private String MaintainMemo;
}
