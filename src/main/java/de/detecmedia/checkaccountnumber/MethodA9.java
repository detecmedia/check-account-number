package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen A9.
 * <p>
 * <b>gültig seit 08.03.2004</b></p>
 * <p>
 * Die Kontonummer ist einschließlich der Prüfziffer 10-stellig, ggf. ist die
 * Kontonummer für die Prüfzifferberechnung durch linksbündige Auffüllung
 * mit Nullen 10-stellig darzustellen.</p>
 * <p>
 * Variante 1:</p>
 * <p>
 * Modulus 10, Gewichtung 3, 7, 1, 3, 7, 1, 3, 7, 1</p>
 * <p>
 * Gewichtung und Berechnung erfolgen nach der Methode 01. Führt die Berechnung
 * nach Variante1 zu einem Prüfzifferfehler, so ist nach Variante 2 zu
 * prüfen.</p>
 * <p>
 * Testkontonummern (richtig): 5043608, 86725</p>
 * <p>
 * Testkontonummern (falsch): 504360, 822035, 32577083, 86724</p>
 * <p>
 * Variante 2:</p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 2, 3, 4</p>
 * <p>
 * Gewichtung und Berechnung erfolgen nach der Methode 06.</p>
 * <p>
 * Testkontonummern (richtig): 504360, 822035, 32577083 Testkontonummern
 * (falsch): 86724, 292497, 30767208</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodA9
        extends AbstractMethod {

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        number = expand(number);
        if (variant1(number.clone())) {
            return true;
        }
        return variant2(number.clone());
    }

    /**
     * <p>
     * Variante 1:</p>
     * <p>
     * Modulus 10, Gewichtung 3, 7, 1, 3, 7, 1, 3, 7, 1</p>
     * <p>
     * Gewichtung und Berechnung erfolgen nach der Methode 01. Führt die Berechnung
     * nach Variante1 zu einem Prüfzifferfehler, so ist nach Variante 2 zu
     * prüfen.</p>
     * <p>
     * Testkontonummern (richtig): 5043608, 86725</p>
     * <p>
     * Testkontonummern (falsch): 504360, 822035, 32577083, 86724</p>
     *
     * @return
     */
    boolean variant1(int[] number) {
        Method01 m = new Method01();
        m.setAccountNumberArray(number);
        return m.test();
    }

    /**
     * <p>
     * Variante 2:</p>
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 2, 3, 4</p>
     * <p>
     * Gewichtung und Berechnung erfolgen nach der Methode 06.</p>
     * <p>
     * Testkontonummern (richtig): 504360, 822035, 32577083 Testkontonummern
     * (falsch): 86724, 292497, 30767208</p>
     *
     * @return
     */
    boolean variant2(int[] number) {
        Method06 m = new Method06();
        m.setAccountNumberArray(number);
        return m.test();
    }

}
