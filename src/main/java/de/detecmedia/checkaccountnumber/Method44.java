package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.*;

/**
 * Kennzeichen 44.
 * <p>
 * Modulus 11, Gewichtung 2, 4, 8, 5, A, 0, 0, 0, 0 (A = 10)</p><p>
 * Die Berechnung erfolgt wie bei Verfahren 33.</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 10
 * Kontonr.:   x x x x x x x x x P
 * Gewichtung: 0 0 0 0 A 5 8 4 2
 * </pre><p>
 * Testkontonummern: 889006, 2618040504</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 * @see Method33
 */
public class Method44 extends Method33 {

    @Override
    public boolean test() {
        int A = 10;

        weighting = new int[]{2, 4, 8, 5, A, 0, 0, 0, 0};
        return check(weighting);

    }

}
