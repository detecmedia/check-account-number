/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.converter.Weighting;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Markus Potthast
 */
public class Method00Test {

    public Method00Test() {
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
     * Test of check method, of class Methode00.
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method00 instance = new Method00();
        boolean result;

        // check 9290701
        instance.setAccountNumber("0001501824");
        result = instance.test();
        assertEquals(true, result);
        // check 9290701
        instance = new Method00();
        instance.setAccountNumber("539290858");
        result = instance.test();
        assertEquals(true, result);
        instance = new Method00();
        instance.setAccountNumber("1501824");
        result = instance.test();
        assertEquals(true, result);
        instance = new Method00();
        instance.setAccountNumber("1501832");
        result = instance.test();
        assertEquals(true, result);

        instance = new Method00();
        instance.setAccountNumber("0009876542");
        result = instance.test();
        assertEquals(false, result);


    }

    @Test
    public void testCheck1() {
        System.out.println("check");
        Method00 instance = new Method00();
        boolean result;

        // check 9290701
        instance.setAccountNumber("0009876542");
        result = instance.test();
        assertEquals(false, result);
    }

    /**
     * Test of check method, of class Method00.
     */
    @Test
    public void testCheck() {
        System.out.println("check");
        int[] weighting = new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2, 1};
        Method00 instance = new Method00();
        instance.setAccountNumber("9290701");
        boolean expResult = true;
        boolean result = instance.check(Weighting.Weighting(weighting));
        assertEquals(expResult, result);
    }

    /**
     * Test of getFlag method, of class Method00.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method00 instance = new Method00();
        char[] expResult = "00".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

}
