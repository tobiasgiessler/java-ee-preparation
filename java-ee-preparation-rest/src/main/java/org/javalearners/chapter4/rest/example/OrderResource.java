package org.javalearners.chapter4.rest.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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

    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_XML)
    public Order createOrder(@FormParam("id") final int id, @FormParam("amount") final double amount) {
        final Order order = new Order(id, amount);
        orders.add(order);
        return order;
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Order putXml(@PathParam("id") final int id, final String content) {
        final Order order = getOrderById(id);
        System.out.println("submitted content: " + content);
        // do some updates based on content
        return order;
    }

    @DELETE
    @Path("{id}")
    public void deleteOrder(@PathParam("id") final int id) {
        final Order order = getOrderById(id);
        System.out.println("Removing order with id=" + id);
        orders.remove(order);
    }

    private Order getOrderById(final int id) {
        return orders.stream()
                .filter(o -> o.getId() == id)
                .findFirst()
                .get();
    }

}
