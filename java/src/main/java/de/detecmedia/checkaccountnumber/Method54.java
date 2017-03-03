package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.*;

/**
 * Kennzeichen 54. TODO: Zurzeit nicht in der Abfrageliste.
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 2</p><p>
 * Die Kontonummer ist 10-stellig, wobei die Stellen 1 u. 2 generell mit 49
 * belegt sind. Die einzelnen Stellen der Kontonummer sind von rechts nach links
 * mit den Ziffern 2, 3, 4, 5, 6, 7, 2 zu multiplizieren. Die jeweiligen
 * Produkte werden ad- diert. Die Summe ist durch 11 zu dividieren. Der
 * verbleibende Rest wird vom Divisor (11) subtrahiert. Das Ergebnis ist die
 * Prüfziffer. Ergibt sich als Rest 0 oder 1, ist die Prüfziffer zweistellig
 * und kann nicht verwendet werden. Die Kontonummer ist dann nicht
 * verwendbar.</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   4 9 K K K K K K K P
 * Gewichtung:     2 7 6 5 4 3 2
 * </pre>
 * <p>
 * Testkontonummern: (49) 64137395, (49) 00010987</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method54 extends AbstractMethod {

    @Override
    public boolean test() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
