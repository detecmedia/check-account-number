package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen A7.
 * <p>
 * <b>gültig seit 08.09.2003</b></p>
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2</p>
 * <p>
 * Die Kontonummer ist einschließlich der Prüfziffer 10-stellig, ggf. ist die
 * Kontonummer für die Prüfzifferberechnung durch linksbündige Auffüllung
 * mit Nullen 10-stellig darzustellen.</p>
 * <p>
 * Variante 1:</p>
 * <p>
 * Gewichtung und Berechnung erfolgen nach der Methode 00. Führt die Berechnung
 * nach Variante1 zu einem Prüfzifferfehler, ist nach Variante 2 zu
 * prüfen.</p>
 * <p>
 * Testkontonummern (richtig): 19010008,19010438<br>
 * Testkontonummern (falsch): 19010660, 19010876, 209010892, 209010893</p>
 * <p>
 * Variante 2:</p>
 * <p>
 * Gewichtung und Berechnung erfolgen nach der Methode 03.</p>
 * <p>
 * Testkontonummern (richtig): 19010660,19010876, 209010892<br>
 * Testkontonummer (falsch): 209010893</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodA7
        extends AbstractMethod {

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        if (variant1(number)) {
            return true;
        }
        this.getAccountNumberArray();
        return variant2(number);
    }

    /**
     * <p>
     * Variante 1:</p>
     * <p>
     * Gewichtung und Berechnung erfolgen nach der Methode 00. Führt die
     * Berechnung nach Variante1 zu einem Prüfzifferfehler, ist nach Variante 2
     * zu prüfen.</p>
     * <p>
     * Testkontonummern (richtig): 19010008,19010438<br>
     * Testkontonummern (falsch): 19010660, 19010876, 209010892, 209010893</p>
     *
     * @param number
     * @return
     */
    boolean variant1(int[] number) {
        Method00 m = new Method00();
        m.setAccountNumberArray(number);
        return m.test();

    }

    /**
     * Variante 2:</p>
     * <p>
     * Gewichtung und Berechnung erfolgen nach der Methode 03. </p>
     * <p>
     * Testkontonummern (richtig): 19010660,19010876, 209010892<br>
     * Testkontonummer (falsch): 209010893</p>
     *
     * @param number
     * @return
     */
    boolean variant2(int[] number) {
        Method03 m = new Method03();
        m.setAccountNumberArray(number);
        return m.test();
    }

}
