package com.peruru.mvc.services;

import com.peruru.mvc.model.Product;

import java.util.List;


public interface ProductService {
    List<Product> getProductList();
    Product getProductById(int id);
    Product saveOrUpdateProduct(Product product);
    void deleteProduct(int id);
}
