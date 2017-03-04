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
public class Method80Test {

    public Method80Test() {
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
     * Test of test method, of class Method80.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        Method80 instance = new Method80();
        instance.setAccountNumber("340968");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testTest1() {
        System.out.println("test");
        Method80 instance = new Method80();
        instance.setAccountNumber("340966");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method80.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method80 instance = new Method80();
        char[] expResult = "80".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of mehtodA method, of class Method80.
     */
    @Test
    public void testMehtodA() {
        System.out.println("mehtodA");
        int[] number = {3, 4, 0, 9, 6, 8};
        Method80 instance = new Method80();
        boolean expResult = true;
        boolean result = instance.mehtodA(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of methodB method, of class Method80.
     */
    @Test
    public void testMethodB() {
        System.out.println("methodB");
        int[] number = {3, 4, 0, 9, 6, 6};
        Method80 instance = new Method80();
        boolean expResult = true;
        boolean result = instance.methodB(number);
        assertEquals(expResult, result);

    }

}
