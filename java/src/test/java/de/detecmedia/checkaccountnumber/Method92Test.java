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
 *
 * @author Markus Potthast <mpt@detecmedia.de>
 */
public class Method92Test {

    public Method92Test() {
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
     * Test of test method, of class Method92.
     * <pre>
     * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
     * Kontonr.:   x x x 2 2 2 2 2 2 P
     * Gewichtung:       1 7 3 1 7 3
     * ------------------------------
     *                   2+14+6+2+14+6= 44
     * 10 - 4 = 6
     * 
     * P=6
     * </pre>
     */
    @Test
    public void testTest() {
        System.out.println("test");
        Method92 instance = new Method92();
        instance.setAccountNumber("2222226");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method92.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method92 instance = new Method92();
        char[] expResult = "92".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

}
