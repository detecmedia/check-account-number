package de.detecmedia.checkaccountnumber;
// TODO: implements code

/**
 * Kennzeichen 19.
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8, 9, 1</p><p>
 * Die Berechnung und mögliche Ergebnisse entsprechen dem Verfahren 06.</p><p>
 * Testkontonummern: 0240334000, 0200520016</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method19 extends Method06 {
    private int[] weighting;
    @Override
    public boolean test() {
        weighting = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 1};
        return this.check(weighting);
    }

}
