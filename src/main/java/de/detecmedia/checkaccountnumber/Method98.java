package de.detecmedia.checkaccountnumber;

import org.apache.log4j.Logger;

/**
 * Kennzeichen 98.
 * <p>
 * Modulus 10, Gewichtung 3, 1, 7, 3, 1, 7, 3</p>
 * <p>
 * Die Kontonummer ist 10-stellig. Die Berechnung erfolgt wie bei Verfahren 01.
 * Es ist jedoch zu beachten, dass nur die Stellen3 bis 9 in die
 * Prüfzifferberechnung einbezogen werden. Die Stelle 10 der Kontonummer ist
 * die Prüfziffer.</p>
 * <p>
 * Führt die Berechnung zu einem falschen Ergebnis, so ist alternativ das
 * Verfahren 32 anzuwenden.</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 10
 * Kontonr.:   x x x x x x x x x P
 * Gewichtung:     3 7 1 3 7 1 3
 * </pre>
 * <pre>
 * Beispiel:
 * P Kontonr.: 9  6  1  9  6  0  8  1  1  8
 * Gewichtung:       3  7  1  3  7  1  3
 *                  --------------------
 *                   3+63+ 6+ 0+56+ 1+ 3 = 132
 * 132 % 10 = REST 2
 * 10 - 2 = 8
 * 8 = Prüfziffer</pre>
 * <p>
 * T estkontonummern: 9619439213, 9619509976, 9619319999, 3009800016,
 * 5989800173, 6719430018</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method98
        extends Method01 {

    private int[] weighting;

    private final Logger log = Logger.getLogger(Method98.class);

    @Override
    public boolean test() {
        weighting = new int[]{3, 1, 7, 3, 1, 7, 3, 0, 0};
        return check(weighting);
    }

}
