package com.chatbot.storemanager.repository.operations;

import java.sql.*;
import java.util.ArrayList;

import com.chatbot.storemanager.model.Address;
import com.chatbot.storemanager.model.Client;
import com.chatbot.storemanager.model.Document;
import org.springframework.jdbc.object.StoredProcedure;

public class GetClientInfo extends StoredProcedure {

    public static ArrayList<Client> getClient(Connection conn, String companyId, String clientId) throws SQLException {

        final CallableStatement statement = conn.prepareCall("{call pack_api_erpynet.p_cliente_buscar(?, ?, ?, ?, ?)}");

        statement.setString(1, companyId);
        statement.setString(2, clientId);
        statement.registerOutParameter(3, Types.VARCHAR);
        statement.registerOutParameter(4, Types.REF_CURSOR);
        statement.registerOutParameter(5, Types.REF_CURSOR);

        statement.execute();

        ArrayList<Client> clients = new ArrayList<>();
        ArrayList<Address> addresses = new ArrayList<>();

        if ("OK".equals(statement.getString(3))) {
            final ResultSet clientsRs = (ResultSet) statement.getObject(4);
            final ResultSet addressesRs = (ResultSet) statement.getObject(5);

            while (addressesRs.next()) {
                String codDir = addressesRs.getString("CodDir");
                String dirEntrega = addressesRs.getString("DirEntrega");
                String codRuta = addressesRs.getString("CodRuta");
                String nombreRuta = addressesRs.getString("NombreRuta");
                String giroNego = addressesRs.getString("GiroNego");
                String codVendedor = addressesRs.getString("CodVendedor");
                String nombreVendedor = addressesRs.getString("NombreVendedor");
                String condicionVenta = addressesRs.getString("CondicionVenta");
                String listaPrecio = addressesRs.getString("ListaPrecio");
                Double latitud = addressesRs.getDouble("Latitud");
                Double longitud = addressesRs.getDouble("Longitud");
                String idSucu = addressesRs.getString("IdSucu");
                String idAlma = addressesRs.getString("IdAlma");

                addresses.add(new Address(codDir, dirEntrega, codRuta, nombreRuta, giroNego, codVendedor,
                        nombreVendedor, condicionVenta, listaPrecio, latitud, longitud, idSucu, idAlma));
            }

            while (clientsRs.next()) {
                String codCliente = clientsRs.getString("CodCliente");
                String razonSoc = clientsRs.getString("RazonSoc");
                String domFiscal = clientsRs.getString("DomiFiscal");
                String tipDocIden = clientsRs.getString("TipDocIden");
                String nroDocIden = clientsRs.getString("NroDocIden");
                Double limiteCred = clientsRs.getDouble("LimiteCred");

                clients.add(new Client(codCliente, razonSoc, domFiscal, addresses, new Document(tipDocIden, nroDocIden), limiteCred));
            }
        }
        statement.close();

        return clients;
    }

}