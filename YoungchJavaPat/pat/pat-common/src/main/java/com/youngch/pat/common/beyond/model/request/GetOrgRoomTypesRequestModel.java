package com.youngch.pat.common.beyond.model.request;

import lombok.Data;

/**
 * @author: yexudong
 * @Date: 2020/5/27 16:17
 */
@Data
public class GetOrgRoomTypesRequestModel {
    private Long OrgId;
    private String RoomTypeId;
}
