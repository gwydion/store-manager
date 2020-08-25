package com.chatbot.storemanager;

import com.chatbot.storemanager.exceptions.EntityNotFoundException;
import com.chatbot.storemanager.exceptions.ProcedureExecutionException;
import com.chatbot.storemanager.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class ManagementServiceImpl implements ManagementService {

    @Autowired
    private ManagementRepository repository;

    @Override
    public Client getClient(final String company, final String client) throws EntityNotFoundException, ProcedureExecutionException {
        return repository.getClient(company, client);
    }

    @Override
    public List<ProductInfo> getProducts(String productId) throws EntityNotFoundException, ProcedureExecutionException {
        return repository.getProducts(productId);
    }

    @Override
    public String startOrder(StartOrderRequest request) throws ProcedureExecutionException {
        return repository.startOrder(request);
    }

    @Override
    public void updateOrder(UpdateOrderRequest request) throws ProcedureExecutionException {
        if (!CollectionUtils.isEmpty(request.getProducts())) {
            for (ProductOrderDetail product : request.getProducts()) {
                repository.addProductToOrder(request.getCompanyId(), request.getOrderId(), product);
            }
        }
    }

    @Override
    public CloseOrderResponse closeOrder(String companyId, String orderId) throws ProcedureExecutionException {
        return repository.closeOrder(companyId, orderId);
    }
}
