package org.kaviya.services;


import org.kaviya.model.Account;
import org.kaviya.model.Customer;
import org.kaviya.repository.CustomerRepository;

public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createCustomer(String name, String customerId, Account account) {
        Customer customer = new Customer(name, customerId, account);
        customerRepository.createCustomer(customer);
    }

    public Customer getCustomer(String customerId) {
        return customerRepository.getCustomer(customerId);
    }

    public boolean updateCustomer(Customer updatedCustomer) {
        return customerRepository.updateCustomer(updatedCustomer);
    }

    public boolean deleteCustomer(String customerId) {
        return customerRepository.deleteCustomer(customerId);
    }
}

