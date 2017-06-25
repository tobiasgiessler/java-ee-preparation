package org.javalearners.chapter2.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This example creates a servlet using the @WebServlet annotation. Servlets can
 * also be defined using the web.xml file.
 * 
 * To the servlet the name "SpringfieldAcountServlet" is assigned. 
 * 
 * The urlPatterns determine with which urls the servlet can be called.
 * 
 * In initParams the param "financialAdviser" is declared with a value. This 
 * param can be used inside the servlet.
 */
@WebServlet(
        name = "SpringfieldAccountServlet",
        urlPatterns = {"/account", "/accountServlet"},
        initParams = {
            @WebInitParam(name = "financialAdviser", value = "Charles Montgomery Burns")
        }
)
public class AccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (final PrintWriter out = response.getWriter()) {
            final String customerName = request.getParameter("customer");
            final String responseContent = new StringBuilder()
                    .append("<html>")
                    .append("<head>")
                    .append("<title>")
                    .append("MyServlet")
                    .append("</title>")
                    .append("<body>")
                    .append("<h1>My First Servlet</h1>")
                    .append("<h2>Account Servlet</h2>")
                    .append("<div>")
                    .append("Financial Adviser: ").append(getInitParameter("financialAdviser"))
                    .append("</div>")
                    .append("<div>")
                    .append("Customer: ").append(customerName)
                    .append("</div>")
                    .append("<div>")
                    .append("Number of visits: ").append(getNumberOfVisits(request))
                    .append("</div>")
                    .append("</body>")
                    .append("</html>")
                    .toString();
            out.println(responseContent);
        }
    }
    
    private int getNumberOfVisits(HttpServletRequest request) {
        final String attrName = "numberOfVisits";
        final Object attrValue = request.getSession().getAttribute(attrName);
        final int numberOfVisits = attrValue != null ? (int) attrValue : 0;

        request.getSession().setAttribute(attrName, numberOfVisits+1);
        return numberOfVisits;
    }

}
