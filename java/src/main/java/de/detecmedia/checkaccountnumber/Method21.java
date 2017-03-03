package de.detecmedia.checkaccountnumber;

import java.util.Arrays;
import org.apache.log4j.Logger;

/**
 * Kennzeichen 21.
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2 (modifiziert)</p><p>
 * Die Berechnung erfolgt wie bei Verfahren00. Nach der Addition der Produkte
 * werden neben der Einerstelle jedoch alle Stellen berücksichtigt, indem
 * solange Quersummen gebildet werden, bis ein einstelliger Wert verbleibt. Die
 * Differenz zwischen diesem Wert und dem Wert 10 ist die Prüfziffer.</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method21 extends Method00 {

    public Logger log = Logger.getLogger(Method21.class);

    @Override
    public boolean test() {
        weighting = new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2};
        return this.check(weighting);
    }

    protected int add(int[] number) {
        log.debug("Number: " + Arrays.toString(number));
        int pz = 0;
        for (int i = 0; i < (number.length - 1); i++) {
            int o = number[i];
            while (o > 9) {
                o = this.iterierteQuersumme(o);
                log.debug("quersumme von: " + number[i] + " " + o);
            }

            log.debug(pz += o);
        }
        return pz;
    }

}
