package org.javalearners.chapter3.jsf;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class UserService implements Serializable {

    @Inject
    private User user;

    public void register() {
        System.out.println(
                new StringBuilder()
                        .append("Registering ")
                        .append(user.getName())
                        .append(" with the password \"")
                        .append(user.getPassword())
                        .append("\"")
                        .toString());
    }
}
