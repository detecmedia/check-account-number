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
import org.junit.Ignore;

/**
 *
 * @author Markus Potthast <mpt@detecmedia.de>
 */
public class MethodB6Test {

    public MethodB6Test() {
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
     * Test of test method, of class MethodB6.
     * <p>
     * TODO: Test muss noch erstellt
     * </p>
     * werden
     */
    @Test
    
    public void testTest() {
        System.out.println("test");
        MethodB6 instance = new MethodB6();
        instance.setAccountNumber("0269876545");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);


    }

    /**
     * Test of getFlag method, of class MethodB6.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        MethodB6 instance = new MethodB6();
        char[] expResult = "B6".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of variant1 method, of class MethodB6.
     */
    @Test
    public void testVariant1() {
        System.out.println("variant1");
        int[] number = {9, 1, 1, 0, 0, 0, 0, 0, 0, 0};
        MethodB6 instance = new MethodB6();
        boolean expResult = true;
        boolean result = instance.variant1(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of variant2 method, of class MethodB6.
     * <p>
     * TODO: Test muss noch erstellt
     * </p>
     * <pre>
     * BLZ 80053782: 487310018
     * </pre>
     */
    @Test
    
    public void testVariant2() {
        System.out.println("variant2");
        ESERAltsystems eserAltsystems = new ESERAltsystems();
        eserAltsystems.setBankCode("80053782");
        eserAltsystems.setAccountNumber("0487310018");
        eserAltsystems.generateEserAccountNumber1();
        MethodB6 instance = new MethodB6();
        instance.setAccountNumber(String.valueOf(eserAltsystems.generateEserAccountNumber1()));
        boolean expResult = true;
        boolean result = instance.variant2(instance.getAccountNumberArray());
        assertEquals(expResult, result);
        
    }

}
