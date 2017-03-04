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
public class MethodD2Test {

    public MethodD2Test() {
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
     * Test of test method, of class MethodD2.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        MethodD2 instance = new MethodD2();
        instance.setAccountNumber("71214205");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class MethodD2.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        MethodD2 instance = new MethodD2();
        char[] expResult = "D2".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of variant1 method, of class MethodD2.
     */
    @Test
    public void testVariant1() {
        System.out.println("variant1");
        int[] number = {1, 8, 9, 9, 1, 2, 1, 3, 7};
        MethodD2 instance = new MethodD2();
        boolean expResult = true;
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);

    }

    @Test
    public void testVariant11() {
        System.out.println("variant1");
        int[] number = {0, 1, 7, 9, 7, 5, 1, 3, 1, 4};
        MethodD2 instance = new MethodD2();
        boolean expResult = false;
        boolean result = instance.variant3(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant2 method, of class MethodD2.
     */
    @Test
    public void testVariant2() {
        System.out.println("variant2");
        int[] number = {4, 4, 5, 5, 6, 6, 7, 7, 8, 4};
        MethodD2 instance = new MethodD2();
        boolean expResult = true;
        boolean result = instance.variant2(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant3 method, of class MethodD2.
     */
    @Test
    public void testVariant3() {
        System.out.println("variant3");
        int[] number = {5, 1, 1, 8, 1, 0, 0, 8};
        MethodD2 instance = new MethodD2();
        boolean expResult = true;
        boolean result = instance.variant3(number);
        assertEquals(expResult, result);

    }

}
