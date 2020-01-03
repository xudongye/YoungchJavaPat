package com.youngch.pat.beyond.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data
public class ApiRespModel<T> {
    public String Code;

    public String Message;

    public String SubCode;

    public String SubMessage;

    public List<T> Data;
}
