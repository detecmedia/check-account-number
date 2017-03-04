package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.*;

/**
 * Kennzeichen 48.
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7</p><p>
 * Die Kontonummer ist 10-stellig. Die Stellen 3 bis 8 der Kontonummer werden
 * von rechts nach links mit den Ziffern 2, 3, 4, 5, 6, 7 multipliziert. Die
 * restliche Berechnung und Ergebnisse entsprechen dem Verfahren 06. Die Stelle
 * 9 der Kontonummer ist per Definition die Prüfziffer.</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   x x x x x x x x P x
 * Gewichtung:     7 6 5 4 3 2
 * </pre>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method48 extends Method06 {

    private int[] weighting;

    @Override
    public boolean test() {
        weighting = new int[]{2, 3, 4, 5, 6, 7};
        int[] number = expand(this.getAccountNumberArray());
        number = factor(number, weighting, 3, 7);
        int pz = add(number, 2, 7);
        pz = modulus11(pz);

        return checkPz(pz, number, 9);

    }

}
