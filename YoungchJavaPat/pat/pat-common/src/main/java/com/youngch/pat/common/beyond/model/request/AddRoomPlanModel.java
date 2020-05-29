package com.youngch.pat.common.beyond.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author: yexudong
 * @Date: 2020/4/8 13:36
 */
@Data
public class AddRoomPlanModel {

    @JsonProperty("RoomTypeId")
    private String RoomTypeId;
    @JsonProperty("Count")
    private int Count;
}
