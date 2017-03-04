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
public class Method35Test {

    public Method35Test() {
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
     * Test of check method, of class Method35.
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method35 instance = new Method35();
        instance.setAccountNumber("0000108443");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of check method, of class Method35.
     */
    @Test
    public void testCheck1() {
        System.out.println("check");
        Method35 instance = new Method35();
        instance.setAccountNumber("0000107451");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of check method, of class Method35.
     */
    @Test
    public void testCheck2() {
        System.out.println("check");
        Method35 instance = new Method35();
        instance.setAccountNumber("0000102921");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of check method, of class Method35.
     */
    @Test
    public void testCheck3() {
        System.out.println("check");
        Method35 instance = new Method35();
        instance.setAccountNumber("0000102349");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of check method, of class Method35.
     */
    @Test
    public void testCheck4() {
        System.out.println("check");
        Method35 instance = new Method35();
        instance.setAccountNumber("0000101709");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of check method, of class Method35.
     * 0  0  0  0  1  0  1  5  9  9
     * 10 9  8  7  6  5  4  3  2
     * --------------------------
     * 0 +0 +0 +0 +6 +0 +4 +15+18 = 43
     * <p>
     * 43
     */
    @Test
    public void testCheck5() {
        System.out.println("check");
        Method35 instance = new Method35();
        instance.setAccountNumber("0000101599");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method35.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method35 instance = new Method35();
        char[] expResult = "35".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of add method, of class Method35.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int[] number = {1, 1, 1, 1, 1, 1, 1, 1};
        Method35 instance = new Method35();
        int expResult = 7;
        int result = instance.add(number);
        assertEquals(expResult, result);

    }

    /**
     * Test of modulus11 method, of class Method35.
     */
    @Test
    public void testModulus11() {
        System.out.println("modulus11");
        int number = 13;
        Method35 instance = new Method35();
        int expResult = 2;
        int result = instance.modulus11(number);
        assertEquals(expResult, result);

    }

}
