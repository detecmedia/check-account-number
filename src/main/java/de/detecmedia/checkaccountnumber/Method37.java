package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen 37.
 * <p>
 * Modulus 11, Gewichtung 2, 4, 8, 5, A (A = 10)</p><p>
 * Die Kontonummer ist 10-stellig. Die Stellen 5 bis 9 der Kontonummer werden
 * von rechts nach links mit den Faktoren 2, 4, 8, 5, A multipliziert. Dabei
 * steht der Buchstabe A für den Wert 10. Die restliche Berechnung und
 * Ergebnisse entsprechen dem Verfahren 06. Die Stelle 10 der Kontonummer ist
 * per Definition die Prüfziffer.
 * </p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   x x x x x x x x x P
 * Gewichtung:         A 5 8 4 2
 * </pre>
 * <p>
 * Testkontonummern: 624315, 632500</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method37 extends Method06 {

    @Override
    public boolean test() {
        int A = 10;
        weighting = new int[]{2, 4, 8, 5, A};
        int[] number = expand(this.getAccountNumberArray());
        number = factor(number, weighting, 5, 9);
        int pz = add(number, 4, 9);
        pz = modulus11(pz);
        return checkPz(pz, number);
    }

}
