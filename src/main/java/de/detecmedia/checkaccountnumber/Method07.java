package de.detecmedia.checkaccountnumber;

import org.apache.log4j.Logger;

/**
 * Kennzeichen 07
 * .<p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8, 9, 10</p>
 * <p>
 * Die Berechnung erfolgt wie bei Verfahren 02.</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 * @see Method02
 */
public class Method07 extends Method02 {

    private static Logger log = Logger.getLogger(Method07.class);

    @Override
    public boolean test() {
        weighting = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10};
        return this.check(weighting);
    }

}
