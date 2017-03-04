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
     * Logger for this class
     */
    private static Logger log = Logger.getLogger(Method01.class);

    private int[] weighting;

    @Override
    public boolean test() {
        weighting = new int[]{3, 7, 1, 3, 7, 1, 3, 7, 1, 3, 7, 1};
        return this.check(weighting);
    }

    protected boolean check(int[] weighting) {
        int[] number = this.getAccountNumberArray();

        number = this.factor(number, weighting);

        int pz = add(number);

        pz = modulus10(pz);
        log.debug("pz to number = " + pz + " to " + number[number.length - 1]);
        return checkPz(pz, number);
    }

    @Override
    protected int add(int[] number, int start, int end) {
        log.debug(start + " to " + end);
        int pz = 0;
        for (int i = start--; i < end; i++) {

            int o = number[i];
            log.debug("+" + o);
            pz += o;
        }
        log.debug("after add: " + pz);
        return pz;
    }

}
