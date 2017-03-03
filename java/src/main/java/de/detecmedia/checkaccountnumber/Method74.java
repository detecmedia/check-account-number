package de.detecmedia.checkaccountnumber;

import org.apache.log4j.Logger;

/**
 * Kennzeichen 74.
 * <p>
 * <b>geändert zum 04.06.2007</b></p>
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2 ff.</p>
 * <p>
 * Die Kontonummer (2- bis 10-stellig) ist durch linksbündige Nullenauffüllung
 * 10-stellig darzustellen. Die 10. Stelle ist per Definition die Prüfziffer.
 * Die für die Berechnung relevanten Stellen werden von rechts nach links mit
 * den Ziffern 2, 1, 2, 1, 2 ff. multipliziert. Die weitere Berechnung und die
 * Ergebnisse entsprechen dem Verfahren 00.</p>
 * <p>
 * Ausnahme:<br>
 * Bei 6-stelligen Kontonummern ist folgende Besonderheit zu beachten:</p>
 * <p>
 * Ergibt die erste Berechnung der Prüfziffer nach dem Verfahren00 einen
 * Prüfzifferfehler, so ist eine weitere Berechnung vorzunehmen. Hierbei ist
 * die Summe der Produkte auf die nächste Halbdekade hochzurechnen. Die
 * Differenz ist die Prüfziffer.</p>
 * <p>
 * Beispiel:</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:           2 3 9 3 1 P
 * Gewichtung:         2 1 2 1 2
 *                    ----------
 *                     4+3+9+3+2 = 21
 *                        (Q)
 * (Q = Quersumme)
 * 1. Berechnung (Verfahren 00) 10 - 1 = 9
 * 2. Berechnung 21 + 4 = 25 (nächste Halbdekade)
 *
 * ￼</pre>
 * <p>
 * In diesem Fall kann die Prüfziffer 4 oder 9 lauten.</p>
 * <p>
 * Testkontonummern (richtig): 1016, 26260, 242243, 242248, 18002113,
 * 1821200043</p>
 * <p>
 * Testkontonummern (falsch): 1011, 26265, 18002118, 6160000024</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method74 extends Method00 {

    private Logger log = Logger.getLogger(Method74.class);

    @Override
    public boolean test() {
        weighting = new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2};
        int[] number = expand(this.getAccountNumberArray());
        number = this.factor(number, weighting);
        int pz = add(number);
        pz = modulus10(pz);
        if (checkPz(pz, number)) {
            return true;
        }

        if (String.valueOf(this.getLong()).length() == 6) {
            int[] halfDecade = {5, 15, 25, 35, 45, 55, 65, 74, 85, 95};

            number = expand(this.getAccountNumberArray());
            number = this.factor(number, weighting);
            pz = add(number);
            int j = 0;
            for (int i = 0; i < halfDecade.length; i++) {
                j = halfDecade[i] - pz;
                log.debug("variant 2: " + j);
                if (j >= 0 && j <= 9) {
                    break;
                }

            }
            log.debug("after: " + pz);
            pz = j;

            return checkPz(pz, number);
        }
        return false;
    }

}
