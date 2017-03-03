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
public class MethodB2Test {
    
    public MethodB2Test() {
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
     * Test of test method, of class MethodB2.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        MethodB2 instance = new MethodB2();
        instance.setAccountNumber("1002345674");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class MethodB2.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        MethodB2 instance = new MethodB2();
        instance.setAccountNumber("9000481805");
        char[] expResult = "B2".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);
        
    }

    /**
     * Test of variant1 method, of class MethodB2.
     */
    @Test
    public void testVariant1() {
        System.out.println("variant1");
        int[] number = {0,0,2,0,0,1,2,3,5,7};
        MethodB2 instance = new MethodB2();
        boolean expResult = true;
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of variant2 method, of class MethodB2.
     */
    @Test
    public void testVariant2() {
        System.out.println("variant2");
        int[] number = {9,0,0,0,4,8,1,8,0,5};
        MethodB2 instance = new MethodB2();
        boolean expResult = true;
        boolean result = instance.variant2(number);
        assertEquals(expResult, result);
        
    }
    
}
