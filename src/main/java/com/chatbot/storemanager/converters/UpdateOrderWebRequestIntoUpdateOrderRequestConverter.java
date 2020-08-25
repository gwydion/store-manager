package com.chatbot.storemanager.converters;

import com.chatbot.storemanager.model.ProductOrderDetail;
import com.chatbot.storemanager.model.UpdateOrderRequest;
import com.chatbot.storemanager.web.ProductOrderDetailWeb;
import com.chatbot.storemanager.web.UpdateOrderWebRequest;
import org.springframework.stereotype.Component;

@Component
public class UpdateOrderWebRequestIntoUpdateOrderRequestConverter implements Converter<UpdateOrderWebRequest, UpdateOrderRequest> {

    private final ListConverter<ProductOrderDetailWeb, ProductOrderDetail> productsConverter;

    public UpdateOrderWebRequestIntoUpdateOrderRequestConverter(Converter<ProductOrderDetailWeb, ProductOrderDetail> productConverter) {
        this.productsConverter = new ListConverter<>(productConverter);
    }

    @Override
    public UpdateOrderRequest convert(UpdateOrderWebRequest webRequest) {
        return webRequest == null ? null : new UpdateOrderRequest(webRequest.getCompanyId(), webRequest.getOrderId(), productsConverter.convert(webRequest.getProducts()));
    }
}
