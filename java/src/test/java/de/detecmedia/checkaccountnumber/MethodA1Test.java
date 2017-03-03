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
public class MethodA1Test {
    
    public MethodA1Test() {
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
     * Test of test method, of class MethodA1.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        MethodA1 instance = new MethodA1();
        instance.setAccountNumber("0010030005");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
    }

    @Test
    public void testTest1() {
        System.out.println("test");
        MethodA1 instance = new MethodA1();
        instance.setAccountNumber("0010030997");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
    }
    /**
     * 1  0  1  0  0  3  0  0  5  4
     * 0  0  2  1  2  1  2  1  2  P
     * ----------------------------
     * 0  0  2  0  0  3  0  0 10
     * ---------------------------
     * 1+ 0+ 2+ 0+ 0+ 3+ 0+ 0+ 1 = 6
     * 
     * 10 - 6 = 4
     */
    @Test
    public void testTest2() {
        System.out.println("test");
        MethodA1 instance = new MethodA1();
        instance.setAccountNumber("1010030054");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
    }
    
   
    @Test
    public void testTest3() {
        System.out.println("test");
        MethodA1 instance = new MethodA1();
        instance.setAccountNumber("0110030005");
        boolean expResult = false;
        boolean result = instance.test();
        assertEquals(expResult, result);
    }

     @Test
    public void testTest4() {
        System.out.println("test");
            MethodA1 instance = new MethodA1();
        instance.setAccountNumber("01100300");
        boolean expResult = false;
        boolean result = instance.test();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getFlag method, of class MethodA1.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        MethodA1 instance = new MethodA1();
        char[] expResult = "A1".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);
       
    }
    
}
