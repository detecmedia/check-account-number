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
public class Method73Test {

    public Method73Test() {
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
     * Test of test method, of class Method73.
     * <p>
     * Testkontonummern: richtig: 0003503398, 0001340967 falsch: 0003503391,
     * 0001340966</p>
     * <p>
     * Testkontonummern: richtig: 0003503391, 0001340968 falsch: 0003503392,
     * 0001340966</p>
     * <p>
     * Testkontonummern: richtig: 0003503392, 0001340966, 123456 falsch: 121212,
     * 987654321</p>
     */
    @Test
    public void testTest() {
        System.out.println("test");
        Method73 instance = new Method73();
        instance.setAccountNumber("0003503398");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testTest1() {
        System.out.println("test");
        Method73 instance = new Method73();
        instance.setAccountNumber("0001340967");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testTest2() {
        System.out.println("test");
        Method73 instance = new Method73();
        instance.setAccountNumber("0003503391");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testTest3() {
        System.out.println("test");
        Method73 instance = new Method73();
        instance.setAccountNumber("0001340968");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testTest4() {
        System.out.println("test");
        Method73 instance = new Method73();
        instance.setAccountNumber("0003503392");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testTest5() {
        System.out.println("test");
        Method73 instance = new Method73();
        instance.setAccountNumber("0001340966");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method73.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method73 instance = new Method73();
        char[] expResult = "73".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of variant1 method, of class Method73.
     */
    @Test
    public void testVariant1() {
        System.out.println("variant1");
        Method73 instance = new Method73();
        instance.setAccountNumber("0003503398");
        boolean expResult = true;
        boolean result = instance.variant1(instance.getAccountNumberArray());
        assertEquals(expResult, result);

    }

    /**
     * Test of variant2 method, of class Method73.
     */
    @Test
    public void testVariant2() {
        System.out.println("variant2");
        int[] number = {0, 0, 0, 3, 5, 0, 3, 3, 9, 1};
        Method73 instance = new Method73();
        boolean expResult = true;
        boolean result = instance.variant2(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant3 method, of class Method73.
     */
    @Test
    public void testVariant3() {
        System.out.println("variant3");
        int[] number = {0, 0, 0, 3, 5, 0, 3, 3, 9, 2};
        Method73 instance = new Method73();
        boolean expResult = true;
        boolean result = instance.variant3(number);
        assertEquals(expResult, result);

    }

}
