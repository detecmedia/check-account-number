package de.detecmedia.checkaccountnumber;

import org.apache.log4j.Logger;

/**
 * Kennzeichen 01.
 * <p>
 * Modulus 10, Gewichtung 3, 7, 1, 3, 7, 1, 3, 7, 1 <br>Die Stellen der
 * Kontonummer sind von rechts nach links mit den Ziffern 3, 7, 1, 3, 7, 1 usw.
 * zu multiplizieren. Die jeweiligen Produkte werden addiert.<br> Nach der
 * Addition bleiben außer der Einerstelle alle anderen Stellen
 * unberücksichtigt.</p><p>
 * Die Einerstelle wird von dem Wert 10 subtrahiert. Das Ergebnis ist die
 * Prüfziffer (10. Stelle der Kontonummer). Ergibt sich nach der Subtraktion
 * der Rest 10, ist die Prüfziffer 0.</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method01 extends AbstractMethod {

    /**
     * Logger for this class.
     */
    private static Logger log = Logger.getLogger(Method01.class);

    /**
     * test method 01.
     *
     * @return boolean
     */
    @Override
    public boolean test() {
        return this.check(WEIGHTING_3_7_1_3_7_1_3_7_1_3_7_1);
    }

    /**
     * check.
     *
     * @param weighting weighting array
     * @return boolean
     */
    protected boolean check(final int[] weighting) {
        int[] number = this.getAccountNumberArray();

        number = this.factor(number, weighting);

        int pz = add(number);

        pz = modulus10(pz);
        log.debug("pz to number = " + pz + " to " + number[number.length - 1]);
        return checkPz(pz, number);
    }

    /**
     * addition.
     * @param number account number array
     * @param start  start pos
     * @param end    end pos
     * @return int
     */
    @Override
    protected int add(final int[] number, final int start, final int end) {
        log.debug(start + " to " + end);
        int pz = 0;
        for (int i = start; i < end; i++) {

            int o = number[i];
            log.debug("+" + o);
            pz += o;
        }
        log.debug("after add: " + pz);
        return pz;
    }

}
