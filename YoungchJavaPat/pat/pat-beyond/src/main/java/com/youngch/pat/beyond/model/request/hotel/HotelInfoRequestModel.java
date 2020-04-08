package com.youngch.pat.beyond.model.request.hotel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HotelInfoRequestModel {
    @JsonProperty("OrgId")
    private Long OrgId;
}
