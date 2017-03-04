package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen 81.
 * <p>
 * <b>geändert zum 06.09.2004</b></p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7</p>
 * <p>
 * Die Kontonummer ist durch linksbündige Nullenauffüllung 10- stellig
 * darzustellen. Die 10.Stelle ist per Definition die Prüfziffer. Die für die
 * Berechnung relevanten Stellen werden von rechts nach links mit den Ziffern 2,
 * 3, 4, 5, 6, 7 multipliziert. Die weitere Berechnung und die möglichen
 * Ergebnisse entsprechen dem Verfahren 32.</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   x x x x x x x x x P
 * Gewichtung:       7 6 5 4 3 2
 * </pre>
 * <p>
 * Testkontonummern: 0646440, 1359100</p>
 * <p>
 * Ausnahme:</p>
 * <p>
 * Ist nach linksbündiger Auffüllung mit Nullen auf 10 Stellen die 3. Stelle
 * der Kontonummer = 9 (Sachkonten), so erfolgt die Berechnung gemäß der
 * Ausnahme in Methode 51 mit den gleichen Ergebnissen und Testkontonummern.</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method81 extends Method32 {
    private int[] weighting;

    @Override
    public boolean test() {
        weighting = new int[]{2, 3, 4, 5, 6, 7};
        return this.check(weighting);
    }

}
