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
 * @author Markus Potthast
 */
public class Method01Test {

    public Method01Test() {
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
     * Test of check method, of class Methode01.
     */
    @Test
    public void testTest() {
        System.out.println("check");
        CheckAccountNumber instance = new Method01();
        boolean result;

        // check 9290701
        instance.setAccountNumber("2462647212");
        result = instance.test();
        assertEquals(true, result);
        // check 9290701
        instance = new Method01();
        instance.setAccountNumber("34728138");
        result = instance.test();
        assertEquals(true, result);

        instance = new Method01();
        instance.setAccountNumber("1234569");
        result = instance.test();
        assertEquals(true, result);

        instance = new Method01();
        instance.setAccountNumber("123456");
        result = instance.test();
        assertEquals(false, result);

        instance = new Method01();
        instance.setAccountNumber("00098765421");
        result = instance.test();
        assertEquals(false, result);

    }

    /**
     * Test of check method, of class Method01.
     *
     * @see Method01
     * <p>
     * 1  2  3  4  5  6  7  8  9 10
     * 4  3  2  1  2  3  4
     * 2  1  2  1  2  1  2
     * -------------------------
     * 8+ 3+ 4+ 1+ 4+ 3+ 8 = 31
     * <p>
     * 10 - 1 = 9
     */
    @Test
    public void testCheck() {
        System.out.println("check");
        int[] weighting = {2, 1, 2, 1, 2, 1, 2};
        Method01 instance = new Method01();
        instance.setAccountNumber("43212349");
        boolean expResult = true;
        boolean result = instance.check(weighting);
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method01.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method01 instance = new Method01();
        char[] expResult = "01".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of add method, of class Method01.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int[] number = {1, 2, 3, 4, 5};
        Method01 instance = new Method01();
        instance.setAccountNumber("12345");
        int expResult = 10;
        int result = instance.add(number);
        assertEquals(expResult, result);

    }

}
