package de.detecmedia.checkaccountnumber;

import org.apache.log4j.Logger;

/**
 * Kennzeichen 86.
 * <p>
 * <b>geändert zum 06.09.2004</b></p>
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1</p>
 * <p>
 * Methode A</p>
 * <p>
 * Die Kontonummer ist durch linksbündige Nullenauffüllung 10- stellig
 * darzustellen. Die Berechnung und die möglichen Ergebnisse entsprechen dem
 * Verfahren 00; es ist jedoch zu beachten, dass nur die Stellen 4 bis 9 in das
 * Prüfzifferberechnungsverfahren einbezogen werden. Die Stelle 10 der
 * Kontonummer ist die Prüfziffer.</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   x x x x x x x x x P
 * Gewichtung:       1 2 1 2 1 2
 * </pre>
 * <p>
 * Testkontonummern: 340968, 1001171, 1009588</p>
 * <p>
 * Führt die Berechnung nach Methode A zu einem Prüfziffer- fehler, so ist die
 * Berechnung nach Methode B vorzunehmen.</p>
 * <p>
 * Methode B</p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7</p>
 * <p>
 * Die Kontonummer ist durch linksbündige Nullenauffüllung 10- stellig
 * darzustellen. Die Stellen 4 bis 9 der Kontonummer werden von rechts nach
 * links mit den Ziffern 2, 3, 4, 5, 6, 7 multipliziert. Die weitere Berechnung
 * und die möglichen Ergebnisse entsprechen dem Verfahren 32. Die Stelle 10 ist
 * die Prüfziffer.</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   x x x x x x x x x P
 * Gewichtung:       7 6 5 4 3 2
 * </pre>
 * <p>
 * Testkontonummern: 123897, 340960</p>
 * <p>
 * Ausnahme:</p>
 * <p>
 * Ist nach linksbündiger Auffüllung mit Nullen auf 10 Stellen die 3. Stelle
 * der Kontonummer = 9 (Sachkonten), so erfolgt die Berechnung gemäß der
 * Ausnahme in Methode 51 mit den gleichen Ergebnissen und Testkontonummern.</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method86
        extends AbstractMethod {

    private Logger log = Logger.getLogger(Method86.class);

    @Override
    public boolean test() {
        int[] number = expand(this.getAccountNumberArray());
        if (methodA(number)) {
            return true;
        }
        if (methodB(number)) {
            return true;
        }
        return exception(number);
    }

    /**
     * <p>
     * Methode A</p>
     * <p>
     * Die Kontonummer ist durch linksbündige Nullenauffüllung 10- stellig
     * darzustellen. Die Berechnung und die möglichen Ergebnisse entsprechen
     * dem Verfahren 00; es ist jedoch zu beachten, dass nur die Stellen 4 bis 9
     * in das Prüfzifferberechnungsverfahren einbezogen werden. Die Stelle 10
     * der Kontonummer ist die Prüfziffer.</p>
     * <pre>
     * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
     * Kontonr.:   x x x x x x x x x P
     * Gewichtung:       1 2 1 2 1 2
     * </pre>
     * <p>
     * Testkontonummern: 340968, 1001171, 1009588</p>
     * <p>
     * Führt die Berechnung nach Methode A zu einem Prüfziffer- fehler, so ist
     * die Berechnung nach Methode B vorzunehmen.</p>
     *
     * @param number
     * @return
     */
    boolean methodA(int[] number) {
        number = expand(number);
        weighting = new int[]{2, 1, 2, 1, 2, 1};
        Method00 method00 = new Method00();
        method00.setAccountNumberArray(number);
        number = method00.factor(number, weighting, 4, 9);
        int pz = method00.add(number, 3, 9);
        pz = method00.modulus10(pz);
        return checkPz(pz, number);
    }

    /**
     * <p>
     * Methode B. </p>
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7</p>
     * <p>
     * Die Kontonummer ist durch linksbündige Nullenauffüllung 10- stellig
     * darzustellen. Die Stellen 4 bis 9 der Kontonummer werden von rechts nach
     * links mit den Ziffern 2, 3, 4, 5, 6, 7 multipliziert. Die weitere
     * Berechnung und die möglichen Ergebnisse entsprechen dem Verfahren 32.
     * Die Stelle 10 ist die Prüfziffer.</p>
     * <pre>
     * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
     * Kontonr.:   x x x x x x x x x P
     * Gewichtung:       7 6 5 4 3 2
     * </pre>
     * <p>
     * Testkontonummern: 123897, 340960</p>
     *
     * @param number
     * @return
     * @see Method32
     */
    boolean methodB(int[] number) {
        number = expand(number);
        weighting = new int[]{2, 3, 4, 5, 6, 7};
        Method32 method32 = new Method32();
        method32.setAccountNumberArray(number);
        return method32.test();
    }

    /**
     * <p>
     * Ausnahme. </p>
     * <p>
     * Ist nach linksbündiger Auffüllung mit Nullen auf 10 Stellen die 3.
     * Stelle der Kontonummer = 9 (Sachkonten), so erfolgt die Berechnung gemäß
     * der Ausnahme in Methode 51 mit den gleichen Ergebnissen und
     * Testkontonummern.</p>
     *
     * @param number
     * @return
     * @see Method51
     */
    boolean exception(int[] number) {
        number = expand(number);
        if (number[2] == 9) {
            Method51 method51 = new Method51();
            method51.setAccountNumberArray(number);
            return method51.test();
        }
        return false;
    }

}
