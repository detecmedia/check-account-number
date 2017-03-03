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
public class Method75Test {

    public Method75Test() {
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
     * Test of test method, of class Method75.
     *
     * <p>
     * Modulus 10, Gewichtung 2, 1, 2, 1, 2</p>
     * <pre>
     * S = Stammnummer
     * X = Weitere Ziffern der Kontonummer, die jedoch nicht in
     *     die Prüfzifferberechnung mit einbezogen werden
     * P = Prüfziffer
     *
     * Stellennr.:      1 2 3 4 5 6 7 8 9 A (A = 10)
     * 6stell.Kontonr.: 0 0 0 0 2 1 2 1 2 6
     * 7stell.Kontonr.: 0 0 0 X S S S S S P
     * 9stell.Kontonr.: 0 9 S S S S S P X X
     * 10stell.Kontonr.:0 S S S S S P X X X
     * </pre>
     * 
     * <pre>
     * 2 1 2 1 2 P
     * 2 1 2 1 2
     * ----------
     * 4+1+4+1+4 = 14
     * 14 % 10 = 4;
     * 10 -4 = 6
     * P = 6
     * </pre>
     */
    @Test
    public void testTest() {
        System.out.println("test");
        Method75 instance = new Method75();
        instance.setAccountNumber("0000212126");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }
    
    /**
     * <pre>
     * 0 9 S S S S S P X X.
     * 
     * 0 9 1 2 3 4 1 2 3 4
     * 0 0 2 1 2 1 2 P 3 4
     * -------------------
     *     2+2+6+4+2=16
     * 
     * 10 - 6 = 4
     * P = 4
     * </pre>
     */
    @Test
    public void testTest1() {
        System.out.println("test");
        Method75 instance = new Method75();
        instance.setAccountNumber("21212434");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }
    /**
     * <pre>
     * 
     * 10stell.Kontonr.:
     * 0 S S S S S P X X X
     * 0 4 3 2 1 4 6 2 1 4
     *   2 1 2 1 2
     * --------------------
     *   8+3+4+1+8=24
     * 
     * 10 -4 = 6
     * 
     * </pre>
     */
    @Test
    public void testTest2() {
        System.out.println("test");
        Method75 instance = new Method75();
        instance.setAccountNumber("432146214");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method75.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method75 instance = new Method75();
        char[] expResult = "75".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

}
