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
public class Method46Test {
    
    public Method46Test() {
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
     * Test of check method, of class Method46.
     * 1  2  3  4  5  6  7  P  9  10 
     * 0  2  3  5  4  6  8  6  1  2
     * 
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method46 instance = new Method46();
        instance.setAccountNumber("0235468612");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testCheck1() {
        System.out.println("check");
        Method46 instance = new Method46();
        instance.setAccountNumber("0837890901");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }
     
    @Test
    public void testCheck2() {
        System.out.println("check");
        Method46 instance = new Method46();
        instance.setAccountNumber("1041447600");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getFlag method, of class Method46.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method46 instance = new Method46();
        char[] expResult = "46".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);
        
    }

   
    
}
