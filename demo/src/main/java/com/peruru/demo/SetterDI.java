package com.peruru.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SetterDI {
    private HelloWorldService helloWorldService;
    @Autowired
    public void setHelloWorldService(HelloWorldService helloWorldService){
        this.helloWorldService = helloWorldService;
    }
    public void getMessage(){
        helloWorldService.sayHello();
        System.out.println("I am from setterDI");
    }
}
