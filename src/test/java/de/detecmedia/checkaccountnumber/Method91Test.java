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
public class Method91Test {

    public Method91Test() {
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
     * Test of test method, of class Method91.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        Method91 instance = new Method91();
        instance.setAccountNumber("8840087000");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method91.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method91 instance = new Method91();
        char[] expResult = "91".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of variant1 method, of class Method91.
     */
    @Test
    public void testVariant1() {
        System.out.println("variant1");
        int[] number = {2, 9, 7, 4, 1, 1, 8, 0, 0, 0};
        Method91 instance = new Method91();
        boolean expResult = true;
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant2 method, of class Method91.
     */
    @Test
    public void testVariant2() {
        System.out.println("variant2");
        int[] number = {2, 9, 7, 4, 1, 1, 7, 0, 0, 0};
        Method91 instance = new Method91();
        boolean expResult = true;
        boolean result = instance.variant2(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant3 method, of class Method91.
     */
    @Test
    public void testVariant3() {
        System.out.println("variant3");
        int[] number = {8, 8, 4, 0, 0, 1, 9, 0, 0, 0};
        Method91 instance = new Method91();
        boolean expResult = true;
        boolean result = instance.variant3(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant4 method, of class Method91.
     */
    @Test
    public void testVariant4() {
        System.out.println("variant4");
        int[] number = {8, 8, 4, 0, 0, 1, 2, 0, 0, 0};
        Method91 instance = new Method91();
        boolean expResult = true;
        boolean result = instance.variant4(number);
        assertEquals(expResult, result);

    }

}
