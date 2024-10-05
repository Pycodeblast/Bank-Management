package org.kaviya.services;

import org.kaviya.model.Account;
import org.kaviya.repository.AccountRepository;  // Ensure this matches your package structure

public class AccountService {
    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void createAccount(String accountNumber, double balance) {
        Account account = new Account(accountNumber, balance);
        accountRepository.createAccount(account);
    }

    public Account getAccount(String accountNumber) {
        return accountRepository.getAccount(accountNumber);
    }

    public boolean updateAccount(Account updatedAccount) {
        return accountRepository.updateAccount(updatedAccount);
    }

    public boolean deleteAccount(String accountNumber) {
        return accountRepository.deleteAccount(accountNumber);
    }
}
