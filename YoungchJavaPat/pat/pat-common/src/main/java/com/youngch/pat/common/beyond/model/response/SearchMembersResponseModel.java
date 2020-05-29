package com.youngch.pat.common.beyond.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * @author: yexudong
 * @Date: 2020/5/28 16:09
 */
public class SearchMembersResponseModel {
    @JsonProperty("MemberId")
    private String MemberId;
    private String Name;
    private String Gender;
    private String Mobile;
    private String Email;
    private String IDType;
    private String IDNO;
    private String MemberCardId;
    private String StatusCode;
    private String MemberLevel;
    private String MemberLevelName;
    private float Value;
    private float Point;
    private Date BirthDay;
    private String SourceDetailCode;
    private String ExtCardNo;
    private String Remark;
    private String ParentCardNo;
}
