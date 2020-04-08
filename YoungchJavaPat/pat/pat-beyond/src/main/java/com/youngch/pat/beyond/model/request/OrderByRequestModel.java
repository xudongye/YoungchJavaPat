package com.youngch.pat.beyond.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OrderByRequestModel {
    @JsonProperty("OrderBy")
    private String OrderBy;
    @JsonProperty("Asc")
    private boolean Asc;
}
