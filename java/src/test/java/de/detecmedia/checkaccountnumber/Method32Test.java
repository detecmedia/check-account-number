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
 *
 * @author Markus Potthast <mpt@detecmedia.de>
 */
public class Method32Test {

    public Method32Test() {
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
     * Test of check method, of class Method32. 9141405, 1709107983, 0122116979,
     * 0121114867, 9030101192, 9245500460
     * 
     * 
     * <pre>
     * 1  2  3  4  5  6  7  8  9  P
     * 0  0  0  9  1  4  1  4  0  5
     * </pre>
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method32 instance = new Method32();
        instance.setAccountNumber("0009141405");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }
    /**
     * <pre>
     * 1  2  3  4  5  6  7  8  9  P
     * 1  7  0  9  1  0  7  9  8  3
     *          7  6  5  4  3  2
     * -------------------------
     *         63+ 6+ 0+28+27+16 = 140
     * 140 % 11 = 8
     * 11 - 8 = 3
     * 
     * P = 3
     * </pre>
     */
    @Test
    public void testCheck1() {
        System.out.println("check");
        Method32 instance = new Method32();
        instance.setAccountNumber("1709107983");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }
    @Test
    public void testCheck2() {
        System.out.println("check");
        Method32 instance = new Method32();
        instance.setAccountNumber("0122116979");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }
    @Test
    public void testCheck3() {
        System.out.println("check");
        Method32 instance = new Method32();
        instance.setAccountNumber("0121114867");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }
    @Test
    public void testCheck4() {
        System.out.println("check");
        Method32 instance = new Method32();
        instance.setAccountNumber("9030101192");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }
    @Test
    public void testCheck5() {
        System.out.println("check");
        Method32 instance = new Method32();
        instance.setAccountNumber("9245500460");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }

    

}
