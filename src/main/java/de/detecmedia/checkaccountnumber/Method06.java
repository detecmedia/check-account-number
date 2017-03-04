package de.detecmedia.checkaccountnumber;

import org.apache.log4j.Logger;

/**
 * Kennzeichen 06.
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7 (modifiziert)</p>
 * <p>
 * Die einzelnen Stellen der Kontonummer sind von rechts nach links mit den
 * Ziffern 2, 3, 4, 5, 6, 7, 2, 3 ff. zu multiplizieren. Die jeweiligen Produkte
 * werden addiert. Die Summe ist durch 11 zu dividieren. Der verbleibende Rest
 * wird vom Divisor (11) subtrahiert. Das Ergebnis ist die Prüfziffer. Ergibt
 * sich als Rest 1, findet von dem Rechenergebnis 10 nur die Einerstelle (0) als
 * Prüfziffer Verwendung. Verbleibt nach der Division durch 11 kein Rest, dann
 * ist auch die Prüfziffer 0. Die Stelle 10 der Kontonummer ist die
 * Prüfziffer.</p>
 * <p>
 * Testkontonummern: 94012341, 5073321010</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method06 extends AbstractMethod {

    private static Logger log = Logger.getLogger(Method06.class);

    private int[] weighting;

    @Override
    public boolean test() {
        weighting = new int[]{2, 3, 4, 5, 6, 7, 2, 3, 4, 5, 6, 7};
        return check(weighting);
    }

    public boolean check(int[] weighting) {

        int[] number = this.getAccountNumberArray();

        number = this.factor(number, weighting);

        int pz = this.add(number);

        pz = modulus11(pz);

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
            log.debug("pz 1: " + pz);
            return 0;
        }
        pz = 11 - pz;
        pz %= 10;
        log.debug("pz all: " + pz);
        return pz;
    }

    @Override
    protected int add(int[] number) {
        return add(number, 0, number.length - 1);
    }

    @Override
    protected int add(int[] number, int start, int end) {
        log.debug(start + " to " + end);
        int pz = 0;
        for (int i = start; i < end; i++) {
            log.debug("+" + number[i]);
            int o = number[i];
            pz += o;
        }
        log.debug("after add: " + pz);
        return pz;
    }

}
