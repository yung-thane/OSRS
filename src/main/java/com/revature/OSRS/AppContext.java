package com.revature.OSRS;

import org.apache.catalina.startup.Tomcat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AppContext {

    private static final String itemCSVFile = "OSRSItems.csv";
    public static ItemRepository itemRepository;
    private static ItemService itemService;
    private static Tomcat server;
    private static ItemController itemController;
    private static Connection connection;

    public static void build(){
        itemRepository = new ItemRepository(itemCSVFile);
        itemService = new ItemService(itemRepository);
        itemController = new ItemController();
        //Starting Tomcat server.
        server = new Tomcat();
        server.getConnector();
        server.addContext("", null);
        server.addServlet("", "defaultServlet", new DefaultController()).addMapping("/*");
        server.addServlet("", "itemServlet", itemController).addMapping("/items");
        server.addServlet("", "searchServlet", new SearchForm()).addMapping("/search");
        try {
            //Makes database in memory. Creates a table. Must be rerun every time program is reopened.
            //connection = DriverManager.getConnection("jdbc:h2:mem:", "OSRS", "OSRS");
            connection = DriverManager.getConnection("jdbc:h2:~/OSRS", "OSRS", "OSRS");
            connection.createStatement().execute("CREATE TABLE ITEMS(itemId int primary key, itemName varchar, buyAverage int, sellAverage int, profitAverage int)");
            itemRepository.setConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ItemRepository getItemRepository() {
        return itemRepository;
    }

    public static ItemService getItemService() {
        return itemService;
    }

    public static Tomcat getTomcat(){
        return server;
    }
}
