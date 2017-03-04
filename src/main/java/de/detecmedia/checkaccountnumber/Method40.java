package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen 40.
 * <p>
 * Modulus 11, Gewichtung 2, 4, 8, 5, A, 9, 7, 3, 6 (A = 10)</p><p>
 * Die Kontonummer ist 10-stellig. Die Stellen 1 bis 9 der Kontonummer werden
 * von rechts nach links mit den Faktoren 2, 4, 8, 5, A, 9, 7, 3, 6.
 * multipliziert. Dabei steht der Buchstabe A für den Wert10. Die restliche
 * Berechnung und Ergebnisse entsprechen dem Verfahren 06. Die Stelle 10 der
 * Kontonummer ist per Definition die Prüfziffer.
 * </p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   x x x x x x x x x P
 * Gewichtung: 6 3 7 9 A 5 8 4 2
 * </pre>
 * <p>
 * Testkontonummern: 1258345, 3231963</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method40 extends Method06 {

    @Override
    public boolean test() {
        int A = 10;
        weighting = new int[]{2, 4, 8, 5, A, 9, 7, 3, 6};
        return check(weighting);
    }

}
