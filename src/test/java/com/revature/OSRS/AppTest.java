package com.revature.OSRS;

import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    static List<Item> lines;

    @BeforeAll
    public static void setup() throws IOException, CsvException {
        lines = App.parseItems(App.loadItemCSV("OSRSItems.csv"));
    }
    @Test
    public void givenItemName_ThenReturnItem(){
        String givenItem = "Dragon harpoon";
        String result = App.searchByName(givenItem, lines);
        assertEquals(givenItem, result);
    }

    @Test
    public void givenNonCSVFile_ThenThrowsIllegalArgumentException(){
        String notCSV = "OSRSItems.txt";
        App.loadItemCSV(notCSV);
        //Our test fails although the results are what we were expecting. Therefore we assertThrows, which we use a lambda
        //function for.
        assertThrows(IllegalArgumentException.class,()-> App.loadItemCSV(notCSV));
    }

}