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
 * @todo more tests
 */
public class MethodD6Test {

    public MethodD6Test() {
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
     * Test of test method, of class MethodD6.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        MethodD6 instance = new MethodD6();
        instance.setAccountNumber("9001291005");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testTest1() {
        System.out.println("test");
        MethodD6 instance = new MethodD6();
        instance.setAccountNumber("7001000681");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class MethodD6.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        MethodD6 instance = new MethodD6();
        char[] expResult = "D6".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of variant1 method, of class MethodD6.
     */
    @Test
    public void testVariant1() {
        System.out.println("variant1");
        int[] number = {3, 4, 0, 9};
        MethodD6 instance = new MethodD6();
        boolean expResult = true;
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant2 method, of class MethodD6.
     */
    @Test
    public void testVariant2() {
        System.out.println("variant2");
        int[] number = {3, 6, 0, 1, 6, 7, 1, 0, 5, 6};
        MethodD6 instance = new MethodD6();
        boolean expResult = true;
        boolean result = instance.variant2(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant3 method, of class MethodD6.
     */
    @Test
    public void testVariant3() {
        System.out.println("variant3");
        int[] number = {7, 0, 0, 1, 0, 0, 0, 6, 8, 1};
        MethodD6 instance = new MethodD6();
        boolean expResult = true;
        boolean result = instance.variant3(number);
        assertEquals(expResult, result);

    }

}
