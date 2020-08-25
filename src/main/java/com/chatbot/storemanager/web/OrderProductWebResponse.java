package com.chatbot.storemanager.web;

public class OrderProductWebResponse {

    private final String code;
    private final Double amount;
    private final String type;
    private final Double pricePerUnit;
    private final Double totalPrice;
    private final Double discountPercentage;
    private final Double totalDiscount;
    private final Double taxPercentage;
    private final Double totalTax;
    private final Double priceToPay;
    private final Double perceptionAmount;
    private final String errorMessage;

    public OrderProductWebResponse(String code, Double amount, String type, Double pricePerUnit, Double totalPrice, Double discountPercentage, Double totalDiscount, Double taxPercentage, Double totalTax, Double priceToPay, Double perceptionAmount, String errorMessage) {
        this.code = code;
        this.amount = amount;
        this.type = type;
        this.pricePerUnit = pricePerUnit;
        this.totalPrice = totalPrice;
        this.discountPercentage = discountPercentage;
        this.totalDiscount = totalDiscount;
        this.taxPercentage = taxPercentage;
        this.totalTax = totalTax;
        this.priceToPay = priceToPay;
        this.perceptionAmount = perceptionAmount;
        this.errorMessage = errorMessage;
    }

    public String getCode() {
        return code;
    }

    public Double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public Double getTotalDiscount() {
        return totalDiscount;
    }

    public Double getTaxPercentage() {
        return taxPercentage;
    }

    public Double getTotalTax() {
        return totalTax;
    }

    public Double getPriceToPay() {
        return priceToPay;
    }

    public Double getPerceptionAmount() {
        return perceptionAmount;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
