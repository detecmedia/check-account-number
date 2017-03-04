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
public class Method96Test {

    public Method96Test() {
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
     * Test of test method, of class Method96.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        Method96 instance = new Method96();
        instance.setAccountNumber("0000254100");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method96.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method96 instance = new Method96();
        char[] expResult = "96".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of variant1 method, of class Method96.
     */
    @Test
    public void testVariant1() {
        System.out.println("variant1");
        int[] number = {0, 0, 0, 0, 2, 5, 4, 1, 0, 0};
        Method96 instance = new Method96();
        boolean expResult = true;
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant2 method, of class Method96.
     */
    @Test
    public void testVariant2() {
        System.out.println("variant2");
        int[] number = {0, 0, 0, 0, 0, 0, 0, 2, 0, 8};
        Method96 instance = new Method96();
        boolean expResult = true;
        boolean result = instance.variant2(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant3 method, of class Method96.
     */
    @Test
    public void testVariant3() {
        System.out.println("variant3");
        int[] number = {0, 0, 0, 1, 3, 0, 0, 0, 0, 0};
        Method96 instance = new Method96();
        boolean expResult = true;
        boolean result = instance.variant3(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant3 method, of class Method96.
     */
    @Test
    public void testVariant31() {
        System.out.println("variant3");
        int[] number = {0, 0, 9, 9, 3, 9, 9, 9, 9, 9};
        Method96 instance = new Method96();
        boolean expResult = true;
        boolean result = instance.variant3(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant3 method, of class Method96.
     */
    @Test
    public void testVariant32() {
        System.out.println("variant3");
        int[] number = {0, 0, 9, 9, 3, 5, 9, 9, 9, 9};
        Method96 instance = new Method96();
        boolean expResult = true;
        boolean result = instance.variant3(number);
        assertEquals(expResult, result);

    }

}
