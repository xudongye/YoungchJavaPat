package com.youngch.pat.beyond.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class HotelInfoResponseModel {
    @JsonProperty("OrgId")
    private String OrgId;
    @JsonProperty("OrgSn")
    private String OrgSn;
    @JsonProperty("OrgName")
    private String OrgName;
    @JsonProperty("OrgInfoType")
    private String OrgInfoType;
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
    @JsonProperty("Star")
    private Long Star;
    @JsonProperty("Longitude")
    private Float Longitude;
    @JsonProperty("Latitude")
    private Float Latitude;
    @JsonProperty("ServiceTags")
    private List<String> ServiceTags;
    @JsonProperty("CanNetOpen")
    private Boolean CanNetOpen;
    @JsonProperty("ImageUris")
    private String ImageUris;
    @JsonProperty("DecorationDate")
    private String DecorationDate;
    @JsonProperty("OpeningDate")
    private String OpeningDate;
    @JsonProperty("DistrictId")
    private String DistrictId;
    @JsonProperty("CommercialLocationId")
    private String CommercialLocationId;
    @JsonProperty("WeChatLocationId")
    private String WeChatLocationId;
    @JsonProperty("PanoramicSite")
    private String PanoramicSite;
    @JsonProperty("CityId")
    private String CityId;
    @JsonProperty("CityName")
    private String CityName;
    @JsonProperty("BrandCategory")
    private List<String> BrandCategory;
    @JsonProperty("OrgLabel")
    private List<String> OrgLabel;
    @JsonProperty("StatusName")
    private String StatusName;
}
