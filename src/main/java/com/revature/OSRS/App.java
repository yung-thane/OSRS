package com.revature.OSRS;


import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class App {
    public static void main(String[] args){
        URI uri = null;
        //Uses class.ClassLoader, .getResource, and .to.URI to scan through folders and get OSRSItems.csv as a URI named uri.
        //It's useful because once program is packaged and shipped the folder structure changes making hard coding a filepath
        // problematic. Take care to note that once you load ClassLoader, any changes made to the file will only be reflected
        // once the program/ClassLoader is restarted. Surround with try/catch to handle URISyntaxException.
        try {
            uri = App.class.getClassLoader().getResource("OSRSItems.csv").toURI();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        //Uses a Paths.get to save uri as a Path named filepath.
        Path filepath = Paths.get(uri);
        List<String> lines = null;

        //Using Files.readAllLines and the Path filepath acquired above, makes a List<String> named lines. Surrounded with
        //a try/catch for the IOException.
        try {
            lines = Files.readAllLines(filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Shorthand version of for each loops
        lines.forEach(System.out::println);
    }
}
