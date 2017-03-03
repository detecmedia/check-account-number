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
 * @author Markus Potthast 
 */
public class Method06Test {
    
    public Method06Test() {
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
        CheckAccountNumber instance = new Method06();
        instance.setAccountNumber("94012341");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
                
        
    }

    /**
     * Test of check method, of class Method06.
     */
    @Test
    public void testCheck_0args() {
        System.out.println("check");
        Method06 instance = new Method06();
        instance.setAccountNumber("5073321010");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
    }

    /**
     * Test of check method, of class Method06.
     */
    @Test
    public void testCheck_intArr() {
        System.out.println("check");
        int[] weighting = new int[]{2, 3, 4, 5, 6, 7, 2, 3, 4, 5, 6, 7};
        Method06 instance = new Method06();
        instance.setAccountNumber("5073321010");
        boolean expResult = true;
        boolean result = instance.check(weighting);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of modulus11 method, of class Method06.
     */
    @Test
    public void testModulus11() {
        System.out.println("modulus11");
        int pz = 140;
        Method06 instance = new Method06();
        int expResult = 3;
        int result = instance.modulus11(pz);
        assertEquals(expResult, result);
      
    }

    /**
     * Test of add method, of class Method06.
     */
    @Test
    public void testAdd_intArr() {
        System.out.println("add");
        int[] number = {1,2,1,2,1,2,1,2,1,2};
        Method06 instance = new Method06();
        int expResult = 13;
        int result = instance.add(number);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of add method, of class Method06.
     */
    @Test
    public void testAdd_3args() {
        System.out.println("add");
        int[] number = {1,2,1,2,1,2,1,2,1,2};
        int start = 0;
        int end = 7;
        Method06 instance = new Method06();
        int expResult = 10;
        int result = instance.add(number, start, end);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of check method, of class Method06.
     */
    @Test
    public void testCheck() {
        System.out.println("check");
        int[] weighting = {2, 3, 4, 5, 6, 7};
        Method06 instance = new Method06();
        instance.setAccountNumber("5073321010");
        boolean expResult = true;
        boolean result = instance.check(weighting);
        assertEquals(expResult, result);
        
        
    }

    /**
     * Test of getFlag method, of class Method06.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method06 instance = new Method06();
        char[] expResult = "06".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);
       
    }
    
}
