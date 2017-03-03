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
public class Method56Test {
    
    public Method56Test() {
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
     * Test of check method, of class Method56.
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method56 instance = new Method56();
        instance.setAccountNumber("0290545005");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }
    /**
     * Test of check method, of class Method56.
     */
    @Test
    public void testCheck1() {
        System.out.println("check");
        Method56 instance = new Method56();
        instance.setAccountNumber("9718304037");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getFlag method, of class Method56.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method56 instance = new Method56();
        char[] expResult = "56".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);
       
    }

    /**
     * Test of checkBeginWhith9 method, of class Method56.
     */
    @Test
    public void testCheckBeginWhith9() {
        System.out.println("checkBeginWhith9");
       
        Method56 instance = new Method56();
        instance.setAccountNumber("9718304037");
        boolean expResult = true;
        boolean result = instance.checkBeginWhith9(instance.getAccountNumberArray());
        assertEquals(expResult, result);
      
    }


    /**
     * Test of add method, of class Method56.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int[] number = {1,1,1,1,1,1,1};
        int start = 0;
        int end = 7;
        Method56 instance = new Method56();
        int expResult = 7;
        int result = instance.add(number, start, end);
        assertEquals(expResult, result);
    }
}
