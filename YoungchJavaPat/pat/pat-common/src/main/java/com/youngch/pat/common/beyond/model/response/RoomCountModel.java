package com.youngch.pat.common.beyond.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RoomCountModel {
    @JsonProperty("RoomTypeId")
    public String RoomTypeId;
    @JsonProperty("RoomType")
    public RoomTypeModel RoomType;
    @JsonProperty("Count")
    public int Count;
    @JsonProperty("DetailCounts")
    public int[] DetailCounts;
    @JsonProperty("OverbookingCount")
    public int OverbookingCount;
}
