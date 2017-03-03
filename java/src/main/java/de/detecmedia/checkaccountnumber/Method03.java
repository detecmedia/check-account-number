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
     * Logger for this Class
     */
    private static Logger log = Logger.getLogger(Method03.class);

    @Override
    public boolean test() {
        weighting = new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2, 1};
        return this.check(weighting);
    }

}
