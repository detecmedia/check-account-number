/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.detecmedia.checkaccountnumber;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * @author Markus Potthast <mpt@detecmedia.de>
 */
public class MethodC4Test {

    public MethodC4Test() {
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
     * Test of test method, of class MethodC4.
     */
    @Ignore
    @Test
    public void testTest() {
        System.out.println("test");
        MethodC4 instance = new MethodC4();
        instance.setAccountNumber("9000577650");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class MethodC4.
     */
    @Ignore
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        MethodC4 instance = new MethodC4();
        char[] expResult = "C4".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of variant1 method, of class MethodC4.
     */
    @Ignore
    @Test
    public void testVariant1() {
        System.out.println("variant1");
        int[] number = {0, 0, 0, 0, 0, 0, 0, 0, 1, 9};
        MethodC4 instance = new MethodC4();
        boolean expResult = true;
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant2 method, of class MethodC4.
     */
    @Test
    @Ignore
    public void testVariant2() {
        System.out.println("variant2");
        int[] number = {9, 0, 0, 0, 4, 2, 0, 5, 3, 0};
        MethodC4 instance = new MethodC4();
        boolean expResult = true;
        boolean result = instance.variant2(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant2 method, of class MethodC4.
     */
    @Test
    @Ignore
    public void testVariant21() {
        System.out.println("variant2");
        int[] number = {9, 0, 0, 0, 7, 3, 2, 0, 0, 0};
        MethodC4 instance = new MethodC4();
        boolean expResult = false;
        boolean result = instance.variant2(number);
        assertEquals(expResult, result);

    }

}
