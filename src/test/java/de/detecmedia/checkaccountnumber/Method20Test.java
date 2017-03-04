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
public class Method20Test {

    public Method20Test() {
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
     * Test of check method, of class Method20.
     * <p>
     * <p>
     * <pre>
     * 1  2  3  4  5  6  7  8  9  P
     * 0  1  2  3  4  5  6  7  8  9
     * 3  9  8  7  6  5  4  3  2
     * -------------------------
     * 0+ 9+16+21+24+25+24+21+16 = 156
     *
     * 156 % 11 = 2
     *
     * 11 - 2 = 9
     * </pre>
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method20 instance = new Method20();
        instance.setAccountNumber("0123456789");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

}
