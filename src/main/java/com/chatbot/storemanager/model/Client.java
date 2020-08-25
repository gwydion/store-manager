package com.chatbot.storemanager.model;

import com.chatbot.storemanager.web.AddressWebResponse;
import com.chatbot.storemanager.web.DocumentWebResponse;

import java.util.List;

public class Client {

    private final String clientCode;
    private final String companyCode;
    private final String name;
    private final String address;
    private final List<Address> deliveryAddresses;
    private final Document document;
    private final double creditLimit;

    public Client(final String clientCode, final String name, final String address,
                  final List<Address> deliveryAddresses, final Document document, final double creditLimit) {
        this.clientCode = clientCode;
        this.companyCode = "";
        this.name = name;
        this.address = address;
        this.deliveryAddresses = deliveryAddresses;
        this.document = document;
        this.creditLimit = creditLimit;
    }

    public String getClientCode() {
        return clientCode;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Address> getDeliveryAddresses() {
        return deliveryAddresses;
    }

    public Document getDocument() {
        return document;
    }

    public double getCreditLimit() {
        return creditLimit;
    }
}
