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

    private Logger log = Logger.getLogger(Method71.class);

    @Override
    public boolean test() {
        int[] number = expand(this.getAccountNumberArray());
        int[] weighting = {6, 5, 4, 3, 2, 1};
        number = factor(number, weighting);
        int pz = add(number, 1, 7);
        pz = modulus11(pz);
        return checkPz(pz, number);
    }

    @Override
    protected int[] factor(int[] number, int[] weighting) {
        int numberI = 1;
        log.debug("result factor: " + Arrays.toString(number));
        for (int i = 0; i < weighting.length; i++) {
            number[numberI++] *= weighting[i];
        }
        log.debug("result factor: " + Arrays.toString(number));
        return number;
    }

    @Override
    protected int modulus11(int number) {
        number %= 11;
        log.debug("%11 " + number);
        if (number == 0) {
            return 0;
        }
        number = 11 - number;
        if (number == 10) {
            return 1;
        }
        return number;
    }

}
