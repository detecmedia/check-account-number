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
public class Method85Test {

    public Method85Test() {
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
     * Test of test method, of class Method85.
     *
     * @TODO make more tests
     */
    @Test
    public void testTest() {
        System.out.println("test");
        Method85 instance = new Method85();
        instance.setAccountNumber("0001156071");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of test method, of class Method85.
     *
     * @TODO make more tests
     */
    @Test
    public void testTest1() {
        System.out.println("test");
        Method85 instance = new Method85();
        instance.setAccountNumber("3199100002");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method85.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method85 instance = new Method85();
        char[] expResult = "85".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of methodA method, of class Method85.
     */
    @Test
    public void testMethodA() {
        System.out.println("methodA");
        int[] numnber = {0, 0, 0, 1, 1, 5, 6, 0, 7, 1};

        Method85 instance = new Method85();
        instance.setAccountNumberArray(numnber);
        boolean expResult = true;
        boolean result = instance.methodA(numnber);
        assertEquals(expResult, result);
    }

    /**
     * Test of methodB method, of class Method85.
     * 0000156078
     */
    @Test
    public void testMethodB() {
        System.out.println("methodB");
        int[] numnber = {0, 0, 0, 0, 1, 5, 6, 0, 7, 8};
        Method85 instance = new Method85();
        boolean expResult = true;
        boolean result = instance.methodB(numnber);
        assertEquals(expResult, result);

    }

    /**
     * Test of methodC method, of class Method85.
     * 0000156071
     */
    @Test
    public void testMethodC() {
        System.out.println("methodC");
        int[] numnber = {0, 0, 0, 0, 1, 5, 6, 0, 7, 1};
        Method85 instance = new Method85();
        boolean expResult = true;
        boolean result = instance.methodC(numnber);
        assertEquals(expResult, result);
    }

    /**
     * Test of exception method, of class Method85.
     * 3199100002
     */
    @Test
    public void testException() {
        System.out.println("exception");
        int[] numnber = {3, 1, 9, 9, 1, 0, 0, 0, 0, 2};
        Method85 instance = new Method85();
        boolean expResult = true;
        boolean result = instance.exception(numnber);
        assertEquals(expResult, result);

    }

}
