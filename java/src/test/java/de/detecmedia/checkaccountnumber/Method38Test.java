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
public class Method38Test {
    
    public Method38Test() {
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
     * Test of check method, of class Method38.
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method38 instance = new Method38();
        instance.setAccountNumber("191919");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
       
    }
    /**
     * Test of check method, of class Method38.
     */
    @Test
    public void testCheck1() {
        System.out.println("check");
        Method38 instance = new Method38();
        instance.setAccountNumber("1100660");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getFlag method, of class Method38.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method38 instance = new Method38();
        char[] expResult = new char[]{'3','8'};
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);
        
    }

    
    
}
