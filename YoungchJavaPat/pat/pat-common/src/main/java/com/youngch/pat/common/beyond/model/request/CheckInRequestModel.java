package com.youngch.pat.common.beyond.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author: yexudong
 * @Date: 2020/4/9 11:17
 */
@Data
public class CheckInRequestModel {
    @JsonProperty("OrgId")
    private Long OrgId;
    @JsonProperty("OrderIds")
    private Long[] OrderIds;
    @JsonProperty("OccupationIds")
    private Long[] OccupationIds;
    @JsonProperty("CheckinIds")
    private Long[] CheckinIds;
    @JsonProperty("RoomNumbers")
    private String[] RoomNumbers;
    @JsonProperty("CheckinStatus")
    private String[] CheckinStatus;
    @JsonProperty("MemberId")
    private String MemberId;
    @JsonProperty("Mobile")
    private String Mobile;
    @JsonProperty("IdCardNumber")
    private String IdCardNumber;
    @JsonProperty("PageSize")
    private int PageSize;
    @JsonProperty("PageIndex")
    private int PageIndex;

}
