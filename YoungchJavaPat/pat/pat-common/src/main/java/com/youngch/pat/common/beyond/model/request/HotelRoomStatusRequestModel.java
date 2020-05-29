package com.youngch.pat.common.beyond.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HotelRoomStatusRequestModel {
    @JsonProperty("OrgId")
    private Long OrgId;
    @JsonProperty("RoomNos")
    private String[] RoomNos;
}
