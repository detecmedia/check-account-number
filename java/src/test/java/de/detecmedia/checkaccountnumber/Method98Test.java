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
public class Method98Test {
    
    public Method98Test() {
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
     * Test of test method, of class Method98.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        Method98 instance = new Method98();
        instance.setAccountNumber("9619608118");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method98.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method98 instance = new Method98();
        char[] expResult = "98".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);
        
    }
    
}
