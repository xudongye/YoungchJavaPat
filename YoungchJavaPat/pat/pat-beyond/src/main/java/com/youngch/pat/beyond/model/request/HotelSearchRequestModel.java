package com.youngch.pat.beyond.model.request;

import lombok.Data;

@Data
public class HotelSearchRequestModel {

    private String ArriveTime;

    private String DepartureTime;

    private long[] HotelIds;

    private String HotelName;

    private String[]OrgSns;

    private String CityId;

    private String DistrictId;

    private Integer Star;

    private String CommercialLocationId;

    private float Latitude;

    private float Longitude;

    private Integer Distance;

    private String[] ServiceTags;

    private boolean OnlyOpenedHotel;

    private String CheckinType;

    private String[] RoomTypeIds;

    private String[] RoomStatuses;

    private String[] MemberLevels;

    private boolean PhysicalRoomTypeOnly;

    private boolean BasicInfoOnly;

    private boolean IncludeDetailCounts;

    private boolean IncludePrices;

    private boolean IncludeRoomCounts;

    private String RateCode;

    private String[] ContractorLevels;

    private String SearchType;

    private OrderByRequestModel[] OrderByRequests;

    private Integer PageSize;

    private Integer PageIndex;
}
