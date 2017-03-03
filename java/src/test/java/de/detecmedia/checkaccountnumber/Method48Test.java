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
public class Method48Test {

    public Method48Test() {
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
     * Test of check method, of class Method48.
     *
     * <pre>
     * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
     * Kontonr.:   x x x x x x x x P x
     * Gewichtung:     7 6 5 4 3 2
     * </pre>
     * 
     * <pre>
     *  1  2  3  4  5  6  7  8  9  10
     *  1  2  1  2  1  2  1  2  P  2
     *        7  6  5  4  3  2
     * ------------------------
     *        7+12+ 5+ 8+ 3+ 4 = 39
     * 39 % 11 = 6
     * 11 - 6 = 5
     * 
     * P = 5
     * </pre>
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method48 instance = new Method48();
        instance.setAccountNumber("1212121252");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method48.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method48 instance = new Method48();
        char[] expResult = "48".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);
        
    }

   

}
