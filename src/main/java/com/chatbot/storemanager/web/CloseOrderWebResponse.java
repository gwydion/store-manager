package com.chatbot.storemanager.web;

import java.util.List;

public class CloseOrderWebResponse {

    private final String orderId;
    private final double totalPrice;
    private final double totalDiscount;
    private final double totalPayment;
    private final double totalTaxes;
    private final List<ProductOrderDetailWeb> products;

    public CloseOrderWebResponse(String orderId, double totalPrice, double totalDiscount, double totalPayment, double totalTaxes, List<ProductOrderDetailWeb> products) {
        this.orderId = orderId;
        this.totalPrice = totalPrice;
        this.totalDiscount = totalDiscount;
        this.totalPayment = totalPayment;
        this.totalTaxes = totalTaxes;
        this.products = products;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public double getTotalTaxes() {
        return totalTaxes;
    }

    public List<ProductOrderDetailWeb> getProducts() {
        return products;
    }
}
