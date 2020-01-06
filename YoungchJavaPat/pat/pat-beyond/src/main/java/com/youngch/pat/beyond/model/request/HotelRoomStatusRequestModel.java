package com.youngch.pat.beyond.model.request;

import lombok.Data;

@Data
public class HotelRoomStatusRequestModel {
    private Long OrgId;
    private String[] RoomNos;
}
