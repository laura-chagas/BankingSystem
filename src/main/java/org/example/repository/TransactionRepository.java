package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.connection.ConnectionDB.connect;

public class TransactionRepository {

    private Connection conn = connect();
    private PreparedStatement pstm;

    public boolean registerNewTransaction(String dateTransaction, Double valueTransaction, int id_origin_account, int id_destination_account) {
        try {
            String SQL = "INSERT INTO tbtransaction (datetransaction, valuetransaction, id_origin_account, id_destination_account) " +
                    "VALUES (?,?,?,?) ";
            pstm = conn.prepareStatement(SQL);
            pstm.setString(1, dateTransaction);
            pstm.setDouble(2, valueTransaction);
            pstm.setInt(3, id_origin_account);
            pstm.setInt(4, id_destination_account);
            pstm.executeUpdate();
            pstm.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean showAllTransactionsofaSpecificAccount(int idoriginaccount) {
        try {
            String SQL = "SELECT * FROM tbtransaction WHERE id_origin_account = ?";
            pstm = conn.prepareStatement(SQL);
            pstm.setInt(1, idoriginaccount);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("DATA DA TRANSAÇÃO: " + rs.getString("dateTransaction"));
                System.out.println("VALOR TRANSFERIDO: " + rs.getString("valueTransaction"));
                System.out.println("ID DE ORIGEM: " + rs.getString("id_origin_account"));
                System.out.println("ID DE DESTINO: " + rs.getString("id_destination_account"));
                System.out.println();
            }
            pstm.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
