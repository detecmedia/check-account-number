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
 *
 * @author Markus Potthast <mpt@detecmedia.de>
 */
public class Method76Test {

    public Method76Test() {
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
     * Test of test method, of class Method76.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        Method76 instance = new Method76();
        instance.setAccountNumber("0006543200");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testTest1() {
        System.out.println("test");
        Method76 instance = new Method76();
        instance.setAccountNumber("65432");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    
    @Test
    public void testTest2() {
        System.out.println("test");
        Method76 instance = new Method76();
        instance.setAccountNumber("7876543100");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method76.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method76 instance = new Method76();
        char[] expResult = "76".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of modulus11 method, of class Method76.
     */
    @Test
    public void testModulus11() {
        System.out.println("modulus11");
        int number = 14;
        Method76 instance = new Method76();
        int expResult = 3;
        int result = instance.modulus11(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of add method, of class Method76.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int[] number = {1, 1, 1, 1, 1, 1, 1, 1};
        int start = 0;
        int end = 7;
        Method76 instance = new Method76();
        int expResult = 7;
        int result = instance.add(number, start, end);
        assertEquals(expResult, result);

    }

}
