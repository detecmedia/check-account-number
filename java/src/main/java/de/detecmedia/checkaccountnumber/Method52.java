package de.detecmedia.checkaccountnumber;

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
 * <p>
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
    /**
     * define logger.
     */
    private static final Logger LOG = Logger.getLogger(Method52.class);
    /**
     * Check digit.
     */
    private static final int CHECKDIGIT = 5;
    /**
     * MODULAR.
     */
    private static final int MODULAR11 = 11;
    /**
     * START is 0.
     */
    private static final int START = 0;
    /**
     * FACTOR = 10.
     */
    private static final int FACTOR = 10;
    /**
     * start positon from check.
     */
    private static final int CHECKSTARTPOS = 6;

    /**
     * Set first 9.
     */
    private static final int FIRSTNUMBER = 9;

    /**
     * Weighting.
     */
    private static final int[] WEIGHING =
            new int[]{2, 4, 8, 5, 10, 9, 7, 3, 6, 1, 2, 4};

    /**
     * check.
     *
     * @param weighting weithing array
     * @return boolean
     */
    public boolean check(final int[] weighting) {

        int[] number = this.getAccountNumberArray();
        int numberPz = number[CHECKDIGIT];
        number[CHECKDIGIT] = 0;
        number = factor(number, weighting, 1, number.length);
        int pz = add(number, START, number.length);
        int tmp = pz % MODULAR11;
        LOG.debug("tmp : " + tmp);
        int i = 0;

        do {
            LOG.debug("tmp : " + tmp);
            pz = (tmp + i * FACTOR) % MODULAR11;
            if (pz != FACTOR) {
                i++;
            }

            LOG.debug("pz: " + pz);
        } while (pz != FACTOR);

        number[CHECKDIGIT] = numberPz;
        LOG.debug("i: " + i);

        return checkPz(i, number, CHECKSTARTPOS)
                || number.length == FACTOR
                && number[0] == FIRSTNUMBER
                && checkMethod20();

    }

    /**
     * Override add.
     *
     * @param number number array
     * @param start  start pos
     * @param end    end pos
     * @return int[]
     */
    @Override
    protected int add(final int[] number, final int start, final int end) {
        LOG.debug(start + " to " + end);
        int pz = 0;
        for (int i = start; i < end; i++) {
            int o = number[i];
            LOG.debug("+" + number[i]);
            pz += o;
        }
        LOG.debug("after add: " + pz);
        return pz;
    }

    /**
     * use method 20.
     *
     * @return boolean
     */
    protected boolean checkMethod20() {
        Method20 method20 = new Method20();
        method20.setAccountNumber(accountNumber);
        return method20.test();
    }

    /**
     * test from method 52.
     * @return boolean
     */
    @Override
    public boolean test() {
        return this.check(WEIGHING);
    }

    /**
     * override factor for method 52.
     * @param number number array
     * @param weighting weighting
     * @param start start pos
     * @param end end pos
     * @return int[]
     */
    @Override
    protected int[] factor(
            final int[] number,
            final int[] weighting,
            final int start,
            final int end
    ) {

        int startpos = start - 1;
        LOG.debug("start: " + startpos);
        LOG.debug("end: " + end);
        LOG.debug("tmp array:" + (end - startpos));
        int[] tmp = new int[(end - startpos)];
        LOG.debug("tmp.lenght " + tmp.length);
        //end--;
        LOG.debug("number:" + Arrays.toString(number));
        LOG.debug("weighting:" + Arrays.toString(weighting));

        int tmpI = 0;
        for (int i = startpos; i < end; i++) {
            tmp[tmpI] = number[i];
            tmpI++;
        }
        tmpI = 0;
        for (int i = tmp.length - 1; i != -1; i--) {
            int u = tmp[i];
            if (tmpI < weighting.length) {
                LOG.debug(u + " * " + weighting[tmpI]);
                tmp[i] *= weighting[tmpI];
                tmpI++;
            }
        }
        LOG.debug("tmp: " + Arrays.toString(tmp));
        tmpI = 0;

        LOG.debug("tmp " + startpos + "-" + end + ": " + Arrays.toString(tmp));
        for (int i = startpos; i < end; i++) {
            number[i] = tmp[tmpI++];
        }
        LOG.debug("number: " + Arrays.toString(number));
        return number;
    }

}
