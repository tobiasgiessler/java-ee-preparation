package org.javalearners.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
    
    @GET
    @Path("queryparams")
    public String getQueryParam(@QueryParam("name") final String name) {
        // http://localhost:8080/messenger/webapi/injectdemo/queryparams?name=Homer Simpson
        return "name: " + name;
    }
    
    @GET
    @Path("matrixparams")
    public String getMatrixParam(@MatrixParam("name") final String name) {
        // http://localhost:8080/messenger/webapi/injectdemo/matrixparams;name=Homer Simpson
        return "name: " + name;
    }
    
    @POST
    @Path("formparams")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String getFormParam(@FormParam("name") final String name) {
        return "name: " + name;
    }
    
    @GET
    @Path("headerparams")
    public String getHeaderParam(@HeaderParam("customHeader") final String headerValue) {
        return "customHeader: " + headerValue;
    }
    
    @GET
    @Path("cookieparams")
    public String getCookieParam(@CookieParam("cookieName") final String cookieValue) {
        return "cookieName: " + cookieValue;
    }
    
    @GET
    @Path("context")
    public String getParamsViaContext(
            @Context UriInfo uriInfo, 
            @Context HttpHeaders headers) {
        final String absolutePath = uriInfo.getAbsolutePath().toString();
        final String cookies = headers.getCookies().toString();
        return "path: " + absolutePath + "\ncookies: " + cookies;
    }
    
}
