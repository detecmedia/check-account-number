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
public class Method83Test {
    
    public Method83Test() {
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
     * Test of test method, of class Method83.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        Method83 instance = new Method83();
        instance.setAccountNumber("0001156136");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }
    /**
     * Test of test method, of class Method83.
     */
    @Test
    public void testTest1() {
        System.out.println("test");
        Method83 instance = new Method83();
        instance.setAccountNumber("0099100002");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getFlag method, of class Method83.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method83 instance = new Method83();
        char[] expResult = "83".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of mehtodA method, of class Method83.
     */
    @Test
    public void testMehtodA() {
        System.out.println("mehtodA");
        int[] number = {0,0,0,1,1,5,6,0,7,1};
        Method83 instance = new Method83();
        boolean expResult = true;
        boolean result = instance.methodA(number);
        assertEquals(expResult, result);
    }
    /**
     * Test of mehtodA method, of class Method83.
     */
    @Test
    public void testMehtodASachkonten() {
        System.out.println("mehtodA");
        int[] number = {0,0,9,9,1,0,0,0,0,2};
        Method83 instance = new Method83();
        boolean expResult = true;
        boolean result = instance.methodA(number);
        assertEquals(expResult, result);
    }

    /**
     * Test of mehtodB method, of class Method83.
     */
    @Test
    public void testMehtodB() {
        System.out.println("mehtodB");
        int[] number = {0,0,0,0,1,5,6,0,7,8};
        Method83 instance = new Method83();
        boolean expResult = true;
        boolean result = instance.methodB(number);
        assertEquals(expResult, result);
    }

    /**
     * Test of mehtodC method, of class Method83.
     */
    @Test
    public void testMehtodC() {
        System.out.println("mehtodC");
        int[] number = {0,0,0,0,1,5,6,0,7,1};
        Method83 instance = new Method83();
        boolean expResult = true;
        boolean result = instance.methodC(number);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testMehtodCA() {
        System.out.println("mehtodC");
        int[] number = {3,1,9,9,1,0,0,0,0,2};
        Method83 instance = new Method83();
        boolean expResult = true;
        boolean result = instance.methodC(number);
        assertEquals(expResult, result);
    }
    
}
