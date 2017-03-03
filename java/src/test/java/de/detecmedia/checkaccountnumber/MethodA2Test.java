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
public class MethodA2Test {
    
    public MethodA2Test() {
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
     * Test of test method, of class MethodA2.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        MethodA2 instance = new MethodA2();
        instance.setAccountNumber("3456789012");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFlag method, of class MethodA2.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        MethodA2 instance = new MethodA2();
        char[] expResult = "A2".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);
       
    }

    /**
     * Test of variant1 method, of class MethodA2.
     * 3456789019
     */
    @Test
    public void testVariant1() {
        System.out.println("variant1");
        int[] number = {3,4,5,6,7,8,9,0,1,9};
        MethodA2 instance = new MethodA2();
        boolean expResult = true;
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);
         
    }

    /**
     * Test of variant2 method, of class MethodA2.
     */
    @Test
    public void testVariant2() {
        System.out.println("variant2");
        int[] number = {3,4,5,6,7,8,9,0,1,2};;
        MethodA2 instance = new MethodA2();
        boolean expResult = true;
        boolean result = instance.variant2(number);
        assertEquals(expResult, result);        
    }
    
}
