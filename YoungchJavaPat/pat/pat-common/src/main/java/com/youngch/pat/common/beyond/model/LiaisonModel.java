package com.youngch.pat.common.beyond.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author: yexudong
 * @Date: 2020/4/8 13:38
 */
@Data
public class LiaisonModel {
    @JsonProperty("Name")
    private String Name;
    @JsonProperty("Mobile")
    private String Mobile;
    @JsonProperty("Gender")
    private int Gender;
    @JsonProperty("Nationality")
    private String Nationality;
}
