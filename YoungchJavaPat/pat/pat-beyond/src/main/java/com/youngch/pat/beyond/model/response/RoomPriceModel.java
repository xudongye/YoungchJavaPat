package com.youngch.pat.beyond.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RoomPriceModel {
    @JsonProperty("Data")
    public String Date;
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
