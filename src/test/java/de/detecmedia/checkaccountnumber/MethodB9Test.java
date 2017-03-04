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
public class MethodB9Test {

    public MethodB9Test() {
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
     * Test of test method, of class MethodB9.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        MethodB9 instance = new MethodB9();
        instance.setAccountNumber("4353631");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of test method, of class MethodB9.
     */
    @Test
    public void testTest1() {
        System.out.println("test");
        MethodB9 instance = new MethodB9();
        instance.setAccountNumber("58467232");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class MethodB9.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        MethodB9 instance = new MethodB9();
        char[] expResult = "B9".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of variant1 method, of class MethodB9.
     */
    @Test
    public void testVariant1() {
        System.out.println("variant1");
        int[] number = {0, 0, 8, 7, 9, 2, 0, 1, 8, 7};
        MethodB9 instance = new MethodB9();
        boolean expResult = true;
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant1 method, of class MethodB9.
     */
    @Test
    public void testVariant11() {
        System.out.println("variant1");
        int[] number = {5, 8, 4, 6, 7, 2, 3, 2};
        MethodB9 instance = new MethodB9();
        boolean expResult = true;
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant2 method, of class MethodB9.
     */
    @Test
    public void testVariant2() {
        System.out.println("variant2");
        int[] number = {7, 7, 1, 2, 5, 6, 3, 3};
        MethodB9 instance = new MethodB9();
        boolean expResult = true;
        boolean result = instance.variant2(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant2 method, of class MethodB9.
     */
    @Test
    public void testVariant21() {
        System.out.println("variant2");
        int[] number = {1, 2, 5, 3, 6, 5, 7};
        MethodB9 instance = new MethodB9();
        boolean expResult = true;
        boolean result = instance.variant2(number);
        assertEquals(expResult, result);

    }

}
