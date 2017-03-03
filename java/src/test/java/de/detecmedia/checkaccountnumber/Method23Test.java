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
public class Method23Test {
    
    public Method23Test() {
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
     * Test of check method, of class Method23.
     * <pre>
     *  1  2  3  4  5  6  P  8  9 10
     *  8  7  6  5  6  7     8  9  7
     *  7  6  5  4  3  2
     * -----------------
     * 56+42+30+20+18+14 = 180
     * 180 % 11 = 4
     * 
     * 11 -4 = 
     * 
     * P = 7
     * 
     * </pre>
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method23 instance = new Method23();
        instance.setAccountNumber("8765677897");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
        
    }
    
}
