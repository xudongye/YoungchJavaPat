package com.youngch.pat.common.beyond.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author: yexudong
 * @Date: 2020/5/26 16:44
 */
@Data
public class SearchOrgWithRoomPriceAndRoomCountResponseModel {
    @JsonProperty("OrgId")
    private String OrgId;
    @JsonProperty("OrgSn")
    private String OrgSn;
    @JsonProperty("OrgName")
    private String OrgName;
    @JsonProperty("Brand")
    private String Brand;
    @JsonProperty("Address")
    private String Address;
    @JsonProperty("Phone")
    private String Phone;
    @JsonProperty("Fax")
    private String Fax;
    @JsonProperty("Description")
    private String Description;
    @JsonProperty("CityId")
    private String CityId;
    @JsonProperty("OrgInfoType")
    private String OrgInfoType;
    @JsonProperty("Star")
    private int Star;
    @JsonProperty("Latitude")
    private float Latitude;
    @JsonProperty("Longitude")
    private float Longitude;
    @JsonProperty("ServiceTags")
    private String[] ServiceTags;
    @JsonProperty("Prices")
    private RoomPriceModel[] Prices;
    @JsonProperty("LowestPrices")
    private RoomPriceModel[] LowestPrices;
    @JsonProperty("RoomCounts")
    private RoomCountModel[] RoomCounts;
    @JsonProperty("CanNetOpen")
    private Boolean CanNetOpen;
    @JsonProperty("ImageUris")
    private String ImageUris;
    @JsonProperty("DecorationDate")
    private Date DecorationDate;
    @JsonProperty("OpeningDate")
    private Date OpeningDate;
    @JsonProperty("WeChatLocationId")
    private String WeChatLocationId;
    @JsonProperty("PanoramicSite")
    private String PanoramicSite;
    @JsonProperty("DistrictId")
    private String DistrictId;
    @JsonProperty("CommercialLocationId")
    private String CommercialLocationId;
    @JsonProperty("CityName")
    private String CityName;
    @JsonProperty("OrgStatus")
    private String OrgStatus;
    @JsonProperty("BrandCategory")
    private String[] BrandCategory;
    @JsonProperty("OrgLabel")
    private String[] OrgLabel;
}
