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
public class MethodA7Test {
    
    public MethodA7Test() {
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
     * Test of test method, of class MethodA7.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        MethodA7 instance = new MethodA7();
        instance.setAccountNumber("19010438");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }
    /**
     * Test of test method, of class MethodA7.
     */
    @Test
    public void testTest1() {
        System.out.println("test");
        MethodA7 instance = new MethodA7();
        instance.setAccountNumber("19010008");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class MethodA7.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        MethodA7 instance = new MethodA7();
        char[] expResult = "A7".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);
        
    }

    /**
     * Test of variant1 method, of class MethodA7.
     */
    @Test
    public void testVariant1() {
        System.out.println("variant1");
        int[] number = {1,9,0,1,0,4,3,8};
        MethodA7 instance = new MethodA7();
        boolean expResult = true;
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of variant2 method, of class MethodA7.
     */
    @Test
    public void testVariant2() {
        System.out.println("variant2");
        int[] number = {1,9,0,1,0,8,7,6};
        MethodA7 instance = new MethodA7();
        boolean expResult = true;
        boolean result = instance.variant2(number);
        assertEquals(expResult, result);
        
    }
    
}
