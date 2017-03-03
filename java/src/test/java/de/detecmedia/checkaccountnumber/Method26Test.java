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
public class Method26Test {
    
    public Method26Test() {
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

     @Test
    public void testTest() {
        System.out.println("check");
        Method26 instance = new Method26();
        instance.setAccountNumber("0020309806");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
       
    }
    
    /**
     * Test of check method, of class Method26.
     */
    @Test
    public void testCheck1() {
        System.out.println("check");
        Method26 instance = new Method26();
        instance.setAccountNumber("0520309001");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
       
    }
     /**
     * Test of check method, of class Method26.
     * <pre>
     * 
     * 2, 3, 4, 5, 6, 7, 2
     * 
     * 1  2  3  4  5  6  7  8  9  10
     * 0  0  0  5  5  0  1  0  2  4
     * 0  5  5  0  1  0  2  4  0  0
     * 2  7  6  5  4  3  2
     * ----------------------------
     * 0+35+30 +0 +4 +0 +4 = 73
     * 
     * 73 % 11 = 7
     * 11 -7 = 4
     * 
     * P = 4
     * 
     * </pre>
     * 
     
     */
    @Test
    public void testCheck2() {
        System.out.println("check");
        Method26 instance = new Method26();
        instance.setAccountNumber("0005501024");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
       
    }
    
    @Test
    public void testCheck3() {
        System.out.println("check");
        Method26 instance = new Method26();
        instance.setAccountNumber("1111118111");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of add method, of class Method26.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int[] number = {1,1,1,1,1,1,1,1};
        Method26 instance = new Method26();
        int expResult = 7;
        int result = instance.add(number);
        assertEquals(expResult, result);
        
    }
    
}
