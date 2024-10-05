package org.kaviya.model;

public class Customer {
    private String name;
    private String customerId;
    private Account account;

    public Customer(String name, String customerId, Account account) {
        this.name = name;
        this.customerId = customerId;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "Customer ID: " + customerId + ", Name: " + name + ", " + account;
    }

}






