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
public class Method64Test {

    public Method64Test() {
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
     * Test of check method, of class Method64.
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method64 instance = new Method64();
        instance.setAccountNumber("1206473010");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testCheck1() {
        System.out.println("check");
        Method64 instance = new Method64();
        instance.setAccountNumber("5016511020");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method64.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method64 instance = new Method64();
        char[] expResult = "64".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of factor method, of class Method64.
     */
    @Test
    public void testFactor() {
        System.out.println("factor");
        int[] number = {2,2,2,2,2,2,2};
        int[] weighting = {2,2,2,2,2,2,2};
        
        Method64 instance = new Method64();
        int[] expResult ={4,4,4,4,4,4,4};
        int[] result = instance.factor(number, weighting);
        assertArrayEquals(expResult, result);

    }

}
