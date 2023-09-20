package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.connection.ConnectionDB.connect;

public class CustomerRepository {
    private Connection conn = connect();
    private PreparedStatement pstm;

    public boolean registerNewCustomer(String name, String cpf, String address) {
        try {
            String SQL = "INSERT INTO tbCustomer (name, cpf,address) VALUES (?,?,?) ";
            pstm = conn.prepareStatement(SQL);
            pstm.setString(1, name);
            pstm.setString(2, cpf);
            pstm.setString(3, address);
            pstm.executeUpdate();
            pstm.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean logIn(String cpf) {
        try {
            String SQL = "SELECT * FROM tbcustomer WHERE cpf = ?";
            pstm = conn.prepareStatement(SQL);
            pstm.setString(1, cpf);
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getString("cpf").equals(cpf)) {
                    pstm.close();
                    return true;
                }
            }
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return false;
    }

    public boolean deleteCustomer(String cpfCustomer) {
        try {
            String SQL = "DELETE FROM tbcustomer WHERE cpf = ?";
            pstm = conn.prepareStatement(SQL);
            pstm.setString(1, cpfCustomer);
            pstm.executeUpdate();
            pstm.close();
            return true;
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return false;
    }

    public boolean changeAddress(String cpfCustomer, String newAddress) {
        try {
            String SQL = "UPDATE tbcustomer SET address = ? WHERE cpf = ?";

            pstm = conn.prepareStatement(SQL);
            pstm.setString(1, newAddress);
            pstm.setString(1, cpfCustomer);
            pstm.executeUpdate();
            pstm.close();
            return true;
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return false;
    }


}
