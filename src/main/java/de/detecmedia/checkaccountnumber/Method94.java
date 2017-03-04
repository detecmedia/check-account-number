package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen 94.
 * <p>
 * Modulus 10, Gewichtung 1, 2, 1, 2, 1, 2, 1, 2, 1</p>
 * <p>
 * Die Stellen 1 bis 9 der Kontonummer sind von rechts nach links mit den
 * Gewichten zu multiplizieren. Die weitere Berechnung erfolgt wie bei Verfahren
 * 00.</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   x x x x x x x x x P
 * Gewichtung: 1 2 1 2 1 2 1 2 1
 * </pre>
 * <p>
 * Testkontonummer: 6782533003</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method94 extends Method00 {
    private int[] weighting;

    @Override
    public boolean test() {
        weighting = new int[]{1, 2, 1, 2, 1, 2, 1, 2, 1};
        return check(weighting);

    }

}
