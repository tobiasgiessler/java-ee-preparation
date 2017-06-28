package org.javalearners.chapter2.servlets;

import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * ServletContainerInitializer can be used to dynamically add servlets.
 * @author tobi
 */
public class MyServletInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        final ServletRegistration.Dynamic registration = ctx.addServlet("ForwardingServlet", new ForwardingServlet());
        registration.addMapping("/dynamicForward");
    }

}
