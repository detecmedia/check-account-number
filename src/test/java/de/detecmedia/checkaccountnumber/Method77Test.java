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
public class Method77Test {

    public Method77Test() {
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
     * Test of test method, of class Method77.
     * <p>
     * Testkontonummern: 10338, 13844, 65354, 69258</p>
     */
    @Test
    public void testTest() {
        System.out.println("test");
        Method77 instance = new Method77();
        instance.setAccountNumber("10338");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testTest1() {
        System.out.println("test");
        Method77 instance = new Method77();
        instance.setAccountNumber("13844");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testTest2() {
        System.out.println("test");
        Method77 instance = new Method77();
        instance.setAccountNumber("65354");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testTest3() {
        System.out.println("test");
        Method77 instance = new Method77();
        instance.setAccountNumber("69258");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method77.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method77 instance = new Method77();
        char[] expResult = "77".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of checkPz method, of class Method77.
     */
    @Test
    public void testCheckPz() {
        System.out.println("checkPz");
        int pz = 0;
        int[] number = {1, 1, 1, 1, 1, 1, 1, 1, 1, 0};
        Method77 instance = new Method77();
        boolean expResult = true;
        boolean result = instance.checkPz(pz, number);

    }

    /**
     * Test of add method, of class Method77.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int[] number = {1, 1, 1, 1, 1, 1, 1, 1};
        int start = 0;
        int end = 7;
        Method77 instance = new Method77();
        int expResult = 7;
        int result = instance.add(number, start, end);
        assertEquals(expResult, result);
    }

}
