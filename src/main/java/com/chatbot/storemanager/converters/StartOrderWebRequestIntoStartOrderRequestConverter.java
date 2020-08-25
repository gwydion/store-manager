package com.chatbot.storemanager.converters;

import com.chatbot.storemanager.model.StartOrderRequest;
import com.chatbot.storemanager.web.StartOrderWebRequest;
import org.springframework.stereotype.Component;

@Component
public class StartOrderWebRequestIntoStartOrderRequestConverter implements Converter<StartOrderWebRequest, StartOrderRequest> {

    @Override
    public StartOrderRequest convert(StartOrderWebRequest webRequest) {
        return webRequest == null ? null : new StartOrderRequest(webRequest.getCompanyId(), webRequest.getClientId(), webRequest.getAddressId(), webRequest.getDate(), webRequest.getSellingConditionId(), webRequest.getPriceListId(), webRequest.getSellerId(), webRequest.getRouteId(), webRequest.getLatitude(), webRequest.getLongitude(), webRequest.getObservation(), webRequest.getStatus(), webRequest.getTotal(), webRequest.getDocumentType(), webRequest.getDocumentNumber(), webRequest.getName(), webRequest.getDeliveryAddress(), webRequest.getPhoneNumber());
    }
}
