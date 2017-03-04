package de.detecmedia.checkaccountnumber;

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

    private static Logger log = Logger.getLogger("de.detecmedia.ceckaccountnumber.Methode04");

    private int[] weighting;

    @Override
    public boolean test() {

        weighting = new int[]{2, 3, 4, 5, 6, 7, 2, 3, 4};

        return this.check(weighting);
    }

}
