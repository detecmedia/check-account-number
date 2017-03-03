package de.detecmedia.checkaccountnumber;

import java.util.Arrays;
import org.apache.log4j.Logger;

/**
 * Kennzeichen 64.
 * <p>
 * Modulus 11, Gewichtung 9, 10, 5, 8, 4, 2.</p>
 * <p>
 * Die Kontonummer ist 10-stellig. Die für die Berechnung relevanten Stellen
 * der Kontonummer befinden sich in den Stellen 1 bis 6 und werden von links
 * nach rechts mit den Ziffern 9, 10, 5, 8, 4, 2 multipliziert. Die weitere
 * Berechnung und Ergebnisse entsprechen dem Verfahren 06. Die Prüfziffer
 * befindet sich in Stelle 7 der Kontonummer.</p>
 * <p>
 * Testkontonummern: 1206473010, 5016511020</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 * @see Method06
 */
public class Method64 extends Method06 {

    private Logger log = Logger.getLogger(Method64.class);

    @Override
    public boolean test() {
        weighting = new int[]{9, 10, 5, 8, 4, 2};
        int[] number = expand(this.getAccountNumberArray());
        number = factor(number, weighting);
        int pz = add(number, 0, 6);
        pz = modulus11(pz);
        return checkPz(pz, number, 7);
    }

    @Override
    protected int[] factor(int[] number, int[] weighting) {
        for (int i = 0; i < weighting.length; i++) {
            log.debug(number[i] + " * " + weighting[i]);
            number[i] *= weighting[i];

        }
        log.debug("result: " + Arrays.toString(number));
        return number;
    }

}
