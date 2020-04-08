package com.youngch.pat.beyond.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class HotelRoomStatusResponseModel {
    @JsonProperty("RoomNo")
    private String RoomNo;
    @JsonProperty("RoomTypeId")
    private String RoomTypeId;
    @JsonProperty("Status")
    private String Status;
    @JsonProperty("Locked")
    private Boolean Locked;
    @JsonProperty("IsActive")
    private Boolean IsActive;
    @JsonProperty("MaintainBeginTime")
    private Date MaintainBeginTime;
    @JsonProperty("MaintainEndTime")
    private Date MaintainEndTime;
    @JsonProperty("MaintainMemo")
    private String MaintainMemo;
}
