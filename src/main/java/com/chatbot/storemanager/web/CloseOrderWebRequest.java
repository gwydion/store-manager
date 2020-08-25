package com.chatbot.storemanager.web;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CloseOrderWebRequest {

    private final String companyId;
    private final String orderId;

    @JsonCreator
    public CloseOrderWebRequest(@JsonProperty("companyId") String companyId, @JsonProperty("orderId") String orderId) {
        this.companyId = companyId;
        this.orderId = orderId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getOrderId() {
        return orderId;
    }

}
