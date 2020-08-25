package com.chatbot.storemanager;

import com.chatbot.storemanager.exceptions.ClientNotFoundException;
import com.chatbot.storemanager.exceptions.ProcedureExecutionException;
import com.chatbot.storemanager.exceptions.ProductNotFoundException;
import com.chatbot.storemanager.model.*;

import java.util.List;

public interface ManagementRepository {

    Client getClient(String companyId, String clientId) throws ProcedureExecutionException, ClientNotFoundException;

    List<ProductInfo> getProducts(String productId) throws ProcedureExecutionException, ProductNotFoundException;

    String startOrder(StartOrderRequest request) throws ProcedureExecutionException;

    void addProductToOrder(String companyId, String orderId, ProductOrderDetail product) throws ProcedureExecutionException;

    CloseOrderResponse closeOrder(String companyId, String orderId) throws ProcedureExecutionException;
}
