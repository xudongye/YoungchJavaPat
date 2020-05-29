package com.youngch.pat.common.beyond.model.request;

import lombok.Data;


/**
 * @author: yexudong
 * @Date: 2020/5/26 15:15
 */
@Data
public class SearchOrgWithRoomPriceAndRoomCountRequestModel {
    private String ArriveTime;
    private String DepartureTime;
    private Long[] OrgIds;
    private boolean OnlyOpenedOrg = true;
    private boolean PhysicalRoomTypeOnly;
    private boolean BasicInfoOnly;
    private boolean IncludeDetailCounts = true;
    private boolean IncludePrices = true;
    private boolean IncludeRoomCounts = true;
    private String CheckinType;
    private String[] RoomTypeIds;
    private String[] RoomStatuses;
}
