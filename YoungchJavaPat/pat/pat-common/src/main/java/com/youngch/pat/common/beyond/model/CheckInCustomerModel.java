package com.youngch.pat.common.beyond.model;

import lombok.Data;

/**
 * @author: yexudong
 * @Date: 2020/6/2 10:20
 */
@Data
public class CheckInCustomerModel {
    private String Name;
    private String CardTypeId = "C01";
    private String CardNo;
    private String Mobile;
    private boolean ThemSelfCheckin;
}
