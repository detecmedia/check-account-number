package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen A2.
 * <p>
 * <b>gültig seit 09.06.2003</b></p>
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
 * nach Variante1 zu einem Prüfzifferfehler, so ist nach Variante 2 zu
 * prüfen.</p>
 * <p>
 * Testkontonummern (richtig): 3456789019, 5678901231, 6789012348<br>
 * Testkontonummern (falsch): 3456789012, 1234567890</p>
 * <p>
 * Variante 2:</p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 2, 3, 4</p>
 * <p>
 * Gewichtung und Berechnung erfolgen nach der Methode 04.</p>
 * <p>
 * Testkontonummer (richtig): 3456789012 <br>
 * Testkontonummern (falsch) 1234567890, 0123456789</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodA2
        extends AbstractMethod {

    @Override
    public boolean test() {
        int[] number = expand(this.getAccountNumberArray());
        if (variant1(number)) {
            return true;
        }
        number = expand(this.getAccountNumberArray());
        return variant2(number);
    }

    /**
     * <p>
     * Variante 1:</p>
     * <p>
     * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2</p>
     * <p>
     * Gewichtung und Berechnung erfolgen nach der Methode 00. Führt die
     * Berechnung nach Variante1 zu einem Prüfzifferfehler, so ist nach
     * Variante 2 zu prüfen.</p>
     * <p>
     * Testkontonummern (richtig): 3456789019, 5678901231, 6789012348<br>
     * Testkontonummern (falsch): 3456789012, 1234567890</p>
     *
     * @param number
     * @return
     */
    boolean variant1(int number[]) {
        weighting = new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2};
        Method00 method00 = new Method00();
        method00.setAccountNumberArray(number);
        return method00.check(weighting);

    }

    /**
     * <p>
     * Variante 2:</p>
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 2, 3, 4</p>
     * <p>
     * Gewichtung und Berechnung erfolgen nach der Methode 04.</p>
     * <p>
     * Testkontonummer (richtig): 3456789012 <br>
     * Testkontonummern (falsch) 1234567890, 0123456789</p>
     *
     * @param number
     * @return
     */
    boolean variant2(int number[]) {
        weighting = new int[]{2, 3, 4, 5, 6, 7, 2, 3, 4};
        Method04 method04 = new Method04();
        method04.setAccountNumberArray(number);
        return method04.check(weighting);

    }

}
