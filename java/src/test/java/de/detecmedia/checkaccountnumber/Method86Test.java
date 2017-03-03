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
public class Method86Test {
    
    public Method86Test() {
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
     * Test of test method, of class Method86.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        Method86 instance = new Method86();
        instance.setAccountNumber("1009588");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getFlag method, of class Method86.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method86 instance = new Method86();
        char[] expResult = "86".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);
        
    }

    /**
     * Test of methodA method, of class Method86.
     */
    @Test
    public void testMethodA() {
        System.out.println("methodA");
        int[] number = {3,4,0,9,6,8};
        Method86 instance = new Method86();
        boolean expResult = true;
        boolean result = instance.methodA(number);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of methodB method, of class Method86.
     */
    @Test
    public void testMethodB() {
        System.out.println("methodB");
        int[] number = {1,2,3,8,9,7};
        Method86 instance = new Method86();
        boolean expResult = true;
        boolean result = instance.methodB(number);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of exception method, of class Method86.
     */
    @Test
    public void testException() {
        System.out.println("exception");
        int[] number = {0,0,9,9,1,0,0,1,1,0};
        Method86 instance = new Method86();
        boolean expResult = true;
        boolean result = instance.exception(number);
        assertEquals(expResult, result);
       
    }
    
}
