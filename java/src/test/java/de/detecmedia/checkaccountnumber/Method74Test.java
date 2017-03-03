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
public class Method74Test {

    public Method74Test() {
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
     * Test of test method, of class Method74.
     * <p>
     * Testkontonummern (richtig): 1016, 26260, 242243, 242248, 18002113,
     * 1821200043</p>
     * <p>
     * Testkontonummern (falsch): 1011, 26265, 18002118, 6160000024</p>
     *
     */
    @Test
    public void testTest() {
        System.out.println("test");
        Method74 instance = new Method74();
        instance.setAccountNumber("1016");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * 26260.
     * <pre>
     * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
     * Kontonr.:             2 6 2 6 P
     * Gewichtung:           1 2 1 2
     *                    ----------
     *                       2+3+2+3 = 10
     *                        (Q) (Q)
     * (Q = Quersumme)
     * 1. Berechnung (Verfahren 00) 10 - 10 = 0
     * 2. Berechnung 21 + 4 = 25 (nächste Halbdekade)
     *
     * P = 0
     *
     * ￼</pre>
     */
    @Test
    public void testTest1() {
        System.out.println("test");
        Method74 instance = new Method74();
        instance.setAccountNumber("26260");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * 242243.
     * <pre>
     * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
     * Kontonr.:           2 4 2 2 4 3
     * Gewichtung:       1 2 1 2 1 2
     *                  --------------
     *                     4+4+4+2+8 = 22
     *
     * (Q = Quersumme)
     *
     * 1. Berechnung (Verfahren 00) 2 - 10 = 8
     * 2. Berechnung 22 + 3 = 25 (nächste Halbdekade)
     *
     * P = 0
     *
     * ￼</pre>
     */
    @Test
    public void testTest2() {
        System.out.println("test");
        Method74 instance = new Method74();
        instance.setAccountNumber("242243");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testTest3() {
        System.out.println("test");
        Method74 instance = new Method74();
        instance.setAccountNumber("242248");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testTest4() {
        System.out.println("test");
        Method74 instance = new Method74();
        instance.setAccountNumber("18002113");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testTest5() {
        System.out.println("test");
        Method74 instance = new Method74();
        instance.setAccountNumber("1821200043");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     *
     * <pre>
     * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
     * Kontonr.:               1 0 1 P
     * Gewichtung:         2 1 2 1 2
     *                    ----------
     *                         2+0+2 = 4
     *                        
     * (Q = Quersumme)
     * 1. Berechnung (Verfahren 00) 10 - 4 = 6
     * 2. Berechnung 4 + 4 = 5 (nächste Halbdekade)
     *
     * ￼
     * </pre>
     */
    @Test
    public void testTest6() {
        System.out.println("test");
        Method74 instance = new Method74();
        instance.setAccountNumber("1011");
        boolean expResult = false;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }
    /**
     *
     * <pre>
     * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
     * Kontonr.:             2 6 2 6 P
     * Gewichtung:         2 1 2 1 2
     *                    ----------
     *                       2+3+2+3 = 10
     *                        
     * (Q = Quersumme)
     * 1. Berechnung (Verfahren 00) 10 - 9 = 1
     * 2. Berechnung 9 + 6 = 15 (nächste Halbdekade)
     *
     * ￼
     * </pre>
     */
    @Test
    public void testTest7() {
        System.out.println("test");
        Method74 instance = new Method74();
        instance.setAccountNumber("26265");
        boolean expResult = false;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method74.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method74 instance = new Method74();
        char[] expResult = "74".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

}
