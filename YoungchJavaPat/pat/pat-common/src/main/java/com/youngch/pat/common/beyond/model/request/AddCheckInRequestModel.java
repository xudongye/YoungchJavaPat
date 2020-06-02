package com.youngch.pat.common.beyond.model.request;

import com.youngch.pat.common.beyond.model.CheckInCustomerModel;
import lombok.Data;

/**
 * @author: yexudong
 * @Date: 2020/6/2 10:17
 */
@Data
public class AddCheckInRequestModel {
    private Long OrderId;
    private Long OccupationId;
    private Long OrgId;
    private CheckInCustomerModel Customer;
}
