package com.chatbot.storemanager.repository.operations;

import com.chatbot.storemanager.model.ProductInfo;
import org.springframework.jdbc.object.StoredProcedure;

import java.sql.*;
import java.util.ArrayList;

public class GetProductInfo extends StoredProcedure {

    private static final String DEFAULT_COMPANY = "03";

    public static ArrayList<ProductInfo> getProducts(Connection conn, String productId) throws SQLException {

        final CallableStatement statement = conn.prepareCall("{call pack_api_erpynet.p_producto_buscar(?, ?, ?, ?, ?, ?, ?, ?)}");

        statement.setString(1, DEFAULT_COMPANY);
        statement.setString(2, "");
        statement.setString(3, "");
        statement.setString(4, productId);
        statement.setString(5, "");
        statement.setString(6, "");
        statement.registerOutParameter(7, Types.VARCHAR);
        statement.registerOutParameter(8, Types.REF_CURSOR);

        statement.execute();

        ArrayList<ProductInfo> productInfos = new ArrayList<>();

        if ("OK".equals(statement.getString(7))) {
            final ResultSet productsRs = (ResultSet) statement.getObject(8);

            while (productsRs.next()) {
                String code = productsRs.getString("Cod_producto");
                String name = productsRs.getString("Nom_Producto");
                String buyingPackaging = productsRs.getString("EmpaqueCompra");
                int masterStockAmount = productsRs.getInt("Stock_Master");
                String sellingPackaging = productsRs.getString("EmpaqueVta");
                int stockAmount = productsRs.getInt("Stock_Unidad");
                String fragmentIndicator = productsRs.getString("IndicadoFraccion");
                double masterPrice = productsRs.getDouble("PrecioMaster");
                double salePrice = productsRs.getDouble("PrecioVta");

                productInfos.add(new ProductInfo(code, name, buyingPackaging, masterStockAmount,
                        sellingPackaging, stockAmount, fragmentIndicator, masterPrice, salePrice));
            }

        }
        statement.close();

        return productInfos;
    }

}