package de.detecmedia.checkaccountnumber;

import static de.detecmedia.checkaccountnumber.converter.Weighting.Weighting;

/**
 * Kennzeichen 79.
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2 ff.</p>
 * <p>
 * Die Kontonummer ist 10-stellig. Die Berechnung und Ergebnisse entsprechen dem
 * Verfahren 00. Es ist jedoch zu beachten, dass die Berechnung vom Wert der 1.
 * Stelle der Kontonummer abhängig ist.</p>
 * <p>
 * Variante 1</p>
 * <p>
 * Die 1. Stelle der Kontonummer hat die Ziffer 3, 4, 5, 6, 7 oder 8</p>
 * <p>
 * Die für die Berechnung relevanten Stellen der Kontonummer befinden sich in
 * den Stellen 1 bis 9. Die 10. Stelle ist per Definition die Prüfziffer.</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.: 3230012688
 * Gewichtung: 2 1 2 1 2 1 2 1 2
 * </pre>
 * <p>
 * Variante 2</p>
 * <p>
 * Die 1. Stelle der Kontonummer hat die Ziffer 1, 2 oder 9</p>
 * <p>
 * Die für die Berechnung relevanten Stellen der Kontonummer befinden sich in
 * den Stellen 1 bis 8. Die 9. Stelle ist die Prüfziffer der 10-stelligen
 * Kontonummer.</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.: 9011200140
 * Gewichtung: 1 2 1 2 1 2 1 2</pre>
 * <p>
 * Kontonummern, die in der 1. Stelle eine 0 haben, wurden nicht vergeben und
 * gelten deshalb als falsch.</p>
 * <p>
 * Testkontonummern: 3230012688, 4230028872, 5440001898, 6330001063, 7000149349,
 * 8000003577, 1550167850, 9011200140</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method79
        extends Method00 {

    private int[] weighting;

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        number = expand(number);
        if (number[0] == 0) {
            return false;
        }
        if (variant1(number)) {
            return true;
        }
        return variant2(number);
    }

    /**
     * <p>
     * Variante 1. </p>
     * <p>
     * Die 1. Stelle der Kontonummer hat die Ziffer 3, 4, 5, 6, 7 oder 8</p>
     * <p>
     * Die für die Berechnung relevanten Stellen der Kontonummer befinden sich
     * in den Stellen 1 bis 9. Die 10. Stelle ist per Definition die
     * Prüfziffer.</p>
     * <pre>
     * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
     * Kontonr.:   3 2 3 0 0 1 2 6 8 8
     * Gewichtung: 2 1 2 1 2 1 2 1 2
     * -------------------------------
     *             6+2+6+0+0+1+4+6+7= 32
     * </pre>
     * <p>
     * 32 % 10 = 2 10 -2 = 8
     *
     * @param number
     * @return
     */
    boolean variant1(int[] number) {
        weighting = new int[]{};
        return this.check(Weighting("2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2"));
    }

    /**
     * <p>
     * Variante 2. </p>
     * <p>
     * Die 1. Stelle der Kontonummer hat die Ziffer 1, 2 oder 9</p>
     * <p>
     * Die für die Berechnung relevanten Stellen der Kontonummer befinden sich
     * in den Stellen 1 bis 8. Die 9. Stelle ist die Prüfziffer der
     * 10-stelligen Kontonummer.</p>
     * <pre>
     * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
     * Kontonr.:   9 0 1 1 2 0 0 1 4 0
     * Gewichtung: 1 2 1 2 1 2 1 2</pre>
     * <p>
     * Kontonummern, die in der 1. Stelle eine 0 haben, wurden nicht vergeben
     * und gelten deshalb als falsch.</p>
     *
     * @param number
     * @return
     */
    boolean variant2(int[] number) {
        weighting = new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2};
        number = factor(number, weighting, 1, 8);
        int pz = add(number, 0, 8);
        pz = modulus10(pz);
        return checkPz(pz, number, 9);
    }

}
