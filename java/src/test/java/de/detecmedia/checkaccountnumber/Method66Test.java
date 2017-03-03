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
public class Method66Test {

    public Method66Test() {
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
     * Test of check method, of class Method66.
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method66 instance = new Method66();
        instance.setAccountNumber("100154508");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testCheck1() {
        System.out.println("check");
        Method66 instance = new Method66();
        instance.setAccountNumber("101154508");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testCheck2() {
        System.out.println("check");
        Method66 instance = new Method66();
        instance.setAccountNumber("100154516");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testCheck3() {
        System.out.println("check");
        Method66 instance = new Method66();
        instance.setAccountNumber("101154516");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method66.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method66 instance = new Method66();
        char[] expResult = "66".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }


    /**
     * Test of add method, of class Method66.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int[] number = {1,1,1,1,1,1,1};
        int start = 0;
        int end = 6;
        Method66 instance = new Method66();
        int expResult = 6;
        int result = instance.add(number, start, end);
        assertEquals(expResult, result);

    }

}
