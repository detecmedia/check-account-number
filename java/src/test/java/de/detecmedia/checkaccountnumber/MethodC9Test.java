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
public class MethodC9Test {
    
    public MethodC9Test() {
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
     * Test of test method, of class MethodC9.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        MethodC9 instance = new MethodC9();
        instance.setAccountNumber("0123456789");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of getFlag method, of class MethodC9.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        MethodC9 instance = new MethodC9();
        char[] expResult = "C9".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);
        
    }

    /**
     * Test of variant1 method, of class MethodC9.
     */
    @Test
    public void testVariant1() {
        System.out.println("variant1");
        int[] number = {3,4,5,6,7,8,9,0,1,9};
        MethodC9 instance = new MethodC9();
        boolean expResult = true;
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of variant2 method, of class MethodC9.
     */
    @Test
    public void testVariant2() {
        System.out.println("variant2");
        int[] number = {0,1,2,3,4,5,6,7,8,9};
        MethodC9 instance = new MethodC9();
        boolean expResult = true;
        boolean result = instance.variant2(number);
        assertEquals(expResult, result);
      
    }
    
}
