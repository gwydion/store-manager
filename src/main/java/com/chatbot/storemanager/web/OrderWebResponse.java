package com.chatbot.storemanager.web;

import java.util.List;

public class OrderWebResponse {

    private final Double totalPrice;
    private final Double totalDiscount;
    private final Double totalPayment;
    private final Double otherTaxes;
    private final String errorCode;
    private final List<OrderProductWebResponse> products;

    public OrderWebResponse(Double totalPrice, Double totalDiscount, Double totalPayment, Double otherTaxes, String errorCode, List<OrderProductWebResponse> products) {
        this.totalPrice = totalPrice;
        this.totalDiscount = totalDiscount;
        this.totalPayment = totalPayment;
        this.otherTaxes = otherTaxes;
        this.errorCode = errorCode;
        this.products = products;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public Double getTotalDiscount() {
        return totalDiscount;
    }

    public Double getTotalPayment() {
        return totalPayment;
    }

    public Double getOtherTaxes() {
        return otherTaxes;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public List<OrderProductWebResponse> getProducts() {
        return products;
    }
}
