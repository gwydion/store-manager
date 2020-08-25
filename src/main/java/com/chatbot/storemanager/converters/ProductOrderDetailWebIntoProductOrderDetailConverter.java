package com.chatbot.storemanager.converters;

import com.chatbot.storemanager.model.ProductOrderDetail;
import com.chatbot.storemanager.web.ProductOrderDetailWeb;
import org.springframework.stereotype.Component;

@Component
public class ProductOrderDetailWebIntoProductOrderDetailConverter implements Converter<ProductOrderDetailWeb, ProductOrderDetail> {

    @Override
    public ProductOrderDetail convert(ProductOrderDetailWeb webRequest) {
        return webRequest == null ? null : new ProductOrderDetail(webRequest.getProductId(), webRequest.getAmount(), webRequest.getType(), webRequest.getUnitPrice(), webRequest.getTotalPrice(), webRequest.getDiscount(), webRequest.getTotalDiscount(), webRequest.getTax(), webRequest.getTotalTax(), webRequest.getFinalPrice());
    }
}
