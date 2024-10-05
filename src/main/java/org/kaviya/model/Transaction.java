package org.kaviya.model;

import java.util.UUID;

public class Transaction {
    private String transactionId;  // Unique identifier for the transaction
    private String accountNumber;   // Account number related to the transaction
    private double amount;          // Amount of the transaction
    private String type;            // Type of transaction: deposit or withdraw

    // Constructor generates a unique transaction ID if not provided
    public Transaction(String accountNumber, double amount, String type) {
        this.transactionId = UUID.randomUUID().toString();  // Generate a unique transaction ID
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.type = type;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Transaction ID: " + transactionId +
                ", Account: " + accountNumber +
                ", Amount: $" + amount +
                ", Type: " + type;
    }
}
