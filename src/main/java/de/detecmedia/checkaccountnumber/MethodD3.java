package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen D3.
 * <p>
 * gültig seit 08.12.2008</p>
 * <p>
 * Die Kontonummer ist einschließlich der Prüfziffer 10-stellig, ggf. ist die
 * Kontonummer für die Prüfzifferberechnung durch linksbündige Auffüllung
 * mit Nullen 10-stellig darzustellen.</p>
 * <p>
 * Variante 1:</p>
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2</p>
 * <p>
 * Gewichtung und Berechnung erfolgen nach der Methode 00. Führt die Berechnung
 * nach Variante 1 zu einem Prüfzifferfehler, so ist nach Variante 2 zu
 * prüfen.</p>
 * <p>
 * Testkontonummern (richtig): 1600169591, 1600189151, 1800084079<br>
 * Testkontonummern (falsch): 1600166307, 1600176485, 1600201934</p>
 * <p>
 * Variante 2:</p>
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2 (modifiziert) Gewichtung und
 * Berechnung erfolgen nach der Methode 27.</p>
 * <p>
 * Testkontonummer (richtig): 6019937007, 6021354007, 6030642006<br>
 * Testkontonummer (falsch) : 6025017009, 6028267003, 6019835001</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodD3
        extends AbstractMethod {

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        number = expand(number);
        if (variant1(number.clone())) {
            return true;
        }
        if (variant2(number.clone())) {
            return true;
        }
        return false;
    }

    /**
     * <p>
     * Variante 1:</p>
     * <p>
     * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2</p>
     * <p>
     * Gewichtung und Berechnung erfolgen nach der Methode 00. Führt die
     * Berechnung nach Variante 1 zu einem Prüfzifferfehler, so ist nach
     * Variante 2 zu prüfen.</p>
     * <p>
     * Testkontonummern (richtig): 1600169591, 1600189151, 1800084079<br>
     * Testkontonummern (falsch): 1600166307, 1600176485, 1600201934</p>
     *
     * @return
     */
    boolean variant1(int[] number) {
        Method00 m = new Method00();
        m.setAccountNumberArray(number);
        return m.test();
    }

    /**
     * <p>
     * Variante 2:</p>
     * <p>
     * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2 (modifiziert) Gewichtung
     * und Berechnung erfolgen nach der Methode 27.</p>
     * <p>
     * Testkontonummer (richtig): 6019937007, 6021354007, 6030642006<br>
     * Testkontonummer (falsch) : 6025017009, 6028267003, 6019835001</p>
     *
     * @param number
     * @return
     */
    boolean variant2(int[] number) {
        Method27 m = new Method27();
        m.setAccountNumberArray(number);
        return m.test();
    }

}
