package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.calculator.Factory;
import de.detecmedia.checkaccountnumber.converter.Weighting;
import org.apache.log4j.Logger;

import java.util.Arrays;

import static de.detecmedia.checkaccountnumber.calculator.Factory.factory;

/**
 * Kennzeichen 02.
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8, 9, 2
 * </p>
 * <p>
 * Die Stellen der Kontonummer sind von rechts nach links mit den Ziffern 2, 3,
 * 4, 5, 6, 7, 8, 9, 2 zu multiplizieren. Die jeweiligen Produkte werden
 * addiert. Die Summe ist durch 11 zu dividieren. Der verbleibende Rest wird vom
 * Divisor (11) subtrahiert. Das Ergebnis ist die Prüfziffer. Verbleibt nach
 * der Division durch 11 kein Rest, ist die Prüfziffer 0. Ergibt sich als Rest
 * 1, ist die Prüfziffer zweistellig und kann nicht verwendet werden. Die
 * Kontonummer ist dann nicht verwendbar.
 * </p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method02 extends AbstractMethod {
    /**
     * define class logger.
     */
    private static final Logger LOG = Logger.getLogger(Method02.class);

    /**
     * test method 02.
     *
     * @return boolean
     */
    @Override
    public boolean test() {
        return check(Weighting.Weighting("2,3,4,5,6,7,8,9,2"));
    }

    /**
     * check.
     *
     * @param weighting weighting array
     * @return boolean
     */
    protected boolean check(final Weighting weighting) {
        LOG.debug("factor: " + Arrays.toString(weighting.getWeighting()));
        int[] number = this.getAccountNumberArray();
        LOG.debug("number befor method->factor: " + Arrays.toString(number));
        number = factory(number, weighting);
        LOG.debug("number after method->factor: " + Arrays.toString(number));
        int pz = add(number, 0, number.length - 1);

        pz = this.modulus11(pz);

        return this.checkPz(pz, number);
    }

    /**
     * addition.
     *
     * @param number account number array
     * @param start  start pos
     * @param end    end pos
     * @return int
     */
    @Override
    protected int add(final int[] number, final int start, final int end) {
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
