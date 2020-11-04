package com.peruru.mvc.services;

import com.peruru.mvc.model.Product;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProductServiceImpl implements ProductService{

    private Map<Integer,Product> products;

    public ProductServiceImpl() {
        loadProducts();
    }

    @Override
    public List<Product> getProductList() {
        return new ArrayList<>(products.values());
    }
    public void loadProducts() {
        products = new HashMap<>();
        Product chocolate = new Product();
        chocolate.setId(1);
        chocolate.setName("Chocolate");
        chocolate.setCost(10.0);

        Product icecream = new Product();
        icecream.setId(2);
        icecream.setName("Ice Cream");
        icecream.setCost(30.0);

        Product biscuit = new Product();
        biscuit.setId(3);
        biscuit.setName("Biscuit");
        biscuit.setCost(25.0);

        Product snack = new Product();
        snack.setId(4);
        snack.setName("Manchurian");
        snack.setCost(70.0);

        products.put(1,chocolate);
        products.put(2,icecream);
        products.put(3,biscuit);
        products.put(4,snack);
    }

    @Override
    public Product getProductById(int id) {
        return products.get(id);
    }

    private Integer getNextKey(){
        return Collections.max(products.keySet())+1;
    }

    @Override
    public Product saveOrUpdateProduct(Product product) {
        if(product != null){
            if(!products.containsKey(product.getId())){
                product.setId(getNextKey());
            }
            products.put(product.getId(),product);
            return product;
        }else{
            throw new RuntimeException("Product cannot be null");
        }
    }

    @Override
    public void deleteProduct(int id) {
        products.remove(id);
    }


}
