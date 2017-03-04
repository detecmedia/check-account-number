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
public class Method95Test {

    public Method95Test() {
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
     * Test of test method, of class Method95.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        Method95 instance = new Method95();
        instance.setAccountNumber("0068007003");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of test method, of class Method95.
     */
    @Test
    public void testTest1() {
        System.out.println("test");
        Method95 instance = new Method95();
        instance.setAccountNumber("0847321750");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of test method, of class Method95.
     */
    @Test
    public void testTest2() {
        System.out.println("test");
        Method95 instance = new Method95();
        instance.setAccountNumber("6450060494");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of test method, of class Method95.
     */
    @Test
    public void testTest3() {
        System.out.println("test");
        Method95 instance = new Method95();
        instance.setAccountNumber("6454000003");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method95.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method95 instance = new Method95();
        char[] expResult = "95".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

}
