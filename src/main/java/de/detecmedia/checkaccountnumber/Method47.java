package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.*;

/**
 * Kennzeichen 47.
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6</p><p>
 * Die Kontonummer ist 10-stellig. Die Stellen 4 bis 8 der Kontonummer werden
 * von rechts nach links mit den Ziffern 2, 3, 4, 5, 6 multipliziert. Die
 * restliche Berechnung und Ergebnisse entsprechen dem Verfahren 06. Die Stelle
 * 9 der Kontonummer ist per Definition die Prüfziffer.</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   x x x x x x x x P x
 * Gewichtung:       6 5 4 3 2</pre><p>
 * Testkontonummern: 1018000, 1003554450</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 * @see Method06
 */
public class Method47 extends Method06 {

    private int[] weighting;

    @Override
    public boolean test() {
        weighting = new int[]{2, 3, 4, 5, 6};
        int[] number = expand(this.getAccountNumberArray());
        number = factor(number, weighting, 4, 8);
        int pz = add(number, 3, 8);
        pz = modulus11(pz);
        return checkPz(pz, number, 9);
    }

}
