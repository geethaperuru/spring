package com.peruru.mvc.services;

import com.peruru.mvc.model.Customer;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class CustomerServiceImpl implements CustomerService{

    Map<Integer,Customer> customers;

    public CustomerServiceImpl() {
        loadCustomers();
    }

    private void loadCustomers() {
        customers = new HashMap<>();

        Customer c1 = new Customer();
        c1.setId(1);
        c1.setFirstName("Geetha");
        c1.setLastName("Peruru");
        c1.setEmail("geetha@gmail.com");
        c1.setCity("Proddatur");
        c1.setState("AP");
        c1.setAddress1("D:No:11/140 upstairs");
        c1.setAddress2("Dargha Bazar");
        c1.setPhoneNumber("9876543210");
        c1.setZipcode("516360");

        Customer c2 = new Customer();
        c2.setId(2);
        c2.setFirstName("Pavan");
        c2.setLastName("Peruru");
        c2.setEmail("pavan@gmail.com");
        c2.setCity("Proddatur");
        c2.setState("AP");
        c2.setAddress1("D:No:11/140 upstairs");
        c2.setAddress2("Dargha Bazar");
        c2.setPhoneNumber("8796345120");
        c2.setZipcode("516360");

        Customer c3 = new Customer();
        c3.setId(3);
        c3.setFirstName("Shyam");
        c3.setLastName("Peruru");
        c3.setEmail("shyam@gmail.com");
        c3.setCity("Proddatur");
        c3.setState("AP");
        c3.setAddress1("D:No:11/140 upstairs");
        c3.setAddress2("Dargha Bazar");
        c3.setPhoneNumber("7347590183");
        c3.setZipcode("516360");

        customers.put(1,c1);
        customers.put(2,c2);
        customers.put(3,c3);
    }

    @Override
    public List<Customer> getCustomersList() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer getCustomerById(int id) {
        return customers.get(id);
    }
    public int getNextKey(){
        return Collections.max(customers.keySet())+1;
    }
    @Override
    public Customer saveOrUpdate(Customer customer) {
        if(customer != null){
            if(!customers.containsKey(customer.getId())){
                customer.setId(getNextKey());
            }
            customers.put(customer.getId(),customer);
            return customer;
        }else{
            throw new RuntimeException("customer cannot be null");
        }
    }

    @Override
    public void DeleteCustomer(int id) {
        customers.remove(id);
    }
}
