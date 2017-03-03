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
public class MethodD0Test {
    
    public MethodD0Test() {
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
     * Test of test method, of class MethodD0.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        MethodD0 instance = new MethodD0();
        instance.setAccountNumber("6100272324");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }
    @Test
    public void testTest1() {
        System.out.println("test");
        MethodD0 instance = new MethodD0();
        instance.setAccountNumber("6100272324");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getFlag method, of class MethodD0.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        MethodD0 instance = new MethodD0();
        char[] expResult = "D0".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);
        
    }

    /**
     * Test of variant1 method, of class MethodD0.
     */
    @Test
    public void testVariant1() {
        System.out.println("variant1");
        int[] number = {6,1,0,0,2,7,3,4,7,9};
        MethodD0 instance = new MethodD0();
        boolean expResult = true;
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);
       
    }
    @Test
    public void testVariant11() {
        System.out.println("variant1");
        int[] number = {6,1,0,0,2,7,2,3,2,4};
        MethodD0 instance = new MethodD0();
        boolean expResult = true;
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of variant2 method, of class MethodD0.
     */
    @Test
    public void testVariant2() {
        System.out.println("variant2");
        int[] number = {5,7,0,0,0,0,0,0,0,0};
        MethodD0 instance = new MethodD0();
        boolean expResult = true;
        boolean result = instance.variant2(number);
        assertEquals(expResult, result);
        
    }
    
}
