package com.youngch.pat.common.beyond.model.request;

import lombok.Data;

/**
 * @author: yexudong
 * @Date: 2020/5/29 14:14
 */
@Data
public class QueryOrdersRequestModel {
    private Long OrgId;
    private String Keywords;
    private String[] OrderStatusIds;
}
