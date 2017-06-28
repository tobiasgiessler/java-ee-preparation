package org.javalearners.chapter2.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This example creates a servlet using the servlet declaration in the web.xml 
 * file. It forwards the request it receives to the accountServlet for further 
 * processing.
 */
public class ForwardingServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //response.sendRedirect("http://localhost:8080/java-ee-preparation-web/account?customer=Homer Simpsons");
        request.getRequestDispatcher("accountServlet").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        processRequest(request, response);
    }

}
