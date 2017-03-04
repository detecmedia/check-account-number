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
 * @author Markus Potthast <mpt@detecmedia.de>
 */
public class Method84Test {

    public Method84Test() {
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
     * Test of test method, of class Method84.
     */
    @Test
    public void testTest() {
        System.out.println("test");
        Method84 instance = new Method84();
        instance.setAccountNumber("240699");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testTest1() {
        System.out.println("test");
        Method84 instance = new Method84();
        instance.setAccountNumber("350982");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testTest2() {
        System.out.println("test");
        Method84 instance = new Method84();
        instance.setAccountNumber("461059");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testTest3() {
        System.out.println("test");
        Method84 instance = new Method84();
        instance.setAccountNumber("240692");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testTest4() {
        System.out.println("test");
        Method84 instance = new Method84();
        instance.setAccountNumber("350985");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testTest5() {
        System.out.println("test");
        Method84 instance = new Method84();
        instance.setAccountNumber("461052");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testTest6() {
        System.out.println("test");
        Method84 instance = new Method84();
        instance.setAccountNumber("240961");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testTest7() {
        System.out.println("test");
        Method84 instance = new Method84();
        instance.setAccountNumber("350984");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testTest8() {
        System.out.println("test");
        Method84 instance = new Method84();
        instance.setAccountNumber("461054");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method84.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method84 instance = new Method84();
        char[] expResult = "84".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of methodA method, of class Method84.
     */
    @Test
    public void testMethodA() {
        System.out.println("methodA");
        int[] number = {2, 4, 0, 6, 9, 9};
        Method84 instance = new Method84();
        boolean expResult = true;
        boolean result = instance.methodA(number);
        assertEquals(expResult, result);
    }

    /**
     * Test of methodB method, of class Method84.
     */
    @Test
    public void testMethodB() {
        System.out.println("methodB");
        int[] number = {2, 4, 0, 6, 9, 2};
        Method84 instance = new Method84();
        boolean expResult = true;
        boolean result = instance.methodB(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of methodC method, of class Method84.
     * <p>
     * <p>
     * 0 0 0 0 3 5 0 9 8 4
     * 2 1 2 1 2
     * -----------------
     * 6+5+0+9+16 = 36
     * 36 % 11 = 3
     * 11 -3 = 8
     */
    @Test
    public void testMethodC() {
        System.out.println("methodC");
        int[] number = {3, 5, 0, 9, 8, 4};
        Method84 instance = new Method84();
        boolean expResult = true;
        boolean result = instance.methodC(number);
        assertEquals(expResult, result);

    }

}
