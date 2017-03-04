package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen 20.
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8, 9, 3 (modifiziert)</p><p>
 * Die Berechnung und mögliche Ergebnisse entsprechen dem Verfahren 06.</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method20 extends Method06 {

    @Override
    public boolean test() {
        weighting = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 3};
        return this.check(weighting);
    }

}
