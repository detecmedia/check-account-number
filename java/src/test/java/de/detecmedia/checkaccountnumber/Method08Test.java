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
public class Method08Test {
    
    public Method08Test() {
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
     * Test of check method, of class Methode00.
     */
    @org.junit.Test
    public void testTest() {
        System.out.println("check");
        CheckAccountNumber instance = new Method08();
        boolean result;
        
        instance.setAccountNumber("59999");
        result = instance.test();
        assertEquals(false, result);
        
        // check 9290701
        instance = new Method08();
        instance.setAccountNumber("0001501824");
        result = instance.test();
        assertEquals(true, result);
        // check 9290701
        instance = new Method08();
        instance.setAccountNumber("539290858");
        result = instance.test();
        assertEquals(true, result);
        
        instance = new Method08();
        instance.setAccountNumber("1501824");
        result = instance.test();
        assertEquals(true, result);
        
        instance = new Method08();
        instance.setAccountNumber("1501832");
        result = instance.test();
        assertEquals(true, result);
        
        instance = new Method08();
        instance.setAccountNumber("123456");
        result = instance.test();
        assertEquals(false, result);
        
        instance = new Method08();
        instance.setAccountNumber("0009876542");
        result = instance.test();
        assertEquals(false, result);
        
        
        
    }
    
}
