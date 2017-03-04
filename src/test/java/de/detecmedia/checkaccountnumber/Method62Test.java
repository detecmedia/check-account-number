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
public class Method62Test {

    public Method62Test() {
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
     * Test of check method, of class Method62.
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method62 instance = new Method62();
        instance.setAccountNumber("5029076701");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method62.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method62 instance = new Method62();
        char[] expResult = "62".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }


}
