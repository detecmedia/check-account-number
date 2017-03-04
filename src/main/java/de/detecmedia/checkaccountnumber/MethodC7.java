package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen C7.
 * <p>
 * gültig seit 03.12.2007</p>
 * <p>
 * Die Kontonummer ist einschließlich der Prüfziffer 10-stellig, ggf. ist die
 * Kontonummer für die Prüfzifferberechnung durch linksbündige Auffüllung
 * mit Nullen 10-stellig darzustellen.</p>
 * <p>
 * Variante 1:</p>
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1</p>
 * <p>
 * Die Berechnung und mögliche Ergebnisse entsprechen der Methode 63. Führt
 * die Berechnung nach Variante 1 zu einem Prüfzifferfehler, so ist nach
 * Variante 2 zu prüfen.</p>
 * <p>
 * Testkontonummern (richtig): 3500022, 38150900, 600103660, 39101181<br>
 * Testkontonummern (falsch): 94012341, 5073321010</p>
 * <p>
 * Variante 2:</p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7 (modifiziert)</p>
 * <p>
 * Die Berechnung und mögliche Ergebnisse entsprechen der Methode 06.</p>
 * <p>
 * Testkontonummern (richtig): 94012341, 5073321010 <br>
 * Testkontonummern (falsch): 1234517892, 987614325</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodC7
        extends AbstractMethod {

    private int[] weighting;

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
     * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1</p>
     * <p>
     * Die Berechnung und mögliche Ergebnisse entsprechen der Methode 63.
     * Führt die Berechnung nach Variante 1 zu einem Prüfzifferfehler, so ist
     * nach Variante 2 zu prüfen.</p>
     * <p>
     * Testkontonummern (richtig): 3500022, 38150900, 600103660, 39101181<br>
     * Testkontonummern (falsch): 94012341, 5073321010</p>
     *
     * @return
     */
    boolean variant1(int[] number) {
        Method63 m = new Method63();
        m.setAccountNumberArray(number);
        return m.test();
    }

    /**
     * <p>
     * Variante 2:</p>
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7 (modifiziert)</p>
     * <p>
     * Die Berechnung und mögliche Ergebnisse entsprechen der Methode 06.</p>
     * <p>
     * Testkontonummern (richtig): 94012341, 5073321010 <br>
     * Testkontonummern (falsch): 1234517892, 987614325</p>
     *
     * @param number
     * @return
     */
    boolean variant2(int[] number) {
        number = expand(number);
        Method06 m = new Method06();
        weighting = new int[]{2, 3, 4, 5, 6, 7, 2, 3, 4, 5, 6, 7};
        m.setAccountNumberArray(number);
        return m.check(weighting);
    }

}
