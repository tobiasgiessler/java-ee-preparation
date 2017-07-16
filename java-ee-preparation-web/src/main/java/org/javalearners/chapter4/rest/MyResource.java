package org.javalearners.chapter4.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("resource")
public class MyResource {
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {
        //http://localhost:8080/java-ee-preparation-web/webresources/resource
        System.out.println("get");
        return "foobar";
    }
    
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String post(
            @FormParam("name") final String name, 
            @FormParam("age") final String age) {
        System.out.println("post");
        System.out.println("name: " + name);
        System.out.println("age: " + age);
        return new StringBuilder()
                .append("Added entry for ")
                .append(name)
                .append(" (").append(age).append(").")
                .toString();
    }
    
}
