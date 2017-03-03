package de.detecmedia.checkaccountnumber;

import java.util.Arrays;
import org.apache.log4j.Logger;

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

    private static Logger log = Logger.getLogger(Method00.class);

    @Override
    public boolean test() {

        weighting = new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2, 1};
        return check(weighting);

    }

    protected boolean check(int[] weighting) {
        int[] number = expand(this.getAccountNumberArray());

        log.debug("number: " + Arrays.toString(number));
        // Stellen der Kontonummer sind von rechts nach links mit den Ziffern 2, 1, 2, 1, 2 usw. zu multiplizieren.
        number = this.factor(number, weighting);

        int pz = this.add(number);

        pz = this.modulus10(pz);
        if (pz == 10) {
            pz = 0;
        }
        log.debug("pz: " + pz);
        log.debug("last number of account number: " + number[number.length - 1]);

        return checkPz(pz, number);

    }

}
