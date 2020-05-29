package com.youngch.pat.common.beyond.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.youngch.pat.common.beyond.model.LiaisonModel;
import lombok.Data;

import java.util.Date;

/**
 * @author: yexudong
 * @Date: 2020/4/9 11:23
 */
@Data
public class CheckInContentResponseModel {
    @JsonProperty("OrgId")
    private long OrgId;
    @JsonProperty("CheckinId")
    private long CheckinId;
    @JsonProperty("OrderId")
    private long OrderId;
    @JsonProperty("OccupationId")
    private long OccupationId;
    @JsonProperty("RoomNumber")
    private String RoomNumber;
    @JsonProperty("BillId")
    private long BillId;
    @JsonProperty("CheckinStatus")
    private String CheckinStatus;
    @JsonProperty("CheckinCustomer")
    private LiaisonModel CheckinCustomer;
    @JsonProperty("ActualArriveTime")
    private Date ActualArriveTime;
    @JsonProperty("ActualDepatureTime")
    private Date ActualDepatureTime;
    @JsonProperty("EstimatedDepartureTime")
    private Date EstimatedDepartureTime;
    @JsonProperty("BenefitDepartureTime")
    private Date BenefitDepartureTime;
    @JsonProperty("Memo")
    private String Memo;
    @JsonProperty("IsMainBill")
    private Boolean IsMainBill;
}
