package com.revature.OSRS;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DefaultController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Setting content type lets the browser know what type of data it is working with.
        resp.setContentType("text/html");
        //Default is 200, we don't have to set unless we want to alter later on.
        resp.setStatus(200);
        resp.getWriter().println("<html>\n" +
                "<head>\n" +
                "    <title>OSRS Item Site" +
                "</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <h1>Welcome to the Item site</h1>\n" +
                "</body>\n" +
                "</html>");
    }
}
