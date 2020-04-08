package com.youngch.pat.beyond.model.request.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author: yexudong
 * @Date: 2020/4/8 13:41
 */
@Data
public class OrderServiceItemModel {
    @JsonProperty("ItemId")
    private Long ItemId;
    @JsonProperty("ItemPrice")
    private Float ItemPrice;
    @JsonProperty("CustomerOwned")
    private Boolean CustomerOwned;
    @JsonProperty("PersistentOnRefresh")
    private Boolean PersistentOnRefresh;
}
