
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
public class Method41Test {

    public Method41Test() {
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
     * Test of check method, of class Method41.
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method41 instance = new Method41();
        instance.setAccountNumber("4013410024");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of check method, of class Method41.
     */
    @Test
    public void testCheck1() {
        System.out.println("check");
        Method41 instance = new Method41();
        instance.setAccountNumber("4013410024");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of check method, of class Method41.
     */
    @Test
    public void testCheck2() {
        System.out.println("check");
        Method41 instance = new Method41();
        instance.setAccountNumber("4016660195");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of check method, of class Method41.
     */
    @Test
    public void testCheck3() {
        System.out.println("check");
        Method41 instance = new Method41();
        instance.setAccountNumber("0166805317");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of check method, of class Method41.
     */
    @Test
    public void testCheck4() {
        System.out.println("check");
        Method41 instance = new Method41();
        instance.setAccountNumber("4019310079");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of check method, of class Method41.
     */
    @Test
    public void testCheck5() {
        System.out.println("check");
        Method41 instance = new Method41();
        instance.setAccountNumber("4019340829");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of check method, of class Method41.
     */
    @Test
    public void testCheck6() {
        System.out.println("check");
        Method41 instance = new Method41();
        instance.setAccountNumber("4019151002");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method41.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method41 instance = new Method41();
        char[] expResult = "41".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }


}
