package com.testcompany.app;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;

/**
 * Application Entry Point
 */
public class App 
{
    public static void main( String[] args )
    {

        try (FileReader reader = new FileReader("./data.json"))
        {
            // Read in data from JSON file
            JsonObject obj = (JsonObject) Jsoner.deserialize(reader);
            JsonArray data = (JsonArray) obj.get("data");

            System.out.println(data);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JsonException e) {
            e.printStackTrace();
        }
    }
}
