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
}
