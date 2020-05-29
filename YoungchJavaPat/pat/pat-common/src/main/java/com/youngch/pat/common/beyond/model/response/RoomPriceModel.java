package com.youngch.pat.common.beyond.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class RoomPriceModel {
    @JsonProperty("Date")
    public java.util.Date Date;
    @JsonProperty("OrignPrice")
    public float OrignPrice;
    @JsonProperty("ActualPrice")
    public float ActualPrice;
    @JsonProperty("RoomTypeId")
    public String RoomTypeId;
    @JsonProperty("RoomType")
    public RoomTypeModel RoomType;
    @JsonProperty("RoomCount")
    public int RoomCount;
    @JsonProperty("Description")
    public String Description;
}
