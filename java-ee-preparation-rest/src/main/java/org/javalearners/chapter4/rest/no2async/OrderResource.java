package org.javalearners.chapter4.rest.no2async;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("orders")
public class OrderResource {
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getAll() {
        return "Hello World";
    }
    
}
