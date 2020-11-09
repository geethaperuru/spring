package com.practise.jpa.service.jpaServices;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

public class JpaService {
    protected EntityManagerFactory emf;

    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

}
