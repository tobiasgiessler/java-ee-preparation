package org.javalearners.messenger.resources;

import java.util.List;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.javalearners.messenger.model.Message;
import org.javalearners.messenger.resources.beans.MessageFilterBean;
import org.javalearners.messenger.service.MessageService;

@Path("messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

    private final MessageService messageService = new MessageService();

    @GET
    public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) {
        if (filterBean.getYear() != null) {
            return messageService.getAllMessagesByYear(filterBean.getYear());
        } else if (
                filterBean.getStart() != null && 
                filterBean.getSize() != null) {
            return messageService.getAllMessagesPaginated(
                    filterBean.getStart(), 
                    filterBean.getSize());
        } else {
            return messageService.getAllMessages();
        }
    }

    @GET
    @Path("{messageId}")
    public Message getMessage(@PathParam("messageId") final long messageId) {
        return messageService.getMessage(messageId);
    }

    @POST
    public Message addMessage(final Message message) {
        return messageService.addMessage(message);
    }

    @PUT
    @Path("{messageId}")
    public Message updateMessage(
            @PathParam("messageId") final long messageId,
            final Message message) {
        message.setId(messageId);
        return messageService.updateMessage(message);
    }

    @DELETE
    @Path("{messageId}")
    public void removeMessage(@PathParam("messageId") final long messageId) {
        messageService.removeMessage(messageId);
    }
    
    @Path("{messageId}/comments")
    public CommentResource getCommentResource() {
        return new CommentResource();
    }

}
