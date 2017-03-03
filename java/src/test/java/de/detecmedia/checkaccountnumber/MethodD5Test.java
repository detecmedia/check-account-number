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
public class MethodD5Test {
    
    public MethodD5Test() {
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
     * Test of test method, of class MethodD5.
     * @TODO check all accout numbers
     */
    @Test
    public void testTest() {
        System.out.println("test");
        MethodD5 instance = new MethodD5();
        instance.setAccountNumber("0099632004");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }
    @Test
    public void testTest1() {
        System.out.println("test");
        MethodD5 instance = new MethodD5();
        instance.setAccountNumber("0000100088");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getFlag method, of class MethodD5.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        MethodD5 instance = new MethodD5();
        char[] expResult = "D5".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);
        
    }

    /**
     * Test of variant1 method, of class MethodD5.
     */
    @Test
    public void testVariant1() {
        System.out.println("variant1");
        int[] number = {5,9,9,9,7,1,8,1,3,8};
        MethodD5 instance = new MethodD5();
        boolean expResult = true;
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testVariant11() {
        System.out.println("variant1");
        int[] number = {3,2,9,9,6,3,2,0,0,8};
        MethodD5 instance = new MethodD5();
        boolean expResult = false;
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);
        
    }
    @Test
    public void testVariant12() {
        System.out.println("variant1");
        int[] number = {0,3,9,9,2,4,2,1,3,9};
        MethodD5 instance = new MethodD5();
        boolean expResult = false;
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of variant2 method, of class MethodD5.
     */
    @Test
    public void testVariant2() {
        System.out.println("variant2");
        int[] number = {0,0,0,4,7,1,1,1,7,3};
        MethodD5 instance = new MethodD5();
        boolean expResult = true;
        boolean result = instance.variant2(number);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of variant3 method, of class MethodD5.
     */
    @Test
    public void testVariant3() {
        System.out.println("variant3");
        int[] number = {0,0,0,4,7,1,1,1,7,2};
        MethodD5 instance = new MethodD5();
        boolean expResult = true;
        boolean result = instance.variant3(number);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of variant4 method, of class MethodD5.
     */
    @Test
    public void testVariant4() {
        System.out.println("variant4");
        int[] number = {4,7,1,1,1,7,4};
        MethodD5 instance = new MethodD5();
        boolean expResult = true;
        boolean result = instance.variant4(number);
        assertEquals(expResult, result);
        
    }
    
     @Test
    public void testVariant41() {
        System.out.println("variant4");
        int[] number = {0,0,0,0,1,0,0,0,8,8};
        MethodD5 instance = new MethodD5();
        boolean expResult = true;
        boolean result = instance.variant4(number);
        assertEquals(expResult, result);
      
    }

    /**
     * Test of add method, of class MethodD5.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int[] number = {1,1,1,1,1,1,1,1,1,1};
        int start = 0;
        int end = 7;
        MethodD5 instance = new MethodD5();
        int expResult = 7;
        int result = instance.add(number, start, end);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of modulus7 method, of class MethodD5.
     */
    @Test
    public void testModulus7() {
        System.out.println("modulus7");
        int pz = 8;
        MethodD5 instance = new MethodD5();
        int expResult = 6;
        int result = instance.modulus7(pz);
        assertEquals(expResult, result);
        
    }
    
}
