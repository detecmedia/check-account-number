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
public class Method93Test {

    public Method93Test() {
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
     * Test of test method, of class Method93.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        Method93 instance = new Method93();
        instance.setAccountNumber("6714790000");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method93.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method93 instance = new Method93();
        char[] expResult = "93".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of variant1 method, of class Method93.
     */
    @Test
    public void testVariant1() {
        System.out.println("variant1");
        int[] number = {6, 7, 1, 4, 7, 9, 0, 0, 0, 0};
        Method93 instance = new Method93();
        boolean expResult = true;
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant1 method, of class Method93.
     */
    @Test
    public void testVariant11() {
        System.out.println("variant1");
        int[] number = {0, 0, 0, 0, 6, 7, 1, 4, 7, 9};
        Method93 instance = new Method93();
        boolean expResult = true;
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant2 method, of class Method93.
     */
    @Test
    public void testVariant2() {
        System.out.println("variant2");
        int[] number = {1, 2, 7, 7, 8, 3, 0, 0, 0, 0};
        Method93 instance = new Method93();
        boolean expResult = true;
        boolean result = instance.variant2(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant2 method, of class Method93.
     */
    @Test
    public void testVariant21() {
        System.out.println("variant2");
        int[] number = {0, 0, 0, 0, 1, 2, 7, 7, 8, 3};
        Method93 instance = new Method93();
        boolean expResult = true;
        boolean result = instance.variant2(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variantA method, of class Method93.
     */
    @Test
    public void testVariantA() {
        System.out.println("variantA");
        int[] number = {6, 7, 1, 4, 7, 9, 0, 0, 0, 0};
        int modulus = Method93.MODULUS11;
        Method93 instance = new Method93();
        boolean expResult = true;
        boolean result = instance.variantA(number, modulus);
        assertEquals(expResult, result);
    }

    /**
     * Test of variantB method, of class Method93.
     */
    @Test
    public void testVariantB() {
        System.out.println("variantB");
        int[] number = {0, 0, 0, 0, 1, 2, 7, 7, 9, 1};
        int modulus = Method93.MODULUS7;
        Method93 instance = new Method93();
        boolean expResult = true;
        boolean result = instance.variantB(number, modulus);
        assertEquals(expResult, result);

    }

}
