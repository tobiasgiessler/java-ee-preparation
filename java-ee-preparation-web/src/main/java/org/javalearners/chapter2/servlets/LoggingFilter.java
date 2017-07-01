package org.javalearners.chapter2.servlets;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * A request filter may be used to update the request and response payload. In this example we just use it to print
 * status information for every received request.
 */
@WebFilter(filterName = "LoggingFilter", urlPatterns = {"/*"})
public class LoggingFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("received request");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

}
