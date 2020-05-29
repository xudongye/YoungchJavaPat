package com.youngch.pat.common.beyond.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author: yexudong
 * @Date: 2020/5/25 14:13
 */
@Data
public class GetAvailableRoomsRequestModel {

    @JsonProperty("OrgId")
    private Long OrgId;
    @JsonProperty("RoomTypeIds")
    private String[] RoomTypeIds;
    @JsonProperty("RoomStatuses")
    private String[] RoomStatuses;
    @JsonProperty("ArriveTime")
    private String ArriveTime;
    @JsonProperty("DepartureTime")
    private String DepartureTime;
    @JsonProperty("CheckinType")
    private String CheckinType;

}
