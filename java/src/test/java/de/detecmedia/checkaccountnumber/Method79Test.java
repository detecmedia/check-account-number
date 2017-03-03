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
public class Method79Test {

    public Method79Test() {
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
     * Test of test method, of class Method79.
     *  <p>
     * Testkontonummern: 3230012688, 4230028872, 5440001898, 6330001063,
     * 7000149349, 8000003577, 1550167850, 9011200140</p>
     */
    @Test
    public void testTest() {
        System.out.println("test");
        Method79 instance = new Method79();
        instance.setAccountNumber("3230012688");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }
    /**
     * Test of test method, of class Method79.
     *  <p>
     * Testkontonummern: 3230012688, 4230028872, 5440001898, 6330001063,
     * 7000149349, 8000003577, 1550167850, 9011200140</p>
     */
    @Test
    public void testTest1() {
        System.out.println("test");
        Method79 instance = new Method79();
        instance.setAccountNumber("4230028872");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }
    /**
     * Test of test method, of class Method79.
     *  <p>
     * Testkontonummern: 3230012688, 4230028872, 5440001898, 6330001063,
     * 7000149349, 8000003577, 1550167850, 9011200140</p>
     */
    @Test
    public void testTest3() {
        System.out.println("test");
        Method79 instance = new Method79();
        instance.setAccountNumber("5440001898");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }
    /**
     * Test of test method, of class Method79.
     *  <p>
     * Testkontonummern: 3230012688, 4230028872, 5440001898, 6330001063,
     * 7000149349, 8000003577, 1550167850, 9011200140</p>
     */
    @Test
    public void testTest4() {
        System.out.println("test");
        Method79 instance = new Method79();
        instance.setAccountNumber("6330001063");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }
    /**
     * Test of test method, of class Method79.
     *  <p>
     * Testkontonummern: 3230012688, 4230028872, 5440001898, 6330001063,
     * 7000149349, 8000003577, 1550167850, 9011200140</p>
     */
    @Test
    public void testTest5() {
        System.out.println("test");
        Method79 instance = new Method79();
        instance.setAccountNumber("7000149349");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }
    /**
     * Test of test method, of class Method79.
     *  <p>
     * Testkontonummern: 3230012688, 4230028872, 5440001898, 6330001063,
     * 7000149349, 8000003577, 1550167850, 9011200140</p>
     */
    @Test
    public void testTest6() {
        System.out.println("test");
        Method79 instance = new Method79();
        instance.setAccountNumber("8000003577");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }
    /**
     * Test of test method, of class Method79.
     *  <p>
     * Testkontonummern: 3230012688, 4230028872, 5440001898, 6330001063,
     * 7000149349, 8000003577, 1550167850, 9011200140</p>
     */
    @Test
    public void testTest7() {
        System.out.println("test");
        Method79 instance = new Method79();
        instance.setAccountNumber("1550167850");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }
    /**
     * Test of test method, of class Method79.
     *  <p>
     * Testkontonummern: 3230012688, 4230028872, 5440001898, 6330001063,
     * 7000149349, 8000003577, 1550167850, 9011200140</p>
     */
    @Test
    public void testTest8() {
        System.out.println("test");
        Method79 instance = new Method79();
        instance.setAccountNumber("9011200140");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method79.
     *
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method79 instance = new Method79();
        char[] expResult = "79".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of variant1 method, of class Method79.
     */
    @Test
    public void testVariant1() {
        System.out.println("variant1");
        Method79 instance = new Method79();
        instance.setAccountNumber("3230012688");
        boolean expResult = true;
        boolean result = instance.variant1(instance.getAccountNumberArray());
        assertEquals(expResult, result);
        
    }

    /**
     * Test of variant2 method, of class Method79.
     */
    @Test
    public void testVariant2() {
        System.out.println("variant2");
        Method79 instance = new Method79();
        instance.setAccountNumber("9011200140");
        boolean expResult = true;
        boolean result = instance.variant2(instance.getAccountNumberArray());
        assertEquals(expResult, result);
    }

}
