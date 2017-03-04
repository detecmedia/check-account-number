/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.detecmedia.checkaccountnumber;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Markus Potthast <mpt@detecmedia.de>
 */
public class CheckAccountNumberTest {

    public CheckAccountNumberTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setAccountNumber method, of class CheckAccountNumber.
     */
    @Test
    public void testSetAccountNumber() {
        System.out.println("setAccountNumber");
        String accountNumber = "";
        CheckAccountNumber instance = new CheckAccountNumberImpl();
        instance.setAccountNumber(accountNumber);

    }

    /**
     * Test of test method, of class CheckAccountNumber.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        CheckAccountNumber instance = new CheckAccountNumberImpl();
        boolean expResult = false;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class CheckAccountNumber.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        CheckAccountNumber instance = new CheckAccountNumberImpl();
        char[] expResult = null;
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    public class CheckAccountNumberImpl implements CheckAccountNumber {

        public void setAccountNumber(String accountNumber) {
        }

        public boolean test() {
            return false;
        }

        public char[] getFlag() {
            return null;
        }
    }

}
