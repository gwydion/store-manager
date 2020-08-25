package com.chatbot.storemanager.converters;

import com.chatbot.storemanager.model.ProductInfo;
import com.chatbot.storemanager.web.ProductWebResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductIntoProductWebResponseConverter implements Converter<ProductInfo, ProductWebResponse> {

    @Override
    public ProductWebResponse convert(ProductInfo productInfo) {
        return productInfo == null ? null : new ProductWebResponse(productInfo.getCode(), productInfo.getName(), productInfo.getPurchasePackaging(), productInfo.getMasterStockAmount(), productInfo.getSalesPackaging(), productInfo.getStockAmount(), productInfo.getFractionIndicator(), productInfo.getMasterPrice(), productInfo.getSalePrice());
    }
}
