package org.javalearners.messenger.resources;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.javalearners.messenger.model.Message;
import org.javalearners.messenger.service.MessageService;

@Path("messages")
public class MessageResource {

    private final MessageService messageService = new MessageService();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<Message> getMessages() {
        return messageService.getAllMessages();
    }

}
