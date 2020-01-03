package com.youngch.pat.beyond.model.response;

import lombok.Data;

@Data
public class HotelSearchResponseModel {
    public long HotelId;

    public String OrgSn;

    public String Name;

    public String Brand;

    public String Address;

    public String Phone;

    public String Fax;

    public String Description;

    public String CityId;

    public String HotelInfoType;

    public Integer Star;

    public Float Latitude;

    public Float Longitude;

    public String[] ServiceTags;

    public RoomPriceModel[] Prices;

    public RoomPriceModel[] LowestPrices;

    public RoomCountModel[] RoomCounts;

    public Boolean CanNetOpen;

    public String ImageUris;

    public String DecorationDate;

    public String OpeningDate;

    public String WeChatLocationId;

    public String PanoramicSite;

    public String DistrictId;

    public String CommercialLocationId;

    public String CityName;

    public String OrgStatus;
}
