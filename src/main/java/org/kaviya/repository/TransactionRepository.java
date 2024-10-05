package org.kaviya.repository;

import org.kaviya.model.Transaction;
import java.util.List;

public interface TransactionRepository {
    void createTransaction(Transaction transaction);
    boolean deleteTransaction(String transactionId);
    List<Transaction> getAllTransactionsByAccount(String accountNumber); // Add this method
}
