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
public class Method34Test {

    public Method34Test() {
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
     * Test of check method, of class Method34.
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method34 instance = new Method34();
        instance.setAccountNumber("9913000700");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * 9914001000
     */
    @Test
    public void testCheck1() {
        System.out.println("check");
        Method34 instance = new Method34();
        instance.setAccountNumber("9914001000");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testCheck2() {
        System.out.println("check");
        Method34 instance = new Method34();
        instance.setAccountNumber("9914004004");
        boolean expResult = false;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

}
