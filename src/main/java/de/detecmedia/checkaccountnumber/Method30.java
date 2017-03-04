package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.exception.AccountNumberLenghtException;

import java.util.Arrays;

import org.apache.log4j.Logger;

/**
 * Kennzeichen 30. Modulus 10, Gewichtung 2, 0, 0, 0, 0, 1, 2, 1, 2 Die letzte
 * Stelle ist per Definition die Prüfziffer. Die einzelnen Stellen der
 * Kontonummer sind ab der ersten Stelle von links nach rechts mit den Ziffern
 * 2, 0, 0, 0, 0, 1, 2, 1, 2 zu multiplizieren. Die jeweiligen Produkte werden
 * addiert (ohne Quersummenbildung). Die weitere Berechnung erfolgt wie bei
 * Verfahren 00.
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   x x x x x x x x x P
 * Gewichtung: 2 0 0 0 0 1 2 1 2
 * </pre>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method30 extends Method00 {

    public Logger log = Logger.getLogger(Method30.class);

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        if (number.length != 10) {
            throw new AccountNumberLenghtException();
        }
        weighting = new int[]{2, 0, 0, 0, 0, 1, 2, 1, 2};
        number = factor(number, weighting);
        int pz = this.add(number);

        pz = this.modulus10(pz);

        if (pz == number[number.length - 1]) {
            return true;
        }
        return false;
    }

    @Override
    protected int[] factor(int[] number, int[] weighting) {
        log.debug("number: " + Arrays.toString(number));
        log.debug("weighting: " + Arrays.toString(weighting));
        for (int i = 0; i < number.length - 1; i++) {
            log.debug(number[i] + "*" + weighting[i] + "=" + number[i] * weighting[i]);
            number[i] *= weighting[i];
        }
        return number;
    }

    protected int add(int[] number) {
        int pz = 0;
        for (int i = 0; i < (number.length - 1); i++) {
            int o = number[i];

            pz += o;
        }
        return pz;
    }

}
