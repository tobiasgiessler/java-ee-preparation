package org.javalearners.cdi.service;

// A bean with no qualifier automatically has the qualifier @Default

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class Greeting {
    
    public String greet(String name) {
        return "Hello, " + name + ".";
    }
    
}
