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
public class MethodA4Test {

    public MethodA4Test() {
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
     * Test of test method, of class MethodA4.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        MethodA4 instance = new MethodA4();
        instance.setAccountNumber("5030101099");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class MethodA4.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        MethodA4 instance = new MethodA4();
        char[] expResult = "A4".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of variant1 method, of class MethodA4.
     */
    @Test
    public void testVariant1() {
        System.out.println("variant1");
        int[] number = {0, 0, 0, 4, 7, 1, 1, 1, 7, 3};
        MethodA4 instance = new MethodA4();
        boolean expResult = true;
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant2 method, of class MethodA4.
     */
    @Test
    public void testVariant2() {
        System.out.println("variant2");
        int[] number = {0, 0, 0, 4, 7, 1, 1, 1, 7, 2};
        MethodA4 instance = new MethodA4();
        boolean expResult = true;
        boolean result = instance.variant2(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant2 method, of class MethodA4.
     */
    @Test
    public void testVariant21() {
        System.out.println("variant2");
        int[] number = {8, 6, 2, 3, 4, 2, 0, 0, 0, 4};
        MethodA4 instance = new MethodA4();
        boolean expResult = false;
        boolean result = instance.variant2(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant3 method, of class MethodA4.
     */
    @Test
    public void testVariant3() {
        System.out.println("variant3");
        int[] number = {1, 1, 9, 9, 5, 0, 3, 0, 1, 0};
        MethodA4 instance = new MethodA4();
        boolean expResult = true;
        boolean result = instance.variant3(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant4 method, of class MethodA4.
     */
    @Test
    public void testVariant4() {
        System.out.println("variant4");
        int[] number = {8, 9, 9, 7, 7, 1, 0, 0, 0, 0};
        MethodA4 instance = new MethodA4();
        boolean expResult = true;
        boolean result = instance.variant4(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant4 method, of class MethodA4.
     */
    @Test
    public void testVariant41() {
        System.out.println("variant4");
        int[] number = {0, 0, 0, 1, 1, 2, 3, 4, 5, 8};
        MethodA4 instance = new MethodA4();
        boolean expResult = true;
        boolean result = instance.variant4(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of add method, of class MethodA4.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int[] number = {10, 10, 10, 10, 10, 10, 10, 10};
        int start = 0;
        int end = 7;
        MethodA4 instance = new MethodA4();
        int expResult = 70;
        int result = instance.add(number, start, end);
        assertEquals(expResult, result);

    }

}
