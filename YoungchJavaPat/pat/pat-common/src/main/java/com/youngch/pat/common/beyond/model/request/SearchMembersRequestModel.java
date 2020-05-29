package com.youngch.pat.common.beyond.model.request;

import lombok.Data;

/**
 * @author: yexudong
 * @Date: 2020/5/28 16:05
 */
@Data
public class SearchMembersRequestModel {
    private String IdNo;
    private String Mobile;
    private int PageIndex = 1;
    private int PageSize = 5;
}
