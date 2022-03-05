package com.revature.OSRS;

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
    @Test
    public void givenItemName_ThenReturnItem(){
        List<String[]> lines = App.loadItems();

        String givenItem = "Dragon harpoon";
        String result = App.searchByName(givenItem, lines);
        assertEquals(givenItem, result);
    }

}