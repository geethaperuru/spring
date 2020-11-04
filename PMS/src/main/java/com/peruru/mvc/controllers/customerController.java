package com.peruru.mvc.controllers;

import com.peruru.mvc.model.Customer;
import com.peruru.mvc.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class customerController {

    private CustomerService customerService;

    @Autowired
    public customerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/customers")
    public String getCustomersList(Model model){
        model.addAttribute("customers",customerService.getCustomersList());
        return "customers";
    }
    @RequestMapping("/customer/{id}")
    public String getCustomerById(@PathVariable("id") Integer id, Model model){
        model.addAttribute("customer",customerService.getCustomerById(id));
        return "customer";
    }

    @RequestMapping("/customer/add")
    public String addCustomer(Model model){
        model.addAttribute("customer",new Customer());
        return "customerForm";
    }

    @RequestMapping("/customer/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Integer id){
        customerService.DeleteCustomer(id);
        return "redirect:/customers";
    }
    @RequestMapping("/customer/edit/{id}")
    public String editCustomer(@PathVariable("id") Integer id,Model model){
        model.addAttribute("customer",customerService.getCustomerById(id));
        return "customerForm";
    }

    @RequestMapping(value = "/customer",method = RequestMethod.POST)
    public String saveOrUpdate(Customer customer){
        Customer savedCustomer = customerService.saveOrUpdate(customer);
        return "redirect:/customer/"+savedCustomer.getId();
    }
}
