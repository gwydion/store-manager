package com.chatbot.storemanager.web;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UpdateOrderWebRequest {

    private final String companyId;
    private final String orderId;
    private final List<ProductOrderDetailWeb> products;

    @JsonCreator
    public UpdateOrderWebRequest(@JsonProperty("companyId") String companyId, @JsonProperty("orderId") String orderId, @JsonProperty("products") List<ProductOrderDetailWeb> products) {
        this.companyId = companyId;
        this.orderId = orderId;
        this.products = products;
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getOrderId() {
        return orderId;
    }

    public List<ProductOrderDetailWeb> getProducts() {
        return products;
    }
}
