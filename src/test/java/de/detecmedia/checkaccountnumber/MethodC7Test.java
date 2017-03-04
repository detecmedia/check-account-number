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
public class MethodC7Test {

    public MethodC7Test() {
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
     * Test of test method, of class MethodC7.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        MethodC7 instance = new MethodC7();
        instance.setAccountNumber("5073321010");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class MethodC7.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        MethodC7 instance = new MethodC7();
        char[] expResult = "C7".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of variant1 method, of class MethodC7.
     */
    @Test
    public void testVariant1() {
        System.out.println("variant1");
        int[] number = {3, 5, 0, 0, 0, 2, 2};
        MethodC7 instance = new MethodC7();
        boolean expResult = true;
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant2 method, of class MethodC7.
     */
    @Test
    public void testVariant2() {
        System.out.println("variant2");
        int[] number = {9, 4, 0, 1, 2, 3, 4, 1};
        MethodC7 instance = new MethodC7();
        boolean expResult = true;
        boolean result = instance.variant2(number);
        assertEquals(expResult, result);

    }

}
