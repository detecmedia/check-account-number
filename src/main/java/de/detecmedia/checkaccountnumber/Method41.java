package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.*;
import org.apache.log4j.Logger;

/**
 * Kennzeichen 41.
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2 (modifiziert)</p><p>
 * Die Berechnung erfolgt wie bei Verfahren 00</p>
 * <p>
 * Ausnahme:<br>
 * Ist die 4. Stelle der Kontonummer (von links) = 9, so werden die Stellen 1
 * bis 3 nicht in die Prüfzifferberechnung einbezogen.</p>
 * <pre>
 * Stellennr.:           1  2  3  4  5  6  7  8  9  10
 * Kontonr.:             4  0  1  9  1  1  0  0  0  8
 * Ktonr.                0  0  0  9  1  1  0  0  0  8
 * umgesetzt Gewichtung:          1  2  1  2  1  2
 *                               --------------------
 *                                9+ 2+ 1+ 0+ 0+ 0 = 12
 * 10 - 2 = 8
 * 8 = Prüfziffer
 * </pre><p>
 * Testkontonummern: 4013410024, 4016660195, 0166805317 4019310079, 4019340829,
 * 4019151002</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 * @see Method00
 */
public class Method41 extends Method00 {

    public Logger log = Logger.getLogger(Method41.class);

    private int[] weighting;

    @Override
    public boolean test() {
        weighting = new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2};
        int[] number = this.getAccountNumberArray();
        if (number[3] == 9) {
            number = this.factor(number, weighting, 4, 9);
            int pz = add(number, 3, 9);
            pz = this.modulus10(pz);

            if (pz == number[number.length - 1]) {
                return true;
            }

        }

        return check(weighting);

    }

}
