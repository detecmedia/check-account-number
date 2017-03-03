package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen D9.
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
 * nach Variante 1 zu einem Prüfziffer- fehler, so ist nach Variante 2 zu
 * prüfen.</p>
 * <p>
 * Testkontonummern (richtig): 1234567897, 0123456782 Testkontonummern (falsch):
 * 9876543210, 1234567890, 6543217890, 0543216789</p>
 * <p>
 * Variante 2:</p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8, 9, 10 Gewichtung und Berechnung
 * erfolgen nach der Methode 10.</p>
 * <p>
 * Führt die Berechnung nach Variante 2 zu einem Prüfziffer- fehler, so ist
 * nach Variante 3 zu prüfen.</p>
 * <p>
 * Testkontonummern (richtig): 9876543210, 1234567890, 0123456789
 * Testkontonummern (falsch): 6543217890, 0543216789</p>
 * <p>
 * Variante 3:</p>
 * <p>
 * Modulus 10, Gewichtung 3, 9, 7, 1, 3, 9, 7, 1, 3</p>
 * <p>
 * Gewichtung und Berechnung erfolgen nach der Methode 18. Testkontonummern
 * (richtig): 1100132044, 1100669030 Testkontonummern (falsch): 1100789043,
 * 1100914032</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodD9
        extends AbstractMethod {

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        if(variant1(number.clone())) {
            return true;
        }
        if(variant2(number.clone())) {
            return true;
        }
        if(variant3(number.clone())) {
            return true;
        }
        return false;
    }

    /**
     * <p>
     * Variante 1. </p>
     * <p>
     * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2</p>
     * <p>
     * Gewichtung und Berechnung erfolgen nach der Methode 00. Führt die
     * Berechnung nach Variante 1 zu einem Prüfziffer- fehler, so ist nach
     * Variante 2 zu prüfen.</p>
     * <p>
     * Testkontonummern (richtig): 1234567897, 0123456782 Testkontonummern
     * (falsch): 9876543210, 1234567890, 6543217890, 0543216789</p>
     *
     * @return
     */
    boolean variant1(int[] number) {
        Method00 m = new Method00();
        m.setAccountNumberArray(number);
        weighting = new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2};
        return m.check(weighting);
    }

    /**
     * <p>
     * Variante 2. </p>
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8, 9, 10 Gewichtung und
     * Berechnung erfolgen nach der Methode 10.</p>
     * <p>
     * Führt die Berechnung nach Variante 2 zu einem Prüfziffer- fehler, so
     * ist nach Variante 3 zu prüfen.</p>
     * <p>
     * Testkontonummern (richtig): 9876543210, 1234567890, 0123456789
     * Testkontonummern (falsch): 6543217890, 0543216789</p>
     *
     * @param number
     * @return
     */
    boolean variant2(int[] number) {
        weighting = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10};
        Method10 m = new Method10();
        m.setAccountNumberArray(number);
        return m.check(weighting);
        
    }

    /**
     * <p>
     * Variante 3. </p>
     * <p>
     * Modulus 10, Gewichtung 3, 9, 7, 1, 3, 9, 7, 1, 3</p>
     * <p>
     * Gewichtung und Berechnung erfolgen nach der Methode 18. Testkontonummern
     * (richtig): 1100132044, 1100669030 Testkontonummern (falsch): 1100789043,
     * 1100914032</p>
     *
     * @return
     */
    boolean variant3(int[] number) {
        weighting = new int[]{3, 9, 7, 1, 3, 9, 7, 1, 3};
        Method18 m = new Method18();
        m.setAccountNumberArray(number);
        return m.check(weighting);
    }

}
