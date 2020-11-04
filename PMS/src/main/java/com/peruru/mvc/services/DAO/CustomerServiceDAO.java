package com.peruru.mvc.services.DAO;

import com.peruru.mvc.model.Customer;
import com.peruru.mvc.services.CustomerService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
@Primary
public class CustomerServiceDAO implements CustomerService {

    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }


    @Override
    public List<Customer> getCustomersList() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("select c from Customer c",Customer.class).getResultList();
    }

    @Override
    public Customer getCustomerById(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Customer.class,id);
    }

    @Override
    public Customer saveOrUpdate(Customer customer) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Customer savedCustomer = em.merge(customer);
        em.getTransaction().commit();
        return savedCustomer;
    }

    @Override
    public void DeleteCustomer(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Customer.class,id));
        em.getTransaction().commit();
    }
}
