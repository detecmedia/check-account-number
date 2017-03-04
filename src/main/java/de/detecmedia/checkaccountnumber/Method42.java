package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.*;

/**
 * Kennzeichen 42.
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8, 9</p><p>
 * Die Kontonummer ist 10-stellig. Die Stellen 2 bis 9 der Kontonummer werden
 * von rechts nach links mit den Ziffern 2, 3, 4, 5, 6, 7, 8, 9 multipliziert.
 * Die restliche Berechnung und Ergebnisse entsprechen dem Verfahren 06. Die
 * Stelle 10 der Kontonummer ist per Definition die Prüfziffer.
 * <p>
 * </p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   x x x x x x x x x P
 * Gewichtung:   9 8 7 6 5 4 3 2
 * </pre><p>
 * Testkontonummern: 59498, 59510</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method42 extends Method06 {

    private int[] weighting;

    @Override
    public boolean test() {

        weighting = new int[]{2, 3, 4, 5, 6, 7, 8, 9};
        int[] number = expand(this.getAccountNumberArray());

        number = factor(number, weighting, 2, 9);

        int pz = add(number, 2, 9);
        pz = modulus11(pz);
        return checkPz(pz, number);
    }

}
