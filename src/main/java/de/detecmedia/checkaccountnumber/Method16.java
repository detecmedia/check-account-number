package de.detecmedia.checkaccountnumber;

import org.apache.log4j.Logger;

/**
 * Kennzeichen 16.
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 2, 3, 4 </p><p>
 * Die Berechnung erfolgt wie bei Verfahren06. Sollte sich jedoch nach der
 * Division der Rest 1 ergeben, so ist die Kontonummer unabhängig vom
 * eigentlichen Berechnungs- ergebnis richtig, wenn die Ziffern an 10. und 9.
 * Stelle identisch sind.</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method16 extends Method06 {

    private static Logger log = Logger.getLogger(Method16.class);

    private int[] weighting;

    @Override
    public boolean test() {
        weighting = new int[]{2, 3, 4, 5, 6, 7, 2, 3, 4};
        if (this.check(weighting)) {
            return true;
        }

        return false;
    }

    @Override
    public boolean check(int[] weighting) {

        int[] number = this.getAccountNumberArray();

        number = this.factor(number, weighting);

        int pz = 0;
        for (int i = 0; i < (number.length - 1); i++) {
            int o = number[i];
            pz += o;
        }

        pz = modulus11(pz);

        if (pz == 1 && (number[8] == number[9])) {
            return true;
        }

        return this.checkPz(pz, number);
    }

    @Override
    protected int modulus11(int pz) {
        pz %= 11;
        log.debug("%11: " + pz);
        if (pz == 0) {
            log.debug("pz 0: " + pz);
            return 0;
        }
        if (pz == 1) {
            return 1;
        }
        pz = 11 - pz;
        log.debug("pz all: " + pz);
        return pz;
    }

}
