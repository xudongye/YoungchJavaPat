package com.youngch.pat.beyond.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HotelSearchResponseModel {
    @JsonProperty("HotelId")
    public long HotelId;
    @JsonProperty("OrgSn")
    public String OrgSn;
    @JsonProperty("Name")
    public String Name;
    @JsonProperty("Brand")
    public String Brand;
    @JsonProperty("Address")
    public String Address;
    @JsonProperty("Phone")
    public String Phone;
    @JsonProperty("Fax")
    public String Fax;
    @JsonProperty("Description")
    public String Description;
    @JsonProperty("CityId")
    public String CityId;
    @JsonProperty("HotelInfoType")
    public String HotelInfoType;
    @JsonProperty("Star")
    public Integer Star;
    @JsonProperty("Latitude")
    public Float Latitude;
    @JsonProperty("Longitude")
    public Float Longitude;
    @JsonProperty("ServiceTags")
    public String[] ServiceTags;
    @JsonProperty("Prices")
    public RoomPriceModel[] Prices;
    @JsonProperty("LowestPrices")
    public RoomPriceModel[] LowestPrices;
    @JsonProperty("RoomCounts")
    public RoomCountModel[] RoomCounts;
    @JsonProperty("CanNetOpen")
    public Boolean CanNetOpen;
    @JsonProperty("ImageUris")
    public String ImageUris;
    @JsonProperty("DecorationDate")
    public String DecorationDate;
    @JsonProperty("OpeningDate")
    public String OpeningDate;
    @JsonProperty("WeChatLocationId")
    public String WeChatLocationId;
    @JsonProperty("PanoramicSite")
    public String PanoramicSite;
    @JsonProperty("DistrictId")
    public String DistrictId;
    @JsonProperty("CommercialLocationId")
    public String CommercialLocationId;
    @JsonProperty("CityName")
    public String CityName;
    @JsonProperty("OrgStatus")
    public String OrgStatus;
}
