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
public class Method24Test {

    public Method24Test() {
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
     * Test of check method, of class Method24.
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method24 instance = new Method24();
        instance.setAccountNumber("0000138301");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of check method, of class Method24.
     */
    @Test
    public void testCheck1() {
        System.out.println("check");
        Method24 instance = new Method24();
        instance.setAccountNumber("1306118605");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of check method, of class Method24.
     */
    @Test
    public void testCheck2() {
        System.out.println("check");
        Method24 instance = new Method24();
        instance.setAccountNumber("3307118608");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }


    /**
     * 9  3  0  7  1  1  8  6  0   3
     * <p>
     * /
     */
    @Test
    public void testCheck3() {
        System.out.println("check");
        Method24 instance = new Method24();
        instance.setAccountNumber("9307118603");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of factor method, of class Method24.
     * <pre>
     * Stellennr.:             1  2  3  4  5  6  7  8  9  10
     * Kontonr.:                           1  3  8  3  0  1
     * Ktonr. umgesetzt:       0  0  0  0  1  3  8  3  0
     * Gewichtung:                         1  2  3  1  2
     *                        --------------------------
     *                                     1  6 24  3  0
     *
     * </pre>
     */
    @Test
    public void testFactor1() {
        System.out.println("factor");
        int[] number = {0, 0, 0, 0, 1, 3, 8, 3, 0, 1};
        int[] weighting = {1, 2, 3, 1, 2, 3, 1, 2, 3};
        Method24 instance = new Method24();
        int[] expResult = {0, 0, 0, 0, 1, 6, 24, 3, 0, 1};
        int[] result = instance.factor(number, weighting);
        assertArrayEquals(expResult, result);

    }

    /**
     * <pre>
     * Stellennr.:             1  2  3  4  5  6  7  8  9  10
     * Kontonr.:               1  3  0  6  1  1  8  6  0   5
     * Gewichtung:             1  2  3  1  2  3  1  2  3
     *                        --------------------------
     *                         1  6  0  6  2  3  8 12  0
     * </pre>
     */
    @Test
    public void testFactor2() {
        System.out.println("factor");
        int[] number = {1, 3, 0, 6, 1, 1, 8, 6, 0, 5};
        int[] weighting = {1, 2, 3, 1, 2, 3, 1, 2, 3};
        Method24 instance = new Method24();
        int[] expResult = {1, 6, 0, 6, 2, 3, 8, 12, 0, 5};
        int[] result = instance.factor(number, weighting);
        assertArrayEquals(expResult, result);

    }

    /**
     * <pre>
     * Stellennr.:             1  2  3  4  5  6  7  8  9  10
     * Kontonr.:               3  3  0  7  1  1  8  6  0   8
     * Ktonr. umgesetzt:       0  3  0  7  1  1  8  6  0
     * Gewichtung:                1  2  3  1  2  3  1  2
     *                        --------------------------
     *                            3  0 21  1  2 24  6  0
     * </pre>
     */
    @Test
    public void testFactor3() {
        System.out.println("factor");
        int[] number = {3, 3, 0, 7, 1, 1, 8, 6, 0, 8};
        int[] weighting = {1, 2, 3, 1, 2, 3, 1, 2, 3};
        Method24 instance = new Method24();
        int[] expResult = {0, 3, 0, 21, 1, 2, 24, 6, 0, 8};
        int[] result = instance.factor(number, weighting);
        assertArrayEquals(expResult, result);

    }

    /**
     * <pre>
     * Stellennr.:             1  2  3  4  5  6  7  8  9  10
     * Kontonr.:               9  3  0  7  1  1  8  6  0   3
     * Ktonr. umgesetzt:       0  0  0  7  1  1  8  6  0
     * Gewichtung:                      1  2  3  1  2  3
     *                                 -----------------
     *                                  7  2  3  8 12  0
     * </pre>
     */
    @Test
    public void testFactor4() {
        System.out.println("factor");
        int[] number = {9, 3, 0, 7, 1, 1, 8, 6, 0, 3};
        int[] weighting = {1, 2, 3, 1, 2, 3, 1, 2, 3};
        Method24 instance = new Method24();
        int[] expResult = {0, 0, 0, 7, 2, 3, 8, 12, 0, 3};
        int[] result = instance.factor(number, weighting);
        assertArrayEquals(expResult, result);

    }


    /**
     * Test of add method, of class Method24.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int[] number = {0, 0, 0, 7, 2, 3, 8, 12, 0, 3};
        int[] weighting = new int[]{1, 2, 3, 1, 2, 3, 1, 2, 3};
        Method24 instance = new Method24();
        int expResult = 33;
        int result = instance.add(number, weighting);
        assertEquals(expResult, result);

    }

    /**
     * Test of factor method, of class Method24.
     */
    @Test
    public void testFactor() {
        System.out.println("factor");
        int[] number = {0, 0, 0, 7, 2, 3, 8, 12, 0, 3};
        int[] weighting = new int[]{1, 2, 3, 1, 2, 3, 1, 2, 3};
        Method24 instance = new Method24();
        int[] expResult = {0, 0, 0, 7, 4, 9, 8, 24, 0, 3};
        int[] result = instance.factor(number, weighting);
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method24.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method24 instance = new Method24();
        char[] expResult = "24".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

}
