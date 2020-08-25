package com.chatbot.storemanager.model;

public class ProductInfo {

    private final String code;
    private final String name;
    private final String purchasePackaging;
    private final Integer masterStockAmount;
    private final String salesPackaging;
    private final Integer stockAmount;
    private final String fractionIndicator;
    private final Double masterPrice;
    private final Double salePrice;

    public ProductInfo(String code, String name, String purchasePackaging, Integer masterStockAmount, String salesPackaging, Integer stockAmount, String fractionIndicator, Double masterPrice, Double salePrice) {
        this.code = code;
        this.name = name;
        this.purchasePackaging = purchasePackaging;
        this.masterStockAmount = masterStockAmount;
        this.salesPackaging = salesPackaging;
        this.stockAmount = stockAmount;
        this.fractionIndicator = fractionIndicator;
        this.masterPrice = masterPrice;
        this.salePrice = salePrice;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getPurchasePackaging() {
        return purchasePackaging;
    }

    public Integer getMasterStockAmount() {
        return masterStockAmount;
    }

    public String getSalesPackaging() {
        return salesPackaging;
    }

    public Integer getStockAmount() {
        return stockAmount;
    }

    public String getFractionIndicator() {
        return fractionIndicator;
    }

    public Double getMasterPrice() {
        return masterPrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }
}
