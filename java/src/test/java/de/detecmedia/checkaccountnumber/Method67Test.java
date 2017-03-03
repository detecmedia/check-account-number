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
public class Method67Test {
    
    public Method67Test() {
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
     * Test of check method, of class Method67.
     * 
     * 1  2  3  4  5  6  7  8  9 10
     * 2  3  2  1  2  3  4  P  0  0
     * 2  1  2  1  2  1  2
     * ----------------------------
     * 4+ 3+ 4+ 1+ 4+ 3+ 8 = 27
     * 
     * 27 % 10 = 7
     * 10 - 7 = 3
     * 
     * P = 3
     * 
     * 2321234800
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method67 instance = new Method67();
        instance.setAccountNumber("2321234300");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getFlag method, of class Method67.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method67 instance = new Method67();
        char[] expResult = "67".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);
        
    }

    
    
}
