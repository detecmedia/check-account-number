package de.detecmedia.checkaccountnumber;

import org.apache.log4j.Logger;

/**
 * Kennzeichen 08
 * .<p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2 (modifiziert) </p><p>
 * Die Berechnung erfolgt wie bei Verfahren 00, jedoch erst ab der Kontonummer
 * 60 000.</p>
 *
 * @author Markus Potthast
 */
public class Method08 extends Method00 {

    private static Logger log = Logger.getLogger(Method08.class);

    @Override
    public boolean test() {
        if (Integer.valueOf(accountNumber).intValue() < 60000) {
            log.debug("accountnumber < 60000");
            return false;
        }
        return super.test();
    }

}
