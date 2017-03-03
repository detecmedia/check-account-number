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
public class Method05Test {
    
    public Method05Test() {
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
     * Test of check method, of class Methode05.
     */
    @Test
    public void testTest() {
       System.out.println("check");
        CheckAccountNumber instance = new Method05();
        boolean result;
        
        // check 9290701
        instance.setAccountNumber("1234561");
        result = instance.test();
        assertEquals(true, result);
        // check 9290701
        instance = new Method05();
        instance.setAccountNumber("34728138");
        result = instance.test();
        assertEquals(true, result);
        
        instance = new Method05();
        instance.setAccountNumber("56789870");
        result = instance.test();
        assertEquals(true, result);
        
        instance = new Method05();
        instance.setAccountNumber("123457");
        result = instance.test();
        assertEquals(false, result);
        
        instance = new Method05();
        instance.setAccountNumber("0009876542");
        result = instance.test();
        assertEquals(false, result);
    }
    
    
}
