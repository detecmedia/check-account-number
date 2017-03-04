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
public class Method27Test {

    public Method27Test() {
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
     * Test of check method, of class Method27.
     */
    @Test
    public void testCheck1() {
        System.out.println("check");
        Method27 instance = new Method27();
        instance.setAccountNumber("9290701");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of check method, of class Method27.
     */
    @Test
    public void testTest() throws NumberFormatException {
        System.out.println("check");
        Method27 instance = new Method27();
        instance.setAccountNumber("2847169488");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

}
