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
public class Method39Test {
    
    public Method39Test() {
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
     * Test of check method, of class Method39.
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method39 instance = new Method39();
        instance.setAccountNumber("200205");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }
    @Test
    public void testCheck1() {
        System.out.println("check");
        Method39 instance = new Method39();
        instance.setAccountNumber("10019400");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getFlag method, of class Method39.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method39 instance = new Method39();
        char[] expResult = new char[] {'3','9'};
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);
        
    }

    
    
}
