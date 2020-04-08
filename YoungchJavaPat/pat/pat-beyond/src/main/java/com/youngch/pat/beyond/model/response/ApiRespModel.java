package com.youngch.pat.beyond.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class ApiRespModel<T> {
    @JsonProperty("Code")
    public Long Code;
    @JsonProperty("Message")
    public String Message;
    @JsonProperty("SubCode")
    public Long SubCode;
    @JsonProperty("SubMessage")
    public String SubMessage;
    @JsonProperty("Data")
    public T Data;
}
