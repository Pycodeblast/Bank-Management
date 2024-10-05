package org.kaviya.services;

import org.kaviya.model.Transaction;
import org.kaviya.repository.TransactionRepository;
import org.kaviya.repository.AccountRepository;

import java.util.List;

public class TransactionService {
    private final TransactionRepository transactionRepository;  // Repository for transaction data
    private final AccountRepository accountRepository; // To get account details

    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    public void createTransaction(String accountNumber, double amount, String type) {
        // Validate transaction type
        if (!type.equalsIgnoreCase("deposit") && !type.equalsIgnoreCase("withdraw")) {
            throw new IllegalArgumentException("Transaction type must be either 'deposit' or 'withdraw'.");
        }

        // Create a new transaction
        Transaction transaction = new Transaction(accountNumber, amount, type);
        transactionRepository.createTransaction(transaction);
    }

    public void deposit(String accountNumber, double amount) {
        accountRepository.getAccount(accountNumber).deposit(amount);
        createTransaction(accountNumber, amount, "deposit");
    }

    public void withdraw(String accountNumber, double amount) {
        accountRepository.getAccount(accountNumber).withdraw(amount);
        createTransaction(accountNumber, amount, "withdraw");
    }

    public List<Transaction> getTransactionsByAccount(String accountNumber) {
        return transactionRepository.getAllTransactionsByAccount(accountNumber);
    }

    public boolean deleteTransaction(String transactionId) {
        return transactionRepository.deleteTransaction(transactionId);
    }
}
