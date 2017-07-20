package org.javalearners.messenger.applications;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.javalearners.messenger.resources.MessageResource;

@ApplicationPath("webapi")
public class MessengerApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> resources = new HashSet<>();
        resources.add(MessageResource.class);
        return resources;
    }



}
