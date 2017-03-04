package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen 82.
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6</p>
 * <p>
 * Die Kontonummer ist durch linksbündige Nullenauffüllung 10- stellig
 * darzustellen. Die 10.Stelle ist per Definition die Prüfziffer. Die für die
 * Berechnung relevanten Stellen werden von rechts nach links mit den Ziffern 2,
 * 3, 4, 5, 6 multipliziert. Die weitere Berechnung und die möglichen
 * Ergebnisse entsprechen dem Verfahren 33.</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   x x x x x x x x x P
 * Gewichtung:         6 5 4 3 2
 * </pre>
 * <p>
 * Ausnahme:</p>
 * <p>
 * Sind die 3. und 4. Stelle der Kontonummer = 99, so erfolgt die Berechnung
 * nach Verfahren 10.</p>
 * <p>
 * Testkontonummern: 123897, 3199500501</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method82 extends Method33 {

    @Override
    public boolean test() {

        int[] number = expand(this.getAccountNumberArray());
        weighting = new int[]{2, 3, 4, 5, 6};
        if (this.check(weighting)) {
            return true;
        }
        number = expand(this.getAccountNumberArray());
        if (number[2] == 9 && number[3] == 9) {
            Method10 method10 = new Method10();
            method10.setAccountNumberArray(number);
            return method10.test();
        }
        return false;
    }

}
