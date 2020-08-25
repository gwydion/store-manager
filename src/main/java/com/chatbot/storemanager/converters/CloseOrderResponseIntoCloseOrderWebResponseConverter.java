package com.chatbot.storemanager.converters;

import com.chatbot.storemanager.model.CloseOrderResponse;
import com.chatbot.storemanager.model.ProductOrderDetail;
import com.chatbot.storemanager.web.CloseOrderWebResponse;
import com.chatbot.storemanager.web.ProductOrderDetailWeb;
import org.springframework.stereotype.Component;

@Component
public class CloseOrderResponseIntoCloseOrderWebResponseConverter implements Converter<CloseOrderResponse, CloseOrderWebResponse> {

    private final ListConverter<ProductOrderDetail, ProductOrderDetailWeb> productsConverter;

    public CloseOrderResponseIntoCloseOrderWebResponseConverter(Converter<ProductOrderDetail, ProductOrderDetailWeb> productConverter) {
        this.productsConverter = new ListConverter<>(productConverter);
    }

    @Override
    public CloseOrderWebResponse convert(CloseOrderResponse response) {
        return response == null ? null : new CloseOrderWebResponse(response.getOrderId(), response.getTotalPrice(), response.getTotalDiscount(), response.getTotalPayment(), response.getTotalTaxes(), productsConverter.convert(response.getProducts()));
    }
}
