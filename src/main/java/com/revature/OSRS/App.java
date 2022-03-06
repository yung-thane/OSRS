package com.revature.OSRS;


import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

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
        //Loads Data
        List<Item> items = loadItems();

        //Search query
        String searchQuery = "Dragon harpoon";
        System.out.println(searchByName(searchQuery, items));

        //Save results

        }
        public static BufferedReader loadItemCSV(String csvFile) {
            if (!csvFile.endsWith(".csv"))
                throw new IllegalArgumentException("Must be a CSV file.");
            //Uses class.ClassLoader, .getResource, and .to.URI to scan through folders and get OSRSItems.csv as a URI named uri.
            //It's useful because once program is packaged and shipped the folder structure changes making hard coding a filepath
            // problematic. Take care to note that once you load ClassLoader, any changes made to the file will only be reflected
            // once the program/ClassLoader is restarted. Surround with try/catch to handle URISyntaxException.
            try {
                URI uri = Objects.requireNonNull(App.class.getClassLoader().getResource(csvFile)).toURI();
                //Uses a Paths.get to save uri as a Path named filepath.
                Path filepath = Paths.get(Objects.requireNonNull(uri));
                return Files.newBufferedReader(filepath);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (IOException e) {
                System.err.println("Couldn't load file.");
            }
        }



        public static List<Item> parseItems(BufferedReader br) throws IOException, CsvException {
            List<Item> items = new ArrayList<>();
            //Using OpenCSV library implementation to build a parser using CSVParserBuilder, .withSeparator to separate columns with commas as a delimeter,
            //.skipline(1) to skip the header in the parsing, and .build to complete the build.
            //CSVreader named reader is built using CSVReaderBuilder with the br BufferedReader passed as an argument and withCSVParser with parser passed as an argument
            //and .build to complete the build. We then use the CSVReader we just made to save the lines of information to a List<String[]> named lines.
            //We ensure to close the reader.
            CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
            CSVReader reader = new CSVReaderBuilder(br).withCSVParser(parser).withSkipLines(1).build();
            List<String[]> lines = reader.readAll();
            reader.close();
            //Parsing lines into Item array.
            for (String[] columns: lines) {
                items.add(new Item(Integer.parseInt(columns[1]), columns[2], Integer.parseInt(columns[5]), Integer.parseInt(columns[7])));
            }
            return items;
        }

        public static String searchByName(String searchQuery, List<Item> items){
            for (Item item: items){
                if(item.getItemName().equalsIgnoreCase(searchQuery))
                    return item.getItemName();
        }
        return null;
    }
}
