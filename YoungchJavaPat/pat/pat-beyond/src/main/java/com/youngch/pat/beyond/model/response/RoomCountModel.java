package com.youngch.pat.beyond.model.response;

import lombok.Data;

@Data
public class RoomCountModel {
    public String RoomTypeId;

    public RoomTypeModel RoomType;

    public int Count;

    public int[] DetailCounts;

    public int OverbookingCount;
}
