package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.constants.DigitCheck;
import de.detecmedia.checkaccountnumber.converter.Weighting;
import org.apache.log4j.Logger;

import java.util.Arrays;

import static de.detecmedia.checkaccountnumber.calculator.Factory.factory;
import static de.detecmedia.checkaccountnumber.converter.Weighting.Weighting;

/**
 * Kennzeichen 00.
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2 Die Stellen der Kontonummer
 * sind von rechts nach links mit den Ziffern 2, 1, 2,1, 2 usw. zu
 * multiplizieren. Die jeweiligen Produkte werden addiert, nachdem jeweils aus
 * den zweistelligen Produkten die Quersumme gebildet wurde (z.B. Produkt 16 =
 * Quersumme 7). Nach der Addition bleiben außer der Einerstell. alle anderen
 * Stellen unberücksichtigt. Die Einerstelle wird von dem Wert 10 subtrahiert.
 * Das Ergebnis ist die Prüfziffer (10. Stelle der Kontonummer).<br>
 * Ergibt sich nach der Subtra ktion der Rest 10, ist die Prüfziffer 0.
 * <p>
 * <b>Testkontonummern:</b> 9290701, 539290858 1501824, 1501832<br>
 * </p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method00 extends AbstractMethod {
    /**
     * define logger.
     */
    private static Logger log = Logger.getLogger(Method00.class);

    /**
     * test for method 00.
     *
     * @return boolean
     */
    @Override
    public boolean test() {
        return check(Weighting("2,1,2,1,2,1,2,1,2,1"));
    }

    /**
     * check .
     *
     * @param weighting weighting int array
     * @return boolean
     */
    protected boolean check(final Weighting weighting) {
        int[] number = expand(this.getAccountNumberArray());

        log.debug("number: " + Arrays.toString(number));
        // Stellen der Kontonummer sind von rechts nach
        // links mit den Ziffern 2, 1, 2, 1, 2 usw. zu multiplizieren.
        number = factory(number, weighting.getWeighting());

        int checkDigit = this.add(number);

        checkDigit = this.modulus10(checkDigit);
        if (checkDigit == DigitCheck.IS_10) {
            checkDigit = 0;
        }
        log.debug("checkDigit: " + checkDigit);
        log.debug(
                "last number of account number: "
                        + number[number.length - 1]);

        return checkPz(checkDigit, number);

    }

}
