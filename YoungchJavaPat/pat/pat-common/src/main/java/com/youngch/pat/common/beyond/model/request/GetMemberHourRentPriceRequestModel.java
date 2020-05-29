package com.youngch.pat.common.beyond.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author: yexudong
 * @Date: 2020/5/27 16:40
 */
@Data
public class GetMemberHourRentPriceRequestModel {
    @JsonProperty("OrgId")
    private Long OrgId;
    @JsonProperty("ArriveTime")
    private String ArriveTime;
    @JsonProperty("DepartureTime")
    private String DepartureTime;
    @JsonProperty("MemberLevels")
    private String[] MemberLevels;
}
