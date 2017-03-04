/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.exception.AccountNumberLenghtException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Markus Potthast
 */
public class Method15Test {

    public Method15Test() {
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

    @Test
    public void testAccountNumberlenght() {
        System.out.println("accountNumberlenght");
        CheckAccountNumber instance = new Method15();
        instance.setAccountNumber("123456789");
        try {
            instance.test();
            fail("Exception not found");
        } catch (AccountNumberLenghtException e) {
        }
    }

    /**
     * Test of check method, of class Method15.
     * <pre>
     * Check der Kontonummer.
     * 1  2  3  4  5  6  7  8  9  P
     * 0  1  2  3  4  5  6  7  8
     *                5  4  3  2
     *                ------------
     *                25+24+21+18 = 88
     * 88 % 11 = 8 R 0
     *
     * 11 - 0 = 11 = 0
     *
     * P = 0
     * </pre>
     */
    @Test
    public void testCheck1() {
        System.out.println("check");
        CheckAccountNumber instance = new Method15();
        instance.setAccountNumber("1234567890");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Kennzeichen 15.
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5 </p>
     * <p>
     * Die Kontonummer ist 10-stellig. Die Berechnung erfolgt wie bei Verfahren
     * 06; es ist jedoch zu beachten, dass nur die Stellen 6 bis 9 in das
     * Prüfzifferberechnungsverfahren einbezogen werden. Die Stelle 10 der
     * Kontonummer ist die Prüfziffer.</p>
     *
     * @see Method06
     * <p>
     * Test of check method, of class Method15.      <pre>
     * 1  2  3  4  5  6  7  8  9  P
     * 0  1  2  3  4  5  6  7  8  2
     *                5  4  3  2
     *             -------------
     *               25+24+21+16 = 86
     * <p>
     * 86 % 11 = 11 R 9
     * <p>
     * 11 - 9 = 2
     * <p>
     * P = 2
     * <p>
     * </pre>
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method15 instance = new Method15();
        instance.setAccountNumber("0123456782");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of factor method, of class Method15.
     * <pre>
     * 1  2  3  4  5  6  7  8  9  P
     * 0  1  2  3  4  5  6  7  8  9
     *                5  4  3  2
     *                -------------
     *               25+24+21+16
     * </pre>
     */
    @Test
    public void testFactor() {
        System.out.println("factor");
        int[] number = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] weighting = {2, 3, 4, 5};
        Method15 instance = new Method15();
        int[] expResult = {0, 1, 2, 3, 4, 25, 24, 21, 16, 9};
        int[] result = instance.factor(number, weighting);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of check method, of class Method15.
     */
    @Test
    public void testCheck() {
        System.out.println("check");
        int[] weighting = new int[]{2, 3, 4, 5};
        Method15 instance = new Method15();
        instance.setAccountNumber("0123456782");
        boolean expResult = true;
        boolean result = instance.check(weighting);
        assertEquals(expResult, result);

    }

}
