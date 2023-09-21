package org.example.view;

import org.example.service.CustomerUseCase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CustomerView {

    static Scanner scan;

    static CustomerUseCase customerUseCase;

    public CustomerView() {
        scan = new Scanner(System.in);
        customerUseCase = new CustomerUseCase();
    }

    public static void logIn() {
        System.out.println("Preencha seu cpf: ");
        System.out.print("CPF: ");
        String cpfView = scan.next();

        if (CustomerUseCase.logIn(cpfView)) {
            menuCustomer();
        } else {
            System.out.println("CAMPO INVÁLIDO. ");
        }
    }

    public static void registerCustomer() {
        System.out.println("Preencha suas informações: ");
        System.out.print("PRIMEIRO NOME: ");
        String nameView = scan.next();
        System.out.print("CPF (com ou sem ponto/traço): ");
        String cpfView = scan.next();
        System.out.print("ENDEREÇO (ex: Rua example, 451) : ");
        scan.nextLine();
        String addressView = scan.nextLine();

        if (customerUseCase.registerNewCustomer(nameView, cpfView, addressView)) {
            System.out.println("Cliente cadastrado! ");
            logIn();
        } else {
            System.out.println("CAMPOS INVÁLIDOS. ");
        }
    }

    public static void registerNewAccount() {

        System.out.print("INFORME O NUMERO DA CONTA: ");
        String accountnumberView = scan.next();

        System.out.print("INFORME O ID DA CONTA: ");
        int idAccountView = scan.nextInt();

        if ( customerUseCase.registerNewBankAccount(accountnumberView, 0.00, idAccountView)){
            System.out.println("CONTA BANCÁRIA REGISTRADA COM SUCESSO! ");
        }else {
            System.out.println("CAMPOS FORAM PREENCHIDOS ERRADO! ");
        }

    }

    public static void deleteCustomer(){
        System.out.print("INFORME SEU CPF: ");
        String cpfCustomer = scan.next();

       if (customerUseCase.deleteCustomer(cpfCustomer)){
           System.out.println("CLIENTE DELETADO COM SUCESSO! ");
       }else {
           System.out.println("CPF INVÁLIDO! ");
       }

    }

    public static void menuCustomer() {
        int choice;
        do {
            System.out.println("VOCÊ DESEJA: ");
            System.out.println("[1] Ver saldo         [2] Sacar dinheiro| \n[3] Depositar         [4] Deletar conta| \n[5] PIX         [6] VER TODAS AS SUAS CONTAS| \n[7] VER TODAS AS TRANSAÇÕES         [8] REGISTRAR CONTA BANCÁRIA\n         [0] Sair|");
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    customerUseCase.showBalance(receiveNumberAccount());
                    break;
                case 2:
                    System.out.println("Informe o id da sua conta! ");
                    int idAccountView = scan.nextInt();

                    System.out.println("Informe o valor a ser sacado! ");
                    double valueView = scan.nextDouble();

                    if (customerUseCase.updateBalanceSubstract(idAccountView, valueView)) {
                        System.out.println("Saque efetuado! ");
                    } else {
                        System.out.println("Algum campo foi preenchido errado! tente novamente...");
                    }
                    break;
                case 3:
                    customerUseCase.updateBalanceAdd(receiveIdAccount(), receivevalue());
                    System.out.println("Deposito efetuado! ");
                    break;
                case 4:
                    String conta = receiveNumberAccount();
                    if (conta.length() == 6) {
                        customerUseCase.deleteBankAccount(conta);
                        System.out.println("Conta excluída :) ");
                    } else {
                        System.out.println("Número da conta informado é incorreto! ");
                    }
                    break;
                case 5:
                    if (transaction()) {
                        System.out.println("Transação realizada com sucesso");
                    } else {
                        System.out.println("Ocorreu um error na transação");
                    }
                    break;
                case 6:
                    customerUseCase.showAccountCustomers(receiveIdAccount());
                    break;
                case 7:
                    customerUseCase.showAllTransactionsofaSpecificAccount(receiveIdAccount());
                    break;
                case 8:
                    registerNewAccount();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida");
            }
        } while (choice != 0);

    }

    private static boolean transaction() {
        int idOriginAccount = receiveIdAccount();

        double value = receivevalue();

        System.out.println("Digite o id da conta para qual deseja transferir:");
        int id_destination_account = scan.nextInt();

        String date = returnsFormattedCurrentDate();

        customerUseCase.realizeTransaction(date, value, idOriginAccount, id_destination_account);
        return true;
    }

    private static String returnsFormattedCurrentDate() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return localDate.format(formatter);
    }

    public static String receiveNumberAccount() {

        System.out.print("Digite o número da sua conta: ");
        String numberAccountView = scan.next();
        return numberAccountView;

    }

    public static int receiveIdAccount() {

        System.out.print("Informe o id da sua conta:  ");
        int idAccountView = scan.nextInt();

        return idAccountView;

    }

    public static double receivevalue() {

        System.out.println("Informe o valor: ");
        double valueView = scan.nextDouble();

        return valueView;

    }
}

