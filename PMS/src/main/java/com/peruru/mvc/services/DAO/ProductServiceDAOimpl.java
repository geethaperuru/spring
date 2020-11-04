package com.peruru.mvc.services.DAO;

import com.peruru.mvc.model.Product;
import com.peruru.mvc.services.ProductService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Primary
public class ProductServiceDAOimpl implements ProductService {

    private EntityManagerFactory emf;

    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<Product> getProductList() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("select p from Product p",Product.class).getResultList();
    }

    @Override
    public Product getProductById(int id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Product.class,id);
    }

    @Override
    @Transactional
    public Product saveOrUpdateProduct(Product product) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Product savedProduct = em.merge(product);
        em.getTransaction().commit();
        return savedProduct;
    }

    @Override
    @Transactional
    public void deleteProduct(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Product.class,id));
        em.getTransaction().commit();
    }
}
