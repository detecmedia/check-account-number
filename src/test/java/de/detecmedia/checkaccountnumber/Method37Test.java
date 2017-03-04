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
public class Method37Test {

    public Method37Test() {
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
     * Test of check method, of class Method37.
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method37 instance = new Method37();
        instance.setAccountNumber("624315");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testCheck1() {
        System.out.println("check");
        Method37 instance = new Method37();
        instance.setAccountNumber("632500");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method37.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method37 instance = new Method37();
        char[] expResult = new char[]{'3', '7'};
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }


}
