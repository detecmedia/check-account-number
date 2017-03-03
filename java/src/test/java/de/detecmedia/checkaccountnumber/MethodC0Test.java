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
public class MethodC0Test {

    private ESERAltsystems eserAltsystems;

    public MethodC0Test() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        eserAltsystems = new ESERAltsystems();
        eserAltsystems.setBankCode("13051172");
        eserAltsystems.setAccountNumber("43001500");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of test method, of class MethodC0.
     *
     * <pre>
     * 2, 4, 8, 5, 10, 9, 7, 3, 6, 1, 2, 4
     *
     *
     * 3
     *       1  1  7  2  4  P  1  5  0  0
     * 4  2  1  6  3  7  9 10  5  8  4  2
     * ----------------------------------
     *       1+ 6+21+14+36+ 0+ 5+40+ 0+ 0 = 123
     *
     * 123 % 11 = 2
     * (2 +3 *10) % 11
     * </pre>
     */
    @Test
    public void testTest() {
        System.out.println("test");
        MethodC0 instance = new MethodC0();
        instance.setAccountNumber("6932875274");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of test method, of class MethodC0. 8 8
     * <pre>
     * 48726458
     *  1  1  7  2  4  P  7  2  6  4  5  7
     *  4  2  1  6  3  7  9 10  5  8  4  2
     * -------------------------------------
     * (4+ 2+ 7+12+12+ 0+63+20+30+32+20+14) % 11
     *
     *
     * 194 % 11 = 7
     *
     * (9 + 8 * 10) % 11
     *
     * p = 8
     * </pre>
     *
     *
     */
    @Test
    public void testTest1() {
        System.out.println("test");
        eserAltsystems.setAccountNumber("0048726457");
        MethodC0 instance = new MethodC0();
        instance.setAccountNumber(eserAltsystems.getESERAltsystems(ESERAltsystems.ACHT));
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testTest11() {
        System.out.println("test");
        eserAltsystems.setAccountNumber("43001500");
        MethodC0 instance = new MethodC0();
        instance.setAccountNumber(eserAltsystems.getESERAltsystems(ESERAltsystems.ACHT));
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testTest12() {
        System.out.println("test");
        eserAltsystems.setAccountNumber("82335729");
        MethodC0 instance = new MethodC0();
        instance.setAccountNumber(eserAltsystems.getESERAltsystems(ESERAltsystems.ACHT));
        boolean expResult = false;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * <pre>
     * 
     * 2, 4, 8, 5, 10, 9, 7, 3, 6, 1, 2, 4
     * 
     *       1  1  7  2  2  P  8  3  7  5  2  1
     *       *  *  *  *  *  *  *  *  *  *  *  *
     *       4  2  1  6  3  7  9 10  5  8  4  2
     *       ----------------------------------
     *       4+ 2+ 7+12+ 6+ 0+72+30+35+40+ 8 +2 = 218
     *
     * 218 : 11 = 19 Rest 9
     *
     * 9+0x10= 2:11=0   Rest 2          (10 = Gewicht über der Prüf- ziffer)
     * 2+1x10=19:11=1   Rest 1
     * 2+2x10=22:11=2   Rest 0
     * 2+3x10=32:11=2   Rest 10
     *
     *
     * Die Prüfziffer lautet 3.
     * </pre>
     */
    @Test
    public void testTest13() {
        System.out.println("test");
        eserAltsystems.setAccountNumber("29837521");
        MethodC0 instance = new MethodC0();
        instance.setAccountNumber(eserAltsystems.getESERAltsystems(ESERAltsystems.ACHT));
        boolean expResult = false;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class MethodC0.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        MethodC0 instance = new MethodC0();
        char[] expResult = "C0".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of variant1 method, of class MethodC0.
     */
    @Test
    public void testVariant1() {
        System.out.println("variant1");

        MethodC0 instance = new MethodC0();
        instance.setAccountNumber(eserAltsystems.getESERAltsystems(ESERAltsystems.ACHT));
        boolean expResult = true;
        boolean result = instance.variant1(instance.getAccountNumberArray());
        assertEquals(expResult, result);

    }

    /**
     * Test of variant2 method, of class MethodC0.
     */
    @Test
    public void testVariant2() {
        System.out.println("variant2");
        int[] number = {0, 0, 8, 2, 3, 3, 5, 7, 2, 9};
        MethodC0 instance = new MethodC0();
        boolean expResult = true;
        boolean result = instance.variant2(number);
        assertEquals(expResult, result);

    }

}
