package de.detecmedia.checkaccountnumber;

import org.apache.log4j.Logger;

/**
 * Kennzeichen 56.
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 2, 3, 4</p>
 * <p>
 * Die Stellen 1 bis 9 der Kontonummer werden von rechts nach links mit den
 * Ziffern 2, 3, 4, 5, 6, 7, 2, 3, 4 multipliziert. Die jeweiligen Produkte
 * werden addiert und die Summe durch 11 dividiert. Der Rest wird von 11
 * abgezogen, das Ergebnis ist die Prüfziffer. Prüfziffer ist die 10. Stelle
 * der Kontonummer.</p>
 * <p>
 * <b>
 * Beispiel 1)</b></p>
 * <pre>
 * Stellennr.: 1  2  3  4  5  6  7  8  9  A (A=10)
 * Kontonr.:   0  2  9  0  5  4  5  0  0  P
 * Gewichtung: 4  3  2  7  6  5  4  3  2
 *            --------------------------
 *             0+ 6+18+ 0+30+20+20+ 0+ 0 = 94
 * 94 : 11 = 8, Rest 6
 * 11 -  6 = 5
 *
 * Die Prüfziffer ist 5
 * </pre>
 * <p>
 * Bei dem Ergebnis 10 oder 11 ist die Kontonummer ungültig.</p>
 * <p>
 * <b>
 * Beispiel 2)</b></p>
 * <p>
 * Beginnt eine 10-stellige Kontonummer mit 9, so wird beim Ergebnis 10 die
 * Prüfziffer = 7 und beim Ergebnis 11 die Prüfziffer = 8 gesetzt.</p>
 * <pre>
 * Stellennr.: 1  2  3  4  5  6  7  8  9  A (A=10)
 * Kontonr.:   9  7  1  8  3  0  4  0  3  P
 * Gewichtung: 4  3  2  7  6  5  4  3  2
 *            --------------------------
 *            36+21+ 2+56+18+ 0+16+ 0+ 6 = 155
 * 155 : 11 = 14, Rest 1
 *  11 -  1 = 10
 *
 *
 * Die Prüfziffer ist 7.
 * </pre> ￼ ￼ ￼ ￼
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method56 extends AbstractMethod {

    private Logger log = Logger.getLogger(Method56.class);

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        if (number.length == 10 && number[0] == 9) {
            return checkBeginWhith9(number);
        }

        weighting = new int[]{2, 3, 4, 5, 6, 7, 2, 3, 4};
        number = factor(number, weighting);
        int pz = add(number);

        pz %= 11;

        pz = 11 - pz;

        pz %= 10;

        log.debug("pz = " + pz);

        return checkPz(pz, number);
    }

    boolean checkBeginWhith9(int[] number) {
        weighting = new int[]{2, 3, 4, 5, 6, 7, 2, 3, 4};
        number = factor(number, weighting);
        int pz = add(number);

        pz %= 11;

        pz = 11 - pz;

        if (pz == 10) {
            pz = 7;
        }
        if (pz == 11) {
            pz = 8;
        }

        log.debug("pz = " + pz);

        return checkPz(pz, number);

    }

    @Override
    protected int add(int[] number, int start, int end) {
        log.debug(start + " to " + end);
        int pz = 0;
        for (int i = start--; i < end; i++) {
            log.debug("+" + number[i]);
            int o = number[i];
            pz += o;
        }
        log.debug("after add: " + pz);
        return pz;
    }

}
