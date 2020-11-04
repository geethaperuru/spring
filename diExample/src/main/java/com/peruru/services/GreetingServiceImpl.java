package com.peruru.services;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
//@Primary
//@Profile("English")
@Profile({"default","English"})
public class GreetingServiceImpl implements GreetingService{

    @Override
    public String getGreeting() {
        return "Hi Geetha";
    }
}
