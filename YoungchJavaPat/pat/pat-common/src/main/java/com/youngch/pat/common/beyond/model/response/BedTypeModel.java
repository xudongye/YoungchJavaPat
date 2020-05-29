package com.youngch.pat.common.beyond.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author: yexudong
 * @Date: 2020/5/27 16:24
 */
@Data
public class BedTypeModel {
    @JsonProperty("Key")
    private String Key;
    @JsonProperty("Name")
    private String Name;
    @JsonProperty("Desc")
    private String Desc;
    @JsonProperty("Count")
    private int Count;
}
