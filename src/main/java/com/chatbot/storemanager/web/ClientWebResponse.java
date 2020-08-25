package com.chatbot.storemanager.web;

import java.util.List;

public class ClientWebResponse{

    private final String clientCode;
    private final String companyCode;
    private final String name;
    private final String address;
    private final List<AddressWebResponse> deliveryAddresses;
    private final DocumentWebResponse document;
    private final double creditLimit;

    public ClientWebResponse(String clientCode, String companyCode, String name, String address,
            List<AddressWebResponse> deliveryAddresses, DocumentWebResponse document, double creditLimit){
        this.clientCode = clientCode;
        this.companyCode = companyCode;
        this.name = name;
        this.address = address;
        this.deliveryAddresses = deliveryAddresses;
        this.document = document;
        this.creditLimit = creditLimit;
    }

    public String getClientCode(){
        return clientCode;
    }

    public String getCompanyCode(){
        return companyCode;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public List<AddressWebResponse> getDeliveryAddresses(){
        return deliveryAddresses;
    }

    public DocumentWebResponse getDocument(){
        return document;
    }

    public double getCreditLimit(){
        return creditLimit;
    }
}
