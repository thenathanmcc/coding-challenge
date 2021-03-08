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

    /**
     * Test expenses calculation function when given empty arraylist of accounts
     */
    @Test
    public void testExpensesArrayListEmpty() {
        ArrayList<Account> accounts = new ArrayList<>();
        BigDecimal expense = App.calculateTotalExpense(accounts);

        assertTrue(expense.equals(new BigDecimal("0.0")));
    }

    /**
     * Test percentage formatting function rounding correctness
     */
    @Test
    public void testPercentageFormatRounding() {
        BigDecimal percentage = new BigDecimal("13.123415");
        String formatted_percentage = App.formatPercentage(percentage);

        assertTrue(formatted_percentage.equals("13.1%"));
    }

    /**
     * Test percentage formatting function rounding up correctly
     */
    @Test
    public void testPercentageFormatRoundUp() {
        BigDecimal percentage = new BigDecimal("13.153415");
        String formatted_percentage = App.formatPercentage(percentage);

        assertTrue(formatted_percentage.equals("13.2%"));
    }

    /**
     * Test the Gross Profit Margin calculation function with 0 as the total revenue
     * A value of 0 revenue should not result in a GPM of infinity
     */
    @Test
    public void testGPMZeroRevenue() {
        ArrayList<Account> accounts = new ArrayList<>();
        BigDecimal gpm = App.calculateGrossProfitMargin(new BigDecimal("0.0"), accounts);

        assertTrue(gpm.equals(new BigDecimal("0.0")));
    }

    /**
     * Test the Net Profit Margin calculation function with 0 as the total revenue
     * A value of 0 revenue should not result in a NPM of infinity
     */
    @Test
    public void testNPMZeroRevenue() {
        ArrayList<Account> accounts = new ArrayList<>();
        BigDecimal npm = App.calculateNetProfitMargin(new BigDecimal("0.0"), new BigDecimal("32456"));

        assertTrue(npm.equals(new BigDecimal("0.0")));
    }
}
