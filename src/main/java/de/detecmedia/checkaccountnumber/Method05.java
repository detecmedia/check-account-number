package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.converter.Weighting;
import org.apache.log4j.Logger;

/**
 * Kennzeichen 05.
 * <p>
 * Modulus 10, Gewichtung 7, 3, 1, 7, 3, 1, 7, 3, 1 </p>
 * <p>
 * Die erechnung erfolgt wie bei Verfahren 01.</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 * @see Method01
 */
public class Method05 extends Method01 {

    /**
     * define logger.
     */
    private static final Logger LOG = Logger.getLogger(Method05.class);

    /**
     * test method 05.
     *
     * @return boolean
     */
    @Override
    public boolean test() {
        LOG.debug("test mebtod 05");
        return this.check(Weighting.W_7_3_1_7_3_1_7_3_1);
    }
}
