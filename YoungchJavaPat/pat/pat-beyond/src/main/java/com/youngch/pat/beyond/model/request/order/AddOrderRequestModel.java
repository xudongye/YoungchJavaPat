package com.youngch.pat.beyond.model.request.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.youngch.pat.beyond.model.response.RoomCountModel;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author: yexudong
 * @Date: 2020/4/8 13:33
 */
@Data
public class AddOrderRequestModel {
    @JsonProperty("CheckinType")
    private String CheckinType;
    @JsonProperty("OrgId")
    private Long OrgId;
    @JsonProperty("EstimatedArriveTime")
    private Date EstimatedArriveTime;
    @JsonProperty("EstimatedDepartureTime")
    private Date EstimatedDepartureTime;
    @JsonProperty("RoomPlans")
    private RoomCountModel[] RoomPlans;
    @JsonProperty("MemberId")
    private Long MemberId;
    @JsonProperty("ContractId")
    private Long ContractId;
    @JsonProperty("SalerId")
    private String SalerId;
    @JsonProperty("Liaisons")
    private LiaisonModel[] Liaisons;
    @JsonProperty("Locked")
    private Boolean Locked;
    @JsonProperty("ExpireKeepTime")
    private Date ExpireKeepTime;
    @JsonProperty("PrePaymentTypeId")
    private String PrePaymentTypeId;
    @JsonProperty("PromotionId")
    private Long PromotionId;
    @JsonProperty("Memo")
    private String Memo;
    @JsonProperty("ServiceItems")
    private OrderServiceItemModel[] ServiceItems;
    @JsonProperty("OrderSn")
    private String OrderSn;
    @JsonProperty("OpenId")
    private String OpenId;
}
