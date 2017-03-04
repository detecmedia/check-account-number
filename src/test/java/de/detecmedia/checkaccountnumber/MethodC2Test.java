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
public class MethodC2Test {

    public MethodC2Test() {
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
     * Test of test method, of class MethodC2.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        MethodC2 instance = new MethodC2();
        instance.setAccountNumber("8738142564");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class MethodC2.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        MethodC2 instance = new MethodC2();
        char[] expResult = "C2".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of variant1 method, of class MethodC2.
     */
    @Test
    public void testVariant1() {
        System.out.println("variant1");
        int[] number = {2, 3, 9, 4, 8, 7, 1, 4, 2, 6};
        MethodC2 instance = new MethodC2();
        boolean expResult = true;
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);

    }

    @Test
    public void testVariant11() {
        System.out.println("variant1");
        int[] number = {4, 2, 1, 8, 4, 6, 1, 9, 5, 0};
        MethodC2 instance = new MethodC2();
        boolean expResult = true;
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant2 method, of class MethodC2.
     */
    @Test
    public void testVariant2() {
        System.out.println("variant2");
        int[] number = {5, 1, 2, 7, 4, 8, 5, 1, 6, 6};
        MethodC2 instance = new MethodC2();
        boolean expResult = true;
        boolean result = instance.variant2(number);
        assertEquals(expResult, result);

    }

}
