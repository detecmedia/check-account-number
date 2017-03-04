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
public class Method53Test {

    private ESERAltsystems eserAltsystems;

    public Method53Test() {
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
        eserAltsystems.setBankCode("1605208");
        eserAltsystems.setAccountNumber("2382432256");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of check method, of class Method53.
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method53 instance = new Method53();

        instance.setAccountNumber(eserAltsystems.getESERAltsystems(ESERAltsystems.NEUN));
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method53.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method53 instance = new Method53();
        char[] expResult = "53".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of check method, of class Method53.
     */
    @Test

    public void testCheck() {
        System.out.println("check");
        int[] weighting = new int[]{2, 4, 8, 5, 10, 9, 7, 3, 6, 1, 2, 4};
        Method53 instance = new Method53();
        instance.setAccountNumber(eserAltsystems.getESERAltsystems(ESERAltsystems.NEUN));
        boolean expResult = true;
        boolean result = instance.check(weighting);
        assertEquals(expResult, result);

    }


}
