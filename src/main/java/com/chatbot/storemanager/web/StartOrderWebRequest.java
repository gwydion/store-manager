package com.chatbot.storemanager.web;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class StartOrderWebRequest {

    private final String companyId;
    private final String clientId;
    private final String addressId;
    private final String date;
    private final String sellingConditionId;
    private final String priceListId;
    private final String sellerId;
    private final String routeId;
    private final String latitude;
    private final String longitude;
    private final String observation;
    private final String status;
    private final String total;
    private final String documentType;
    private final String documentNumber;
    private final String name;
    private final String deliveryAddress;
    private final String phoneNumber;

    @JsonCreator
    public StartOrderWebRequest(@JsonProperty("companyId") String companyId, @JsonProperty("clientId") String clientId,
                                @JsonProperty("addressId") String addressId, @JsonProperty("date") String date,
                                @JsonProperty("sellingConditionId") String sellingConditionId, @JsonProperty("priceListId") String priceListId,
                                @JsonProperty("sellerId") String sellerId, @JsonProperty("routeId") String routeId,
                                @JsonProperty("latitude") String latitude, @JsonProperty("longitude") String longitude,
                                @JsonProperty("observation") String observation, @JsonProperty("status") String status,
                                @JsonProperty("total") String total, @JsonProperty("documentType") String documentType,
                                @JsonProperty("documentNumber") String documentNumber, @JsonProperty("name") String name,
                                @JsonProperty("deliveryAddress") String deliveryAddress, @JsonProperty("phoneNumber") String phoneNumber) {
        this.companyId = companyId;
        this.clientId = clientId;
        this.addressId = addressId;
        this.date = date;
        this.sellingConditionId = sellingConditionId;
        this.priceListId = priceListId;
        this.sellerId = sellerId;
        this.routeId = routeId;
        this.latitude = latitude;
        this.longitude = longitude;
        this.observation = observation;
        this.status = status;
        this.total = total;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.name = name;
        this.deliveryAddress = deliveryAddress;
        this.phoneNumber = phoneNumber;
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getClientId() {
        return clientId;
    }

    public String getAddressId() {
        return addressId;
    }

    public String getDate() {
        return date;
    }

    public String getSellingConditionId() {
        return sellingConditionId;
    }

    public String getPriceListId() {
        return priceListId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public String getRouteId() {
        return routeId;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getObservation() {
        return observation;
    }

    public String getStatus() {
        return status;
    }

    public String getTotal() {
        return total;
    }

    public String getDocumentType() {
        return documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public String getName() {
        return name;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
