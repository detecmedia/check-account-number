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
public class Method29Test {
    
    public Method29Test() {
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
     * Test of check method, of class Method29.
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method29 instance = new Method29();
        instance.setAccountNumber("3145863029");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getFlag method, of class Method29.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method29 instance = new Method29();
        char[] expResult = "29".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);
      
    }
    
}
