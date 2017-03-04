package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.exception.AccountNumberLenghtException;

import javax.security.auth.login.AccountLockedException;

import org.apache.log4j.Logger;

/**
 * Kennzeichen 35.
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8, 9, 10</p><p>
 * Die Kontonummer ist ggf. durch linksbündige Nullenauffüllung 10-stellig
 * darzustellen. Die 10. Stelle der Kontonummer ist die Prüfziffer. Die Stellen
 * 1 bis 9 der Kontonummer werden von rechts nach links mit den Ziffern 2, 3, 4,
 * ff. multipliziert. Die jeweiligen Produkte werden addiert. Die Summe der
 * Produkte ist durch 11 zu dividieren. Der verbleibende Rest ist die
 * Prüfziffer. Sollte jedoch der Rest 10 ergeben, so ist die Kontonummer
 * unabhängig vom eigentlichen Berechnungs- ergebnis richtig, wenn die Ziffern
 * an 10. und 9. Stelle identisch sind.</p>
 * <p>
 * Beispiel 1: </p>
 * <pre>
 * Stellennr.: P  1  2  3  4  5  6  7  8  9  10
 * Kontonr.:      0  0  0  0  1  0  8  4  4  3
 * Gewichtung:    10 9  8  7  6  5  4  3  2
 *             -----------------------------
 *                0+ 0+ 0+ 0+ 6+ 0+32+12+ 8 = 58
 *
 * 58 : 11 = 5 Rest 3
 * 3 ist die Prüfziffer
 * </pre>
 * <p>
 * Beispiel 2: </p>
 * <pre>
 * Stellennr.: P  1  2  3  4  5  6  7  8  9 10
 * Kontonr.:      0  0  0  0  1  0  1  5  9  9
 * Gewichtung:    10 9  8  7  6  5  4  3  2
 *               --------------------------
 *                0+ 0+ 0+ 0+ 6+ 0+ 4+15+18 = 43
 *
 * 43:11 Rest 10
 *
 * </pre>
 * <p>
 * Testkontonummern: 0000108443, 0000107451, 0000102921, 0000102349, 0000101709,
 * 0000101599</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method35 extends AbstractMethod {

    public Logger log = Logger.getLogger(Method35.class);

    @Override
    public boolean test() {
        weighting = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] number = this.getAccountNumberArray();
        number = this.expand(number);
        if (number.length != 10) {
            throw new AccountNumberLenghtException();
        }
        number = factor(number, weighting);
        int pz = add(number);
        pz = modulus11(pz);
        if (pz == 10) {
            number = this.getAccountNumberArray();
            if (number[8] == number[9]) {
                return true;
            }
        }
        return checkPz(pz, number);
    }

    @Override
    protected int add(int[] number) {
        int pz = 0;
        for (int i = 0; i < (number.length - 1); i++) {
            int o = number[i];
            pz += o;
        }
        log.debug("Summe: " + pz);
        return pz;
    }

    @Override
    protected int modulus11(int number) {
        return number % 11;
    }

}
