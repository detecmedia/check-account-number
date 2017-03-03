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
public class Method19Test {
    
    public Method19Test() {
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
     * Test of check method, of class Method19.
     * 0240334000
     */
    @Test
    public void testCheck0() {
        System.out.println("check");
        Method19 instance = new Method19();
        instance.setAccountNumber("0240334000");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        // TODO Test muss noch erstellt werden..
        
    }
    
    /**
     * Test of check method, of class Method19.
     * 0200520016
     */
    @Test
    public void testCheck1() {
        System.out.println("check");
        Method19 instance = new Method19();
        instance.setAccountNumber("0200520016");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        // TODO Test muss noch erstellt werden..
        
    }
    
     /**
     * Test of check method, of class Method19.
     * 0200520016
     */
    @Test
    public void testCheck2() {
        System.out.println("check");
        Method19 instance = new Method19();
        instance.setAccountNumber("0200520324");
        boolean expResult = false;
        boolean result = instance.test();
        assertEquals(expResult, result);
        // TODO Test muss noch erstellt werden..
        
    }

    /**
     * Test of test method, of class Method19.
     */
    @Test
    public void testTest() {
       System.out.println("check");
        Method19 instance = new Method19();
        instance.setAccountNumber("0240334000");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }
    
}
