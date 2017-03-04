package de.detecmedia.checkaccountnumber;

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

    private static Logger log = Logger.getLogger("de.detecmedia.ceckaccountnumber.Methode05");

    @Override

    public boolean test() {
        weighting = new int[]{7, 3, 1, 7, 3, 1, 7, 3, 1};
        return this.check(weighting);
    }

}
