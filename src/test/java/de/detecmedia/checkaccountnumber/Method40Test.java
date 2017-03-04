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
public class Method40Test {

    public Method40Test() {
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
     * Test of check method, of class Method40.
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method40 instance = new Method40();
        instance.setAccountNumber("1258345");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of check method, of class Method40.
     */
    @Test
    public void testCheck1() {
        System.out.println("check");
        Method40 instance = new Method40();
        instance.setAccountNumber("3231963");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method40.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method40 instance = new Method40();
        char[] expResult = "40".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }


}
