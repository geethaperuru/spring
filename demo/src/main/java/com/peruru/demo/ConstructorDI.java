package com.peruru.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConstructorDI {
    private HelloWorldService helloWorldService;

    public ConstructorDI(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }
    public void getMessage(){
        helloWorldService.sayHello();
        System.out.println("I am from Constructor DI");
    }
}
