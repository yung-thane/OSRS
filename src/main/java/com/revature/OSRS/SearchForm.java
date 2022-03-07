package com.revature.OSRS;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SearchForm extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String HTMLForm = "<Html>\n" +
                "<Head>\n" +
                "    <Title>Search OSRS Items</Title>\n" +
                "</Head>\n" +
                "<Body>\n" +
                "    <h1>OSRS Items Search</h1>\n" +
                "    <form " +
                "action='' method='get'>\n" +
                "            <input type='name' name='searchName" +
                "'/>\n" +
                "            <input type='submit' value='Search" +
                "'/>\n" +
                "            <a href='OSRSItems.csv'>View All Items</a>\n" +
                "    </form>\n" +
                "</Body>\n" +
                "</Html>";
                resp.getWriter().println(HTMLForm);
    }
}
