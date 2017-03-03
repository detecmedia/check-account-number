package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.exception.InvalidAcountNumberException;
import org.apache.log4j.Logger;

/**
 * Kennzeichen A0.
 * <p>
 * Modulus 11, Gewichtung 2, 4, 8, 5, 10, 0, 0, 0, 0</p>
 * <p>
 * Die Kontonummer ist einschließlich der Prüfziffer 10-stellig, ggf. ist die
 * Kontonummer für die Prüfzifferberechnung durch linksbündige Auffüllung
 * mit Nullen 10-stellig darzustellen. Die Stelle 10 ist die Prüfziffer. Die
 * einzelnen Stellen der Kontonummer (ohne Prüfziffer) sind von rechts nach
 * links mit dem zugehörigen Gewicht (2, 4, 8, 5, 10, 0, 0, 0, 0) zu
 * multiplizieren. Die Produkte werden addiert. Das Ergebnis ist durch 11 zu
 * dividieren. Ergibt sich nach der Division ein Rest von 0 oder 1, so ist die
 * Prüfziffer 0. Ansonsten ist der Rest vom Divisor (11) zu subtrahieren. Das
 * Ergebnis ist die Prüfziffer.</p>
 * <p>
 * Ausnahme: 3-stellige Kontonummern bzw. Kontonummern, deren Stellen 1 bis 7 =
 * 0 sind, enthalten keine Prüfziffer und sind als richtig anzusehen.</p>
 * <pre>
 * Stellennr.: 1  2  3  4  5  6  7  8  9  10
 * Kontonr.:   x  x  x  x  x  x  x  x  x  P
 * Gewichtung: 0  0  0  0 10  5  8  4  2
 *
 * Summe der Produkte dividiert durch 11 = x, Rest
 * Rest = 0 oder 1 Prüfziffer = 0
 * Rest = 2 bis 10 Prüfziffer = 11 – Rest
 * Beispiel:
 * Stellennr.: 1  2  3  4  5  6  7  8  9  10
 * Kontonr.:   0  5  2  1  0  0  3  2  8  7 
 * Gewichtung: 0  0  0  0 10  5  8  4  2  P
 * ----------------------------------------
 * Produkt:    0+ 0+ 0+ 0+ 0+ 0+24+ 8+16 =48 
 * 48:11 = 4,Rest4
 * 11 - 4 =
 * 
 * 7 = P
 * </pre>
 * <p>
 * Testkontonummern: 521003287, 54500, 3287, 18761, 28290</p>
 */
public class MethodA0 extends Method00 {

    private final Logger log = Logger.getLogger(MethodA0.class);

    @Override
    public boolean test() {
        weighting = new int[] {2, 4, 8, 5, 10, 0, 0, 0, 0};
        int[] number = expand(this.getAccountNumberArray());
        if(number[0] == 0 &&
                number[1] == 0 &&
                number[2] == 0 &&
                number[3] == 0 &&
                number[4] == 0 &&
                number[5] == 0 &&
                number[6] == 0
                ) {
            return true;
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

    /**
     * Modulus 11 returns check digit.
     *
     * @param number int
     * @return int check digit
     */
    protected int modulus11(int number) {
        int checkDigit;
        number %= 11;

        log.debug("%11: " + number);
        if (number == 0) {
            log.debug("pz 0: " + number);
            return 0;
        }
        if (number == 1) {
            return 0;
        }
        checkDigit = 11 - number;
        log.debug("pz all: " + checkDigit);
        return checkDigit;
    }


}
