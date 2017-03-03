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
public class MethodE1Test {

    public MethodE1Test() {
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
     * Test of test method, of class MethodE1.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        MethodE1 instance = new MethodE1();
        instance.setAccountNumber("0100041104");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }
    /**
     * Test of test method, of class MethodE1.
     */
    @Test
    public void testTest1() {
        System.out.println("test");
        MethodE1 instance = new MethodE1();
        instance.setAccountNumber("0100054106");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }
    /**
     * Test of test method, of class MethodE1.
     */
    @Test
    public void testTest2() {
        System.out.println("test");
        MethodE1 instance = new MethodE1();
        instance.setAccountNumber("0200025107");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getFlag method, of class MethodE1.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        MethodE1 instance = new MethodE1();
        char[] expResult = "E1".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of add method, of class MethodE1.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int[] number = {10,10,10,10,10,10,10,10};
        int start = 0;
        int end = 7;
        MethodE1 instance = new MethodE1();
        int expResult = 70;
        int result = instance.add(number, start, end);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of modulus11 method, of class MethodE1.
     */
    @Test
    public void testModulus11() {
        System.out.println("modulus11");
        int number = 2550;
        MethodE1 instance = new MethodE1();
        int expResult = 9;
        int result = instance.modulus11(number);
        assertEquals(expResult, result);
        
    }

}
