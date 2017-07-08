package org.javalearners.chapter3.jsf;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class Name {

    private String value = "Homer Simpson";

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
