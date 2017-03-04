package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.*;

/**
 * Kennzeichen 46.
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6</p><p>
 * Die Kontonummer ist 10-stellig. Die Stellen 3 bis 7 der Kontonummer werden
 * von rechts nach links mit den Ziffern 2, 3, 4, 5, 6 multipliziert. Die
 * restliche Berechnung und Ergebnisse entsprechen dem Verfahren 06. Die Stelle
 * 8 der Kontonummer ist per Definition die Prüfziffer.</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   x x x x x x x P x x
 * Gewichtung:     6 5 4 3 2
 * </pre>
 * <p>
 * Testkontonummern: 0235468612, 0837890901, 1041447600</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 * @see Method06
 */
public class Method46 extends Method06 {

    @Override
    public boolean test() {
        weighting = new int[]{2, 3, 4, 5, 6};
        int[] number = this.getAccountNumberArray();
        number = factor(number, weighting, 3, 7);
        int pz = add(number, 2, 7);
        pz = modulus11(pz);
        return checkPz(pz, number, 8);
    }

}
