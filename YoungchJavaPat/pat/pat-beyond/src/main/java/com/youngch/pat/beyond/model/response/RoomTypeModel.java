package com.youngch.pat.beyond.model.response;

import lombok.Data;

@Data
public class RoomTypeModel {
    public String Id;

    public String RoomTypeName;

    public String Description;

    public String HotelRoomTypeDescription;

    public Integer BedAmount;

    public String BedType;

    public boolean Virtual;

    public String PhysicalRoomTypeId;

    public String Abbreviation;

    public boolean IsActive;

    public String ImageUris;
}
