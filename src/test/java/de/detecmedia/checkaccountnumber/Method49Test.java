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
public class Method49Test {

    public Method49Test() {
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
     * Test of check method, of class Method49.
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method49 instance = new Method49();
        instance.setAccountNumber("9290701");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * 2462647212
     */
    @Test
    public void testCheck1() {
        System.out.println("check");
        Method49 instance = new Method49();
        instance.setAccountNumber("2462647212");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method49.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method49 instance = new Method49();
        char[] expResult = "49".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }


}
