package com.configbased.controllers;

import com.configbased.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

    private GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }
    public String greet(){
        String s = greetingService.getGreeting();
        //System.out.println(s);
        return s;
    }
}
