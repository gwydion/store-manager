package com.chatbot.storemanager.web;

public class AddressWebResponse {

    private final String code;
    private final String address;
    private final String routeCode;
    private final String routeName;
    private final String lineOfBusiness;
    private final String sellerCode;
    private final String sellerName;
    private final String saleCondition;
    private final String priceListCode;
    private final Double latitude;
    private final Double longitude;
    private final String officeId;
    private final String storageId;

    public AddressWebResponse(String code, String address, String routeCode, String routeName,
                              String lineOfBusiness, String sellerCode, String sellerName, String saleCondition,
                              String priceListCode, Double latitude, Double longitude, String officeId, String storageId) {
        this.code = code;
        this.address = address;
        this.routeCode = routeCode;
        this.routeName = routeName;
        this.lineOfBusiness = lineOfBusiness;
        this.sellerCode = sellerCode;
        this.sellerName = sellerName;
        this.saleCondition = saleCondition;
        this.priceListCode = priceListCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.officeId = officeId;
        this.storageId = storageId;
    }

    public String getCode() {
        return code;
    }

    public String getAddress() {
        return address;
    }

    public String getRouteCode() {
        return routeCode;
    }

    public String getRouteName() {
        return routeName;
    }

    public String getLineOfBusiness() {
        return lineOfBusiness;
    }

    public String getSellerCode() {
        return sellerCode;
    }

    public String getSellerName() {
        return sellerName;
    }

    public String getSaleCondition() {
        return saleCondition;
    }

    public String getPriceListCode() {
        return priceListCode;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getOfficeId() {
        return officeId;
    }

    public String getStorageId() {
        return storageId;
    }
}
