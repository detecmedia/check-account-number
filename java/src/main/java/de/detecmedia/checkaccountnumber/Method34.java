package de.detecmedia.checkaccountnumber;

import org.apache.log4j.Logger;

/**
 * Kennzeichen 34.
 * <p>
 * Modulus 11, Gewichtung 2, 4, 8, 5, A, 9, 7</p><p>
 * Die Kontonummer ist 10-stellig. Es Berechnungsverfahren 28 mit modifizierter
 * Gewichtung angewendet. Die Gewichtung lautet 2, 4, 8, 5, A, 9, 7. Dabei steht
 * der Buchstabe A für den Wert 10.</p><p>
 * Testkontonummern: 9913000700, 9914001000</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 * @see Method28
 */
public class Method34 extends Method28 {

    public Logger log = Logger.getLogger(Method34.class);

    @Override
    public boolean test() {
        int A = 10;
        weighting = new int[]{2, 4, 8, 5, A, 9, 7};
        return check(weighting);
    }

}
