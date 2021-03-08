package com.testcompany.app;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Test revenue calculation function when given empty arraylist of accounts
     */
    @Test
    public void testRevenueArrayListEmpty() {
        ArrayList<Account> accounts = new ArrayList<>();
        BigDecimal total_revenue = App.calculateTotalRevenue(accounts);

        assertTrue(total_revenue.equals(new BigDecimal("0.0")));
    }

    /**
     * Test the currency formatting function for very large dollar values i.e Trillions
     */
    @Test
    public void testLargeMonetaryValueFormat() {
        BigDecimal total_revenue = new BigDecimal("987654321123456.42");
        String formatted_revenue = App.formatCurrency(total_revenue);

        assertTrue(formatted_revenue.equals("\\$987,654,321,123,456"));
    }

    /**
     * Test the currency formatting function for a dollar value of 0
     */
    @Test
    public void testZeroMonetaryValueFormat() {
        BigDecimal total_revenue = new BigDecimal("0.0");
        String formatted_revenue = App.formatCurrency(total_revenue);

        assertTrue(formatted_revenue.equals("\\$0"));
    }
}
