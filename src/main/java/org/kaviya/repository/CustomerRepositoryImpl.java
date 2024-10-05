package org.kaviya.repository;

import org.kaviya.model.Customer;
import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private Map<String, Customer> customerMap = new HashMap<>();

    @Override
    public void createCustomer(Customer customer) {
        customerMap.put(customer.getCustomerId(), customer);
    }

    @Override
    public Customer getCustomer(String customerId) {
        return customerMap.get(customerId);
    }

    @Override
    public boolean updateCustomer(Customer updatedCustomer) {
        if (customerMap.containsKey(updatedCustomer.getCustomerId())) {
            customerMap.put(updatedCustomer.getCustomerId(), updatedCustomer);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCustomer(String customerId) {
        if (customerMap.containsKey(customerId)) {
            customerMap.remove(customerId);
            return true;
        }
        return false;
    }

    @Override
    public Map<String, Customer> getAllCustomers() {
        return customerMap;
    }
}

