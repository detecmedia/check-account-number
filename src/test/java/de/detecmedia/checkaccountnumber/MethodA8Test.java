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
public class MethodA8Test {

    public MethodA8Test() {
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
     * Test of test method, of class MethodA8.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        MethodA8 instance = new MethodA8();
        instance.setAccountNumber("0001340967");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class MethodA8.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        MethodA8 instance = new MethodA8();
        char[] expResult = "A8".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of variant1 method, of class MethodA8.
     */
    @Test
    public void testVariant1() {
        System.out.println("variant1");
        int[] number = {7, 4, 3, 6, 6, 6, 1};
        MethodA8 instance = new MethodA8();
        boolean expResult = true;
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant2 method, of class MethodA8.
     */
    @Test
    public void testVariant2() {
        System.out.println("variant2");
        int[] number = {7, 4, 3, 6, 6, 6, 0};
        MethodA8 instance = new MethodA8();
        boolean expResult = true;
        boolean result = instance.variant2(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of exception method, of class MethodA8.
     *
     * @see Method51
     */
    @Test
    public void testException() {
        System.out.println("exception");
        int[] number = {2, 5, 9, 9, 1, 0, 0, 0, 0, 2};
        MethodA8 instance = new MethodA8();
        boolean expResult = true;
        boolean result = instance.exception(number);
        assertEquals(expResult, result);

    }

}
