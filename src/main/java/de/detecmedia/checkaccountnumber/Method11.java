/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.detecmedia.checkaccountnumber;

import org.apache.log4j.Logger;

/**
 * Kennzeichen 11
 * .<p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8, 9, 10 (modifiziert)</p>
 * <p>
 * Die Berechnung erfolgt wie bei Verfahren06. Beim Rechenergebnis 10 wird die
 * Null(0) jedoch durch eine 9 ersetzt.</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method11 extends Method06 {

    private static Logger log = Logger.getLogger(Method11.class);

    @Override
    public boolean test() {
        weighting = new int[]{2, 3, 4, 5, 6, 7, 2, 3, 4, 5, 6, 7};
        return this.check(weighting);

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
            return 9;
        }
        pz = 11 - pz;
        log.debug("pz all: " + pz);
        return pz;
    }

}
