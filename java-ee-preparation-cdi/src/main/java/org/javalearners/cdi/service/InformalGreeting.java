package org.javalearners.cdi.service;

import javax.enterprise.context.RequestScoped;

@Informal
@RequestScoped
public class InformalGreeting extends Greeting {
    
    @Override
    public String greet(String name) {
        return "Hi, " + name + "!";
    }
    
}
