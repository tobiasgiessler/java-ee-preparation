package org.javalearners.cdi.service;

import javax.enterprise.context.Dependent;

@Dependent
public class Hello {

    public String sayHello(String name) {
        return "Hello " + name;
    }

}
