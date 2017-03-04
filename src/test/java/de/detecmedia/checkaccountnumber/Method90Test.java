/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.exception.InvalidAcountNumberException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Markus Potthast <mpt@detecmedia.de>
 */
public class Method90Test {

    public Method90Test() {
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
     * Test of test method, of class Method90.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        Method90 instance = new Method90();
        instance.setAccountNumber("0000654321");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method90.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method90 instance = new Method90();
        char[] expResult = "90".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of mehtodA method, of class Method90.
     */
    @Test
    public void testMehtodA() {
        System.out.println("mehtodA");
        int[] number = {0, 0, 0, 1, 9, 7, 5, 6, 4, 1};
        Method90 instance = new Method90();
        boolean expResult = true;
        boolean result = instance.mehtodA(number);
        assertEquals(expResult, result);
    }

    /**
     * Test of mehtodB method, of class Method90.
     */
    @Test
    public void testMehtodB() {
        System.out.println("mehtodB");
        int[] number = {0, 0, 0, 1, 8, 6, 3, 5, 3, 0};
        Method90 instance = new Method90();
        boolean expResult = true;
        boolean result = instance.mehtodB(number);
        assertEquals(expResult, result);
    }

    /**
     * Test of mehtodC method, of class Method90.
     */
    @Test
    public void testMehtodC() {
        System.out.println("mehtodC");
        int[] number = {0, 0, 0, 0, 6, 5, 4, 3, 2, 1};
        Method90 instance = new Method90();
        boolean expResult = true;
        boolean result = instance.mehtodC(number);
        assertEquals(expResult, result);
    }

    @Test
    public void testMehtodC1() {
        try {
            System.out.println("mehtodC1");
            int[] number = {0, 0, 0, 0, 6, 5, 4, 3, 2, 9};
            Method90 instance = new Method90();
            boolean expResult = false;
            boolean result = instance.mehtodC(number);
            assertEquals(expResult, result);
            fail("Exeption not found");
        } catch (InvalidAcountNumberException e) {
        }

    }

    /**
     * Test of mehtodD method, of class Method90.
     */
    @Test
    public void testMehtodD() {
        System.out.println("mehtodD");
        int[] number = {0, 0, 0, 0, 6, 7, 7, 7, 4, 7};
        Method90 instance = new Method90();
        boolean expResult = true;
        boolean result = instance.mehtodD(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of mehtodE method, of class Method90. 0004923250
     */
    @Test
    public void testMehtodE() {
        System.out.println("mehtodE");
        int[] number = {0, 0, 0, 0, 9, 9, 6, 6, 6, 3};
        Method90 instance = new Method90();
        boolean expResult = true;
        boolean result = instance.mehtodE(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of mehtodF method, of class Method90.
     */
    @Test
    public void testMehtodF() {
        System.out.println("mehtodF");
        int[] number = {0, 0, 9, 9, 1, 0, 0, 0, 0, 2};
        Method90 instance = new Method90();
        boolean expResult = true;
        boolean result = instance.mehtodF(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of mehtodG method, of class Method90.
     */
    @Test
    public void testMehtodG() {
        System.out.println("mehtodG");
        int[] number = {0, 0, 0, 4, 9, 2, 3, 2, 5, 0};
        Method90 instance = new Method90();
        boolean expResult = true;
        boolean result = instance.mehtodG(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of add method, of class Method90.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int[] number = {10, 10, 10, 10, 10, 10, 10, 10};
        int start = 0;
        int end = 7;
        Method90 instance = new Method90();
        int expResult = 70;
        int result = instance.add(number, start, end);
        assertEquals(expResult, result);

    }

}
