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
public class MethodD9Test {

    public MethodD9Test() {
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
     * Test of test method, of class MethodD9.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        MethodD9 instance = new MethodD9();
        instance.setAccountNumber("1100132044");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class MethodD9.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        MethodD9 instance = new MethodD9();
        char[] expResult = "D9".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of variant1 method, of class MethodD9.
     */
    @Test
    public void testVariant1() {
        System.out.println("variant1");
        int[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 7};
        MethodD9 instance = new MethodD9();
        boolean expResult = true;
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant2 method, of class MethodD9.
     */
    @Test
    public void testVariant2() {
        System.out.println("variant2");
        int[] number = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        MethodD9 instance = new MethodD9();
        boolean expResult = true;
        boolean result = instance.variant2(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant3 method, of class MethodD9.
     */
    @Test
    public void testVariant3() {
        System.out.println("variant3");
        int[] number = {1, 1, 0, 0, 1, 3, 2, 0, 4, 4};
        MethodD9 instance = new MethodD9();
        boolean expResult = true;
        boolean result = instance.variant3(number);
        assertEquals(expResult, result);

    }

}
