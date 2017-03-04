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

import org.junit.Ignore;

/**
 * @author Markus Potthast <mpt@detecmedia.de>
 */
public class Method69Test {

    public Method69Test() {
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
     * Test of test method, of class Method69.
     */
    @Test
    @Ignore
    public void testTest() {
        System.out.println("test");
        Method69 instance = new Method69();
        boolean expResult = false;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method69.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method69 instance = new Method69();
        char[] expResult = "69".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

}
