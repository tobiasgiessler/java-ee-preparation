package org.javalearners.chapter4.rest.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

@Path("orders")
public class OrderResource {

    private final List<Order> orders;

    public OrderResource() {
        orders = new ArrayList<>();
        orders.add(new Order(0, 5));
        orders.add(new Order(1, 5));
        orders.add(new Order(2, 5));
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Order> getAll() {
        return orders;
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("{oid}")
    public Order getOrder(@PathParam("oid") int oid) {
        List<Order> filteredOrders = orders
                .stream()
                .filter(order -> order.getId() == oid)
                .collect(Collectors.toList());
        return filteredOrders.get(0);
    }

    @GET
    @Path("revenue")
    @Produces(MediaType.TEXT_PLAIN)
    public void getRevenue(@Suspended final AsyncResponse ar) {
        Executors.newSingleThreadExecutor().submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException ex) {
                Logger.getLogger(OrderResource.class.getName()).log(Level.SEVERE, null, ex);
            }
            ar.resume(
                    Double.toString(orders.stream().mapToDouble(Order::getAmount).sum())
            );
        });
    }

}
