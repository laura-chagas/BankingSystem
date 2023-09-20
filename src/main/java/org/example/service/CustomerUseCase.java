package org.example.service;

import org.example.controller.BankAccountController;
import org.example.controller.CustomerController;
import org.example.controller.TransactionController;

public class CustomerUseCase extends ValidationsInfosCustomer {

    static BankAccountController bankAccountController = new BankAccountController();
    static CustomerController customerController = new CustomerController();

    static TransactionController transactionController = new TransactionController();

    public static boolean logIn(String cpf) {
        if (checkCpf(cpf)) {
            return customerController.logIn(cpf);
        }
        return false;
    }

    public boolean registerNewCustomer(String nameUseCase, String cpfUseCase, String addressUseCase) {
        if (checkName(nameUseCase) && checkCpf(cpfUseCase) && checkAddress(addressUseCase)) {
            return customerController.registerNewCustomer(nameUseCase, cpfUseCase, addressUseCase);
        }
        return false;
    }

    public boolean showBalance(String accountNumber) {
        return bankAccountController.showBalance(accountNumber);
    }

    public boolean deleteBankAccount(String accountNumber) {
        return bankAccountController.deleteBankAccount(accountNumber);
    }

    public boolean updateBalanceSubstract(int idAccount, Double value) {
        return bankAccountController.updateBalanceSubstract(idAccount, value);
    }

    public boolean updateBalanceAdd(int idAccount, Double value) {
        return bankAccountController.updateBalanceAdd(idAccount, value);
    }

    public void realizeTransaction(String dateTransaction, Double value, int idAccountOrigin, int idAccountDestin) {
        bankAccountController.updateBalanceSubstract(idAccountOrigin, value);
        bankAccountController.updateBalanceAdd(idAccountDestin, value);
        transactionController.registerNewTransaction(dateTransaction, value, idAccountOrigin, idAccountDestin);
    }

    public boolean showAccountCustomers(int customerid) {
        return bankAccountController.showAccountCustomers(customerid);
    }

    public boolean showAllTransactionsofaSpecificAccount(int idoriginaccount) {
        return transactionController.showAllTransactionsofaSpecificAccount(idoriginaccount);
    }
}
