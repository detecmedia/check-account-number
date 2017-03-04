package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.exception.AccountNumberLenghtException;

import java.util.Arrays;

import org.apache.log4j.Logger;

/**
 * Kennzeichen 15.
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5 </p>
 * <p>
 * Die Kontonummer ist 10-stellig. Die Berechnung erfolgt wie bei Verfahren 06;
 * es ist jedoch zu beachten, dass nur die Stellen 6 bis 9 in das
 * Prüfzifferberechnungsverfahren einbezogen werden. Die Stelle 10 der
 * Kontonummer ist die Prüfziffer.</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 * @see Method06
 */
public class Method15 extends Method06 {

    private static Logger log = Logger.getLogger(Method15.class);

    @Override
    public boolean test() {
        weighting = new int[]{2, 3, 4, 5};
        if (this.accountNumber.length() != 10) {
            throw new AccountNumberLenghtException();
        }
        return this.check(weighting);
    }

    /**
     * @param weighting multiplikator
     * @return boolean true wenn richtig
     */
    @Override
    public boolean check(int[] weighting) {
        log.debug("factor: " + Arrays.toString(weighting));
        int[] number = this.getAccountNumberArray();
        log.debug("number befor method->factor: " + Arrays.toString(number));
        number = this.factor(number, weighting);
        log.debug("number after method->factor: " + Arrays.toString(number));
        int pz = 0;
        for (int i = 5; i < (number.length - 1); i++) {
            int o = number[i];
            pz += o;
        }

        pz = this.modulus11(pz);

        return this.checkPz(pz, number);
    }

    @Override
    protected int[] factor(int[] number, int[] weighting) {
        log.debug("number:" + Arrays.toString(number));
        log.debug("weighting:" + Arrays.toString(weighting));
        int[] tmp = new int[4];
        int tmpI = 0;
        for (int i = 5; i < number.length - 1; i++) {
            tmp[tmpI++] = number[i];

        }
        tmpI = 0;
        for (int i = tmp.length - 1; i != -1; i--) {
            int u = tmp[i];
            log.debug(u + " * " + weighting[tmpI]);
            tmp[i] *= weighting[tmpI++];
        }
        log.debug("tmp: " + Arrays.toString(tmp));
        tmpI = 0;

        log.debug("tmp 4-9: " + Arrays.toString(tmp));
        for (int i = 5; i < (number.length - 1); i++) {
            number[i] = tmp[tmpI++];
        }
        log.debug("number: " + Arrays.toString(number));
        return number;
    }

}
