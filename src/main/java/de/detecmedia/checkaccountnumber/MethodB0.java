package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.exception.AccountNumberLenghtException;

/**
 * Kennzeichen B0.
 * <p>
 * (0=Null)</p>
 * <p>
 * gültig seit 06.12.2004</p>
 * <p>
 * Die Kontonummern sind immer 10-stellig. Kontonummern (ohne führende Nullen
 * gezählt) mit 9 oder weniger Stellen sind falsch. Kontonummern mit 8 an der
 * ersten Stelle sind ebenfalls falsch. Die weitere Verfahrensweise richtet sich
 * nach der 8. Stelle der Kontonummer:</p>
 * <p>
 * Variante 1</p>
 * <p>
 * Für Kontonummern mit einer 1, 2, 3, oder 6 an der 8. Stelle gilt das
 * Verfahren 09 (Keine Prüfzifferberechnung, alle Kontonummern sind
 * richtig).</p>
 * <p>
 * Testkontonummern (richtig): 1197423162, 1000000606</p>
 * <p>
 * Testkontonummern (falsch): 8137423260, 600000606, 51234309</p>
 * <p>
 * Variante 2</p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 2, 3, 4 (von rechts beginnend)</p>
 * <p>
 * Für Kontonummern mit einer 0, 4, 5, 7, 8 oder 9 an der 8.Stelle erfolgen
 * Gewichtung und Berechnung wie beim Verfahren 06.</p>
 * <pre>
 * Beispiel:
 * Stelle: 1 2 3 4 5 6 7 8 9 10
 * Kontonr.: 1024391910
 * Gewichtung: 4 3 2 7 6 5 4 3 2 P
 * Produkt: 4+ 0+ 4+ 28+18+45+4+27+ 2 =132
 * 132: 11=  *
 * 12, Rest 0 = P
 * </pre>
 * <p>
 * Testkontonummern (richtig):1000000406, 1035791538, 1126939724, 1197423460</p>
 * <p>
 * Testkontonummern (falsch):1000000405, 1035791539, 8035791532, 535791830,
 * 51234901</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodB0
        extends AbstractMethod {

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        if (String.valueOf(this.getLong()).length() < 10) {
            throw new AccountNumberLenghtException();
        }
        if (number[0] == 8) {
            return false;
        }
        if (variant1(number.clone())) {
            return true;
        }
        return variant2(number.clone());
    }

    /**
     * <p>
     * Variante 1</p>
     * <p>
     * Für Kontonummern mit einer 1, 2, 3, oder 6 an der 8. Stelle gilt das
     * Verfahren 09 (Keine Prüfzifferberechnung, alle Kontonummern sind
     * richtig).</p>
     * <p>
     * Testkontonummern (richtig): 1197423162, 1000000606</p>
     * <p>
     * Testkontonummern (falsch): 8137423260, 600000606, 51234309</p>
     *
     * @param number
     * @return
     */
    boolean variant1(int[] number) {
        if (number[7] == 1 ||
                number[7] == 2 ||
                number[7] == 3 ||
                number[7] == 6) {
            Method09 method09 = new Method09();
            method09.setAccountNumberArray(number);
            return method09.test();
        }
        return false;
    }

    /**
     * <p>
     * Variante 2. </p>
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 2, 3, 4 (von rechts
     * beginnend)</p>
     * <p>
     * Für Kontonummern mit einer 0, 4, 5, 7, 8 oder 9 an der 8.Stelle erfolgen
     * Gewichtung und Berechnung wie beim Verfahren 06.</p>
     * <pre>
     * Beispiel:
     * Stelle:      1  2  3  4  5  6  7  8  9 10
     * Kontonr.:    1  0  2  4  3  9  1  9  1  0
     * Gewichtung:  4  3  2  7  6  5  4  3  2  P
     * ------------------------------------------
     * Produkt:     4+ 0+ 4+28+18+45+ 4+27+ 2 =132
     * 132: 11=  *
     * 12, Rest 0 = P
     * </pre>
     * <p>
     * Testkontonummern (richtig):1000000406, 1035791538, 1126939724,
     * 1197423460</p>
     * <p>
     * Testkontonummern (falsch):1000000405, 1035791539, 8035791532, 535791830,
     * 51234901</p>
     *
     * @param number
     * @return
     */
    boolean variant2(int[] number) {
        weighting = new int[]{2, 3, 4, 5, 6, 7, 2, 3, 4};
        Method06 m = new Method06();
        m.setAccountNumberArray(number);
        return m.check(weighting);

    }

}
