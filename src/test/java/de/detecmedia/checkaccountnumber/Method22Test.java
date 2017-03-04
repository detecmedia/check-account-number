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
public class Method22Test {

    public Method22Test() {
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
     * Test of check method, of class Method22.
     * <p>
     * <p>
     * Modulus 10, Gewichtung 3, 1, 3, 1, 3, 1, 3, 1, 3</p><p>
     * Die einzelnen Stellen der Kontonummer sind von rechts nach links mit den
     * Ziffern 3, 1, 3, 1 usw. zu multiplizieren. Von den jeweiligen Produkten
     * bleiben die Zehnerstellen unberücksichtigt. Die verbleibenden Zahlen
     * (Einerstellen) werden addiert. Die Differenz bis zum nächsten Zehner ist
     * die Prüfziffer.</p>
     * <p>
     * <pre>
     *   1  2  3  4  5  6  7  8  9  P
     *   4  5  6  7  8  9  0  9  8
     *   3  1  3  1  3  1  3  1  3
     *  --------------------------
     *   2+ 5+ 8+ 7+4+ 9+ 0+ 9+4 = 48
     *
     *
     *   10 -8 = 2
     *   P = 2
     * </pre>
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method22 instance = new Method22();
        instance.setAccountNumber("4567890982");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of add method, of class Method22.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int[] number = {2, 6, 2, 7, 4, 9, 0, 9, 4, 0};
        Method22 instance = new Method22();
        int expResult = 43;
        int result = instance.add(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method22.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method22 instance = new Method22();
        char[] expResult = "22".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

}
