package de.detecmedia.checkaccountnumber.calculator;

import de.detecmedia.checkaccountnumber.exception.InvalidAcountNumberException;
import org.apache.log4j.Logger;

/**
 * checkaccountnumber
 * <p>
 * Created on 05.03.17.
 *
 * @author markus potthast markus.potthast@detecmedia.de
 * @version 1.0.0
 */
public class Modulus {

    private static Logger log = Logger.getLogger(Modulus.class);

    private static final int MODULUS_11 = 11;

    private static final int MINUEND_11 = 11;

    public static int Modulus11(int number) {
        int checkDigit;
        number %= MODULUS_11;

        log.debug("%11: " + number);
        if (number == 0) {
            log.debug("pz 0: " + number);
            return 0;
        }
        if (number == 1) {
            log.debug("InvalidException");
            throw new InvalidAcountNumberException();
        }
        checkDigit = MINUEND_11 - number;
        log.debug("pz all: " + checkDigit);
        return checkDigit;
    }

    public static int Modulus7(int number) {
        number = (number % 7);
        if (number == 0) {
            return 0;
        }
        return 7 - number;
    }
}
