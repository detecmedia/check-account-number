/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.exception.InvalidException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Ignore;

/**
 * @author Markus Potthast
 */
public class AbstractMethodTest {

    public AbstractMethodTest() {
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
     * Test of getArrayFromString method, of class AbstractMethode.
     */
    @Test
    public void testGetArray() {
        System.out.println("getArrayFromString");

        AbstractMethod instance = new AbstractMethodImpl();
        instance.setAccountNumber("1234567");
        int[] expResult = {1, 2, 3, 4, 5, 6, 7};
        int[] result = instance.getAccountNumberArray();
        assertArrayEquals(expResult, result);

    }

    @Test
    public void testGetArray1() {
        System.out.println("getArrayFromString");
        AbstractMethod instance = new AbstractMethodImpl();
        int[] expResult1 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        instance.setAccountNumber("987654321");
        int[] result = instance.getAccountNumberArray();
        assertArrayEquals(expResult1, result);

    }

    @Test
    public void testGetInt() {
        AbstractMethod instance = new AbstractMethodImpl();
        instance.setAccountNumber("123456789");
        int result = instance.getInt();
        int expResult = 123456789;
        assertEquals(expResult, result);
    }

    public class AbstractMethodImpl extends AbstractMethod {

        /**
         * mock
         *
         * @return
         */
        @Override
        public boolean test() {
            return false;
        }

    }

    /**
     * Test of setAccountNumber method, of class AbstractMethode.
     */
    @Test
    public void testSetAccountNumber() {
        System.out.println("setAccountNumber");
        String accountNumber = "";
        AbstractMethod instance = new AbstractMethodImpl();
        instance.setAccountNumber(accountNumber);

    }

    /**
     * Test of iterierteQuersumme method, of class AbstractMethode.
     */
    @Test
    public void testIterierteQuersumme() {
        System.out.println("iterierteQuersumme");
        int zahl = 125;
        AbstractMethod instance = new AbstractMethodImpl();
        int expResult = 8;
        int result = instance.iterierteQuersumme(zahl);
        assertEquals(expResult, result);

    }

    /**
     * Test of modulus10 method, of class AbstractMethode.
     */
    @Test
    public void testModulus10() {
        System.out.println("modulus10");
        int pz = 7;
        AbstractMethod instance = new AbstractMethodImpl();
        int expResult = 3;
        int result = instance.modulus10(pz);
        assertEquals(expResult, result);
        pz = 5;
        expResult = 5;
        result = instance.modulus10(pz);
        assertEquals(expResult, result);

        pz = 17;
        expResult = 3;
        result = instance.modulus10(pz);
        assertEquals(expResult, result);

    }

    /**
     * Test of modulus11 method, of class AbstractMethode.
     */
    @Test
    public void testModulus11() {
        System.out.println("modulus11");
        int pz = 11;
        AbstractMethod instance = new AbstractMethodImpl();
        int expResult = 0;
        int result = instance.modulus11(pz);
        assertEquals(expResult, result);

        try {
            pz = 12;
            expResult = 1;
            result = instance.modulus11(pz);
            fail("not InvalidException");
            assertEquals(expResult, result);
        } catch (InvalidException ex) {

        }

    }

    /**
     * Test of factor method, of class AbstractMethod.
     * <p>
     * 1 2 3 4 5 6 7 8 9 10 0 1 2 3 4 5 6 7 8 9 2 1 2 1 2 1 2 1 2
     * --------------------------- 0 1 4 3 8 5 12 7 16
     */
    @Test
    public void testFactor_intArr_intArr() {
        System.out.println("factor");
        int[] number = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] weighting = new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2};
        AbstractMethod instance = new AbstractMethodImpl();
        int[] expResult = new int[]{0, 1, 4, 3, 8, 5, 12, 7, 16, 9};
        int[] result = instance.factor(number, weighting);
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of factor method, of class AbstractMethod.
     * <p>
     * <pre>
     * 1  2  3  4  5  6  7  8  9  10
     * 0  1  2  3  4  5  6  7  8  9
     *          5  4  3  2  2  1
     * --------------------------
     *         15 16 15 12 14  8
     * </pre>
     */
    @Test
    public void testFactor_4args() {
        System.out.println("factor");
        int[] number = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] weighting = {1, 2, 2, 3, 4, 5};
        int start = 4;
        int end = 9;
        AbstractMethod instance = new AbstractMethodImpl();
        int[] expResult = {0, 1, 2, 15, 16, 15, 12, 14, 8, 9};
        int[] result = instance.factor(number, weighting, start, end);
        assertArrayEquals(expResult, result);


    }

    /**
     * Test of checkPz method, of class AbstractMethod.
     */
    @Test
    public void testCheckPz() {
        System.out.println("checkPz");
        int pz = 0;
        int[] number = {1, 0};
        AbstractMethod instance = new AbstractMethodImpl();
        boolean expResult = true;
        boolean result = instance.checkPz(pz, number);
        assertEquals(expResult, result);

    }

    /**
     * Test of expand method, of class AbstractMethod.
     */
    @Test
    public void testExpand() {
        System.out.println("expand");
        AbstractMethod instance = new AbstractMethodImpl();
        instance.setAccountNumber("84956");
        int[] number = instance.getAccountNumberArray();
        int[] expResult = {0, 0, 0, 0, 0, 8, 4, 9, 5, 6};
        int[] result = instance.expand(number);
        assertArrayEquals(expResult, result);

    }

    @Test
    public void testExpan1d() {
        System.out.println("expand");
        AbstractMethod instance = new AbstractMethodImpl();
        instance.setAccountNumber("12384956");
        int[] number = instance.getAccountNumberArray();
        int[] expResult = {0, 0, 1, 2, 3, 8, 4, 9, 5, 6};
        int[] result = instance.expand(number);
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of getAccountNumberArray method, of class AbstractMethod.
     */
    @Test
    public void testGetAccountNumberArray() {
        System.out.println("getAccountNumberArray");
        AbstractMethod instance = new AbstractMethodImpl();
        instance.setAccountNumber("123456");
        int[] expResult = {1, 2, 3, 4, 5, 6};
        int[] result = instance.getAccountNumberArray();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of setAccountNumberArray method, of class AbstractMethod.
     */
    @Test
    public void testSetAccountNumberArray() {
        System.out.println("setAccountNumberArray");
        int[] accountNumberArray = {1, 2, 3, 4, 5, 6};
        AbstractMethod instance = new AbstractMethodImpl();
        instance.setAccountNumberArray(accountNumberArray);
        int[] result = instance.getAccountNumberArray();
        for (int r : result) {
            System.out.print(r);
        }
        assertArrayEquals(accountNumberArray, result);

    }

    /**
     * Test of getLong method, of class AbstractMethod.
     */
    @Test
    public void testGetLong() {
        System.out.println("getLong");
        AbstractMethod instance = new AbstractMethodImpl();
        instance.setAccountNumber("012345");
        long expResult = 12345L;
        long result = instance.getLong();
        assertEquals(expResult, result);

    }

    /**
     * Test of quersumme method, of class AbstractMethod.
     */
    @Test
    public void testQuersumme() {
        System.out.println("quersumme");
        int zahl = 1234567890;
        AbstractMethod instance = new AbstractMethodImpl();
        int expResult = 45;
        int result = instance.quersumme(zahl);
        assertEquals(expResult, result);

    }

    /**
     * Test of checkPz method, of class AbstractMethod.
     */
    @Test
    public void testCheckPz_int_intArr() {
        System.out.println("checkPz");
        int pz = 4;
        int[] number = {1, 2, 3, 4, 3, 4};
        AbstractMethod instance = new AbstractMethodImpl();
        boolean expResult = true;
        boolean result = instance.checkPz(pz, number);
        assertEquals(expResult, result);

    }

    @Test
    public void testCheckPz_int_intArr1() {
        System.out.println("checkPz");
        int pz = 4;
        int[] number = {1, 2, 3, 4, 3, 5};
        AbstractMethod instance = new AbstractMethodImpl();
        boolean expResult = false;
        boolean result = instance.checkPz(pz, number);
        assertEquals(expResult, result);

    }

    /**
     * Test of checkPz method, of class AbstractMethod.
     */
    @Test
    public void testCheckPz_3args() {
        System.out.println("checkPz");
        int pz = 4;
        int[] number = {1, 2, 3, 4, 5, 6};
        int pos = 4;
        AbstractMethod instance = new AbstractMethodImpl();
        boolean expResult = true;
        boolean result = instance.checkPz(pz, number, pos);
        assertEquals(expResult, result);

    }

    /**
     * Test of checkPz method, of class AbstractMethod.
     */
    @Test
    public void testCheckPz_3args1() {
        System.out.println("checkPz");
        int pz = 4;
        int[] number = {1, 2, 3, 4, 5, 6};
        int pos = 5;
        AbstractMethod instance = new AbstractMethodImpl();
        boolean expResult = false;
        boolean result = instance.checkPz(pz, number, pos);
        assertEquals(expResult, result);

    }

    /**
     * Test of add method, of class AbstractMethod.
     */
    @Test
    @Ignore
    public void testAdd_intArr() {
        System.out.println("add");
        int[] number = null;
        AbstractMethod instance = new AbstractMethodImpl();
        int expResult = 0;
        int result = instance.add(number);
        assertEquals(expResult, result);
        // TODO Test muss noch erstellt werden..
        fail("Test muss noch erstellt werden.");
    }

    /**
     * Test of add method, of class AbstractMethod.
     */
    @Test
    @Ignore
    public void testAdd_3args() {
        System.out.println("add");
        int[] number = null;
        int start = 0;
        int end = 0;
        AbstractMethod instance = new AbstractMethodImpl();
        int expResult = 0;
        int result = instance.add(number, start, end);
        assertEquals(expResult, result);
        // TODO Test muss noch erstellt werden..
        fail("Test muss noch erstellt werden.");
    }

    /**
     * Test of move method, of class AbstractMethod.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        int[] number = {0, 0, 0, 1, 2, 3, 4, 5, 6, 7};
        int pos = -2;
        AbstractMethod instance = new AbstractMethodImpl();
        int[] expResult = {0, 1, 2, 3, 4, 5, 6, 7, 0, 0};
        int[] result = instance.move(number, pos);
        assertArrayEquals(expResult, result);

    }

    @Test
    public void testMove1() {
        System.out.println("move");
        int[] number = {0, 1, 2, 3, 4, 5, 6, 7, 0, 0};
        int pos = 2;
        AbstractMethod instance = new AbstractMethodImpl();
        int[] expResult = {0, 0, 0, 1, 2, 3, 4, 5, 6, 7};
        int[] result = instance.move(number, pos);
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class AbstractMethod.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        AbstractMethod instance = new AbstractMethodImpl();
        char[] expResult = "pl".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of modulus7 method, of class AbstractMethod.
     */
    @Test
    public void testModulus7() {
        System.out.println("modulus7");
        int number = 8;
        AbstractMethod instance = new AbstractMethodImpl();
        int expResult = 6;
        int result = instance.modulus7(number);
        assertEquals(expResult, result);

    }

}
