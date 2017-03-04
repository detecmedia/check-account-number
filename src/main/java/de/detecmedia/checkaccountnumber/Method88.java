package de.detecmedia.checkaccountnumber;

import org.apache.log4j.Logger;

/**
 * Kennzeichen 88.
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7</p>
 * <p>
 * Die Kontonummer ist durch linksbündige Nullenauffüllung 10- stellig
 * darzustellen. Die Stellen 4 bis 9 werden von rechts nach links mit den
 * Gewichten 2, 3, 4, 5, 6, 7 multipliziert. Die restliche Berechnung und
 * mögliche Ergebnisse entsprechen dem Verfahren 06. Die Stelle 10 der
 * Kontonummer ist per Definition die Prüfziffer.</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   x x x x x x x x x P
 * Gewichtung:       7 6 5 4 3 2
 * </pre>
 * <p>
 * Ausnahme:</p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8</p>
 * <p>
 * Ist die 3. Stelle der Kontonummer = 9, so werden die Stellen 3 bis 9 von
 * rechts nach links mit den Gewichten 2, 3, 4, 5, 6, 7, 8 multipliziert. Die
 * weitere Berechnung erfolgt wie bei Verfahren 06.</p>
 * <p>
 * Testkontonummern: 2525259, 1000500, 90013000, 92525253, 99913003</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method88 extends Method06 {

    private final Logger log = Logger.getLogger(Method88.class);

    @Override
    public boolean test() {
        weighting = new int[]{2, 3, 4, 5, 6, 7};
        int[] number = expand(this.getAccountNumberArray());
        number = this.factor(number, weighting, 4, 9);
        int pz = this.add(number, 3, 9);
        pz = this.modulus11(pz);
        number = expand(this.getAccountNumberArray());
        if (checkPz(pz, number)) {
            return true;
        }

        return number[2] == 9 && exception(number);

    }

    /**
     * <p>
     * Ausnahme:</p>
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8</p>
     * <p>
     * Ist die 3. Stelle der Kontonummer = 9, so werden die Stellen 3 bis 9 von
     * rechts nach links mit den Gewichten 2, 3, 4, 5, 6, 7, 8 multipliziert.
     * Die weitere Berechnung erfolgt wie bei Verfahren 06.</p>
     *
     * @param number
     * @return
     */
    private boolean exception(int[] number) {
        weighting = new int[]{2, 3, 4, 5, 6, 7, 8};
        number = this.factor(number, weighting, 3, 9);
        int pz = this.add(number, 2, 9);
        pz = this.modulus11(pz);
        number = expand(this.getAccountNumberArray());
        return checkPz(pz, number);
    }

}
