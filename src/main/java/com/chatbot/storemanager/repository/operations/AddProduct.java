package com.chatbot.storemanager.repository.operations;

import com.chatbot.storemanager.exceptions.ProcedureExecutionException;
import com.chatbot.storemanager.model.ProductOrderDetail;
import org.springframework.jdbc.object.StoredProcedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class AddProduct extends StoredProcedure {

    public static String addProduct(Connection conn, String companyId, String orderId, ProductOrderDetail product) throws SQLException, ProcedureExecutionException {
        CallableStatement statement = null;
        try {
            statement = conn.prepareCall("{call pack_api_erpynet.p_grabapedidodet(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");

            statement.setString(1, companyId);
            statement.setString(2, orderId);
            statement.setString(3, product.getProductId());
            statement.setDouble(4, product.getAmount());
            statement.setString(5, product.getType());
            statement.setDouble(6, product.getUnitPrice());
            statement.setDouble(7, product.getTotalPrice());
            statement.setDouble(8, product.getDiscount());
            statement.setDouble(9, product.getTotalDiscount());
            statement.setDouble(10, product.getTax());
            statement.setDouble(11, product.getTotalTax());
            statement.setDouble(12, product.getFinalPrice());
            statement.registerOutParameter(13, Types.VARCHAR);
            statement.registerOutParameter(14, Types.VARCHAR);

            statement.execute();

            if ("OK".equals(statement.getString(14))) {
                return statement.getString(14);
            } else {
                throw new ProcedureExecutionException(statement.getString(14));
            }
        } finally {
            statement.close();
        }
    }

}