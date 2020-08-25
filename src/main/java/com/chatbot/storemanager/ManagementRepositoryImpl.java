package com.chatbot.storemanager;

import com.chatbot.storemanager.exceptions.ClientNotFoundException;
import com.chatbot.storemanager.exceptions.ProcedureExecutionException;
import com.chatbot.storemanager.exceptions.ProductNotFoundException;
import com.chatbot.storemanager.model.*;
import com.chatbot.storemanager.repository.operations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ManagementRepositoryImpl implements ManagementRepository {

    private final String dbUrl;
    private final String dbUser;
    private final String dbPassword;

    @Autowired
    public ManagementRepositoryImpl(@Value("${erpynet.url}") final String dbUrl,
                                    @Value("${erpynet.user}") final String dbUser,
                                    @Value("${erpynet.password}") final String dbPassword) {
        this.dbUrl = dbUrl;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }

    @Override
    public Client getClient(final String companyId, final String clientId) throws ProcedureExecutionException, ClientNotFoundException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            final ArrayList<Client> clients = GetClientInfo.getClient(conn, companyId, clientId);
            if (CollectionUtils.isEmpty(clients)) {
                throw new ClientNotFoundException(clientId, companyId);
            } else {
                return clients.get(0);
            }
        } catch (SQLException e) {
            throw new ProcedureExecutionException(e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new ProcedureExecutionException(e.getMessage());
            }
        }
    }

    @Override
    public List<ProductInfo> getProducts(String productId) throws ProcedureExecutionException, ProductNotFoundException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            final ArrayList<ProductInfo> products = GetProductInfo.getProducts(conn, productId);
            if (CollectionUtils.isEmpty(products)) {
                throw new ProductNotFoundException(productId);
            } else {
                return products;
            }
        } catch (SQLException e) {
            throw new ProcedureExecutionException(e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new ProcedureExecutionException(e.getMessage());
            }
        }
    }

    @Override
    public String startOrder(StartOrderRequest request) throws ProcedureExecutionException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            return StartOrder.startOrder(conn, request);
        } catch (SQLException e) {
            throw new ProcedureExecutionException(e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new ProcedureExecutionException(e.getMessage());
            }
        }
    }

    @Override
    public void addProductToOrder(String companyId, String orderId, ProductOrderDetail product) throws ProcedureExecutionException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            AddProduct.addProduct(conn, companyId, orderId, product);
        } catch (SQLException e) {
            throw new ProcedureExecutionException(e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new ProcedureExecutionException(e.getMessage());
            }
        }
    }

    @Override
    public CloseOrderResponse closeOrder(String companyId, String orderId) throws ProcedureExecutionException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            return CloseOrder.closeOrder(conn, companyId, orderId);
        } catch (SQLException e) {
            throw new ProcedureExecutionException(e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new ProcedureExecutionException(e.getMessage());
            }
        }
    }

}
