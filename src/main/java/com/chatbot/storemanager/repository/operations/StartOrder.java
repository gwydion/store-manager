package com.chatbot.storemanager.repository.operations;

import com.chatbot.storemanager.exceptions.ProcedureExecutionException;
import com.chatbot.storemanager.model.StartOrderRequest;
import org.springframework.jdbc.object.StoredProcedure;

import java.sql.*;

public class StartOrder extends StoredProcedure {

    public static String startOrder(Connection conn, StartOrderRequest request) throws SQLException, ProcedureExecutionException {
        CallableStatement statement = null;
        try {
            statement = conn.prepareCall("{call pack_api_erpynet.p_grabapedidocab(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");

            statement.setString(1, request.getCompanyId());
            statement.setString(2, "");
            statement.setString(3, request.getClientId());
            statement.setString(4, request.getAddressId());
            statement.setString(5, request.getDate());
            statement.setString(6, request.getSellingConditionId());
            statement.setString(7, request.getPriceListId());
            statement.setString(8, request.getSellerId());
            statement.setString(9, request.getRouteId());
            statement.setString(10, request.getLatitude());
            statement.setString(11, request.getLongitude());
            statement.setString(12, request.getObservation());
            statement.setString(13, request.getStatus());
            statement.setString(14, request.getTotal());
            statement.setString(15, request.getDocumentType());
            statement.setString(16, request.getDocumentNumber());
            statement.setString(17, request.getName());
            statement.setString(18, request.getDeliveryAddress());
            statement.setString(19, request.getPhoneNumber());
            statement.registerOutParameter(20, Types.VARCHAR);
            statement.registerOutParameter(21, Types.VARCHAR);
            statement.registerOutParameter(22, Types.REF_CURSOR);

            statement.execute();

            String id = "";
            if ("OK".equals(statement.getString(20))) {
                final ResultSet messages = (ResultSet) statement.getObject(22);

                if (messages.next()) {
                    id = messages.getString(1);
                }
                return id;
            } else {
                throw new ProcedureExecutionException(statement.getString(21));
            }
        } finally {
            statement.close();
        }
    }

}