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
public class ESERAltsystemsTest {
    
    public ESERAltsystemsTest() {
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
     * Test of setAccountNumber method, of class ESERAltsystems.
     */
    @Test
    public void testSetAccountNumber() {
        System.out.println("setAccountNumber");
        String accountNumber = "12345678";
        ESERAltsystems instance = new ESERAltsystems();
        instance.setAccountNumber(accountNumber);
        
    }

    /**
     * Test of setBankCode method, of class ESERAltsystems.
     */
    @Test
    public void testSetBankCode() {
        System.out.println("setBankCode");
        String bankCode = "12351234";
        ESERAltsystems instance = new ESERAltsystems();
        instance.setBankCode(bankCode);
       
    }

    /**
     * Test of getESERAltsystems method, of class ESERAltsystems.
     */
    @Test
    public void testGetESERAltsystems() {
        System.out.println("getESERAltsystems");
        ESERAltsystems instance = new ESERAltsystems();
        String expResult = "1172411500";
        instance.setAccountNumber("0041001500");
        instance.setBankCode("13051172");
        String result = instance.getESERAltsystems(ESERAltsystems.ACHT);
        assertEquals(expResult, result);
    }

    /**
     * Test of generateEserAccountNumber method, of class ESERAltsystems.
     */
    @Test
    public void testGenerateEserAccountNumber() {
        System.out.println("generateEserAccountNumber");
        ESERAltsystems instance = new ESERAltsystems();
        instance.setAccountNumber("0048726458");
        instance.setBankCode("13051172");
        long expResult = 117248726458L;
        long result = instance.generateEserAccountNumber();
        assertEquals(expResult, result);
        
    }
    
}
