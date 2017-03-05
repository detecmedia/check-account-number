package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.converter.Weighting;
import org.apache.log4j.Logger;

/**
 * Kennzeichen 04.
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 2, 3, 4
 * </p>
 * <p>
 * Die Berechnung erfolgt wie bei Verfahren 02.
 * </p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 * @see Method02
 */
public class Method04 extends Method02 {

    /**
     * define logger.
     */
    private static final Logger LOG = Logger.getLogger(Method04.class);

    /**
     * test method 04.
     *
     * @return boolean
     */
    @Override
    public boolean test() {
        LOG.debug("test mebtod 03");
        return this.check(Weighting.W_2_3_4_5_6_7_2_3_4);
    }
}
