package com.practise.jpa.service;

import java.util.List;

public interface CRUDService<T> {
    List<?> listAll();

    T getById(Integer id);

    T saveOrUpdate(T obj);

    void delete(Integer id);
}
