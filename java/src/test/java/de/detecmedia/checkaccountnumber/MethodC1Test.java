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
public class MethodC1Test {
    
    public MethodC1Test() {
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
     * Test of test method, of class MethodC1.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        MethodC1 instance = new MethodC1();
        instance.setAccountNumber("5876556788");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getFlag method, of class MethodC1.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        MethodC1 instance = new MethodC1();
        char[] expResult = "C1".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);
       
    }

    /**
     * Test of variant1 method, of class MethodC1.
     */
    @Test
    public void testVariant1() {
        System.out.println("variant1");
        int[] number = {0,4,4,6,7,8,6,0,4,0};
        MethodC1 instance = new MethodC1();
        boolean expResult = true;
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of variant1 method, of class MethodC1.
     */
    @Test
    public void testVariant11() {
        System.out.println("variant1");
        int[] number = {0,4,7,8,0,4,6,9,4,0};
        MethodC1 instance = new MethodC1();
        boolean expResult = true;
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);
       
    }
    /**
     * Test of variant1 method, of class MethodC1.
     * 
     * <pre>
     * 
     * Gewichtung 1, 2, 1, 2, 1, 2
     * 
     * 0  7  0  1  6  2  5  8  3  0
     * 0  2  1  2  1  2  1
     * -----------------------------
     *    5+ 0+ 2+ 6+ 4+ 5= 22
     *   22 -1 = 21 
     *   21 % 11 = 10
     * 
     * 10 - 10 = 0
     *   
     * </pre>
     */
    @Test
    public void testVariant12() {
        System.out.println("variant1");
        int[] number = {0,7,0,1,6,2,5,8,3,0};
        MethodC1 instance = new MethodC1();
        boolean expResult = true;
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of variant2 method, of class MethodC1.
     */
    @Test
    public void testVariant2() {
        System.out.println("variant2");
        int[] number = {5,4,3,2,1,1,2,3,4,9};
        MethodC1 instance = new MethodC1();
        boolean expResult = true;
        boolean result = instance.variant2(number);
        assertEquals(expResult, result);
       
    }
    
}
