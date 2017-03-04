package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.*;

/**
 * Kennzeichen 55.
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8, 7, 8 (modifiziert)</p><p>
 * Die Berechnung und Ergebnisse entsprechen dem Verfahren 06.</p>
 * <pre>
 * Kontonummer: x x x x x x x x x P
 * </pre>
 *
 * @author Markus Potthast
 * @version 0.0.2
 * @see Method06
 */
public class Method55 extends Method06 {

    @Override
    public boolean test() {
        weighting = new int[]{2, 3, 4, 5, 6, 7, 8, 7, 8};
        return this.check(weighting);
    }

}
