package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.exception.AccountNumberLenghtException;

/**
 * Kennzeichen 58.
 * <p>
 * <b>geändert seit 04.03.2002</b></p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 0, 0, 0, 0</p>
 * <p>
 * Die Kontonummer (mindestens 6-stellig) ist durch linksbündige
 * Nullenauffüllung 10-stellig darzustellen. Danach ist die 10. Stelle die
 * Prüfziffer. Die Stellen 5 bis 9 werden von rechts nach links mit den Ziffern
 * 2, 3, 4, 5, 6 multipliziert. Die restliche Berechnung und die Ergebnisse
 * entsprechen dem Verfahren 02.</p>
 * <p>
 * Beispiel:</p>
 * <pre>
 * Stellennr.: 1  2  3  4  5  6  7  8  9  P
 * Kontonr.:   1  8  0  0  2  9  3  3  7  7
 * Wichtung:   0  0  0  0  6  5  4  3  2
 *            --------------------------
 *             0 +0 +0 +0+12+45+12+ 9+14 = 92
 * 92 : 11 = 8,     Rest4
 * 11 -  4 = 7
 *
 * P=7
 * </pre>
 * <p>
 * Ergibt die Division einen Rest von 0, so ist die Prüfziffer = 0. Bei einem
 * Rest von 1 ist die Kontonummer falsch.</p>
 * <p>
 * Testkontonummern: 1800881120, 9200654108, 1015222224, 3703169668</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method58 extends Method02 {

    private int[] weighting;

    @Override
    public boolean test() {
        if (this.getAccountNumberArray().length < 6) {
            throw new AccountNumberLenghtException();
        }
        int[] number = expand(this.getAccountNumberArray());
        weighting = new int[]{2, 3, 4, 5, 6};
        number = factor(number, weighting, 5, 9);
        int pz = add(number, 4, 9);
        pz = modulus11(pz);
        return checkPz(pz, number);

    }

}
