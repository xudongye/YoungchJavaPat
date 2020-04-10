package com.youngch.pat.beyond.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author: yexudong
 * @Date: 2020/4/9 13:58
 */
@Data
public class CheckInResponseModel {
    @JsonProperty("PageSize")
    private int PageSize;
    @JsonProperty("PageIndex")
    private int PageIndex;
    @JsonProperty("RecordCount")
    private int RecordCount;
    @JsonProperty("PageCount")
    private int PageCount;
    @JsonProperty("Content")
    private CheckInContentResponseModel[] Content;

}
