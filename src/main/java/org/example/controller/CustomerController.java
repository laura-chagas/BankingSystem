package org.example.controller;

import org.example.repository.CustomerRepository;
import org.example.model.CustomerModel;

public class CustomerController {
    private final CustomerModel customerModel = new CustomerModel();
    private CustomerRepository customerRepositoryController = new CustomerRepository();

    public CustomerController() {
    }

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepositoryController = customerRepository;
    }

    public boolean registerNewCustomer(String name, String cpf, String address) {
        customerModel.setName(name);
        customerModel.setCpf(cpf);
        customerModel.setAddress(address);
        return customerRepositoryController.registerNewCustomer(customerModel.getName(), customerModel.getCpf(), customerModel.getAddress());
    }

    public boolean logIn(String cpf) {
        customerModel.setCpf(cpf);
        return customerRepositoryController.logIn(customerModel.getCpf());
    }

    public boolean deleteCustomer(String cpfCustomer) {
        customerModel.setCpf(cpfCustomer);
        return customerRepositoryController.deleteCustomer(customerModel.getCpf());
    }

    public boolean changeAddress(String cpfCustomer, String newAddress) {
        customerModel.setCpf(cpfCustomer);
        customerModel.setAddress(newAddress);
        return customerRepositoryController.changeAddress(customerModel.getCpf(), customerModel.getAddress());
    }

}
