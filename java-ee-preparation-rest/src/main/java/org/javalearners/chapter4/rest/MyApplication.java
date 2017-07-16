package org.javalearners.chapter4.rest;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import org.javalearners.chapter4.rest.no1firstresource.MyResource;
import org.javalearners.chapter4.rest.no2async.OrderResource;

@ApplicationPath("webresources")
public class MyApplication extends Application {
    
    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> resources = new HashSet<>();
        resources.add(MyResource.class);
        resources.add(OrderResource.class);
        return resources;
    }
    
}
