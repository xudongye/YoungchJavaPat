package com.youngch.pat.beyond.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author: yexudong
 * @Date: 2020/5/19 15:06
 */
@Data
public class HotelParam {

    @ApiModelProperty(value = "酒店名称", required = true)
    @NotEmpty(message = "酒店名称不为空")
    private String hotelName;

    @ApiModelProperty(value = "酒店id", required = true)
    @NotEmpty(message = "酒店id不为空")
    private String hotelId;

}
