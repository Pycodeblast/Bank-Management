package org.kaviya.repository;

import org.kaviya.model.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionRepositoryImpl implements TransactionRepository {
    private Map<String, List<Transaction>> transactionMap; // Maps account numbers to lists of transactions

    public TransactionRepositoryImpl() {
        transactionMap = new HashMap<>();
    }

    @Override
    public void createTransaction(Transaction transaction) {
        // Get the list of transactions for the account number, or create a new one
        transactionMap
                .computeIfAbsent(transaction.getAccountNumber(), k -> new ArrayList<>())
                .add(transaction);
    }

    @Override
    public boolean deleteTransaction(String transactionId) {
        for (List<Transaction> transactions : transactionMap.values()) {
            for (Transaction transaction : transactions) {
                if (transaction.getTransactionId().equals(transactionId)) {
                    transactions.remove(transaction);
                    return true; // Transaction removed successfully
                }
            }
        }
        return false; // Transaction not found
    }

    @Override
    public List<Transaction> getAllTransactionsByAccount(String accountNumber) {
        return transactionMap.getOrDefault(accountNumber, new ArrayList<>()); // Return empty list if none found
    }

    public List<Transaction> getTransactionsForAccount(String accountNumber) {
        return getAllTransactionsByAccount(accountNumber);
    }
}
