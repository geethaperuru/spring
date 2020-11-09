package com.practise.jpa.service.jpaServices;

import com.practise.jpa.model.User;
import com.practise.jpa.service.UserService;
import com.practise.jpa.service.security.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@Primary
public class UserServiceJpa extends JpaService implements UserService {

    private EncryptionService encryptionService;

    @Autowired
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    @Override
    public List<?> listAll() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("select u from User u",User.class).getResultList();
    }

    @Override
    public User getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(User.class,id);
    }

    @Override
    public User saveOrUpdate(User user) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        if(user.getPassword() != null){
            user.setEncryptedPassword(encryptionService.encryptString(user.getPassword()));
        }
        User savedUser = em.find(User.class,user.getId());
        em.getTransaction().commit();
        return savedUser;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(User.class,id));
        em.getTransaction().commit();
    }
}
