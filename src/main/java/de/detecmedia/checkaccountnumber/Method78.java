package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.exception.AccountNumberLenghtException;
import org.apache.log4j.Logger;

/**
 * Kennzeichen 78.
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2</p>
 * <p>
 * Die Berechnung erfolgt wie bei Verfahren 00</p>
 * <p>
 * Ausnahme:</p>
 * <p>
 * 8-stellige Kontonummern sind nicht prüfbar, da diese Nummern keine
 * Prüfziffer enthalten.</p>
 * <p>
 * Testkontonummern: 7581499, 9999999981</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 * @see Method00
 */
public class Method78
        extends Method00 {

    private Logger log = Logger.getLogger(Method78.class);

    @Override
    public boolean test() {
        if (this.getAccountNumberArray().length == 8) {
            throw new AccountNumberLenghtException();
        }
        return super.test();
    }

}
