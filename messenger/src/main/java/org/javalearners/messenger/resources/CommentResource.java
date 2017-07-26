package org.javalearners.messenger.resources;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.javalearners.messenger.model.Comment;
import org.javalearners.messenger.service.CommentService;

@Path("")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {
    
    private final CommentService commentService = new CommentService();
    
    @GET
    public List<Comment> getAllComments(
            @PathParam("messageId") final long messageId) {
        return commentService.getAllComments(messageId);
    }
    
    @POST
    public Comment addCommment(
            @PathParam("messageId") final long messageId, 
            final Comment comment) {
        return commentService.addComment(messageId, comment);
    }
    
    @GET
    @Path("{commentId}")
    public Comment getComment(
            @PathParam("messageId") final long messageId,
            @PathParam("commentId") final long commentId) {
        return commentService.getComment(messageId, commentId);
    }
    
    @PUT
    @Path("{commentId}")
    public Comment updateComment(
            @PathParam("messageId") final long messageId,
            @PathParam("commentId") final long commentId,
            final Comment commment) {
        return commentService.updateComment(messageId, commentId, commment);
    }
    
    @DELETE
    @Path("{commentId}")
    public Comment deleteComment(
            @PathParam("messageId") final long messageId,
            @PathParam("commentId") final long commentId) {
        return commentService.removeComment(messageId, commentId);
    }
    
}
