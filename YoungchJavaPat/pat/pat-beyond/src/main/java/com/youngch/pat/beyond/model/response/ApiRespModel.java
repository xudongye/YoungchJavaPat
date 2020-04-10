package com.youngch.pat.beyond.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ApiRespModel {
    @JsonProperty("Code")
    public Long Code;
    @JsonProperty("Message")
    public String Message;
    @JsonProperty("SubCode")
    public String SubCode;
    @JsonProperty("SubMessage")
    public String SubMessage;
    @JsonProperty("Data")
    public Object Data;
}
