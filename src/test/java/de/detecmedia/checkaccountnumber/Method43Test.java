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
public class Method43Test {

    public Method43Test() {
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
     * Test of check method, of class Method43.
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method43 instance = new Method43();
        instance.setAccountNumber("6135244");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testCheck1() {
        System.out.println("check");
        Method43 instance = new Method43();
        instance.setAccountNumber("9516893476");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method43.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method43 instance = new Method43();
        char[] expResult = "43".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }


    /**
     * Test of add method, of class Method43.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int[] number = {1, 1, 1, 1, 1, 1, 1};
        int start = 0;
        int end = 7;
        Method43 instance = new Method43();
        int expResult = 7;
        int result = instance.add(number, start, end);
        assertEquals(expResult, result);

    }

}
