package de.detecmedia.checkaccountnumber;

import java.util.Arrays;
import org.apache.log4j.Logger;

/**
 * Kennzeichen 71.
 * <p>
 * Modulus 11, Gewichtung 6, 5, 4, 3, 2, 1</p>
 * <p>
 * Die Kontonummer ist immer 10-stellig. Die Stellen 2 bis 7 sind von links nach
 * rechts mit den Ziffern 6, 5, 4, 3, 2, 1 zu multiplizieren. Die Summe ist
 * durch 11 zu dividieren. Der verbleibende Rest wird vom Divisor (11)
 * subtrahiert. Das Ergebnis ist die Prüfziffer.</p>
 * <p>
 * Ausnahmen:<br>
 * Verbleibt nach der Division durch 11 kein Rest, ist die Prüfziffer 0. Ergibt
 * sich als Rest 1, entsteht bei der Subtraktion 11 - 1 = 10; die Zehnerstelle
 * (1) ist dann die Prüfziffer.</p>
 * <pre>
 * Darstellung der Kontonummer:
 * S G G K K K K U U P
 * S    =   Sachgebiet
 * G    =   Geschäftsstelle
 * K    =   Kundennummer
 * U    =   Unternummer
 * P    =   Prüfziffer
 * </pre>
 * <pre>
 * Prüfzifferberechnung:
 * Stellennr.: 1  2  3  4  5  6  7  8  9  A (A=10)
 * Kontonr.:   7  1  0  1  2  3  4  0  0  P
 * Gewichtung:    6  5  4  3  2  1
 *               -----------------
 *                6+ 0+ 4+ 6+ 6+ 4 = 26
 * 26 : 11 = 2, Rest 4
 * 11 - 4 = 7
 * </pre><p>
 * Die Prüfziffer ist in diesem Fall die 7 und die vollständige Kontonummer
 * lautet: 7 1 0 1 2 3 4 0 0 7</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method71 extends AbstractMethod {
    /**
     * define logger.
     */
    private static final Logger LOG = Logger.getLogger(Method71.class);
    /**
     * Modulus 11.
     */
    private static final int MODULUS_11 = 11;
    /**
     * Place of number.
     */
    private static final int PLACE = 10;
    /**
     * weighing.
     */
    private static final int[] WEIGHTING = {6, 5, 4, 3, 2, 1};
    /**
     * start pos.
     */
    private static final int START = 1;
    /**
     * end pos.
     */
    private static final int ENT = 7;

    /**
     * test for method 71.
     *
     * @return boolean
     */
    @Override
    public boolean test() {
        int[] number = expand(this.getAccountNumberArray());
        number = factor(number, WEIGHTING);
        int pz = add(number, START, ENT);
        pz = modulus11(pz);
        return checkPz(pz, number);
    }

    /**
     * override factor.
     *
     * @param number    int[] AccountNumber
     * @param weighting weighting
     * @return int
     */
    @Override
    protected int[] factor(final int[] number, final int[] weighting) {
        int numberI = 1;
        LOG.debug("result factor: " + Arrays.toString(number));
        for (int i = 0; i < weighting.length; i++) {
            number[numberI++] *= weighting[i];
        }
        LOG.debug("result factor: " + Arrays.toString(number));
        return number;
    }

    /**
     * Modulus 11.
     * @param number int
     * @return
     */
    @Override
    protected int modulus11(final int number) {
        int n = number % MODULUS_11;
        LOG.debug("%11 " + n);
        if (n == 0) {
            return 0;
        }
        n = MODULUS_11 - n;
        if (n == PLACE) {
            return 1;
        }
        return n;
    }

}
