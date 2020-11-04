package com.peruru.mvc.bootstrap;

import com.peruru.mvc.model.Customer;
import com.peruru.mvc.services.CustomerService;
import com.peruru.mvc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class customerBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private CustomerService customerService;
    @Autowired
    public customerBootstrap(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadProducts();
    }

    private void loadProducts() {
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
        customerService.saveOrUpdate(c1);

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
        customerService.saveOrUpdate(c2);

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
        customerService.saveOrUpdate(c3);

    }

}
