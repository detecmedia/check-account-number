package de.detecmedia.checkaccountnumber;

import org.apache.log4j.Logger;

/**
 * Kennzeichen 77.
 * <p>
 * Modulus 11, Gewichtung 1, 2, 3, 4, 5</p>
 * <p>
 * Die Kontonummer ist 10-stellig. Die für die Berechnung relevanten Stellen 6
 * bis 10 werden von rechts nach links mit den Ziffern 1, 2, 3, 4, 5
 * multipliziert. Die Produkte werden addiert. Die Summe ist durch 11 zu
 * dividieren.</p>
 * <pre>
 * Stellennr.: 1  2  3  4  5  6  7  8  9  A  (A=10)
 * Kontonr.:   x  x  x  x  x  4  7  6  7  8
 * Gewichtung:                5  4  3  2  1
 *                            -------------
 *                            20+28+18+14+8 = 88
 * 88 : 11 = 8 Rest 0
 * </pre>
 * <p>
 * Verbleibt nach der Division der Summe durch 11 ein Rest, ist folgende neue
 * Berechnung durchzuführen:</p>
 * <p>
 * Modulus 11, Gewichtung 5, 4, 3, 4, 5 Beispiel:</p>
 * <pre>
 * Stellennr.: 1  2  3  4  5  6  7  8  9  A  (A=10)
 * Kontonr.:   x  x  x  x  x  4  7  6  7  1
 * Gewichtung:                5  4  3  4  5
 *                            -------------
 *                            20+28+18+28+5 = 99
 * 99 : 11 = 9 Rest 0</pre>
 * <p>
 * Ergibt sich bei der erneuten Berechnung wiederum ein Rest, dann ist die
 * Kontonummer falsch.</p>
 * <p>
 * Erläuterung:</p>
 * <pre>
 * x = weitere Ziffern der Kontonummer, die jedoch nicht in die Berechnung einbezogen werden.
 * </pre>
 * <p>
 * Testkontonummern: 10338, 13844, 65354, 69258</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method77 extends AbstractMethod {

    private Logger log = Logger.getLogger(Method77.class);

    private int[] weighting;

    @Override
    public boolean test() {
        int[] number = expand(this.getAccountNumberArray());
        weighting = new int[]{1, 2, 3, 4, 5};
        number = factor(number, weighting, 6, 10);
        int pz = add(number, 5, 10);
        if (checkPz(pz, number)) {
            return true;
        }

        number = expand(this.getAccountNumberArray());
        weighting = new int[]{5, 4, 3, 4, 5};
        number = factor(number, weighting, 6, 10);
        pz = add(number, 5, 10);
        return checkPz(pz, number);
    }

    @Override
    protected boolean checkPz(int pz, int[] number) {
        log.debug("pz " + pz);
        return (pz % 11) == 0;
    }

    @Override
    protected int add(int[] number, int start, int end) {
        log.debug(start + " to " + end);
        int pz = 0;
        for (int i = start--; i < end; i++) {

            int o = number[i];
            log.debug("+" + o);
            pz += o;
        }
        log.debug("after add: " + pz);
        return pz;
    }

}
