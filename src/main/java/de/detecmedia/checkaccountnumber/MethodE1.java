package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.exception.InvalidAcountNumberException;
import org.apache.log4j.Logger;

/**
 * Kennzeichen E1.
 * <p>
 * Modulus 11, Gewichtung 1, 2, 3, 4, 5, 6, 11, 10, 9</p>
 * <p>
 * Die Kontonummer sowohl für Kontokorrentkonten als auch für Sparkonten ist
 * 9-stellig und für die Prüfzifferberechnung durch linksbündige Auffüllung
 * mit einer Null 10-stellig darzustellen. Die 10. Stelle der Kontonummer ist
 * die Prüfziffer.</p>
 * <p>
 * Vor der Berechnung der Prüfziffer sind die einzelnen Stellen der Kontonummer
 * durch folgende Werte (ASCII Wert) zu ersetzen:</p>
 * <p>
 * <p>
 * Beispiel:</p>
 * <pre>Ziffern der Kontonummer  0  1  2  3  4  5  6  7  8  9
 * ASCII-Wert                   48 49 50 51 52 53 54 55 56 57
 * </pre>
 * <p>
 * Die einzelnen ASCII-Werte sind von rechts nach links mit den Ziffern 1, 2, 3,
 * 4, 5, 6, 11, 10, 9 zu multiplizieren. Die jeweiligen Produkte werden addiert.
 * Die Summe ist durch 11 zu dividieren. Der verbleibende Rest ist die
 * Prüfziffer. Verbleibt nach der Division durch 11 kein Rest, ist die
 * Prüfziffer 0. Ergibt sich ein Rest 10, ist die Kontonummer falsch.</p>
 * <pre>
 * Stelle-Nr.   1   2   3   4   5   6   7   8  9 10
 * Kontonummer  0   1   3   4   2   1   1   9  0  9
 * ASCII-Wert  48  49  51  52  50  49  49  57 48  P
 * Gewichtung   9  10  11   6   5   4   3   2  1
 *          ---------------------------------------
 * Resultat   432 490 561 312 250 196 147 114 48
 * </pre>
 * <pre>
 * Summe = 2550 : 11 = 231; Rest = 9 = Prüfziffer
 * </pre>
 * <p>
 * Testkontonummern (richtig): 0100041104, 0100054106, 0200025107</p>
 * <p>
 * Testkontonummern (falsch): 0150013107, 0200035101, 0081313890, 4268550840,
 * 0987402008</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodE1
        extends AbstractMethod {

    private final Logger log = Logger.getLogger(MethodE1.class);

    private int[] ascii = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57};

    @Override
    public boolean test() {
        int[] number = expand(this.getAccountNumberArray());
        weighting = new int[]{1, 2, 3, 4, 5, 6, 11, 10, 9};
        for (int i = 0; i < number.length - 1; i++) {
            number[i] = ascii[number[i]];
        }

        number = factor(number, weighting);
        int pz = add(number);
        pz = modulus11(pz);
        return checkPz(pz, number);
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

    @Override
    protected int modulus11(int number) {
        int checkDigit;
        number %= 11;
        return number;
    }

}
