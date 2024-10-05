package org.kaviya;

import org.kaviya.model.Account;
import org.kaviya.model.Bank;
import org.kaviya.model.Customer;
import org.kaviya.model.Transaction; // Make sure to create a Transaction class
import org.kaviya.repository.AccountRepositoryImpl;
import org.kaviya.repository.CustomerRepositoryImpl;
import org.kaviya.repository.TransactionRepositoryImpl;
import org.kaviya.services.AccountService;
import org.kaviya.services.CustomerService;
import org.kaviya.services.TransactionService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Repositories
        AccountRepositoryImpl accountRepository = new AccountRepositoryImpl();
        CustomerRepositoryImpl customerRepository = new CustomerRepositoryImpl();
        TransactionRepositoryImpl transactionRepository = new TransactionRepositoryImpl();

        // Services
        AccountService accountService = new AccountService(accountRepository);
        CustomerService customerService = new CustomerService(customerRepository);
        TransactionService transactionService = new TransactionService(transactionRepository, accountRepository);

        // Bank
        Bank bank = new Bank("MyBank");

        // Create Account
        accountService.createAccount("12345", 1000.00);
        Account account = accountService.getAccount("12345");

        // Add account to the bank
        bank.addAccount(account);

        // Create Customer
        customerService.createCustomer("John Doe", "C001", account);
        Customer customer = customerService.getCustomer("C001");

        // Add customer to the bank
        bank.addCustomer(customer);

        // Perform some transactions for demonstration
        transactionService.deposit("12345", 500.00);  // Deposit transaction
        transactionService.withdraw("12345", 200.00); // Withdrawal transaction

        // Print Bank and Customer details
        System.out.println(bank);
        System.out.println(customer);

        // Print important details
        System.out.println("Important Bank Details:");
        System.out.println("Bank Name: " + bank.getName());
        System.out.println("Total Accounts: " + bank.getAccounts().size());
        System.out.println("Total Customers: " + bank.getCustomers().size());
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.printf("Account Balance: $%.2f%n", account.getBalance());
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("Customer ID: " + customer.getCustomerId());

        // Print Transaction History
        List<Transaction> transactions = transactionRepository.getTransactionsForAccount("12345");
        System.out.println("Transaction History for Account Number " + account.getAccountNumber() + ":");
        System.out.println("----------------------------------------------------");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
