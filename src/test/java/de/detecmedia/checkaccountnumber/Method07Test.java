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
 * @author Markus Potthast
 */
public class Method07Test {

    public Method07Test() {
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
     * Test of check method, of class Method07.
     */
    @Test
    public void testTest() {
        System.out.println("check");
        CheckAccountNumber instance = new Method07();
        boolean result;

        // check 9290701
        instance.setAccountNumber("2462647228");
        result = instance.test();
        assertEquals(true, result);
        // check 9290701
        instance = new Method07();
        instance.setAccountNumber("34728139");
        result = instance.test();
        assertEquals(true, result);

        instance = new Method07();
        instance.setAccountNumber("1234560");
        result = instance.test();
        assertEquals(true, result);

        instance = new Method07();
        instance.setAccountNumber("123456");
        result = instance.test();
        assertEquals(false, result);

        instance = new Method07();
        instance.setAccountNumber("0009876542");
        result = instance.test();
        assertEquals(false, result);
    }

}
