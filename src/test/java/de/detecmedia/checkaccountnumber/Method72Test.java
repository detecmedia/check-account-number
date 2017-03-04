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
public class Method72Test {

    public Method72Test() {
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
     * Test of test method, of class Method72.
     * <p>
     * <pre>
     * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
     * Kontonr.:   0 0 2 3 3 4 1 3 1 P
     * Gewichtung:       1 2 1 2 1 2
     * ------------------------------
     *                   3+6+4+2+3+2= 20
     * 20 % 10 = 0;
     * 10 - 0 = 10;
     * p = 0;
     * </pre>
     */
    @Test
    public void testTest() {
        System.out.println("test");
        Method72 instance = new Method72();
        instance.setAccountNumber("0023341310");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method72.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method72 instance = new Method72();
        char[] expResult = "72".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

}
