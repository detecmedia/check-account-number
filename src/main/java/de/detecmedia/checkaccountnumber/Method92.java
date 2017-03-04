package de.detecmedia.checkaccountnumber;

import org.apache.log4j.Logger;

/**
 * Kennzeichen 92.
 * <p>
 * Modulus 10, Gewichtung 3, 7, 1, 3, 7, 1</p>
 * <p>
 * Die Kontonummer ist 10-stellig. Die Berechnung erfolgt wie bei Verfahren 01.
 * Es ist jedoch zu beachten, dass nur die Stellen 4 bis 9 in das
 * Prüfzifferberechnungsverfahren einbezogen werden. Die Stelle 10 der
 * Kontonummer ist die Prüfziffer.</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   x x x x x x x x x P
 * Gewichtung:       1 7 3 1 7 3
 * </pre>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method92
        extends Method01 {

    private final Logger log = Logger.getLogger(Method92.class);
    private int[] weighting;

    @Override
    public boolean test() {
        weighting = new int[]{3, 7, 1, 3, 7, 1};
        int[] number = expand(this.getAccountNumberArray());
        number = this.factor(number, weighting, 4, 9);

        int pz = add(number, 3, 9);

        pz = modulus10(pz);
        log.debug("pz to number = " + pz + " to " + number[number.length - 1]);
        return checkPz(pz, number);
    }

}
