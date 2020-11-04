package com.configbased.config;

import com.configbased.services.GreetingServiceImpl;
import com.configbased.services.GreetingServiceImplVersion2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class GreetingConfig {
    @Bean

    public GreetingServiceImpl greetingServiceImpl(){
        return new GreetingServiceImpl();
    }

    @Bean
    @Primary
    public GreetingServiceImplVersion2 greetingServiceImplVersion2(){
        return new GreetingServiceImplVersion2();
    }

}
