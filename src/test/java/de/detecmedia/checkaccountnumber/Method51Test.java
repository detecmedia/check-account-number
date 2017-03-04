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
public class Method51Test {

    public Method51Test() {
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
     * Test of check method, of class Method51.
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method51 instance = new Method51();
        instance.setAccountNumber("0001156136");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testCheck1() {
        System.out.println("check");
        Method51 instance = new Method51();
        instance.setAccountNumber("0001234567");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testCheck2() {
        System.out.println("check");
        Method51 instance = new Method51();
        instance.setAccountNumber("201178");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testCheck3() {
        System.out.println("check");
        Method51 instance = new Method51();
        instance.setAccountNumber("0000156071");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testCheck4() {
        System.out.println("check");
        Method51 instance = new Method51();
        instance.setAccountNumber("0099100010");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    @Test
    public void testCheck5() {
        System.out.println("check");
        Method51 instance = new Method51();
        instance.setAccountNumber("2599100003");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);

    }

    /**
     * Test of getFlag method, of class Method51.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method51 instance = new Method51();

        char[] expResult = "51".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }

    @Test
    public void testMethodA() {
        System.out.println("methodA");
        Method51 instance = new Method51();
        instance.setAccountNumber("0001156071");
        boolean expResult = true;
        boolean result;
        result = instance.methodA(instance.getAccountNumberArray());
        assertEquals(expResult, result);


    }

    @Test
    public void testMethodA1() {
        System.out.println("methodA");
        Method51 instance = new Method51();
        instance.setAccountNumber("0001156136");
        boolean expResult = true;
        boolean result;
        result = instance.methodA(instance.getAccountNumberArray());
        assertEquals(expResult, result);


    }

    @Test
    public void testMethodA2() {
        System.out.println("methodA");
        Method51 instance = new Method51();
        instance.setAccountNumber("0001156078");
        boolean expResult = false;
        boolean result;
        result = instance.methodA(instance.getAccountNumberArray());
        assertEquals(expResult, result);


    }

    @Test
    public void testMethodA3() {
        System.out.println("methodA");
        Method51 instance = new Method51();
        instance.setAccountNumber("0000156079");
        boolean expResult = false;
        boolean result;
        result = instance.methodA(instance.getAccountNumberArray());
        assertEquals(expResult, result);


    }

    /**
     * Test of methodB method, of class Method51.
     */
    @Test
    public void testMethodB() {
        System.out.println("methodB");
        Method51 instance = new Method51();
        instance.setAccountNumber("0001156078");
        boolean expResult = true;
        boolean result;
        result = instance.methodB(instance.getAccountNumberArray());
        assertEquals(expResult, result);

    }

    @Test
    public void testMethodB1() {
        System.out.println("methodB");
        Method51 instance = new Method51();
        instance.setAccountNumber("0001234566");
        boolean expResult = false;
        boolean result;
        result = instance.methodB(instance.getAccountNumberArray());
        assertEquals(expResult, result);

    }

    @Test
    public void testMethodB2() {
        System.out.println("methodB");
        Method51 instance = new Method51();
        instance.setAccountNumber("0001156078");
        boolean expResult = true;
        boolean result;
        result = instance.methodB(instance.getAccountNumberArray());
        assertEquals(expResult, result);

    }

    @Test
    public void testMethodB3() {
        System.out.println("methodB");
        Method51 instance = new Method51();
        instance.setAccountNumber("0012345678");
        boolean expResult = false;
        boolean result;
        result = instance.methodB(instance.getAccountNumberArray());
        assertEquals(expResult, result);

    }

    /**
     * Test of methodC method, of class Method51.
     */
    @Test
    public void testMethodC() {
        System.out.println("methodC");
        Method51 instance = new Method51();
        instance.setAccountNumber("340968");
        boolean expResult = true;
        boolean result = instance.methodC(instance.getAccountNumberArray());
        assertEquals(expResult, result);
    }

    @Test
    public void testMethodC1() {
        System.out.println("methodC");
        Method51 instance = new Method51();
        instance.setAccountNumber("201178");
        boolean expResult = true;
        boolean result = instance.methodC(instance.getAccountNumberArray());
        assertEquals(expResult, result);
    }

    @Test
    public void testMethod2C() {
        System.out.println("methodC");
        Method51 instance = new Method51();
        instance.setAccountNumber("1009588");
        boolean expResult = true;
        boolean result = instance.methodC(instance.getAccountNumberArray());
        assertEquals(expResult, result);
    }

    @Test
    public void testMethod3C() {
        System.out.println("methodC");
        Method51 instance = new Method51();
        instance.setAccountNumber("0023456783");
        boolean expResult = false;
        boolean result = instance.methodC(instance.getAccountNumberArray());
        assertEquals(expResult, result);
    }

    @Test
    public void testMethod4C() {
        System.out.println("methodC");
        Method51 instance = new Method51();
        instance.setAccountNumber("0076543211");
        boolean expResult = false;
        boolean result = instance.methodC(instance.getAccountNumberArray());
        assertEquals(expResult, result);
    }

    /**
     * Test of methodD method, of class Method51.
     */
    @Test
    public void testMethodD() {
        System.out.println("methodD");

        Method51 instance = new Method51();
        instance.setAccountNumber("0000156071");
        boolean expResult = true;
        boolean result = instance.methodD(instance.getAccountNumberArray());
        assertEquals(expResult, result);
    }

    @Test
    public void testMethodD1() {
        System.out.println("methodD");

        Method51 instance = new Method51();
        instance.setAccountNumber("101356073");
        boolean expResult = true;
        boolean result = instance.methodD(instance.getAccountNumberArray());
        assertEquals(expResult, result);
    }

    @Test
    public void testMethodD2() {
        System.out.println("methodD");

        Method51 instance = new Method51();
        instance.setAccountNumber("0123412345");
        boolean expResult = false;
        boolean result = instance.methodD(instance.getAccountNumberArray());
        assertEquals(expResult, result);
    }

    @Test
    public void testMethodD3() {
        System.out.println("methodD");

        Method51 instance = new Method51();
        instance.setAccountNumber("67493647");
        boolean expResult = false;
        boolean result = instance.methodD(instance.getAccountNumberArray());
        assertEquals(expResult, result);
    }

    @Test
    public void testMethodD3variant1() {
        System.out.println("methodD");

        Method51 instance = new Method51();
        instance.setAccountNumber("0199100002");
        boolean expResult = true;
        boolean result = instance.methodD(instance.getAccountNumberArray());
        assertEquals(expResult, result);
    }

    @Test
    public void testMethodD3variant2() {
        System.out.println("methodD");

        Method51 instance = new Method51();
        instance.setAccountNumber("0199100004");
        boolean expResult = true;
        boolean result = instance.methodD(instance.getAccountNumberArray());
        assertEquals(expResult, result);
    }

    /**
     * Test of methodDvariant1 method, of class Method51.
     */
    @Test
    public void testMethodDvariant1() {
        System.out.println("methodDvariant1");

        Method51 instance = new Method51();
        instance.setAccountNumber("0199100002");
        boolean expResult = true;
        boolean result = instance.methodDvariant1(instance.getAccountNumberArray());
        assertEquals(expResult, result);

    }

    @Test
    public void testMethodDvariant11() {
        System.out.println("methodDvariant1");

        Method51 instance = new Method51();
        instance.setAccountNumber("0099100010");
        boolean expResult = true;
        boolean result = instance.methodDvariant1(instance.getAccountNumberArray());
        assertEquals(expResult, result);

    }

    @Test
    public void testMethodDvariant12() {
        System.out.println("methodDvariant1");

        Method51 instance = new Method51();
        instance.setAccountNumber("2599100002");
        boolean expResult = true;
        boolean result = instance.methodDvariant1(instance.getAccountNumberArray());
        assertEquals(expResult, result);

    }

    @Test
    public void testMethodDvariant13() {
        System.out.println("methodDvariant1");

        Method51 instance = new Method51();
        instance.setAccountNumber("0199100004");
        boolean expResult = false;
        boolean result = instance.methodDvariant1(instance.getAccountNumberArray());
        assertEquals(expResult, result);

    }

    @Test
    public void testMethodDvariant14() {
        System.out.println("methodDvariant1");

        Method51 instance = new Method51();
        instance.setAccountNumber("2599100003");
        boolean expResult = false;
        boolean result = instance.methodDvariant1(instance.getAccountNumberArray());
        assertEquals(expResult, result);

    }

    @Test
    public void testMethodDvariant15() {
        System.out.println("methodDvariant1");

        Method51 instance = new Method51();
        instance.setAccountNumber("0099345678");
        boolean expResult = false;
        boolean result = instance.methodDvariant1(instance.getAccountNumberArray());
        assertEquals(expResult, result);

    }

    /**
     * Test of methodDvariant2 method, of class Method51.
     * <p>
     * 1  2  3  4  5  6  7  8  9  10
     * 0  1  9  9  1  0  0  0  0  4
     * 10  9  8  7  6  5  4  3  2
     * --------------------------
     * 0  9+72+63+ 6  0  0  0  0 = 150
     * 150 % 11 = 7
     * 11 - 7 = 4
     */
    @Test
    public void testMethodDvariant2() {
        System.out.println("methodDvariant2");
        Method51 instance = new Method51();
        instance.setAccountNumber("0099100010");
        boolean expResult = true;
        boolean result = instance.methodDvariant2(instance.getAccountNumberArray());
        assertEquals(expResult, result);

    }

    @Test
    public void testMethodDvariant21() {
        System.out.println("methodDvariant2");
        Method51 instance = new Method51();
        instance.setAccountNumber("2599100003");
        boolean expResult = true;
        boolean result = instance.methodDvariant2(instance.getAccountNumberArray());
        assertEquals(expResult, result);

    }

    @Test
    public void testMethodDvariant22() {
        System.out.println("methodDvariant2");
        Method51 instance = new Method51();
        instance.setAccountNumber("3199204090");
        boolean expResult = true;
        boolean result = instance.methodDvariant2(instance.getAccountNumberArray());
        assertEquals(expResult, result);

    }

    /**
     * Test of add method, of class Method51.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int[] number = new int[]{1, 2, 1, 2, 1, 2, 1, 2};
        int start = 0;
        int end = 4;
        Method51 instance = new Method51();
        int expResult = 6;
        int result = instance.add(number, start, end);
        assertEquals(expResult, result);

    }

    /**
     * Test of modulus7 method, of class Method51.
     */
    @Test
    public void testModulus7() {
        System.out.println("modulus7");
        int pz = 15;
        Method51 instance = new Method51();
        int expResult = 6;
        int result = instance.modulus7(pz);
        assertEquals(expResult, result);

    }

    @Test
    public void testModulus1() {
        System.out.println("modulus7");
        int pz = 14;
        Method51 instance = new Method51();
        int expResult = 0;
        int result = instance.modulus7(pz);
        assertEquals(expResult, result);

    }


}
