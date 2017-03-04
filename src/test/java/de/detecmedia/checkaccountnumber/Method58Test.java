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
public class Method58Test {

    public Method58Test() {
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
     * Test of check method, of class Method58.
     * Testkontonummern: 1800881120, 9200654108, 1015222224, 3703169668
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method58 instance = new Method58();
        instance.setAccountNumber("1800293377");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testCheck1() {
        System.out.println("check");
        Method58 instance = new Method58();
        instance.setAccountNumber("9200654108");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testCheck2() {
        System.out.println("check");
        Method58 instance = new Method58();
        instance.setAccountNumber("1015222224");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testCheck3() {
        System.out.println("check");
        Method58 instance = new Method58();
        instance.setAccountNumber("3703169668");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method58.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method58 instance = new Method58();
        char[] expResult = "58".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }


}
