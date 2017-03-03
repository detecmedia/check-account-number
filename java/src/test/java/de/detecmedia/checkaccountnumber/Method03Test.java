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
public class Method03Test {
    
    public Method03Test() {
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
     * Test of check method, of class Methode03.
     */
    @Test
    public void testTest() {
       System.out.println("check");
        CheckAccountNumber instance = new Method03();
        boolean result;
        
        // check 9290701
        instance.setAccountNumber("1234567");
        result = instance.test();
        assertEquals(true, result);
        // check 9290701
        instance = new Method03();
        instance.setAccountNumber("34728131");
        result = instance.test();
        assertEquals(true, result);
        
        instance = new Method03();
        instance.setAccountNumber("56789872");
        result = instance.test();
        assertEquals(true, result);
        
        instance = new Method03();
        instance.setAccountNumber("123457");
        result = instance.test();
        assertEquals(false, result);

        instance = new Method03();
        instance.setAccountNumber("0009876542");
        result = instance.test();
        assertEquals(false, result);
    }

    /**
     * Test of getFlag method, of class Method03.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method03 instance = new Method03();
        char[] expResult = "03".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }
    
}
