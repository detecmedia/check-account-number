package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.*;

/**
 * Kennzeichen 65.
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2</p>
 * <p>
 * Die Kontonummer ist zehnstellig. Darstellung der Kontonummer:</p>
 * <pre>
 * GGGSSSSPKU
 * G = Geschäftsstellennummer
 * S = Stammnummer
 * P = Prüfziffer
 * K = Kontenartziffer
 * U = Unterkontonummer</pre>
 * <p>
 * Die Berechnung erfolgt wie bei Verfahren00 über Geschäftsstellennummer und
 * Stammnummer mit der Gewichtung 2, 1, 2, 1, 2, 1, 2.</p>
 * <pre>
 * Stellen:    G  G  G  S  S  S  S  P  K  U
 * Kontonr.:   1  2  3  4  5  6  7     0  0
 * Gewichtung: 2  1  2  1  2  1  2
 *           ---------------------
 *             2+ 2+ 6+ 4+10+ 6+14
 *             2+ 2+ 6+ 4+1 + 6+ 5 = 26
 *                       (Q)    (Q)
 * (Q = Quersumme)
 * </pre>
 * <p>
 * Die Einerstelle wird vom Wert 10 subtrahiert (10 - 6 = 4).</p>
 * <p>
 * Die Prüfziffer ist in diesem Fall die 4 und die vollständige Kontonummer
 * lautet: 1 2 3 4 5 6 7 4 0 0</p>
 * <p>
 * Ausnahme:</p>
 * <p>
 * Ist die Kontenartziffer (neunte Stelle der Kontonummer) eine 9, so werden die
 * neunte und zehnte Stelle der Kontonummer in die Prüfzifferermittlung
 * einbezogen.</p>
 * <p>
 * Die Berechnung erfolgt dann über Geschäftsstellennummer, Stammnummer,
 * Kontenartziffer und Unterkontonummer mit der Gewichtung 2, 1, 2, 1, 2, 1, 2,
 * 1, 2.</p>
 * <pre>
 * Stellen:    G  G  G  S  S  S  S  P  K  U
 * Kontonr.:   1  2  3  4  5  6  7     9  0
 * Gewichtung: 2  1  2  1  2  1  2     1  2
 *            -----------------------------
 *             2+ 2+ 6+ 4+10+ 6+14+    9+ 0
 *             2+ 2+ 6+ 4+ 1+ 6+5     +9+ 0 = 35
 *                        (Q)  (Q)
 * (Q = Quersumme)
 * Die Einerstelle wird vom Wert 10 subtrahiert (10 - 5 = 5).
 * </pre>
 * <p>
 * Die Prüfziffer ist in diesem Fall die 5 und die vollständige Kontonummer
 * lautet: 1 2 3 4 5 6 7 5 9 0</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method65
        extends AbstractMethod {

    private int[] weighting;

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        number = expand(number);
        weighting = new int[]{2, 1, 2, 1, 2, 1, 2};
        number = factor(number, weighting, 1, 7);
        int pz = add(number, 0, 7);
        if (number[8] == 9) {
            number = factor(number, weighting, 9, 10);
            pz = add(number, 8, 10) + pz;
        }
        pz = modulus10(pz);
        return checkPz(pz, number, 8);
    }

}
