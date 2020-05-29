package com.youngch.pat.common.beyond.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author: yexudong
 * @Date: 2020/5/27 16:20
 */
@Data
public class GetOrgRoomTypesResponseModel {

    @JsonProperty("RoomTypeId")
    private String RoomTypeId;
    @JsonProperty("PhysicalRoomTypeId")
    private String PhysicalRoomTypeId;
    @JsonProperty("RoomTypeName")
    private String RoomTypeName;
    @JsonProperty("Abbreviation")
    private String Abbreviation;
    @JsonProperty("BedCount")
    private int BedCount;
    @JsonProperty("BedTypeId")
    private String BedTypeId;
    @JsonProperty("IsVirtual")
    private Boolean IsVirtual;
    @JsonProperty("BedTypes")
    private BedTypeModel[] BedTypes;
    @JsonProperty("Description")
    private String Description;
    @JsonProperty("ConfiguredInfo")
    private ConfiguredInfoModel ConfiguredInfo;
}
