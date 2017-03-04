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
public class Method42Test {

    public Method42Test() {
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
     * Test of check method, of class Method42.
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method42 instance = new Method42();
        instance.setAccountNumber("59498");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of check method, of class Method42.
     */
    @Test
    public void testCheck1() {
        System.out.println("check");
        Method42 instance = new Method42();
        instance.setAccountNumber("59510");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method42.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method42 instance = new Method42();
        char[] expResult = "42".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }


}
