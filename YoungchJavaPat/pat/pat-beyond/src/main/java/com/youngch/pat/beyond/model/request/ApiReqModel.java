package com.youngch.pat.beyond.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ApiReqModel {
    @JsonProperty("ChannelKey")
    private String ChannelKey;
    @JsonProperty("Method")
    private String Method;
    @JsonProperty("BizContent")
    private String BizContent;
    @JsonProperty("Sign")
    private String Sign;
    @JsonProperty("SignType")
    private String SignType;
    @JsonProperty("Format")
    private String Format;
    @JsonProperty("Charset")
    private String Charset;
    @JsonProperty("Version")
    private String Version;
    @JsonProperty("Timestamp")
    private String Timestamp;

}
