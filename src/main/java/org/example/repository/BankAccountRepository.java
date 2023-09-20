package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.connection.ConnectionDB.connect;

public class BankAccountRepository {

    private Connection conn = connect();
    private PreparedStatement pstm;


    public boolean registerNewBankAccount(String accountNumber, Double balance, int customerid) {
        try {
            String SQL = "INSERT INTO tbbankaccount(accountnumber, balance, customerid) VALUES (?,?,?)";
            pstm = conn.prepareStatement(SQL);
            pstm.setString(1, accountNumber);
            pstm.setDouble(2, balance);
            pstm.setInt(3, customerid);
            pstm.executeUpdate();
            pstm.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteBankAccount(String accountNumber) {
        try {
            String SQL = "DELETE FROM tbbankaccount WHERE accountnumber = ?";
            pstm = conn.prepareStatement(SQL);
            pstm.setString(1, accountNumber);
            pstm.executeUpdate();
            pstm.close();
            return true;
        } catch (SQLException error) {
            error.printStackTrace();
        }
        return false;
    }

    public boolean showBalance(String accountNumber) {
        try {
            String SQL = "SELECT balance FROM tbbankaccount WHERE accountNumber = ?";
            pstm = conn.prepareStatement(SQL);
            pstm.setString(1, accountNumber);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("SALDO: " + rs.getDouble("balance"));
                System.out.println();
            }
            pstm.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean showAccountCustomers(int customerid) {
        try {
            String SQL = "SELECT accountnumber FROM tbbankaccount WHERE customerid = ? ";
            pstm = conn.prepareStatement(SQL);
            pstm.setInt(1, customerid);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                System.out.println("NÚMERO DA CONTA: " + rs.getString("accountnumber"));
                System.out.println();

            }
            pstm.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateBalanceSubstract(int idAccount, Double value) {
        try {
            String SQL = "UPDATE tbbankaccount SET balance = balance - " + value + " WHERE idAccount = ? ";
            pstm = conn.prepareStatement(SQL);
            pstm.setDouble(1, value);
            pstm.setInt(1, idAccount);
            pstm.executeUpdate();
            pstm.close();
            return true;
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return false;
    }

    public boolean updateBalanceAdd(int idAccount, Double value) {
        try {
            String SQL = "UPDATE tbbankaccount SET balance = balance + " + value + " WHERE idAccount = ? ";
            pstm = conn.prepareStatement(SQL);
            pstm.setDouble(1, value);
            pstm.setInt(1, idAccount);
            pstm.executeUpdate();
            pstm.close();
            return true;
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return false;
    }


}

