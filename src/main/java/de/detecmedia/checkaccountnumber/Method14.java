package de.detecmedia.checkaccountnumber;

import java.util.Arrays;

import org.apache.log4j.Logger;

/**
 * Kennzeichen 14.
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7</p><p>
 * Die Berechnung erfolgt wie bei Verfahren 02. Es ist jedoch zu beachten, dass
 * die zweistellige Kontoart nicht in das Prüfzifferberechnungsverfahren mit
 * einbezogen wird. Die Kontoart belegt die Stellen 2 und 3, die zu berechnende
 * Grundnummer die Stellen 4 bis 9. Die Prüfziffer befindet sich in Stelle 10.
 *
 * @author Markus Potthast
 * @version 0.0.2
 * @see Method02
 */
public class Method14 extends Method02 {

    private static Logger log = Logger.getLogger(Method14.class);

    @Override
    public boolean test() {
        weighting = new int[]{2, 3, 4, 5, 6, 7};
        return this.check(weighting);
    }

    @Override
    protected int[] factor(int[] number, int[] weighting) {
        log.debug("number: " + Arrays.toString(number));
        log.debug("factor: " + Arrays.toString(weighting));

        int[] tmp = new int[6];
        int tmpI = 0;
        for (int i = 3; i < (number.length - 1); i++) {
            tmp[tmpI++] = number[i];
        }
        tmpI = 0;
        for (int i = tmp.length - 1; i != -1; i--) {
            int u = tmp[i];
            log.debug(u + " * " + weighting[tmpI]);
            tmp[i] *= weighting[tmpI++];
        }
        tmpI = 0;

        log.debug("tmp 4-9: " + Arrays.toString(tmp));
        for (int i = 3; i < (number.length - 1); i++) {
            number[i] = tmp[tmpI++];
        }
        log.debug("number: " + Arrays.toString(number));
        return number;
    }

    @Override
    protected boolean check(int[] weighting) {
        log.debug("factor: " + Arrays.toString(weighting));
        int[] number = this.getAccountNumberArray();
        log.debug("number befor method->factor: " + Arrays.toString(number));
        number = this.factor(number, weighting);
        log.debug("number after method->factor: " + Arrays.toString(number));
        int pz = 0;
        for (int i = 3; i < (number.length - 1); i++) {
            int o = number[i];
            pz += o;
        }

        pz = this.modulus11(pz);

        return this.checkPz(pz, number);
    }

}
