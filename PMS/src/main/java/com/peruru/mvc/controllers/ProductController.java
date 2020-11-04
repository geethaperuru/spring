package com.peruru.mvc.controllers;

import com.peruru.mvc.model.Product;
import com.peruru.mvc.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //list
    @RequestMapping("/products")
    public String listProducts(Model model){
        model.addAttribute("products",productService.getProductList());
        return "products";
    }

    //by id
    @RequestMapping("/product/{id}")
    public String getProduct(@PathVariable("id") Integer id, Model model){
        model.addAttribute("product",productService.getProductById(id));
        return "product";
    }

    //delete
    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id){
        productService.deleteProduct(id);
        return "redirect:/products";
    }
    //update
    @RequestMapping("/edit/{id}")
    public String updateProduct(@PathVariable("id") Integer id,Model model){
        model.addAttribute("product",productService.getProductById(id));
        return "productForm";
    }
    //create
    @RequestMapping("/product/new")
    public String createProduct(Model model){
        model.addAttribute("product",new Product());
        return "productForm";
    }
    //view product
    @RequestMapping(value = "/product",method = RequestMethod.POST)
    public String saveOrUpdate(Product product){
        Product savedProduct = productService.saveOrUpdateProduct(product);
        return "redirect:/product/"+savedProduct.getId();
    }
}
