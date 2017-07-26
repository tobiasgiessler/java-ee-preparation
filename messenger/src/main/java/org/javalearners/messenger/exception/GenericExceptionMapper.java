package org.javalearners.messenger.exception;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.javalearners.messenger.model.ErrorMessage;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {
        final ErrorMessage errorMessage = new ErrorMessage(
                exception.getMessage(), 
                Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), 
                "www.google.de");
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
                .entity(errorMessage)
                .build();
    }
    
}
