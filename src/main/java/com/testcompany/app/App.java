package com.testcompany.app;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonException;
import com.github.cliftonlabs.json_simple.JsonObject;
import com.github.cliftonlabs.json_simple.Jsoner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Application Entry Point
 */
public class App 
{
    public static void main( String[] args )
    {
        ArrayList<Account> accounts = new ArrayList<>();

        try (FileReader reader = new FileReader("./data.json"))
        {
            // Read in data from JSON file
            JsonObject obj = (JsonObject) Jsoner.deserialize(reader);
            JsonArray data = (JsonArray) obj.get("data");

            // Parse JSON data and store in account objects
            Iterator<Object> iterator = data.iterator();
            while (iterator.hasNext()) {
                accounts.add(new Account((JsonObject) iterator.next()));
            }

            // Calculate the five accounting metrics
            BigDecimal revenue = calculateTotalRevenue(accounts);


            // Output accounting metrics in correct format
            System.out.println("Revenue: " + formatCurrency(revenue));


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JsonException e) {
            e.printStackTrace();
        }
    }

    /**
     * Formats a monetary value with a comma separating every 3 digits and removing cents
     * @param monetary_value
     * @return formatted monetary value
     */
    public static String formatCurrency(BigDecimal monetary_value) {
        return "\\$" + String.format("%,.0f", monetary_value.setScale(2, RoundingMode.HALF_UP));
    }

    /**
     * Calculates the total revenue from account data
     * @param accounts ArrayList of accounts
     * @return total revenue
     */
    public static BigDecimal calculateTotalRevenue(ArrayList<Account> accounts){
        BigDecimal total_revenue = new BigDecimal("0.0");
        for (Account account : accounts) {
            if (account.getAccountCategory().equals("revenue")) {
                total_revenue = total_revenue.add(account.getTotalValue());
            }
        }
        return total_revenue;
    }
}
