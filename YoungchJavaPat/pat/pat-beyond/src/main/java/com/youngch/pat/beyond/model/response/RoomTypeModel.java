package com.youngch.pat.beyond.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RoomTypeModel {
    @JsonProperty("Id")
    public String Id;
    @JsonProperty("RoomTypeName")
    public String RoomTypeName;
    @JsonProperty("Description")
    public String Description;
    @JsonProperty("HotelRoomTypeDescription")
    public String HotelRoomTypeDescription;
    @JsonProperty("BedAmount")
    public Integer BedAmount;
    @JsonProperty("BedType")
    public String BedType;
    @JsonProperty("Virtual")
    public boolean Virtual;
    @JsonProperty("PhysicalRoomTypeId")
    public String PhysicalRoomTypeId;
    @JsonProperty("Abbreviation")
    public String Abbreviation;
    @JsonProperty("IsActive")
    public boolean IsActive;
    @JsonProperty("ImageUris")
    public String ImageUris;
}
