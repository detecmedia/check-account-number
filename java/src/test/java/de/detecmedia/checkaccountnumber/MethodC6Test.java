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
public class MethodC6Test {
    
    public MethodC6Test() {
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
     * Test of test method, of class MethodC6.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        MethodC6 instance = new MethodC6();
        instance.setAccountNumber("9000781153");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getFlag method, of class MethodC6.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        MethodC6 instance = new MethodC6();
        char[] expResult = "C6".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);
        
    }
    
}
