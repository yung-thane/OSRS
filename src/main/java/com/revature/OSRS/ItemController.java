package com.revature.OSRS;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ItemController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("itemName");
        String result = AppContext.getItemService().searchByName(name);
        resp.getWriter().println(result);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("itemId"));
        String name = req.getParameter("itemName");
        int buy = Integer.parseInt(req.getParameter("buyAverage"));
        int sell = Integer.parseInt(req.getParameter("sellAverage"));

        AppContext.getItemService().saveItem(new Item(id, name, buy, sell));

    }
}
