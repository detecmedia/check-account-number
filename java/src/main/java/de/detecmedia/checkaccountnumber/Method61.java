package de.detecmedia.checkaccountnumber;

import java.util.Arrays;
import org.apache.log4j.Logger;

/**
 * Kennzeichen 61.
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2</p>
 * <p>
 * Darstellung der Kontonummer:</p>
 * <pre>
 * B B B S S S S P A U (10-stellig)
 * B = Betriebsstellennummer
 * S = Stammnummer
 * P = Prüfziffer
 * A = Artziffer
 * U = Unternummer
 * </pre>
 * <p>
 * Ausnahme:</p><p>
 * Ist die Artziffer (neunte Stelle der Kontonummer) eine 8, so werden die
 * neunte und zehnte Stelle der Kontonummer in die Prüfzifferermittlung
 * einbezogen.</p>
 * <p>
 * Die Berechnung erfolgt dann über Betriebsstellennummer, Stammnummer,
 * Artziffer und Unternummer mit der Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2.</p>
 * <p>
 * Beispiel 1:</p>
 * <pre>
 * Stellennr.: B  B  B  S  S  S  S  P  A  U
 * Kontonr.:   2  0  6  3  0  9  9     0  0
 * Gewichtung: 2  1  2  1  2  1  2
 *             -------------------
 *             4+ 0+12 +3 +0 +9 +18
 *             4+ 0+ 3 +3 +0 +9 +9 = 28
 *                  (Q)         (Q)
 * </pre><p>
 * (Q = Quersumme) Die Einerstelle wird vom Wert 10 subtrahiert (10 - 8 =
 * 2).</p>
 * <p>
 * Die Prüfziffer ist in diesem Fall die 2 und die vollständige Kontonummer
 * lautet: 2 0 6 3 0 9 9 2 0 0</p>
 * <p>
 * Beispiel 2:</p>
 * <pre>
 * Stellennr.: B  B  B  S  S  S  S  P  A  U
 * Kontonr.:   0  2  6  0  7  6  0     8  1
 * Gewichtung: 2  1  2  1  2  1  2     1  2
 *             ----------------------------
 *             0+ 2+12+ 0+14+ 6 +2+    8+ 2
 *             0+ 2+ 3+ 0+ 5 +6 +0+    8+ 2 = 26
 *                 (Q)    (Q)
 *  (Q = Quersumme)
 * Die Einerstelle wird vom Wert 10 subtrahiert (10 - 6 = 4).
 * </pre>
 * <p>
 * Die Prüfziffer ist in diesem Fall die 4 und die vollständige Kontonummer
 * lautet: 0 2 6 0 7 6 0 4 8 1</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method61 extends AbstractMethod {

    private Logger log = Logger.getLogger(Method61.class);

    @Override
    public boolean test() {
        weighting = new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2};

        int[] number = this.expand(this.getAccountNumberArray());
        log.debug("accountNumber: " + Arrays.toString(number));
        if (number[8] == 8) {
            log.debug("go in ausnahme");
            return ausnahme(number);
        }
        number = factor(number, weighting, 1, 7);
        int pz = add(number, 0, 7);
        pz %= 10;
        pz = 10 - pz;
        return checkPz(pz, number, 8);
    }

    private boolean ausnahme(int[] number) {
        weighting = new int[]{2, 1, 0, 2, 1, 2, 1, 2, 1, 2};
        int tmp = number[7];
        number = factor(number, weighting, 1, number.length);
        int pz = add(number, 0, number.length);
        number[7] = tmp;
        pz %= 10;
        pz = 10 - pz;
        return checkPz(pz, number, 8);
    }

}
