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
public class Method60Test {

    public Method60Test() {
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
     * Test of check method, of class Method60.
     * <p>
     * 1  2  3  4  5  6  7  8  9  P
     * 2  2  1  2  3  4  1  2  3  6
     * 2  1  2  1  2  1  2
     * -------------------------
     * 2+ 2+ 6+ 4+ 2+ 2+ 6 = 24
     * 24 % 10 = 4
     * 10 - 4 = 6
     * <p>
     * P = 6
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method60 instance = new Method60();
        instance.setAccountNumber("2212341236");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method60.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method60 instance = new Method60();
        char[] expResult = "60".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }


}
