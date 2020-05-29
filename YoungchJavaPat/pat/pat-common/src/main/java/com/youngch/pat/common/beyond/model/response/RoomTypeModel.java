package com.youngch.pat.common.beyond.model.response;

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
    @JsonProperty("OrgRoomTypeDescription")
    public String OrgRoomTypeDescription;
    @JsonProperty("BedAmount")
    public int BedAmount;
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
