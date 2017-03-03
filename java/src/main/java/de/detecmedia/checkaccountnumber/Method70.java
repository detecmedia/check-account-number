package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen 70. TODO: do later
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7</p>
 * <p>
 * Die Kontonummer ist 10-stellig. Die einzelnen Stellen der Kontonummer sind
 * von rechts nach links mit den Ziffern 2, 3, 4, 5, 6, 7, 2, 3, 4 zu
 * multiplizieren.</p>
 * <p>
 * Die Berechnung erfolgt wie bei Verfahren 06.</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   x x x x x x x x x P
 * Gewichtung: 4 3 2 7 6 5 4 3 2
 * </pre>
 * <p>
 * Ausnahme:<br>
 * Ist die 4. Stelle der Kontonummer = 5 oder die 4. bis 5. Stelle der
 * Kontonummer = 69, so werden die Stellen 1 bis 3 nicht in die
 * Prüfzifferermittlung einbezogen.</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   x x x 5 x x x x x P
 * Kontonr.:   x x x 6 9 x x x x P
 * Gewichtung:       7 6 5 4 3 2
 * </pre>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method70
        extends AbstractMethod {

    @Override
    public boolean test() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
