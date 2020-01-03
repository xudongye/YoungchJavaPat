package com.youngch.pat.beyond.model.response;

import lombok.Data;

@Data
public class RoomPriceModel {
    public String Date;

    public float OrignPrice;

    public float ActualPrice;

    public String RoomTypeId;

    public RoomTypeModel RoomType;

    public int RoomCount;

    public String Description;
}
