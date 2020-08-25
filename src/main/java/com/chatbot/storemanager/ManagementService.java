package com.chatbot.storemanager;

import com.chatbot.storemanager.exceptions.EntityNotFoundException;
import com.chatbot.storemanager.exceptions.ProcedureExecutionException;
import com.chatbot.storemanager.model.*;

import java.util.List;

public interface ManagementService{

    Client getClient(String company, String client) throws EntityNotFoundException, ProcedureExecutionException;

    List<ProductInfo> getProducts(String productId) throws EntityNotFoundException, ProcedureExecutionException;

    String startOrder(StartOrderRequest request) throws ProcedureExecutionException;

    void updateOrder(UpdateOrderRequest request) throws ProcedureExecutionException;

    CloseOrderResponse closeOrder(String companyId, String orderId) throws ProcedureExecutionException;
}
