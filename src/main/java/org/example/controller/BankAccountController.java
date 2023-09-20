package org.example.controller;

import org.example.model.BankAccountModel;
import org.example.repository.BankAccountRepository;

public class BankAccountController {
    private final BankAccountModel bankAccountModel = new BankAccountModel();
    private BankAccountRepository bankAccountRepositoryController = new BankAccountRepository();

    public BankAccountController() {

    }

    public BankAccountController(BankAccountRepository bankAccountRepositoryController) {
        this.bankAccountRepositoryController = bankAccountRepositoryController;
    }

    public boolean registerNewBankAccount(String accountNumber, Double balance, int customerid) {
        bankAccountModel.setAccountNumber(accountNumber);
        bankAccountModel.setBalance(balance);
        bankAccountModel.setCustomerId(customerid);
        return bankAccountRepositoryController.registerNewBankAccount(bankAccountModel.getAccountNumber(), bankAccountModel.getBalance(), bankAccountModel.getCustomerId());
    }

    public boolean deleteBankAccount(String accountNumber) {
        bankAccountModel.setAccountNumber(accountNumber);
        return bankAccountRepositoryController.deleteBankAccount(bankAccountModel.getAccountNumber());
    }

    public boolean showBalance(String accountNumber) {
        bankAccountModel.setAccountNumber(accountNumber);
        return bankAccountRepositoryController.showBalance(bankAccountModel.getAccountNumber());
    }

    public boolean showAccountCustomers(int customerid) {
        bankAccountModel.setCustomerId(customerid);
        return bankAccountRepositoryController.showAccountCustomers(bankAccountModel.getCustomerId());
    }

    public boolean updateBalanceSubstract(int idAccount, Double value) {
        bankAccountModel.setCustomerId(idAccount);
        return bankAccountRepositoryController.updateBalanceSubstract(bankAccountModel.getCustomerId(), value);
    }

    public boolean updateBalanceAdd(int idAccount, Double value) {
        bankAccountModel.setCustomerId(idAccount);
        return bankAccountRepositoryController.updateBalanceAdd(bankAccountModel.getCustomerId(), value);
    }


}
