package com.chatbot.storemanager.repository.operations;

import com.chatbot.storemanager.exceptions.ProcedureExecutionException;
import com.chatbot.storemanager.model.CloseOrderResponse;
import com.chatbot.storemanager.model.ProductOrderDetail;
import org.springframework.jdbc.object.StoredProcedure;

import java.sql.*;
import java.util.ArrayList;

public class CloseOrder extends StoredProcedure {

    public static CloseOrderResponse closeOrder(Connection conn, String company, String orderId) throws SQLException, ProcedureExecutionException {
        CallableStatement statement = null;
        try {
            statement = conn.prepareCall("{call pack_api_erpynet.p_finaliza_pedido(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");

            statement.setString(1, company);
            statement.setString(2, orderId);
            statement.registerOutParameter(3, Types.DOUBLE);
            statement.registerOutParameter(4, Types.DOUBLE);
            statement.registerOutParameter(5, Types.DOUBLE);
            statement.registerOutParameter(6, Types.DOUBLE);
            statement.registerOutParameter(7, Types.VARCHAR);
            statement.registerOutParameter(8, Types.VARCHAR);
            statement.registerOutParameter(9, Types.REF_CURSOR);
            statement.registerOutParameter(10, Types.REF_CURSOR);

            statement.execute();

            if (statement.getString(7) == null) {
                final ArrayList<ProductOrderDetail> products = new ArrayList<>();
                final ResultSet productsRs = (ResultSet) statement.getObject(9);

                while (productsRs.next()) {
                    String code = productsRs.getString("CodProducto");
                    Double amount = productsRs.getDouble("Cantidad");
                    String type = productsRs.getString("TipoProducto");
                    Double unitaryPrice = productsRs.getDouble("PrecioUnitario");
                    Double totalPrice = productsRs.getDouble("ValorVenta");
                    Double discount = productsRs.getDouble("Pdscto");
                    Double totalDiscount = productsRs.getDouble("ValorDscto");
                    Double taxes = productsRs.getDouble("PIGV");
                    Double totalTaxes = productsRs.getDouble("ValorIGV");
                    Double finalPrice = productsRs.getDouble("Total");
                    products.add(new ProductOrderDetail(code, amount, type, unitaryPrice, totalPrice, discount, totalDiscount, taxes, totalTaxes, finalPrice));
                }

                double totalPrice = statement.getDouble(3);
                double totalDiscount = statement.getDouble(4);
                double totalPerception = statement.getDouble(5);
                double totalTaxes = statement.getDouble(6);

                return new CloseOrderResponse(orderId, totalPrice, totalDiscount, totalPerception, totalTaxes, products);
            } else {
                throw new ProcedureExecutionException(statement.getString(8));
            }
        } finally {
            statement.close();
        }
    }
}