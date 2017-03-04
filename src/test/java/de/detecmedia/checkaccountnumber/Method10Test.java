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
public class Method10Test {

    public Method10Test() {
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
     * Test of check method, of class Method10.
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method10 instance = new Method10();
        boolean result;

        // RETRUN TRUE
        instance.setAccountNumber("12345008");
        result = instance.test();
        assertEquals(true, result);

        instance = new Method10();
        instance.setAccountNumber("87654008");
        result = instance.test();
        assertEquals(true, result);

        instance = new Method10();
        // RETURN FALSE
        instance.setAccountNumber("539290853");
        result = instance.test();
        assertEquals(false, result);

        instance = new Method10();
        instance.setAccountNumber("1501824");
        result = instance.test();
        assertEquals(false, result);


    }

}
