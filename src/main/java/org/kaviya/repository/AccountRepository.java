package org.kaviya.repository;

import org.kaviya.model.Account;  // Ensure this matches your actual package name
import java.util.Map;

public interface AccountRepository {
    void createAccount(Account account);
    Account getAccount(String accountNumber);
    boolean updateAccount(Account updatedAccount);
    boolean deleteAccount(String accountNumber);
    Map<String, Account> getAllAccounts();
}
