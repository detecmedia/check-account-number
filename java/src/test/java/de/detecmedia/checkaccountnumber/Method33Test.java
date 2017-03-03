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
public class Method33Test {
    
    public Method33Test() {
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
     * Test of check method, of class Method33.
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method33 instance = new Method33();
        boolean expResult = true;
        instance.setAccountNumber("48658");
        boolean result = instance.test();
        assertEquals(expResult, result);
       
    }
    
    @Test
    public void testCheck1() {
        System.out.println("check");
        Method33 instance = new Method33();
        boolean expResult = true;
        instance.setAccountNumber("084956");
        boolean result = instance.test();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of check method, of class Method33.
     */
    @Test
    public void testCheck() {
        System.out.println("check");
        int[] weighting = {2, 3, 4, 5, 6};
        Method33 instance = new Method33();
        boolean expResult = true;
        instance.setAccountNumber("084956");
        boolean result = instance.check(weighting);
        assertEquals(expResult, result);

    }
    
}
