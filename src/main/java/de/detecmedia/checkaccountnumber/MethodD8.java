package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen D8.
 * <p>
 * gültig seit 06.06.2011</p>
 * <p>
 * Die Kontonummer ist einschließlich der Prüfziffer 10-stellig, ggf. ist die
 * Kontonummer für die Prüfzifferberechnung durch linksbündige Auffüllung
 * mit Nullen 10-stellig darzustellen.</p>
 * <p>
 * Die Berechnung der Prüfziffer und die möglichen Ergebnisse richten sich
 * nach dem jeweils bei der entsprechenden Variante angegebenen
 * Kontonummernkreis. Entspricht eine Kontonummer keinem der vorgegebenen
 * Kontonummern- kreise oder führt die Berechnung der Prüfziffer nach der
 * Variante 1 zu einem Prüfzifferfehler, so ist die Kontonummer ungültig.</p>
 * <p>
 * Variante 1:</p>
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2</p>
 * <p>
 * Für Kontonummern aus dem Kontonummernkreis 1000000000 bis 9999999999
 * entsprechen die Berechnung und mögliche Ergebnisse der Methode 00.</p>
 * <pre>
 * Beispiel:
 * Kontonummer: 6899999954 Stellen 1 – 9: 689999995
 * </pre>
 * <p>
 * <pre>
 * Stelle-Nr.  1  2  3  4  5  6  7  8  9  10
 * Kontonummer 6  8  9  9  9  9  9  9  5  4
 * Gewichtung  2  1  2  1  2  1  2  1  2  P
 * -----------------------------------------
 * Produkt    12  8 18  9 18  9 18  9 10
 * Quersumme  3+  8+ 9+ 9+ 9+ 9+ 9+ 9+ 1
 * </pre>
 * <p>
 * <pre>
 * Summe = 66
 * 10 – 6 (Einerstelle) = 4 = Prüfziffer
 * Testkontonummern (richtig):  1403414848, 6800000439,
 *                              6899999954
 * Testkontonummern (falsch):   3012084101, 1062813622, 0000260986
 *
 * </pre>
 * <p>
 * Variante 2:</p>
 * <p>
 * Für den Kontonummernkreis 00 10000000 bis 0099999999 gilt die Methode 09
 * (keine Prüfzifferberechnung, alle Konto- nummern sind als richtig zu
 * werten).</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodD8
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
     * Variante 1. </p>
     * <p>
     * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2</p>
     * <p>
     * Für Kontonummern aus dem Kontonummernkreis 1000000000 bis 9999999999
     * entsprechen die Berechnung und mögliche Ergebnisse der Methode 00.</p>
     * <pre>
     * Beispiel:
     * Kontonummer: 6899999954 Stellen 1 – 9: 689999995
     * </pre>
     * <p>
     * <pre>
     * Stelle-Nr.  1  2  3  4  5  6  7  8  9  10
     * Kontonummer 6  8  9  9  9  9  9  9  5  4
     * Gewichtung  2  1  2  1  2  1  2  1  2  P
     * -----------------------------------------
     * Produkt    12  8 18  9 18  9 18  9 10
     * Quersumme  3+  8+ 9+ 9+ 9+ 9+ 9+ 9+ 1
     * </pre>
     * <p>
     * <pre>
     * Summe = 66
     * 10 – 6 (Einerstelle) = 4 = Prüfziffer
     * Testkontonummern (richtig):  1403414848, 6800000439,
     *                              6899999954
     * Testkontonummern (falsch):   3012084101, 1062813622, 0000260986
     *
     * </pre>
     *
     * @return
     */
    boolean variant1(int[] number) {
        Method00 m = new Method00();
        m.setAccountNumberArray(number);
        if (m.getLong() >= 1000000000L && m.getLong() <= 9999999999L) {
            weighting = new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2};
            return m.check(weighting);
        }
        return false;
    }

    /**
     * <p>
     * Variante 2:</p>
     * <p>
     * Für den Kontonummernkreis 00 10000000 bis 0099999999 gilt die Methode 09
     * (keine Prüfzifferberechnung, alle Konto- nummern sind als richtig zu
     * werten).</p>
     *
     * @param number
     * @return
     */
    boolean variant2(int[] number) {
        Method09 m = new Method09();
        m.setAccountNumberArray(number);
        if (m.getLong() >= 10000000 && m.getLong() <= 99999999) {
            return m.test();
        }
        return false;
    }

}
