package com.chatbot.storemanager.converters;

import com.chatbot.storemanager.model.ProductOrderDetail;
import com.chatbot.storemanager.web.ProductOrderDetailWeb;
import org.springframework.stereotype.Component;

@Component
public class ProductOrderDetailIntoProductOrderDetailWebConverter implements Converter<ProductOrderDetail, ProductOrderDetailWeb> {

    @Override
    public ProductOrderDetailWeb convert(ProductOrderDetail product) {
        return product == null ? null : new ProductOrderDetailWeb(product.getProductId(), product.getAmount(), product.getType(), product.getUnitPrice(), product.getTotalPrice(), product.getDiscount(), product.getTotalDiscount(), product.getTax(), product.getTotalTax(), product.getFinalPrice());
    }
}
