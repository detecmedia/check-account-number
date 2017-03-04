package de.detecmedia.checkaccountnumber;

import org.apache.log4j.Logger;
import de.detecmedia.checkaccountnumber.Method53;

/**
 *
 *
 */

/**
 * Kennzeichen 53.
 * <p>
 * TODO: fertig stellen Wird gebrauchr für die MEthode B6
 * Die Berechnung entspricht dem Verfahren 52, jedoch für neunstellige
 * Kontonummern.</p>
 * <p>
 * Bildung der Kontonummern des ESER-Altsystems aus angegebener Bankleitzahl und
 * angegebener neunstelliger Kontonummer:</p>
 * <pre>
 * BLZ              Konto-Nr.
 * XXX5XXXX         XTPXXXXXX       (P = Prüfziffer, T)
 * </pre>
 * <p>
 * Kontonummer des ESER-Altsystems:</p>
 * <pre>
 * XXTX-XP-XXXXXX              (XXXXXX = variable Länge, da
 *                              evtl. vorlaufende Nullen eliminiert werden)
 * </pre>
 * <p>
 * Beispiel:</p>
 * <pre>
 * BLZ           Konto-Nr.
 * 1605208       238P432256
 * </pre>
 * <p>
 * ￼
 * Konto-Nr. Altsystem (Multiplikation mit Gewichten) </p>
 * <pre>
 *           2  0  8  2  -  3  P  4  3  2  2  5  6
 *           *  *  *        *  *  *  *  *  *  *  *
 *           4  2  1  6     3  7  9 10  5  8  4  2
 *          --------------------------------------
 *           8+ 0+ 8+12+    9+ 0+36+30+10+16+20+12 = 161
 *
 * 161 : 11 = 14 Rest 7
 *
 * ￼
 * 7 + 0 x 7 =  7;   7 : 11 = 0     Rest 7      (Faktor7:Ge- wicht
 *                                              über der Prüfziffer)
 * 7 + 1 x 7 = 14;  14 : 11 = 1     Rest 3
 * 7 + 2 x 7 = 21;  21 : 11 = 1     Rest 10
 * </pre>
 * <p>
 * Die Prüfziffer lautet 2.</p><p>
 * Bei 10-stelligen, mit 9 beginnenden Kontonummern ist die Prüfziffer nach
 * Verfahren 20 zu berechnen.</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 * @see Method52
 * @see MethodB6
 */
public class Method53 extends Method52 {

    private final Logger log = Logger.getLogger(Method53.class);


    private int[] weighting;
    @Override
    public boolean test() {
        weighting = new int[]{2, 4, 8, 5, 10, 9, 7, 3, 6, 1, 2, 4};
        return this.check(weighting);
    }

    @Override
    public boolean check(int[] weighting) {

        int[] number = this.getAccountNumberArray();
        int pzNumber = number[5];
        number[5] = 0;
        number = factor(number, weighting, 1, number.length);

        int pz = add(number, 0, number.length);
        int tmp = pz % 11;
        log.debug("tmp : " + tmp);
        int i = 0;
        do {
            log.debug("tmp : " + tmp);
            pz = (tmp + i * 7) % 11;
            if (pz != 10) {
                i++;
            }

            log.debug("pz: " + pz);
        } while (pz != 10);
        log.debug("i: " + i);
        number[5] = pzNumber;
        if (checkPz(i, number, 6)) {
            return true;
        }

        if (number.length == 10 && number[0] == 9) {
            return checkMethod20();
        }
        return false;
    }

//    @Override
//    protected int[] factor(int[] number, int[] weighting, int start, int end) {
//
//        start--;
//        log.debug("start: " + start);
//        log.debug("end: " + end);
//        log.debug("tmp array:" + (end - start));
//        int[] tmp = new int[(end - start)];
//        log.debug("tmp.lenght " + tmp.length);
//        //end--;
//        log.debug("number:" + Arrays.toString(number));
//        log.debug("weighting:" + Arrays.toString(weighting));
//
//        int tmpI = 0;
//        for (int i = start; i < end; i++) {
//
//            tmp[tmpI] = number[i];
//
//            tmpI++;
//
//        }
//        tmpI = 0;
//        for (int i = tmp.length - 1; i != -1; i--) {
//            int u = tmp[i];
//            if (tmpI < weighting.length) {
//                int temp = tmp.length - 5;
//                if (i != tmp.length - temp) {
//                    log.debug(u + " * " + weighting[tmpI]);
//                    tmp[i] *= weighting[tmpI];
//                }
//                tmpI++;
//            }
//        }
//        log.debug("tmp: " + Arrays.toString(tmp));
//        tmpI = 0;
//
//        log.debug("tmp " + start + "-" + end + ": " + Arrays.toString(tmp));
//        for (int i = start; i < end; i++) {
//            number[i] = tmp[tmpI++];
//        }
//        log.debug("number: " + Arrays.toString(number));
//        return number;
//    }

//    @Override
//    protected int add(int[] number, int start, int end) {
//        log.debug(start + " to " + end);
//        int pz = 0;
//        for (int i = start--; i < end; i++) {
//            
//            int o = number[i];
//            
//            if (i != 5) {
//                pz += o;
//                log.debug("+" + number[i]);
//            } 
//        }
//        log.debug("after add: " + pz);
//        return pz;
//    }


}
