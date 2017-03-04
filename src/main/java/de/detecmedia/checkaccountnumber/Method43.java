package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.*;
import org.apache.log4j.Logger;

/**
 * Kennzeichen 43.
 * <p>
 * Modulus 10, Gewichtung 1, 2, 3, 4, 5, 6, 7, 8, 9</p>
 * <p>
 * Die Kontonummer ist 10-stellig. Die Stellen 1 bis 9 der Kontonummer werden
 * von rechts nach links mit den Faktoren 1, 2, 3, 4, 5, 6, 7, 8, 9
 * multipliziert. Die Summe der Produkte wird durch den Wert 10 dividiert. Der
 * Rest der Division wird vom Divisor subtrahiert. Die Differenz ist die
 * Prüfziffer. Ergibt die Berechnung eine Differenz von 10, lautet die
 * Prüfziffer 0. Die Stelle 10 der Kontonummer ist per Definition die
 * Prüfziffer.
 * </p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   x x x x x x x x x P
 * Gewichtung: 9 8 7 6 5 4 3 2 1
 * </pre>
 * <p>
 * Testkontonummern: 6135244, 9516893476</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method43 extends AbstractMethod {

    private static Logger log = Logger.getLogger(Method43.class);

    @Override
    public boolean test() {
        weighting = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] number = this.getAccountNumberArray();

        number = factor(number, weighting);
        int pz = add(number);

        pz %= 10;
        pz = 10 - pz;
        return checkPz(pz, number);
    }

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
