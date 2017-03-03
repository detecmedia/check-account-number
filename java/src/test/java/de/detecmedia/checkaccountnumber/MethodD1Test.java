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
public class MethodD1Test {
    
    public MethodD1Test() {
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
     * Test of test method, of class MethodD1.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        MethodD1 instance = new MethodD1();
        instance.setAccountNumber("0082012203");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }
    @Test
    public void testTest1() {
        System.out.println("test");
        MethodD1 instance = new MethodD1();
        instance.setAccountNumber("1452683581");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }
    @Test
    public void testTest2() {
        System.out.println("test");
        MethodD1 instance = new MethodD1();
        instance.setAccountNumber("9000430223");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getFlag method, of class MethodD1.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        MethodD1 instance = new MethodD1();
        char[] expResult = "D1".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);
        
    }
    
}
