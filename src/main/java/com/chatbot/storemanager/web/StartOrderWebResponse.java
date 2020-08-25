package com.chatbot.storemanager.web;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StartOrderWebResponse {

    private final String orderId;

    public StartOrderWebResponse(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
}
