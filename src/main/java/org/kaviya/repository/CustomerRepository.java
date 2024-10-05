package org.kaviya.repository;



import org.kaviya.model.Customer;
import java.util.Map;

public interface CustomerRepository {
    void createCustomer(Customer customer);
    Customer getCustomer(String customerId);
    boolean updateCustomer(Customer updatedCustomer);
    boolean deleteCustomer(String customerId);
    Map<String, Customer> getAllCustomers();
}

