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
public class Method28Test {

    public Method28Test() {
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
     * Test of check method, of class Method28.
     * <pre>
     * Stellennr.:    1  2  3  4  5  6  7  8  9  A (A=10)
     * Kontonr.:      0  0  1  9  9  9  9  0  0  0
     * Gewichtung:    8  7  6  5  4  3  2
     *                -------------------
     *                0  0 +6+45+36+27+18 = 132
     *
     * 132 % 11 = 0
     * 11 -0 = 11
     * </pre>
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method28 instance = new Method28();
        instance.setAccountNumber("0019999000");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * 9130000201
     * <p>
     * <pre>
     * Stellennr.:    1  2  3  4  5  6  7  8  9  A (A=10)
     * Kontonr.:      9  1  3  0  0  0  0  2  0  1
     * Gewichtung:    8  7  6  5  4  3  2
     *               --------------------
     *               72+ 7+18 +0 +0 +0 +0 = 97
     * 97 % 11 = 9
     * 11 -9 = 2
     * P = 2
     *
     * </pre>
     */
    @Test
    public void testCheck1() {
        System.out.println("check");
        Method28 instance = new Method28();
        instance.setAccountNumber("9130000201");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of check method, of class Method28.
     */
    @Test
    public void testCheck() {
        System.out.println("check");
        int[] weighting = {2, 3, 4, 5, 6, 7, 8};
        Method28 instance = new Method28();
        instance.setAccountNumber("9130000201");
        boolean expResult = true;
        boolean result = instance.check(weighting);
        assertEquals(expResult, result);

    }

    /**
     * Test of add method, of class Method28.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int[] number = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        Method28 instance = new Method28();
        int expResult = 7;
        int result = instance.add(number);
        assertEquals(expResult, result);

    }
}
