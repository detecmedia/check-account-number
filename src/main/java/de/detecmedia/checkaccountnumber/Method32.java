package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.exception.AccountNumberLenghtException;
import org.apache.log4j.Logger;

/**
 * Kennzeichen 32.
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7</p><p>
 * Die Kontonummer ist 10-stellig. Die Stellen 4 bis 9 der Kontonummer werden
 * von rechts nach links mit den Ziffern 2, 3, 4, 5, 6, 7 multipliziert. Die
 * Berechnung und Ergebnisse entsprechen dem Verfahren 06. Die Stelle 10 der
 * Kontonummer ist per Definition die Prüfziffer.</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   x x x x x x x x x P
 * Gewichtung:       7 6 5 4 3 2
 * </pre><p>
 * Testkontonummern: 9141405, 1709107983, 0122116979, 0121114867, 9030101192,
 * 9245500460</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 * @see Method06
 */
public class Method32 extends Method06 {

    private final Logger log = Logger.getLogger(Method32.class);

    private int[] weighting;
    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        number = expand(number);
        if (number.length != 10) {
            throw new AccountNumberLenghtException();
        }
        weighting = new int[]{2, 3, 4, 5, 6, 7};
        number = factor(number, weighting, 4, 9);
        int pz = this.add(number, 3, 9);
        pz = modulus11(pz);
        return this.checkPz(pz, number);
    }

}
