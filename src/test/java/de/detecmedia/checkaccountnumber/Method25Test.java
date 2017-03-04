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
public class Method25Test {

    public Method25Test() {
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
     * Test of check method, of class Method25.
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method25 instance = new Method25();
        instance.setAccountNumber("0521382181");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);


    }

    /**
     * Test of add method, of class Method25.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int[] number = {0, 45, 16, 7, 18, 40, 8, 3, 16, 1};
        Method25 instance = new Method25();
        int expResult = 153;
        int result = instance.add(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method25.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method25 instance = new Method25();
        char[] expResult = "25".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

}
