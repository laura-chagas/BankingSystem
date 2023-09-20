package org.example.service;

public class ValidationsInfosCustomer {
    public static boolean checkCpf(String cpf) {
        return (cpf.length() > 11);
    }

    public boolean checkName(String nameCheck) {
        return (!nameCheck.isEmpty());
    }

    public boolean checkAddress(String addressCheck) {
        return (!addressCheck.isEmpty());
    }


}
