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
public class Method52Test {

    private ESERAltsystems eserAltsystems;

    public Method52Test() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        eserAltsystems = new ESERAltsystems();
        eserAltsystems.setBankCode("13051172");
        eserAltsystems.setAccountNumber("43001500");

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of check method, of class Method52.
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method52 instance = new Method52();

        instance.setAccountNumber(eserAltsystems.getESERAltsystems(ESERAltsystems.ACHT));
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * <pre>
     * 1  2  3  4  5  6  7  8  9  P
     * 9  1  2  3  4  5  6  7  8  9
     * 3  9  8  7  6  5  4  3  2
     * -------------------------
     * 27+9+16+21+24+25+24+21+16 = 183
     *
     * 183 % 11 = 4
     *
     * 11 - 7 = 4
     * </pre>
     */
    @Test
    public void testCheck1() {
        System.out.println("check");
        Method52 instance = new Method52();
        instance.setAccountNumber("9123456784");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method52.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method52 instance = new Method52();
        char[] expResult = "52".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of getAccountNumberArray method, of class Method52.
     */
    @Test
    public void testGetAccountNumberArray() {
        System.out.println("getAccountNumberArray");
        Method52 instance = new Method52();
        instance.setAccountNumber("12345");
        int[] expResult = new int[]{1, 2, 3, 4, 5};
        int[] result = instance.getAccountNumberArray();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of add method, of class Method52.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int[] number = new int[]{1, 2, 3, 4, 5};
        int start = 0;
        int end = 0;
        Method52 instance = new Method52();
        int expResult = 15;
        int result = instance.add(number, 0, number.length);
        assertEquals(expResult, result);

    }

    /**
     * Test of check method, of class Method52.
     */
    @Test
    public void testCheck() {
        System.out.println("check");
        //{2, 4, 8, 5, 10, 9, 7, 3, 6, 1, 2, 4};
        //{4,2,1,6,3,7,9,10,5,8,4,2};
        int[] weighting = {2, 4, 8, 5, 10, 9, 7, 3, 6, 1, 2, 4};
        Method52 instance = new Method52();
        instance.setAccountNumber(eserAltsystems.getESERAltsystems(ESERAltsystems.ACHT));
        boolean expResult = true;
        boolean result = instance.check(weighting);
        assertEquals(expResult, result);

    }

}
