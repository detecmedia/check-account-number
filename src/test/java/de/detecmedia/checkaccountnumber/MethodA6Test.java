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
public class MethodA6Test {

    public MethodA6Test() {
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
     * Test of test method, of class MethodA6.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        MethodA6 instance = new MethodA6();
        instance.setAccountNumber("800048548");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of test method, of class MethodA6.
     */
    @Test
    public void testTest1() {
        System.out.println("test");
        MethodA6 instance = new MethodA6();
        instance.setAccountNumber("55300030");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class MethodA6.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        MethodA6 instance = new MethodA6();
        char[] expResult = "A6".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of calculate1 method, of class MethodA6.
     */
    @Test
    public void testCalculate1() {
        System.out.println("calculate1");
        int[] number = {8, 0, 0, 0, 4, 8, 5, 4, 8};
        MethodA6 instance = new MethodA6();
        boolean expResult = true;
        boolean result = instance.calculate1(number);
        assertEquals(expResult, result);
    }

    /**
     * Test of calculate2 method, of class MethodA6.
     */
    @Test
    public void testCalculate2() {
        System.out.println("calculate2");
        int[] number = {5, 5, 3, 0, 0, 0, 3, 0};
        MethodA6 instance = new MethodA6();
        boolean expResult = true;
        boolean result = instance.calculate2(number);
        assertEquals(expResult, result);

    }

}
