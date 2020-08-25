package com.chatbot.storemanager;

import com.chatbot.storemanager.converters.Converter;
import com.chatbot.storemanager.converters.ListConverter;
import com.chatbot.storemanager.exceptions.EntityNotFoundException;
import com.chatbot.storemanager.exceptions.ProcedureExecutionException;
import com.chatbot.storemanager.model.*;
import com.chatbot.storemanager.web.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagementController {

    private final ManagementService service;
    private final Converter<Client, ClientWebResponse> clientConverter;
    private final ListConverter<ProductInfo, ProductWebResponse> productsConverter;
    private final Converter<StartOrderWebRequest, StartOrderRequest> startOrderRequestConverter;
    private final Converter<UpdateOrderWebRequest, UpdateOrderRequest> updateOrderRequestConverter;
    private final Converter<CloseOrderResponse, CloseOrderWebResponse> orderResponseConverter;

    @Autowired
    public ManagementController(final ManagementService service,
                                final Converter<Client, ClientWebResponse> clientConverter,
                                final Converter<ProductInfo, ProductWebResponse> productConverter,
                                final Converter<StartOrderWebRequest, StartOrderRequest> startOrderRequestConverter,
                                final Converter<UpdateOrderWebRequest, UpdateOrderRequest> updateOrderRequestConverter,
                                final Converter<CloseOrderResponse, CloseOrderWebResponse> orderResponseConverter) {
        this.service = service;
        this.clientConverter = clientConverter;
        this.productsConverter = new ListConverter<>(productConverter);
        this.startOrderRequestConverter = startOrderRequestConverter;
        this.updateOrderRequestConverter = updateOrderRequestConverter;
        this.orderResponseConverter = orderResponseConverter;
    }

    @RequestMapping(value = "/company/{company}/client/{client}", method = RequestMethod.GET)
    public ClientWebResponse getClientForCompany(@PathVariable("company") final String companyId,
                                                 @PathVariable("client") final String clientId) throws ProcedureExecutionException, EntityNotFoundException {
        return clientConverter.convert(service.getClient(companyId, clientId));
    }

    @RequestMapping(value = "/product/{product}", method = RequestMethod.GET)
    public List<ProductWebResponse> getProduct(@PathVariable("product") final String productId) throws ProcedureExecutionException, EntityNotFoundException {
        return productsConverter.convert(service.getProducts(productId));
    }

    @RequestMapping(value = "/order/start", method = RequestMethod.POST)
    public StartOrderWebResponse startOrder(@RequestBody final StartOrderWebRequest webRequest) throws ProcedureExecutionException {
        String orderId = service.startOrder(startOrderRequestConverter.convert(webRequest));
        return new StartOrderWebResponse(orderId);
    }

    @RequestMapping(value = "/order/update", method = RequestMethod.POST)
    public void updateOrder(@RequestBody final UpdateOrderWebRequest webRequest) throws ProcedureExecutionException {
        service.updateOrder(updateOrderRequestConverter.convert(webRequest));
    }

    @RequestMapping(value = "/order/close", method = RequestMethod.POST)
    public CloseOrderWebResponse close(@RequestBody final CloseOrderWebRequest webRequest) throws ProcedureExecutionException {
        CloseOrderResponse order = service.closeOrder(webRequest.getCompanyId(), webRequest.getOrderId());
        return orderResponseConverter.convert(order);
    }
}