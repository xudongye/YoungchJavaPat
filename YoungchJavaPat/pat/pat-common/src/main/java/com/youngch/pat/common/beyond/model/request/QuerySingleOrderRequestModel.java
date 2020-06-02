package com.youngch.pat.common.beyond.model.request;

import lombok.Data;

/**
 * @author: yexudong
 * @Date: 2020/6/1 16:23
 */
@Data
public class QuerySingleOrderRequestModel {
    private long OrgId;
    private String OrderId;
    private boolean IncludeOrgInfo;
    private boolean ExcludeOccupations;
    private boolean SearchBalance = true;
}
