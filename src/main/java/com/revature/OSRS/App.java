package com.revature.OSRS;


import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class App {
    public static void main(String[] args){
        AppContext.build();

        //Serve on Tomcat server.
        try {
            AppContext.getTomcat().start();
        } catch (LifecycleException e) {
            System.err.println("Embedded server failed to start.");
        }
        }
}
