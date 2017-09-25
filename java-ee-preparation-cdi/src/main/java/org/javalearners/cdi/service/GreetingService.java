package org.javalearners.cdi.service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class GreetingService {
    
    @Inject
    private Greeting greeting;
    
    public String phraseGreeting(String name) {
        return greeting.greet(name);
    }
    
}
