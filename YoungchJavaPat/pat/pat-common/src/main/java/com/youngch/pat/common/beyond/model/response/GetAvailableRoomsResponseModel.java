package com.youngch.pat.common.beyond.model.response;

import cn.hutool.core.date.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author: yexudong
 * @Date: 2020/5/25 14:17
 */
@Data
public class GetAvailableRoomsResponseModel {
    @JsonProperty("RoomTypeId")
    private String RoomTypeId;
    @JsonProperty("RoomNumber")
    private String RoomNumber;
    @JsonProperty("Status")
    private String Status;
    @JsonProperty("IsActive")
    private Boolean IsActive;
    @JsonProperty("Attribute")
    private String Attribute;
    @JsonProperty("HallId")
    private long HallId;
    @JsonProperty("FloorId")
    private long FloorId;
    @JsonProperty("FloorName")
    private String FloorName;
    @JsonProperty("FLoorNumericaName")
    private int FLoorNumericaName;
    @JsonProperty("LastModifiedUtcTime")
    private Date LastModifiedUtcTime;
    @JsonProperty("MaintainBeginTime")
    private Date MaintainBeginTime;
    @JsonProperty("MaintainEndTime")
    private Date MaintainEndTime;
    @JsonProperty("Locked")
    private Boolean Locked;
    @JsonProperty("Description")
    private String Description;
    @JsonProperty("MaintainMemo")
    private String MaintainMemo;
    @JsonProperty("CanNetOpen")
    private Boolean CanNetOpen;
    @JsonProperty("ImageUris")
    private String ImageUris;
    @JsonProperty("PanoramicSite")
    private String PanoramicSite;
}
