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
public class Method87Test {
    
    public Method87Test() {
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
     * Test of test method, of class Method87.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        Method87 instance = new Method87();
        instance.setAccountNumber("0010720185");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getFlag method, of class Method87.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method87 instance = new Method87();
        char[] expResult = "87".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);
       
    }

    /**
     * Test of exception method, of class Method87.
     */
    @Test
    public void testException() {
        System.out.println("exception");
        int[] number = {0,0,9,9,1,0,0,1,1,0};
        Method87 instance = new Method87();
        boolean expResult = true;
        boolean result = instance.exception(number);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of methodA method, of class Method87.
     */
    @Test
    public void testMethodA() {
        System.out.println("methodA");
        int[] number = {0,0,0,0,0,0,0,4,0,6};
        Method87 instance = new Method87();
        boolean expResult = true;
        boolean result = instance.methodA(number);
        assertEquals(expResult, result);
    }

    /**
     * Test of methodB method, of class Method87.
     */
    @Test
    public void testMethodB() {
        System.out.println("methodB");
        int[] number = {0,0,0,0,1,0,0,0,0,5};
        Method87 instance = new Method87();
        boolean expResult = true;
        boolean result = instance.methodB(number);
        assertEquals(expResult, result);
      
    }

    /**
     * Test of methodC method, of class Method87.
     */
    @Test
    public void testMethodC() {
        System.out.println("methodC");
        int[] number = {0,0,0,0,3,9,3,8,1,4};
        Method87 instance = new Method87();
        boolean expResult = true;
        boolean result = instance.methodC(number);
        assertEquals(expResult, result);
        
    }
    
}
