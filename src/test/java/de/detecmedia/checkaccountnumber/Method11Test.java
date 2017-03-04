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
public class Method11Test {

    public Method11Test() {
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
     * Test of check method, of class Method06.
     */
    @Test
    public void testTest() {
        System.out.println("check");
        CheckAccountNumber instance = new Method11();
        instance.setAccountNumber("94012341");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

        instance = new Method11();
        instance.setAccountNumber("5073321019");
        assertEquals(instance.test(), true);


    }

    /**
     * Test of modulus11 method, of class Method11.
     * 11 % 11 = 0
     */
    @Test
    public void testModulus11() {
        System.out.println("modulus11");
        int pz = 11;
        Method11 instance = new Method11();
        int expResult = 0;
        int result = instance.modulus11(pz);
        assertEquals(expResult, result);

    }

}
