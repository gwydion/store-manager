package com.chatbot.storemanager.converters;

import com.chatbot.storemanager.model.Address;
import com.chatbot.storemanager.model.Client;
import com.chatbot.storemanager.model.Document;
import com.chatbot.storemanager.web.AddressWebResponse;
import com.chatbot.storemanager.web.ClientWebResponse;
import com.chatbot.storemanager.web.DocumentWebResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientIntoClientWebResponseConverter implements Converter<Client, ClientWebResponse> {

    private final Converter<Document, DocumentWebResponse> documentConverter;
    private final ListConverter<Address, AddressWebResponse> addressesConverter;

    @Autowired
    public ClientIntoClientWebResponseConverter(final Converter<Document, DocumentWebResponse> documentConverter,
        final Converter<Address, AddressWebResponse> addressConverter) {
        this.documentConverter = documentConverter;
        this.addressesConverter = new ListConverter<>(addressConverter);
    }

    @Override
    public ClientWebResponse convert(final Client client) {
        return client == null ? null : new ClientWebResponse(client.getClientCode(), client.getCompanyCode(), client.getName(), client.getAddress(), addressesConverter.convert(client.getDeliveryAddresses()), documentConverter.convert(client.getDocument()), client.getCreditLimit());
    }
}
