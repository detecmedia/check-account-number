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
 * @author Markus Potthast 
 */
public class Method02Test {

    public Method02Test() {
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
     * Test of check method, of class Methode02.
     */
    @Test
    public void testTest() {
        System.out.println("check");
        CheckAccountNumber instance = new Method02();
        boolean result;

        // check 9290701
        instance = new Method02();
        instance.setAccountNumber("2462647214");
        result = instance.test();
        assertEquals(true, result);
        // check 9290701
        instance = new Method02();
        instance.setAccountNumber("34728139");
        result = instance.test();
        assertEquals(true, result);

        instance = new Method02();
        instance.setAccountNumber("1234560");
        result = instance.test();
        assertEquals(true, result);

        instance = new Method02();
        instance.setAccountNumber("123456");
        result = instance.test();
        assertEquals(false, result);

        instance = new Method02();
        instance.setAccountNumber("0009876542");
        result = instance.test();
        assertEquals(false, result);
    }

    /**
     * Test of check method, of class Method02.
     */
    @Test
    public void testCheck() {
        System.out.println("check");
        int[] weighting = {2, 3, 4, 5, 6, 7, 8, 9, 2};
        Method02 instance = new Method02();
        instance.setAccountNumber("34728139");
        boolean expResult = true;
        boolean result = instance.check(weighting);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getFlag method, of class Method02.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method02 instance = new Method02();
        char[] expResult = "02".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);
        
    }

    /**
     * Test of add method, of class Method02.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int[] number = {1,2,3,4,5};
        int start = 0;
        int end = 0;
        Method02 instance = new Method02();
        int expResult = 10;
        int result = instance.add(number, 0, 4);
        assertEquals(expResult, result);
        
    }

}
