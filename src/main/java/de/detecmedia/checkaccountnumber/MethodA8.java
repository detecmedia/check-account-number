package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen A8.
 * <p>
 * <b>gültig seit 08.09.2003</b></p>
 * <p>
 * <b>zuletzt geändert zum 07.03.2005</b></p>
 * <p>
 * Die Kontonummer ist durch linksbündige Nullenauffüllung 10- stellig
 * darzustellen. Die 10. Stelle ist per Definition die Prüfziffer.</p>
 * <p>
 * Variante 1:</p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7</p>
 * <p>
 * Die Stellen 4 bis 9 der Kontonummer werden von rechts nach links mit den
 * Ziffern 2, 3, 4, 5, 6, 7 multipliziert. Die weitere Berechnung und die
 * möglichen Ergebnisse entsprechen dem Verfahren 06. Führt die Berechnung
 * nach Variante 1 zu einem Prüfzifferfehler, so sind die Konten nach Variante
 * 2 zu prüfen.</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   x x x x x x x x x P
 * Gewichtung:       7 6 5 4 3 2
 * </pre>
 * <p>
 * Testkontonummern (richtig): 7436661, 7436670, 1359100 Testkontonummern
 * (falsch): 7436660, 7436678</p>
 * <p>
 * Variante 2:</p>
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1</p>
 * <p>
 * Die Stellen 4 bis 9 der Kontonummer werden von rechts nach links mit den
 * Ziffern 2, 1, 2, 1, 2, 1 multipliziert. Die weiter Berechnung und die
 * möglichen Ergebnisse entsprechen dem Verfahren 00.</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   x x x x x x x x x P
 * Gewichtung:       1 2 1 2 1 2
 * </pre>
 * <p>
 * Testkontonummern (richtig): 7436660, 7436678, 0003503398, 0001340967</p>
 * <p>
 * Testkontonummern (falsch): 7436666, 7436677, 0003503391, 0001340966</p>
 * <p>
 * Ausnahme:<br>
 * Ist nach linksbündiger Auffüllung mit Nullen auf 10 Stellen die 3. Stelle
 * der Kontonummer = 9 (Sachkonten), so erfolgt die Berechnung gemäß der
 * Ausnahme in Methode 51 mit den gleichen Ergebnissen und Testkontonummern.</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodA8
        extends AbstractMethod {

    private int[] weighting;

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        number = expand(number);
        if (variant1(number)) {
            return true;
        }
        number = this.getAccountNumberArray();
        if (variant2(number)) {
            return true;
        }
        number = this.getAccountNumberArray();
        if (exception(number)) {
            return true;
        }
        return false;
    }

    /**
     * <p>
     * Variante 1:</p>
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7</p>
     * <p>
     * Die Stellen 4 bis 9 der Kontonummer werden von rechts nach links mit den
     * Ziffern 2, 3, 4, 5, 6, 7 multipliziert. Die weitere Berechnung und die
     * möglichen Ergebnisse entsprechen dem Verfahren 06. Führt die Berechnung
     * nach Variante 1 zu einem Prüfzifferfehler, so sind die Konten nach
     * Variante 2 zu prüfen.</p>
     * <pre>
     * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
     * Kontonr.:   x x x x x x x x x P
     * Gewichtung:       7 6 5 4 3 2
     * </pre>
     * <p>
     * Testkontonummern (richtig): 7436661, 7436670, 1359100 <br>
     * Testkontonummern (falsch): 7436660, 7436678</p>
     *
     * @param number
     * @return
     */
    boolean variant1(int[] number) {
        weighting = new int[]{2, 3, 4, 5, 6, 7, 0, 0, 0};
        Method06 m = new Method06();
        m.setAccountNumberArray(number);
        return m.check(weighting);

    }

    /**
     * <p>
     * Variante 2:</p>
     * <p>
     * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1</p>
     * <p>
     * Die Stellen 4 bis 9 der Kontonummer werden von rechts nach links mit den
     * Ziffern 2, 1, 2, 1, 2, 1 multipliziert. Die weiter Berechnung und die
     * möglichen Ergebnisse entsprechen dem Verfahren 00.</p>
     * <pre>
     * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
     * Kontonr.:   x x x x x x x x x P
     * Gewichtung:       1 2 1 2 1 2
     * </pre>
     * <p>
     * Testkontonummern (richtig): 7436660, 7436678, 0003503398, 0001340967</p>
     * <p>
     * Testkontonummern (falsch): 7436666, 7436677, 0003503391, 0001340966</p>
     *
     * @param number
     * @return
     */
    boolean variant2(int[] number) {
        Method00 m = new Method00();
        m.setAccountNumberArray(number);
        return m.check(new int[]{2, 1, 2, 1, 2, 1, 0, 0, 0});
    }

    /**
     * <p>
     * Ausnahme:<br>
     * Ist nach linksbündiger Auffüllung mit Nullen auf 10 Stellen die 3.
     * Stelle der Kontonummer = 9 (Sachkonten), so erfolgt die Berechnung gemäß
     * der Ausnahme in Methode 51 mit den gleichen Ergebnissen und
     * Testkontonummern.</p>
     *
     * @param number
     * @return
     */
    boolean exception(int[] number) {
        Method51 m = new Method51();
        m.setAccountNumberArray(number);
        return m.test();
    }
}
