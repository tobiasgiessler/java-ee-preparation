package org.javalearners.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.javalearners.messenger.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

    @Override
    public Response toResponse(DataNotFoundException exception) {
        final ErrorMessage errorMessage = new ErrorMessage(
                exception.getMessage(), 
                Status.NOT_FOUND.getStatusCode(), 
                "www.google.de");
        return Response.status(Status.NOT_FOUND)
                .entity(errorMessage)
                .build();
    }
    
}
