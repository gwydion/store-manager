package com.chatbot.storemanager.model;

import java.util.List;

public class UpdateOrderRequest {

    private final String companyId;
    private final String orderId;
    private final List<ProductOrderDetail> products;

    public UpdateOrderRequest(String companyId, String orderId, List<ProductOrderDetail> products) {
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

    public List<ProductOrderDetail> getProducts() {
        return products;
    }
}
