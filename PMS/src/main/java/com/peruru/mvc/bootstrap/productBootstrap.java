package com.peruru.mvc.bootstrap;

import com.peruru.mvc.model.Product;
import com.peruru.mvc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class productBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private ProductService productService;

    @Autowired
    public productBootstrap(ProductService productService) {
        this.productService = productService;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadProducts();
    }
    public void loadProducts() {

        Product chocolate = new Product();
        chocolate.setId(1);
        chocolate.setName("Chocolate");
        chocolate.setCost(10.0);
        productService.saveOrUpdateProduct(chocolate);

        Product icecream = new Product();
        icecream.setId(2);
        icecream.setName("Ice Cream");
        icecream.setCost(30.0);
        productService.saveOrUpdateProduct(icecream);

        Product biscuit = new Product();
        biscuit.setId(3);
        biscuit.setName("Biscuit");
        biscuit.setCost(25.0);
        productService.saveOrUpdateProduct(biscuit);

        Product snack = new Product();
        snack.setId(4);
        snack.setName("Manchurian");
        snack.setCost(70.0);
        productService.saveOrUpdateProduct(snack);
    }

}
