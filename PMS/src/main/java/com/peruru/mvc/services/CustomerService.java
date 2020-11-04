package com.peruru.mvc.services;

import com.peruru.mvc.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomersList();
    Customer getCustomerById(int id);
    Customer saveOrUpdate(Customer customer);
    void DeleteCustomer(int id);
}
