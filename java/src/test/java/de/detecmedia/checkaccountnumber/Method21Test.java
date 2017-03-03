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
public class Method21Test {

    public Method21Test() {
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
     * Test of check method, of class Method21.
     * <pre>
     * 1  2  3  4  5  6  7  8  9  P
     * 9  9  9  9  9  9  9  9  9  P
     * 2  1  2  1  2  1  2  1  2 
     * --------------------------
     * 18+9+18+ 9+18+ 9+18+ 9+18 = 126
     * 
     * 9+9  +9 +9 +9 +9 +9 +9 +9 = 81
     * 10 - 1 = 9
     * 
     * P = 4
     * </pre>
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method21 instance = new Method21();
        instance.setAccountNumber("9999999999");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of add method, of class Method21.
     *
     * <pre>
     * 1  343 34 23 12 34 34 78 P
     * 1  10  7  5  3  7  7  15 P
     * 1+ 1+  7+ 5+ 3+ 7+ 7+  6 P
     * </pre>
     *
     *
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int[] number = {1, 343, 34, 23, 12, 34, 34, 78, 5};
        Method21 instance = new Method21();
        int expResult = 37;
        int result = instance.add(number);
        assertEquals(expResult, result);

    }

}
