package de.detecmedia.checkaccountnumber;

import static de.detecmedia.checkaccountnumber.converter.Weighting.Weighting;

import de.detecmedia.checkaccountnumber.converter.Weighting;
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

    private static final Logger LOG = Logger.getLogger(Method06.class);


    /**
     * test medthod 06
     *
     * @return
     */
    @Override
    public boolean test() {
        LOG.debug("test mebtod 06");
        // return check(Weighting.W_);
        return check(Weighting("2,3,4,5,6,7,2,3,4,5,6,7"));

    }

    /**
     * check
     *
     * @param weighting weighting array
     * @return
     */

    public boolean check(final Weighting weighting) {
        int[] number = this.getAccountNumberArray();

        number = this.factor(number, weighting.getWeighting());

        int pz = this.add(number);

        pz = modulus11(pz);

        return this.checkPz(pz, number);
    }

    @Override
    protected int modulus11(int pz) {
        pz %= 11;
        LOG.debug("%11: " + pz);
        if (pz == 0) {
            LOG.debug("pz 0: " + pz);
            return 0;
        }
        if (pz == 1) {
            LOG.debug("pz 1: " + pz);
            return 0;
        }
        pz = 11 - pz;
        pz %= 10;
        LOG.debug("pz all: " + pz);
        return pz;
    }

    @Override
    protected int add(int[] number) {
        return add(number, 0, number.length - 1);
    }

    @Override
    protected int add(int[] number, int start, int end) {
        LOG.debug(start + " to " + end);
        int pz = 0;
        for (int i = start; i < end; i++) {
            LOG.debug("+" + number[i]);
            int o = number[i];
            pz += o;
        }
        LOG.debug("after add: " + pz);
        return pz;
    }

}
