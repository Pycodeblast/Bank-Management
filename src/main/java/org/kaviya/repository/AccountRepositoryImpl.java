package org.kaviya.repository;



import org.kaviya.model.Account;
import java.util.HashMap;
import java.util.Map;

public class AccountRepositoryImpl implements AccountRepository {
    private Map<String, Account> accountMap = new HashMap<>();

    @Override
    public void createAccount(Account account) {
        accountMap.put(account.getAccountNumber(), account);
    }

    @Override
    public Account getAccount(String accountNumber) {
        return accountMap.get(accountNumber);
    }

    @Override
    public boolean updateAccount(Account updatedAccount) {
        if (accountMap.containsKey(updatedAccount.getAccountNumber())) {
            accountMap.put(updatedAccount.getAccountNumber(), updatedAccount);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAccount(String accountNumber) {
        if (accountMap.containsKey(accountNumber)) {
            accountMap.remove(accountNumber);
            return true;
        }
        return false;
    }

    @Override
    public Map<String, Account> getAllAccounts() {
        return accountMap;
    }
}

