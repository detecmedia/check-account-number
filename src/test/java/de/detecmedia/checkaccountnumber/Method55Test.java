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
public class Method55Test {

    public Method55Test() {
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
     * Test of check method, of class Method55.
     * <p>
     * Gewichtung 2, 3, 4, 5, 6, 7, 8, 7, 8
     * <p>
     * 1  2  3  4  5  6  7  8  9  P
     * 1  2  1  2  1  2  1  2  1
     * 8  7  8  7  6  5  4  3  2
     * ----------------------------
     * 8+14+ 8+14+ 6+10+ 4+ 6+ 2 = 72
     * <p>
     * 72 % 11 = 6
     * 11 - 6 = 5
     * P = 5
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method55 instance = new Method55();
        instance.setAccountNumber("1212121215");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method55.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method55 instance = new Method55();
        char[] expResult = "55".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }


}
