package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.exception.AccountNumberLenghtException;

/**
 * Kennzeichen 33.
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6</p><p>
 * Die Kontonummer ist 10-stellig. Die Stellen 5 bis 9 der Kontonummer werden
 * von rechts nach links mit den Ziffern 2, 3, 4, 5, 6 multipliziert. Die
 * restliche Berechnung und Ergebnisse entsprechen dem Verfahren 06. Die Stelle
 * 10 der Kontonummer ist per Definition die Prüfziffer.</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   x x x x x x x x x P Gewichtung:
 *                     6 5 4 3 2
 * </pre><p>
 * Testkontonummern: 48658, 84956</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 * @see Method06
 */
public class Method33 extends Method06 {
    private int[] weighting;
    @Override
    public boolean test() {

        weighting = new int[]{2, 3, 4, 5, 6};
        return check(weighting);
    }

    @Override
    public boolean check(int[] weighting) {
        int[] number = this.expand(this.getAccountNumberArray());
        if (number.length != 10) {
            throw new AccountNumberLenghtException();
        }
        number = factor(number, weighting, 5, 9);
        int pz = add(number, 4, 9);
        pz = modulus11(pz);
        return checkPz(pz, number);

    }

}
