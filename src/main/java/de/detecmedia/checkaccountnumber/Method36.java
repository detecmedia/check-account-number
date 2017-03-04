package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen 36.
 * <p>
 * Modulus 11, Gewichtung 2, 4, 8, 5</p><p>
 * Die Kontonummer ist 10-stellig. Die Stellen 6 bis 9 der Kontonummer werden
 * von rechts nach links mit den Ziffern 2, 4, 8, 5 multipliziert. Die restliche
 * Berechnung und Ergebnisse entsprechen dem Verfahren 06. Die Stelle 10 der
 * Kontonummer ist per Definition die Prüfziffer.
 * </p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   x x x x x x x x x P
 * Gewichtung:           5 8 4 2
 * </pre>
 * <p>
 * Testkontonummern: 113178, 146666</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method36 extends Method06 {

    private int[] weighting;

    @Override
    public boolean test() {
        weighting = new int[]{2, 4, 8, 5};
        int[] number = expand(this.getAccountNumberArray());
        factor(number, weighting, 6, 9);
        int pz = add(number, 5, 9);
        pz = modulus11(pz);
        return this.checkPz(pz, number);

    }

}
