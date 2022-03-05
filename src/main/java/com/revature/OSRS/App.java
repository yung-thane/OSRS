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
import java.util.List;

public class App {
    public static void main(String[] args){
        List<String[]> lines = loadItems();

        //Shorthand version of for each loops
        //lines.forEach(System.out::println);
        String searchQuery = "Dragon harpoon";
        System.out.println(searchByName(searchQuery, lines));
        }
        public static List<String[]> loadItems(){
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
            List<String[]> lines = null;
            //Using Files.newBufferedReader and the Path filepath acquired above, makes a Buffered Reader named br. Surrounded with
            //a try/catch for the IOException. Using while and .ready the br bufferedreader is looped through while there is data to be read.
            try {
                BufferedReader br = Files.newBufferedReader(filepath);

                //Using OpenCSV library implementation to read
                CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
                CSVReader reader = new CSVReaderBuilder(br).withCSVParser(parser).build();
                 lines = reader.readAll();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (CsvException e){
                e.printStackTrace();
            }
            return lines;
        }

        public static String searchByName(String searchQuery, List<String[]> lines){
            for (String[] item: lines){
                if(item[2].contains(searchQuery))
                    return item[2];
        }
        return null;
    }
}
