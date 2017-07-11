package org.javalearners.chapter3.jsf;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

@Named
@SessionScoped
public class User implements Serializable {

    private String name;
    private String password;
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public void login(ActionEvent evt) {
        if (getName().equals(getPassword())) {
            setStatus("Login successful");
        } else {
            setStatus("Login failed");
        }
    }
}
