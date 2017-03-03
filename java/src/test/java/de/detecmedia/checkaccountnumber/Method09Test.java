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
public class Method09Test {
    
    public Method09Test() {
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
     * Test of test method, of class Method09.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        Method09 instance = new Method09();
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getFlag method, of class Method09.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method09 instance = new Method09();
        char[] expResult = "09".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);
        
    }
    
}
