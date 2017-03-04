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
    /**
     * Define logger.
     */
    private static final Logger LOG = Logger.getLogger(Method61.class);
    /**
     * define normal weighting.
     */
    private static final int[] NORMAL_WEIGHTING =
            new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2};
    /**
     * define exceptions weighting.
     */
    private static final int[] EXCEPTIONS_WEIGHTING =
            new int[]{2, 1, 0, 2, 1, 2, 1, 2, 1, 2};
    /**
     * define exceptions account number pos.
     */
    private static final int EXCEPTIONS_ACCOUNT_NUMBER_POS = 7;
    /**
     * define factor start pos of account number.
     */
    private static final int FACTOR_START_POS = 1;
    /**
     * define factor end pos of account number.
     */
    private static final int FACTOR_END_POS = 7;
    /**
     * define check digit pos.
     */
    private static final int CHECK_DIGIT_POS = 8;
    /**
     * define modulus 10.
     */
    private static final int MODULUS_10 = 10;

    /**
     * Minuend.
     */
    private static final int MINUEND = 10;

    /**
     * 8th pos of account number.
     */
    private static final int PLACE_8 = 8;
    /**
     * is 8.
     */
    private static final int IS_8 = 8;
    /**
     * end pos of addition.
     */
    private static final int END = 7;


    /**
     * test of method 61.
     *
     * @return boolean
     */
    @Override
    public boolean test() {
        int[] number = this.expand(this.getAccountNumberArray());
        LOG.debug("accountNumber: " + Arrays.toString(number));
        if (number[PLACE_8] == IS_8) {
            LOG.debug("go in exceptionsForTests");
            return exceptionsForTests(number);
        }
        number = factor(
                number,
                NORMAL_WEIGHTING,
                FACTOR_START_POS,
                FACTOR_END_POS
        );
        int pz = add(number, 0, END);
        pz %= MODULUS_10;
        pz = MINUEND - pz;
        return checkPz(pz, number, CHECK_DIGIT_POS);
    }

    /**
     * exceptions calculation.
     *
     * @param number account number array
     * @return boolean
     */
    private boolean exceptionsForTests(final int[] number) {
        int tmp = number[EXCEPTIONS_ACCOUNT_NUMBER_POS];
        int[] n = factor(
                number,
                EXCEPTIONS_WEIGHTING,
                FACTOR_START_POS,
                number.length
        );
        int pz = add(n, 0, number.length);
        n[EXCEPTIONS_ACCOUNT_NUMBER_POS] = tmp;
        pz %= MODULUS_10;
        pz = MINUEND - pz;
        return checkPz(pz, number, CHECK_DIGIT_POS);
    }

}
