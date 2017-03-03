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
import org.junit.Ignore;

/**
 *
 * @author Markus Potthast <mpt@detecmedia.de>
 */
public class Method30Test {

    public Method30Test() {
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
     * Test of check method, of class Method30.
     * <pre>
     * Stellennr.: 1  2  3  4  5  6  7  8  9  A (A=10)
     * Kontonr.:   1  2  3  1  2  3  1  2  3  P
     * Gewichtung: 2  0  0  0  0  1  2  1  2
     *             -------------------------
     *             2 +0 +0 +0 +0 +3 +2 +2 +6 = 10
     * 10 -5 = 5 
     * P = 5
     * </pre>
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method30 instance = new Method30();
        instance.setAccountNumber("1231231235");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of factor method, of class Method30.
     */
    
    @Test
    public void testFactor() {
        System.out.println("factor");
        int[] number = {1,2,3,4,5,6,7,8,9,0};
        int[] weighting = {2,2,2,2,2,2,2,2,2,2};
        Method30 instance = new Method30();
        int[] expResult = {2,4,6,8,10,12,14,16,18,0};
        int[] result = instance.factor(number, weighting);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of add method, of class Method30.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int[] number =  {1,2,3,4,5,6,7,8,9,0};
        Method30 instance = new Method30();
        int expResult = 45;
        int result = instance.add(number);
        assertEquals(expResult, result);
        
    }

}
