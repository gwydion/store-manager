package com.chatbot.storemanager.model;

public class ProductOrderDetail {

    private final String productId;
    private final double amount;
    private final String type;
    private final double unitPrice;
    private final double totalPrice;
    private final double discount;
    private final double totalDiscount;
    private final double tax;
    private final double totalTax;
    private final double finalPrice;

    public ProductOrderDetail(String productId, double amount, String type, double unitPrice, double totalPrice, double discount, double totalDiscount, double tax, double totalTax, double finalPrice) {
        this.productId = productId;
        this.amount = amount;
        this.type = type;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.discount = discount;
        this.totalDiscount = totalDiscount;
        this.tax = tax;
        this.totalTax = totalTax;
        this.finalPrice = finalPrice;
    }

    public String getProductId() {
        return productId;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public double getTotalDiscount() {
        return totalDiscount;
    }

    public double getTax() {
        return tax;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public double getFinalPrice() {
        return finalPrice;
    }
}
