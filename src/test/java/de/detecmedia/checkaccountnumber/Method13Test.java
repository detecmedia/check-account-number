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
public class Method13Test {

    public Method13Test() {
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
     * Test of check method, of class Method13.
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method13 instance = new Method13();
        instance.setAccountNumber("1234567690");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        instance = new Method13();
        try {
            instance.setAccountNumber("1234567");
            instance.test();
            fail("not Exception");
        } catch (AccountNumberLenghtException ex) {

        }

    }


}
