package com.practise.jpa.bootstrap;

import com.practise.jpa.model.Customer;
import com.practise.jpa.model.User;
import com.practise.jpa.service.CustomerService;
import com.practise.jpa.service.UserService;
import com.practise.jpa.service.security.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

@Component
public class InputBootstrap implements ApplicationListener<ContextRefreshedEvent>  {


    private EncryptionService encryptionService;
    private CustomerService customerService;
    private UserService userService;
    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Autowired
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }
    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadData();
    }

    private void loadData() {
        EntityManager em = emf.createEntityManager();

        User u = new User();
        u.setVersion(1);
        u.setPassword("password");
        u.setVersion(1);
        u.setEnabled(true);
        u.setEncryptedPassword(encryptionService.encryptString(u.getPassword()));

        Customer c1 = new Customer();
        c1.setVersion(1);
        c1.setFirstName("Geetha");
        c1.setLastName("Peruru");
        c1.setEmail("geetha@gmail.com");
        c1.setCity("Proddatur");
        c1.setState("AP");
        c1.setAddressLine1("D:No:11/140 upstairs");
        c1.setAddressLine2("Dargha Bazar");
        c1.setPhoneNumber("9876543210");
        c1.setZipCode("516360");
        c1.setUser(u);

        customerService.saveOrUpdate(c1);

    }
}
