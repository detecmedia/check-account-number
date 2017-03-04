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
public class Method57Test {

    public Method57Test() {
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
     * Test of check method, of class Method57. Testkontonummern (richtig):
     * 7500021766, 9400001734, 7800028282, 8100244186, 3251080371, 3891234567,
     * 7777778800, 5001050352, 5045090090, 1909700805, 9322111030,
     * 7400060823<br>
     * Testkontonummern (falsch): 5302707782, 6412121212, 1813499124, 2206735010
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method57 instance = new Method57();
        instance.setAccountNumber("7500021766");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testCheck1() {
        System.out.println("check");
        Method57 instance = new Method57();
        instance.setAccountNumber("9400001734");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testCheck2() {
        System.out.println("check");
        Method57 instance = new Method57();
        instance.setAccountNumber("7800028282");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testCheck3() {
        System.out.println("check");
        Method57 instance = new Method57();
        instance.setAccountNumber("8100244186");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testCheck4() {
        System.out.println("check");
        Method57 instance = new Method57();
        instance.setAccountNumber("3251080371");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testCheck5() {
        System.out.println("check");
        Method57 instance = new Method57();
        instance.setAccountNumber("3891234567");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * 7777778800, 5001050352, 5045090090, 1909700805, 9322111030,
     * 7400060823
     */
    @Test
    public void testCheck6() {
        System.out.println("check");
        Method57 instance = new Method57();
        instance.setAccountNumber("7777778800");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testCheck7() {
        System.out.println("check");
        Method57 instance = new Method57();
        instance.setAccountNumber("5001050352");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testCheck8() {
        System.out.println("check");
        Method57 instance = new Method57();
        instance.setAccountNumber("5045090090");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testCheck9() {
        System.out.println("check");
        Method57 instance = new Method57();
        instance.setAccountNumber("1909700805");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testCheck10() {
        System.out.println("check");
        Method57 instance = new Method57();
        instance.setAccountNumber("9322111030");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testCheck11() {
        System.out.println("check");
        Method57 instance = new Method57();
        instance.setAccountNumber("7400060823");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /*5302707782, 6412121212, 1813499124, 2206735010 */

    @Test
    public void testCheck13() {
        System.out.println("check");
        Method57 instance = new Method57();
        instance.setAccountNumber("5302707782");
        boolean expResult = false;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testCheck12() {
        System.out.println("check");
        Method57 instance = new Method57();
        instance.setAccountNumber("6412121212");
        boolean expResult = false;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testCheck14() {
        System.out.println("check");
        Method57 instance = new Method57();
        instance.setAccountNumber("1813499124");
        boolean expResult = false;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testCheck15() {
        System.out.println("check");
        Method57 instance = new Method57();
        instance.setAccountNumber("2206735010");
        boolean expResult = false;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method57.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method57 instance = new Method57();
        char[] expResult = "57".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of variante1 method, of class Method57.
     */
    @Test
    public void testVariante1() {
        System.out.println("variante1");
        int[] number = new int[]{7, 5, 0, 0, 0, 2, 1, 7, 6, 6};
        Method57 instance = new Method57();
        boolean expResult = true;
        boolean result = instance.variante1(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variante2 method, of class Method57. 9 3 2 2 1 1 1 0 3 0 1 2 1 2
     * 1 2 1 2 1 ---------------------------- 9+ 6+ 1+ 2+ 1+ 2+ 1+ 6+ 0 = 28
     */
    @Test
    public void testVariante2() {
        System.out.println("variante2");
        int[] number = new int[]{9, 3, 2, 2, 1, 1, 1, 0, 3, 0};
        Method57 instance = new Method57();
        boolean expResult = true;
        boolean result = instance.variante2(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variante3 method, of class Method57.
     */
    @Test
    public void testVariante3() {
        System.out.println("variante3");
        int[] number = {4, 0, 1, 2, 3, 4, 5};
        Method57 instance = new Method57();
        boolean expResult = true;
        boolean result = instance.variante3(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variante4 method, of class Method57.
     */
    @Test
    public void testVariante4() {
        System.out.println("variante4");
        int[] number = {0, 1, 8, 5, 1, 2, 5, 4, 3, 4};
        Method57 instance = new Method57();
        boolean expResult = true;
        boolean result = instance.variante4(number);
        assertEquals(expResult, result);

    }


}
