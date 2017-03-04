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
public class Method45Test {

    public Method45Test() {
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
     * Test of check method, of class Method45.
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method45 instance = new Method45();
        instance.setAccountNumber("3545343232");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of check method, of class Method45.
     */
    @Test
    public void testCheck1() {
        System.out.println("check");
        Method45 instance = new Method45();
        instance.setAccountNumber("4013410024");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testCheck2() {
        System.out.println("check");
        Method45 instance = new Method45();
        instance.setAccountNumber("0994681254");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testCheck3() {
        System.out.println("check");
        Method45 instance = new Method45();
        instance.setAccountNumber("0000012340");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testCheck4() {
        System.out.println("check");
        Method45 instance = new Method45();
        instance.setAccountNumber("1000199999");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testCheck5() {
        System.out.println("check");
        Method45 instance = new Method45();
        instance.setAccountNumber("0100114240");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method45.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method45 instance = new Method45();
        char[] expResult = "45".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }


}
