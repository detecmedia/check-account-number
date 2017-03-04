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
public class Method88Test {

    public Method88Test() {
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
     * Test of test method, of class Method88.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        Method88 instance = new Method88();
        instance.setAccountNumber("2525259");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testTest1() {
        System.out.println("test");
        Method88 instance = new Method88();
        instance.setAccountNumber("1000500");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testTest2() {
        System.out.println("test");
        Method88 instance = new Method88();
        instance.setAccountNumber("90013000");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testTest3() {
        System.out.println("test");
        Method88 instance = new Method88();
        instance.setAccountNumber("92525253");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testTest4() {
        System.out.println("test");
        Method88 instance = new Method88();
        instance.setAccountNumber("99913003");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method88.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method88 instance = new Method88();
        char[] expResult = "88".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);
    }

}
