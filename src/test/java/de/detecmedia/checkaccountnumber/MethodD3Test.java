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
public class MethodD3Test {

    public MethodD3Test() {
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
     * Test of test method, of class MethodD3.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        MethodD3 instance = new MethodD3();
        instance.setAccountNumber("6030642006");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class MethodD3.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        MethodD3 instance = new MethodD3();
        char[] expResult = "D3".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of variant1 method, of class MethodD3.
     */
    @Test
    public void testVariant1() {
        System.out.println("variant1");
        int[] number = {1, 6, 0, 0, 1, 6, 9, 5, 9, 1};
        MethodD3 instance = new MethodD3();
        boolean expResult = true;
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);

    }

    @Test
    public void testVariant11() {
        System.out.println("variant1");
        int[] number = {1, 6, 0, 0, 1, 7, 6, 4, 8, 5};
        MethodD3 instance = new MethodD3();
        boolean expResult = false;
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant2 method, of class MethodD3.
     */
    @Test
    public void testVariant2() {
        System.out.println("variant2");
        int[] number = {6, 0, 1, 9, 9, 3, 7, 0, 0, 7};
        MethodD3 instance = new MethodD3();
        boolean expResult = true;
        boolean result = instance.variant2(number);
        assertEquals(expResult, result);

    }

}
