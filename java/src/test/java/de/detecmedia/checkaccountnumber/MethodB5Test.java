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
public class MethodB5Test {
    
    public MethodB5Test() {
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
     * Test of test method, of class MethodB5.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        MethodB5 instance = new MethodB5();
        instance.setAccountNumber("1045000252");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getFlag method, of class MethodB5.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        MethodB5 instance = new MethodB5();
        char[] expResult = "B5".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);
        
    }

    /**
     * Test of variant1 method, of class MethodB5.
     * 0159006955
     */
    @Test
    public void testVariant1() {
        System.out.println("variant1");
        int[] number = {0,1,5,9,0,0,6,9,5,5};
        MethodB5 instance = new MethodB5();
        boolean expResult = true;
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);
    
    }
/**
     * Test of variant1 method, of class MethodB5.
     * 0159006955
     */
    @Test
    public void testVariant12() {
        System.out.println("variant1");
        int[] number = {1,1,5,1,0,4,3,2,1,1};
        MethodB5 instance = new MethodB5();
        boolean expResult = false;
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);
    
    }
    /**
     * Test of variant2 method, of class MethodB5.
     */
    @Test
    public void testVariant2() {
        System.out.println("variant2");
        int[] number = {0,1,2,3,4,5,6,7,8,2};;
        MethodB5 instance = new MethodB5();
        boolean expResult = true;
        boolean result = instance.variant2(number);
        assertEquals(expResult, result);
       
    }
    /**
     * Test of variant1 method, of class MethodB5.
     * 0159006955
     */
    @Test
    public void testVariant22() {
        System.out.println("variant2");
        int[] number = {1,1,5,1,0,4,3,2,1,1};
        MethodB5 instance = new MethodB5();
        boolean expResult = true;
        boolean result = instance.variant2(number);
        assertEquals(expResult, result);
    
    }
    
}
