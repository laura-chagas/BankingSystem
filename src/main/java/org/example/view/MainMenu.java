package org.example.view;

import java.util.Scanner;

public class MainMenu {
    Scanner scan;
    CustomerView customerView;

    public MainMenu() {
        scan = new Scanner(System.in);
        customerView = new CustomerView();
    }

    public void start() {

        int indentUser;

        do {
            System.out.println("BEM-VINDO AO SISTEMA DE BANCÁRIO");
            System.out.println("VOCÊ DESEJA: \n\t[1] LOGAR      [2] REGISTRAR-SE   [3] DELETAR CONTA CLIENTE [0] SAIR");
            indentUser = scan.nextInt();
            switch (indentUser) {
                case 1:
                     CustomerView.logIn();
                    break;
                case 2:
                    CustomerView.registerCustomer();
                    break;
                case 3:
                    CustomerView.deleteCustomer();
                    break;
                case 0:
                    System.out.println("ENCERRANDO...");
                    System.exit(0);
                default:
                    System.out.println("Opção Inválida! \n");

            }
        } while (indentUser != 0);

    }


}