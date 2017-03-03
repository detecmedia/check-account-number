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
public class MethodC3Test {
    
    public MethodC3Test() {
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
     * Test of test method, of class MethodC3.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        MethodC3 instance = new MethodC3();
        instance.setAccountNumber("9000577650");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
      
    }

    /**
     * Test of getFlag method, of class MethodC3.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        MethodC3 instance = new MethodC3();
        char[] expResult = "C3".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);
        
    }

    /**
     * Test of variant1 method, of class MethodC3.
     */
    @Test
    public void testVariant1() {
        System.out.println("variant1");
        int[] number = {9,2,9,4,1,8,2};
        MethodC3 instance = new MethodC3();
        boolean expResult = true;
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);
      
    }

    /**
     * Test of variant2 method, of class MethodC3.
     */
    @Test
    public void testVariant2() {
        System.out.println("variant2");
        int[] number = {9,0,0,0,4,2,0,5,3,0};
        MethodC3 instance = new MethodC3();
        boolean expResult = true;
        boolean result = instance.variant2(number);
        assertEquals(expResult, result);
        
    }
    
}
