package com.spring;

import com.peruru.controllers.GreetingController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.peruru")
public class DependancyInjectionApplication {
    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(DependancyInjectionApplication.class, args);
        GreetingController greetingController = (GreetingController) context.getBean("greetingController");

        String greet = greetingController.greet();
        System.out.println(greet);
    }
}
