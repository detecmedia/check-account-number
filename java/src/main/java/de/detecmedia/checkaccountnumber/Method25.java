package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.exception.AccountNumberLenghtException;
import org.apache.log4j.Logger;

/**
 * Kennzeichen 25.
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8, 9 ohne Quersumme</p><p>
 * Die einzelnen Stellen der Kontonummer sind von rechts nach links mit den
 * Ziffern 2, 3, 4, 5, 6, 7, 8 und 9 zu multiplizieren. Die jeweiligen Produkte
 * werden addiert. Die Summe ist durch 11 zu dividieren. Der verbleibende Rest
 * wird vom Divisor subtrahiert. Das Ergebnis ist die Prüfziffer. Verbleibt
 * nach der Division durch 11 kein Rest, ist die Prüfziffer = 0. Ergibt sich
 * als Rest 1, so ist die Prüfziffer immer 0 und kann nur für die
 * Arbeitsziffern 8 und 9 verwendet werden. Die Kontonummer ist für die
 * Arbeitsziffern 0, 1, 2, 3, 4, 5, 6 und 7 dann nicht verwendbar.</p><p>
 * Die Arbeitsziffer (Geschäftsbereich oder Kontoart) befindet sich in der 2.
 * Stelle (von links) des 10-stelligen Kontonummernfeldes.</p>
 * <pre>
 * Stellennr.:           1  2  3  4  5  6  7  8  9  A  (A=10)
 * Kontonr.:             x  x  x  x  x  x  x  x  x  P
 * Gewichtung:              9  8  7  6  5  4  3  2
 * </pre>
 * <p>
 * Die Kontonummer ist 9-stellig, wobei die 1.Stelle die Arbeitsziffer und die
 * letzte Stelle die Prüfziffer ist.</p>
 * <pre>
 * Stellennr.:           1  2  3  4  5  6  7  8  9  A  (A=10)
 * Kontonr.:                5  2  1  3  8  2  1  8  P
 * Gewichtung:              9  8  7  6  5  4  3  2
 *                        ------------------------
 *                         45+16+ 7+18+40+ 8+ 3+16 = 153
 *                                                   153 : 11 = 13, Rest 10
 *
 *                                               11 - 10 = 1, Prüfziffer = 1
 * </pre>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method25 extends AbstractMethod {
    
    private final Logger log = Logger.getLogger(Method25.class);

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        if (number.length != 10) {
            throw new AccountNumberLenghtException();
        }
        int workdigit = number[1];
        weighting = new int[]{2, 3, 4, 5, 6, 7, 8, 9};
        number = this.factor(number, weighting);

        int pz = this.add(number);
        pz = pz % 11;
        
        if (pz == 1 && number[1] == 8
                || number[1] == 9) {
            pz = 0;
            return this.checkPz(pz, number);
        }
        pz = 11 - pz;
        log.debug("PZ = "+pz);
        // 0, 1, 2, 3, 4, 5, 6 und 7 
        log.debug("Arbeitsziffer "+number[1]);
        if (workdigit == 0
                || workdigit == 1
                || workdigit == 2
                || workdigit == 3
                || workdigit == 4
                || workdigit == 5
                || workdigit == 6
                || workdigit == 7) {
            return this.checkPz(pz, number);
        }
        return false;
    }

    @Override
    protected int add(int[] number) {
        int pz = 0;
        for (int i = 0; i < (number.length - 1); i++) {
            int o = number[i];
            pz += o;
        }
        return pz;
    }

}
