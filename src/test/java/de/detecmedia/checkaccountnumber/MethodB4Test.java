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
public class MethodB4Test {

    public MethodB4Test() {
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
     * Test of test method, of class MethodB4.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        MethodB4 instance = new MethodB4();
        instance.setAccountNumber("0000051640");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of test method, of class MethodB4.
     */
    @Test
    public void testTest1() {
        System.out.println("test");
        MethodB4 instance = new MethodB4();
        instance.setAccountNumber("159590");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class MethodB4.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        MethodB4 instance = new MethodB4();
        char[] expResult = "B4".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of variant1 method, of class MethodB4.
     */
    @Test
    public void testVariant1() {
        System.out.println("variant1");
        int[] number = {9, 9, 4, 1, 5, 1, 0, 0, 0, 1};
        MethodB4 instance = new MethodB4();
        boolean expResult = true;
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant2 method, of class MethodB4.
     */
    @Test
    public void testVariant2() {
        System.out.println("variant2");
        int[] number = {0, 0, 0, 0, 2, 5, 1, 4, 3, 7};
        MethodB4 instance = new MethodB4();
        boolean expResult = true;
        boolean result = instance.variant2(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant2 method, of class MethodB4.
     */
    @Test
    public void testVariant21() {
        System.out.println("variant2");
        int[] number = {1, 5, 9, 5, 9,};
        MethodB4 instance = new MethodB4();
        boolean expResult = false;
        boolean result = instance.variant2(number);
        assertEquals(expResult, result);

    }

}
