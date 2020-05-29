package com.youngch.pat.common.beyond.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author: yexudong
 * @Date: 2020/5/27 16:27
 */
@Data
public class ConfiguredInfoModel {
    @JsonProperty("Description")
    private String Description;
    @JsonProperty("ImageUri")
    private String ImageUri;
}
