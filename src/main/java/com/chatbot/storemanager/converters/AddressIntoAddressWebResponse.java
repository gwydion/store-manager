package com.chatbot.storemanager.converters;

import com.chatbot.storemanager.model.Address;
import com.chatbot.storemanager.web.AddressWebResponse;
import org.springframework.stereotype.Component;

@Component
public class AddressIntoAddressWebResponse implements Converter<Address, AddressWebResponse> {

    @Override
    public AddressWebResponse convert(Address address) {
        return address == null ? null : new AddressWebResponse(address.getCode(), address.getStorageId(), address.getRouteCode(), address.getRouteName(), address.getLineOfBusiness(), address.getSellerCode(), address.getSellerName(), address.getSaleCondition(), address.getPriceListCode(), address.getLatitude(), address.getLongitude(), address.getOfficeId(), address.getStorageId());
    }
}
