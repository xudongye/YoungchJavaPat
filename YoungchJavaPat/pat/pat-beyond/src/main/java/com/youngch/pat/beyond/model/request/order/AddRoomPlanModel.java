package com.youngch.pat.beyond.model.request.order;

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
