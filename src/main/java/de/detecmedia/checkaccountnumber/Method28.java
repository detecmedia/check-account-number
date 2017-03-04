package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.exception.AccountNumberLenghtException;
import org.apache.log4j.Logger;

/**
 * Kennzeichen 28.
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8</p><p>
 * Die Kontonummer ist 10-stellig. Die zweistellige Unterkontonummer (Stellen 9
 * und 10) wird nicht in das Berechnungsverfahren einbezogen. Die für die
 * Berechnung relevanten Stellen 1 bis 7 werden von rechts nach links mit den
 * Ziffern 2, 3, 4, 5, 6, 7, 8 multipliziert. Die 8. Stelle ist die Prüfziffer.
 * Die Berechnung und Ergebnisse entsprechen dem Verfahren 06. </p>
 * <pre>
 * Stellennr.:    1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:      x x x x x x x P x x
 * Gewichtung:    8 7 6 5 4 3 2
 * </pre>
 * <p>
 * Wird als Rest eine 0 oder eine 1 ermittelt, so lautet die Prüfziffer 0.</p>
 * <p>
 * Testkontonummern: 19999000, 9130000201</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method28 extends Method06 {

    private static Logger log = Logger.getLogger(Method28.class);

    private int[] weighting;

    @Override
    public boolean test() {
        weighting = new int[]{2, 3, 4, 5, 6, 7, 8};
        return check(weighting);
    }

    @Override
    public boolean check(int[] weighting) {
        int[] number = this.getAccountNumberArray();
        number = expand(number);
        if (number.length != 10) {
            throw new AccountNumberLenghtException();
        }

        number = this.factor(number, weighting, 1, 7);
        int pz = this.add(number);
        log.debug("pz for % 11: " + pz);
        pz = this.modulus11(pz);
        return checkPz(pz, number, 8);
    }

    @Override
    protected int add(int[] number) {
        int pz = 0;
        for (int i = 0; i < 7; i++) {
            int o = number[i];
            pz += o;
        }
        return pz;
    }

}
