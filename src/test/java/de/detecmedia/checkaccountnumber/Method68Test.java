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
public class Method68Test {

    public Method68Test() {
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
     * Test of check method, of class Method68.
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method68 instance = new Method68();
        instance.setAccountNumber("987654328");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of check method, of class Method68.
     */
    @Test
    public void testTest1() {
        System.out.println("check");
        Method68 instance = new Method68();
        instance.setAccountNumber("8889654328");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of variant1 method, of class Method68.
     */
    @Test
    public void testVariant1() {
        System.out.println("variant1");
        Method68 instance = new Method68();
        boolean expResult = true;
        int[] number = {9, 8, 7, 6, 5, 4, 3, 2, 4};
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant2 method, of class Method68.
     */
    @Test
    public void testVariant2() {
        System.out.println("variant2");
        Method68 instance = new Method68();
        boolean expResult = true;
        int[] number = {9, 8, 7, 6, 5, 4, 3, 2, 8};
        boolean result = instance.variant2(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method68.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method68 instance = new Method68();
        char[] expResult = "68".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

}
