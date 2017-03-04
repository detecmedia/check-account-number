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
public class MethodC5Test {

    public MethodC5Test() {
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
     * Test of test method, of class MethodC5.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        MethodC5 instance = new MethodC5();
        instance.setAccountNumber("7099999999");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class MethodC5.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        MethodC5 instance = new MethodC5();
        char[] expResult = "C5".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of variant1 method, of class MethodC5.
     */
    @Test
    public void testVariant1() {
        System.out.println("variant1");
        int[] number = {0, 3, 0, 0, 5, 6, 6, 0, 0, 0};
        MethodC5 instance = new MethodC5();
        boolean expResult = true;
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant2 method, of class MethodC5.
     */
    @Test
    public void testVariant2() {
        System.out.println("variant2");
        int[] number = {1, 0, 0, 0, 0, 6, 1, 3, 7, 8};
        MethodC5 instance = new MethodC5();
        boolean expResult = true;
        boolean result = instance.variant2(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant2 method, of class MethodC5.
     */
    @Test
    public void testVariant21() {
        System.out.println("variant2");
        int[] number = {6, 4, 5, 0, 0, 0, 8, 1, 5, 0};
        MethodC5 instance = new MethodC5();
        boolean expResult = false;
        boolean result = instance.variant2(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant3 method, of class MethodC5.
     */
    @Test
    public void testVariant3() {
        System.out.println("variant3");
        int[] number = {3, 0, 6, 0, 1, 8, 8, 1, 0, 3};
        MethodC5 instance = new MethodC5();
        boolean expResult = true;
        boolean result = instance.variant3(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant3 method, of class MethodC5.
     */
    @Test
    public void testVariant31() {
        System.out.println("variant3");
        int[] number = {8, 6, 2, 3, 4, 1, 0, 0, 0, 0};
        MethodC5 instance = new MethodC5();
        boolean expResult = false;
        boolean result = instance.variant3(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant4 method, of class MethodC5.
     */
    @Test
    public void testVariant4() {
        System.out.println("variant4");
        int[] number = {0, 0, 5, 9, 9, 9, 9, 9, 9, 9};
        MethodC5 instance = new MethodC5();
        boolean expResult = true;
        boolean result = instance.variant4(number);
        assertEquals(expResult, result);

    }


}
