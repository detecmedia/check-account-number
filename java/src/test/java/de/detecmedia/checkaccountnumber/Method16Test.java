package de.detecmedia.checkaccountnumber;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 Kennzeichen 16.
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7 (modifiziert)</p>
 * <p>
 * Die einzelnen Stellen der Kontonummer sind von rechts nach links mit den
 * Ziffern 2, 3, 4, 5, 6, 7, 2, 3 ff. zu multiplizieren. Die jeweiligen Produkte
 * werden addiert. Die Summe ist durch 11 zu dividieren. Der verbleibende Rest
 * wird vom Divisor (11) subtrahiert. Das Ergebnis ist die Prüfziffer. Ergibt
 * sich als Rest 1, findet von dem Rechenergebnis 10 nur die Einerstelle (0) als
 * Prüfziffer Verwendung. Verbleibt nach der Division durch 11 kein Rest, dann
 * ist auch die Prüfziffer 0. Die Stelle 10 der Kontonummer ist die
 * Prüfziffer.</p>
 * <p>
 * Testkontonummern: 94012341, 5073321010</p>
 *
 * Kennzeichen 16.
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 2, 3, 4 </p><p>
 * Die Berechnung erfolgt wie bei Verfahren06. Sollte sich jedoch nach der
 * Division der Rest 1 ergeben, so ist die Kontonummer unabhängig vom
 * eigentlichen Berechnungs- ergebnis richtig, wenn die Ziffern an 10. und 9.
 * Stelle identisch sind.</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method16Test {
    
    public Method16Test() {
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
     * Test of check method, of class Method16.
     */
    @Test
    public void testCheck1() {
        System.out.println("check");
        Method16 instance = new Method16();
        instance.setAccountNumber("0094012341");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of check method, of class Method16.
     */
    @Test
    public void testCheck2() {
        System.out.println("check");
        Method16 instance = new Method16();
        instance.setAccountNumber("5073321010");
        boolean expResult = false;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of check method, of class Method16.
     * 1  2  3  4  5  6  7  8  9  10
     * 
     * 5073321011
     * 
     */
    @Test
    public void testCheck3() {
        System.out.println("check");
        Method16 instance = new Method16();
        instance.setAccountNumber("5073321011");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of test method, of class Method16.
     */
    @Test
    public void testTest() {
         System.out.println("check");
        Method16 instance = new Method16();
        instance.setAccountNumber("0094012341");
        boolean expResult = true;
        boolean result = instance.test();
        assertEquals(expResult, result);
    }

    /**
     * Test of check method, of class Method16.
     */
    @Test
    public void testCheck() {
        System.out.println("check");
        int[] weighting = new int[]{2, 3, 4, 5, 6, 7, 2, 3, 4};
        Method16 instance = new Method16();
        instance.setAccountNumber("5073321011");
        boolean expResult = true;
        boolean result = instance.check(weighting);
        assertEquals(expResult, result);

    }

    /**
     * Test of modulus11 method, of class Method16.
     */
    @Test
    public void testModulus11() {
        System.out.println("modulus11");
        int pz = 11;
        Method16 instance = new Method16();
        int expResult = 0;
        int result = instance.modulus11(pz);
        assertEquals(expResult, result);
        
    }
    
    
}
