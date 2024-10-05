package org.kaviya.model;


import java.util.ArrayList;
import java.util.List;

public class Bank {
    private String name;
    private List<Account> accounts;  // List of accounts in the bank
    private List<Customer> customers;  // List of customers in the bank

    public Bank(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public String toString() {
        return "Bank: " + name + ", Accounts: " + accounts.size() + ", Customers: " + customers.size();
    }
}

