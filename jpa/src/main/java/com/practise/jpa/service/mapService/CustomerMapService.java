package com.practise.jpa.service.mapService;

import com.practise.jpa.model.Customer;
import com.practise.jpa.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerMapService implements CustomerService {

    private Map<Integer, Customer> map;

    public CustomerMapService() {
        map = new HashMap<>();
    }

    @Override
    public List<Customer> listAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public Customer getById(Integer id) {
        return map.get(id);
    }
    private Integer getNextKey(){
        return Collections.max(map.keySet()) + 1;
    }
    @Override
    public Customer saveOrUpdate(Customer customer) {
        if (customer != null){

            if (customer.getId() == null){
                customer.setId(getNextKey());
            }
            map.put(customer.getId(), customer);
            return customer;
        } else {
            throw new RuntimeException("Object Can't be null");
        }
    }

    @Override
    public void delete(Integer id) {
        map.remove(id);
    }
}
