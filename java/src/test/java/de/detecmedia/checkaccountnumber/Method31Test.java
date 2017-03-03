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
public class Method31Test {
    
    public Method31Test() {
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
     * Test of check method, of class Method31.
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method31 instance = new Method31();
        instance.setAccountNumber("1000000524");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testCheck1() {
        System.out.println("check");
        Method31 instance = new Method31();
        instance.setAccountNumber("1000000583");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of add method, of class Method31.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        int[] number = {1,2,3,4};
        Method31 instance = new Method31();
        int expResult = 6;
        int result = instance.add(number);
        assertEquals(expResult, result);
      
    }

    /**
     * Test of getFlag method, of class Method31.
     */
    @Test
    public void testGetFlag() {
        System.out.println("getFlag");
        Method31 instance = new Method31();
        char[] expResult = "31".toCharArray();
        char[] result = instance.getFlag();
        assertArrayEquals(expResult, result);

    }
    
}
