package com.peruru.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        ConstructorDI constructorDI = (ConstructorDI) context.getBean("constructorDI");
        SetterDI setterDI = (SetterDI) context.getBean("setterDI");

        constructorDI.getMessage();
        setterDI.getMessage();
    }

}
