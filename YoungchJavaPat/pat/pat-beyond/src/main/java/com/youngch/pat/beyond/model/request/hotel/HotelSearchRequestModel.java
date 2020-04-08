package com.youngch.pat.beyond.model.request.hotel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class HotelSearchRequestModel {
    @JsonProperty("ArriveTime")
    private Date ArriveTime;
    @JsonProperty("DepartureTime")
    private Date DepartureTime;
    @JsonProperty("OrgIds")
    private Long[] OrgIds;
    @JsonProperty("OrgName")
    private String OrgName;
    @JsonProperty("OrgSns")
    private String[] OrgSns;
    @JsonProperty("CityId")
    private String CityId;
    @JsonProperty("DistrictId")
    private String DistrictId;
    @JsonProperty("Star")
    private Integer Star;
    @JsonProperty("CommercialLocationId")
    private String CommercialLocationId;
    @JsonProperty("Latitude")
    private float Latitude;
    @JsonProperty("Longitude")
    private float Longitude;
    @JsonProperty("Distance")
    private Integer Distance;
    @JsonProperty("ServiceTags")
    private String[] ServiceTags;
    @JsonProperty("OnlyOpenedHotel")
    private boolean OnlyOpenedHotel;
    @JsonProperty("CheckinType")
    private String CheckinType;
    @JsonProperty("RoomTypeIds")
    private String[] RoomTypeIds;
    @JsonProperty("RoomStatuses")
    private String[] RoomStatuses;
    @JsonProperty("MemberLevels")
    private String[] MemberLevels;
    @JsonProperty("PhysicalRoomTypeOnly")
    private boolean PhysicalRoomTypeOnly;
    @JsonProperty("BasicInfoOnly")
    private boolean BasicInfoOnly;
    @JsonProperty("IncludeDetailCounts")
    private boolean IncludeDetailCounts;
    @JsonProperty("IncludePrices")
    private boolean IncludePrices;
    @JsonProperty("IncludeRoomCounts")
    private boolean IncludeRoomCounts;
    @JsonProperty("RateCode")
    private String RateCode;
    @JsonProperty("ContractorLevels")
    private String[] ContractorLevels;
    @JsonProperty("SearchType")
    private String SearchType;
    @JsonProperty("OrderByRequests")
    private OrderByRequestModel[] OrderByRequests;
    @JsonProperty("PageSize")
    private Integer PageSize;
    @JsonProperty("PageIndex")
    private Integer PageIndex;
}
