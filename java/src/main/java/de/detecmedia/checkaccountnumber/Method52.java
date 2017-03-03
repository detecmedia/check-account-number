package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.exception.InvalidBankCodeException;
import java.util.Arrays;
import org.apache.log4j.Logger;

/**
 * Kennzeichen 52.
 * <p>
 * Modulus 11, Gewichtung 2, 4, 8, 5, 10, 9, 7, 3, 6, 1, 2, 4</p>
 * <p>
 * Zur Berechnung der Prüfziffer muss zunächst aus der angegebenen
 * Bankleitzahl und der angegebenen achtstelligen Kontonummer die zugehörige
 * Kontonummer des ESER-Altsystems (maximal 12-stellig) ermittelt werden. Die
 * einzelnen Stellen dieser Alt-Kontonummer sind von rechts nach links mit den
 * Ziffern 2, 4, 8, 5, 10, 9, 7, 3, 6, 1, 2, 4 zu multiplizieren. Dabei ist für
 * die Prüfziffer, die sich immer an der 6. Stelle von links der
 * Alt-Kontonummer befindet, 0 zu setzen. Die jeweiligen Produkte werden addiert
 * und die Summe durch 11 dividiert. Zum Divisionsrest (ggf. auch 0) ist das
 * Gewicht oder ein Vielfaches des Gewichtes über der Prüfziffer zu addieren.
 * Die Summe wird durch 11 dividiert; der Divisionsrest muss 10 lauten. Die
 * Prüfziffer ist der verwendete Faktor des Gewichtes. Kann bei der Division
 * kein Rest 10 erreicht werden, ist die Konto-Nr. nicht verwendbar. Bildung der
 * Konto-Nr. des ESER-Altsystems aus angegebener Bankleitzahl und Konto-Nr.:</p>
 * <pre>
 * BLZ            Konto-Nr.
 * XXX5XXXX       XPXXXXXX        (P = Prüfziffer)
 * </pre>
 * <p>
 * Kontonummer des Altsystems:</p>
 * <pre>
 * XXXX-XP-XXXXX            (XXXX = variable Länge,
 *                           da evtl. vorlaufende Nullen elimi-
 *                           niert werden)
 * </pre>
 * <p>
 * Beispiel:</p>
 * <pre>
 * BLZ                Konto-Nr.
 * 13051172           4P001500
 * </pre>
 * <p>
 *
 * Konto-Nr. Altsystem (Multiplikation mit Gewichten) </p>
 * <pre>
 *       1  1  7  2  -  4  P  -  1  5  0  0
 *       *  *  *  *     *  *     *  *  *  *
 *       1  6  3  7     9  10    5  8  4  2
 *       ----------------------------------
 *       1 +6+21+14   +36 +0    +5+40 +0 +0 = 123
 *
 * 123 : 11 = 11 Rest 2
 *
 * 2+0x10= 2:11=0   Rest 2          (10 = Gewicht über der Prüf- ziffer)
 * 2+1x10=12:11=1   Rest 1
 * 2+2x10=22:11=2   Rest 0
 * 2+3x10=32:11=2   Rest 10
 *
 *
 * Die Prüfziffer lautet 3.
 * </pre>
 * <p>
 * Bei 10-stelligen, mit 9 beginnenden Kontonummern ist die Prüfziffer nach
 * Verfahren 20 zu berechnen.</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method52 extends AbstractMethod {

    private static final Logger log = Logger.getLogger(Method52.class);

    public boolean check(int[] weighting) {

        int[] number = this.getAccountNumberArray();
        int numberPz = number[5];
        number[5] = 0;
        number = factor(number, weighting, 1, number.length);
        int pz = add(number, 0, number.length);
        int tmp = pz % 11;
        log.debug("tmp : " + tmp);
        int i = 0;
        
        do {
            log.debug("tmp : " + tmp);
            pz = (tmp + i * 10) % 11;
            if (pz != 10) {
                i++;
            }

            log.debug("pz: " + pz);
        } while (pz != 10);
        number[5] = numberPz;
        log.debug("i: " + i);
        if (checkPz(i, number, 6)) {
            return true;
        }

        if (number.length == 10 && number[0] == 9) {
            return checkMethod20();
        }
        return false;
    }

    @Override
    protected int add(int[] number, int start, int end) {
        log.debug(start + " to " + end);
        int pz = 0;
        for (int i = start--; i < end; i++) {
            int o = number[i];
            log.debug("+" + number[i]);
            pz += o;
        }
        log.debug("after add: " + pz);
        return pz;
    }

    protected boolean checkMethod20() {
        Method20 method20 = new Method20();
        method20.setAccountNumber(accountNumber);
        return method20.test();
    }

    @Override
    public boolean test() {
        weighting = new int[]{2, 4, 8, 5, 10, 9, 7, 3, 6, 1, 2, 4};
        return this.check(weighting);

    }

    @Override
    protected int[] factor(int[] number, int[] weighting, int start, int end) {

        start--;
        log.debug("start: " + start);
        log.debug("end: " + end);
        log.debug("tmp array:" + (end - start));
        int[] tmp = new int[(end - start)];
        log.debug("tmp.lenght " + tmp.length);
        //end--;
        log.debug("number:" + Arrays.toString(number));
        log.debug("weighting:" + Arrays.toString(weighting));

        int tmpI = 0;
        for (int i = start; i < end; i++) {

            tmp[tmpI] = number[i];

            tmpI++;

        }
        tmpI = 0;
        for (int i = tmp.length - 1; i != -1; i--) {
            int u = tmp[i];
            if (tmpI < weighting.length) {
                log.debug(u + " * " + weighting[tmpI]);
                tmp[i] *= weighting[tmpI];
                tmpI++;
            }
        }
        log.debug("tmp: " + Arrays.toString(tmp));
        tmpI = 0;

        log.debug("tmp " + start + "-" + end + ": " + Arrays.toString(tmp));
        for (int i = start; i < end; i++) {
            number[i] = tmp[tmpI++];
        }
        log.debug("number: " + Arrays.toString(number));
        return number;
    }

}
