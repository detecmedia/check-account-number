package de.detecmedia.checkaccountnumber;

import org.apache.log4j.Logger;

/**
 * Kennzeichen 03.
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2
 * </p>
 * <p>
 * Die Berechnung erfolgt wie bei Verfahren 01.
 * </p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 * @see Method01
 */
public class Method03 extends Method01 {

    /**
     * Logger for this Class.
     */
    private static final Logger LOG = Logger.getLogger(Method03.class);

    /**
     * test method 03.
     *
     * @return boolean
     */
    @Override
    public boolean test() {
        LOG.debug("test mebtod 03");
        return this.check(WEIGHTING_2_1_2_1_2_1_2_1_2_1);
    }

}
