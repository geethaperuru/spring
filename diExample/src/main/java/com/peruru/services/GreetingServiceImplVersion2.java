package com.peruru.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("Telugu")
public class GreetingServiceImplVersion2 implements GreetingService{
    @Override
    public String getGreeting() {
        return "Namasthe Geetha";
    }
}
