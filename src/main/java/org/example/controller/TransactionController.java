package org.example.controller;

import org.example.model.TransactionModel;
import org.example.repository.CustomerRepository;
import org.example.repository.TransactionRepository;

public class TransactionController {

    private final TransactionModel transactionModel = new TransactionModel();
    private TransactionRepository transactionRepository = new TransactionRepository();

    public TransactionController() {
    }

    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public boolean registerNewTransaction(String dateTransaction, Double valueTransaction, int id_origin_account, int id_destination_account) {
        transactionModel.setDatetransaction(dateTransaction);
        transactionModel.setValue(valueTransaction);
        transactionModel.setId_origin_account(id_origin_account);
        transactionModel.setId_destination_account(id_destination_account);
        return transactionRepository.registerNewTransaction(transactionModel.getDatetransaction(), transactionModel.getValue(), transactionModel.getId_origin_account(), transactionModel.getId_destination_account());
    }

    public boolean showAllTransactionsofaSpecificAccount(int idoriginaccount) {
        transactionModel.setId_origin_account(idoriginaccount);
        return transactionRepository.showAllTransactionsofaSpecificAccount(transactionModel.getId_origin_account());
    }

}
