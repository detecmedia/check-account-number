package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen D0.
 * <p>
 * Die Kontonummer ist einschließlich der Prüfziffer 10-stellig, ggf. ist die
 * Kontonummer für die Prüfzifferberechnung durch linksbündige Auffüllung
 * mit Nullen 10-stellig darzustellen.</p>
 * <p>
 * Kontonummern, die an der 1. und 2. Stelle der 10-stelligen Kontonummer einen
 * Wert ungleich „57“ beinhalten, sind nach der Variante 1 zu prüfen.
 * Kontonummern, die an der 1. und 2. Stelle der 10-stelligen Kontonummer den
 * Wert „57“ beinhalten, sind nach der Variante 2 zu prüfen.</p>
 * <p>
 * Variante 1:</p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8, 9, 3 (modifiziert)</p>
 * <p>
 * Die Berechnung und mögliche Ergebnisse entsprechen der Methode 20. Führt
 * die Berechnung nach der Variante 1 zu einem Prüfzifferfehler, so ist die
 * Kontonummer falsch.</p>
 * <p>
 * Testkontonummern (richtig): 6100272324, 6100273479<br>
 * Testkontonummern (falsch): 6100272885, 6100273377, 6100274012</p>
 * <p>
 * Variante 2:</p>
 * <p>
 * Für den Kontonummernkreis 5700000000 bis 5799999999 gilt die Methode 09
 * (keine Prüfzifferberechnung, alle Kontonummern sind als richtig zu
 * werten).</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodD0
        extends AbstractMethod {

    private int[] weighting;

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
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
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8, 9, 3 (modifiziert)</p>
     * <p>
     * Die Berechnung und mögliche Ergebnisse entsprechen der Methode 20. Führt
     * die Berechnung nach der Variante 1 zu einem Prüfzifferfehler, so ist die
     * Kontonummer falsch.</p>
     * <p>
     * Testkontonummern (richtig): 6100272324, 6100273479<br>
     * Testkontonummern (falsch): 6100272885, 6100273377, 6100274012</p>
     *
     * @return
     */
    boolean variant1(int[] number) {
        weighting = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 3};
        Method20 m = new Method20();
        m.setAccountNumberArray(number);
        return m.check(weighting);

    }

    /**
     * <p>
     * Variante 2:</p>
     * <p>
     * Für den Kontonummernkreis 5700000000 bis 5799999999 gilt die Methode 09
     * (keine Prüfzifferberechnung, alle Kontonummern sind als richtig zu
     * werten).</p>
     *
     * @param number
     * @return
     */
    boolean variant2(int[] number) {
        Method09 m = new Method09();
        number = expand(number);
        m.setAccountNumberArray(number);
        long numberLong = m.getLong();
        if (numberLong >= 5700000000L && numberLong <= 5799999999L) {
            return m.test();
        }
        return false;

    }

}
