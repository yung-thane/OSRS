package com.revature.OSRS;


import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.ServerError;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class App {
    public static void main(String[] args){
        AppContext.build();
        //Serve on Tomcat server
        Tomcat server = new Tomcat();
        server.getConnector();
        server.addContext("", null);
        //Using an anonymous class, HttpServlet
        server.addServlet("", "itemServlet", new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                String name = req.getParameter("name");
                String result = AppContext.searchByName(name);
                resp.getWriter().println(result);
            }
        }).addMapping("/items");
        try {
            server.start();
        } catch (LifecycleException e) {
            System.err.println("Embedded server failed to start.");
        }
        //Save results
        }
}
