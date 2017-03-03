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
public class Method18Test {

    public Method18Test() {
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
     * Test of check method, of class Method18.
     *
     * Modulus 10, Gewichtung 3, 9, 7, 1, 3, 9, 7, 1, 3 </p><p>
     * Die Berechnung erfolgt wie bei Verfahren 01.</p>
     * 
     * <pre>
     * 1  2  3  4  5  6  7  8  9  P
     * 0  1  2  3  4  5  6  7  8  2
     * 3  1  7  9  3  1  7  9  3
     * -------------------------
     * 0 +1+14+27+12+ 5+42+63+24 = 188
     * 
     * 10 - 8 = 2
     * 
     * P = 2
     * </pre>
     *
     */
    @Test
    public void testTest() {
        System.out.println("check");
        Method18 instance = new Method18();
        instance.setAccountNumber("0123456782");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }

}
