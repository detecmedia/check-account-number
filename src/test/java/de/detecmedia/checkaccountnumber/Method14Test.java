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
 * @author Markus Potthast
 * @see Method14
 */
public class Method14Test {

    public Method14Test() {
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
     * accountnumbertest.
     * ktno:     1  2  3  4  5  6  7  8  9  P
     * 7  6  5  4  3  2
     * ------------------
     * 28+30+30+28+24+18 = 158
     * 158 % 11 = 154 R 4
     * 11 - 4 = 7
     * <p>
     * P = 7
     * <p>
     * Test of check method, of class Method14.
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method14 instance = new Method14();
        instance.setAccountNumber("1234567897");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of factor method, of class Method14.
     */
    @Test
    public void testFactor() {
        System.out.println("factor");
        // 1  2  3  4  5  6  7  8  9  10
        // 0  1  2  3  4  5  6  7  8  9 
        //          7  6  5  4  3  2
        // --------------------------
        //         21 24 25 24 21 16

        int[] number = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] weighting = {2, 3, 4, 5, 6, 7};
        Method14 instance = new Method14();
        int[] expResult = {0, 1, 2, 21, 24, 25, 24, 21, 16, 9};
        int[] result = instance.factor(number, weighting);
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of check method, of class Method14.
     *
     * @see Method14
     */
    @Test
    public void testCheck() {
        System.out.println("check");
        int[] weighting = {2, 3, 4, 5, 6, 7};
        Method14 instance = new Method14();
        instance.setAccountNumber("1234567897");
        boolean expResult = true;
        boolean result = instance.check(weighting);
        assertEquals(expResult, result);

    }

}
