package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.exception.AccountNumberLenghtException;
import org.apache.log4j.Logger;

/**
 * Kennzeichen 31.
 * <p>
 * Modulus 11, Gewichtung 9, 8, 7, 6, 5, 4, 3, 2, 1</p><p>
 * Die Kontonummer ist 10-stellig. Die Stellen 1 bis 9 der Kontonummer sind von
 * rechts nach links mit den Ziffern 9, 8, 7, 6, 5, 4, 3, 2, 1 zu
 * multiplizieren. Die jeweiligen Produkte werden addiert. Die Summe ist durch
 * 11 zu dividieren. Der verbleibende Rest ist die Prüfziffer. Verbleibt nach
 * der Division durch 11 kein Rest, ist die Prüfziffer 0. Ergibt sich ein Rest
 * 10, ist die Kontonummer falsch. Die Prüfziffer befindet sich in der 10.
 * Stelle der Kontonummer.</p>
 * <p>
 * Beispiel: P </p>
 * <pre>
 * Stellennr.: 1  2  3  4  5  6  7  8  9  10
 * Kontonr.:   0  2  6  3  1  6  0  1  6  5
 * Gewichtung: 1  2  3  4  5  6  7  8  9
 *             -------------------------
 *             0+ 4+18+12+ 5+36+ 0+ 8+54= 137
 *
 * 137 : 11 = 12 Rest 5
 * 5 = Prüfziffer
 * </pre> Testkontonummern: 1000000524, 1000000583
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method31 extends AbstractMethod {

    public Logger log = Logger.getLogger(Method31.class);

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        if (number.length != 10) {
            throw new AccountNumberLenghtException();
        }
        weighting = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        number = this.factor(number, weighting);
        int pz = this.add(number);
        pz %= 11;
        if (pz == 10) {
            return false;
        }
        return checkPz(pz, number);
    }

    @Override
    protected int add(int[] number) {
        int pz = 0;
        for (int i = 0; i < number.length - 1; i++) {
            pz += number[i];
        }
        return pz;
    }

}
