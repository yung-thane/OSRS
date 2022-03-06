package com.revature.OSRS;

import org.apache.catalina.startup.Tomcat;

public class AppContext {

    private static final String itemCSVFile = "OSRSItems.csv";
    public static ItemRepository itemRepository;
    private static ItemService itemService;
    private static Tomcat server;
    private static ItemController itemController;

    public static void build(){
        itemRepository = new ItemRepository(itemCSVFile);
        itemService = new ItemService(itemRepository);
        itemController = new ItemController();
        //Starting Tomcat server.
        server = new Tomcat();
        server.getConnector();
        server.addContext("", null);
        server.addServlet("", "itemServlet", itemController).addMapping("/items");
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
