package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.exception.AccountNumberLenghtException;

import java.util.Arrays;

import org.apache.log4j.Logger;

/**
 * Kennzeichen 24.
 * <p>
 * Modulus 11, Gewichtung 1, 2, 3, 1, 2, 3, 1, 2, 3</p>
 * <p>
 * Die für die Berechnung relevanten Stellen der Kontonummer befinden sich -
 * von links nach rechts gelesen - in den Stellen 1 - 9; die Prüfziffer in
 * Stelle 10. Die Kontonummer ist rechtsbündig zu interpretieren und ggf. mit
 * Nullen aufzufüllen. Die einzelnen Ziffern der Kontonummer sind, beginnend
 * mit der ersten Ziffer ungleich 0, von links nach rechts bis einschließlich
 * Stelle 9 mit den o. g. Gewichtungsfaktoren zu multiplizieren. Zum jeweiligen
 * Produkt ist der zugehörige Gewichtungsfaktor zu addieren (zum ersten Produkt
 * +1, zum zweiten +2, zum dritten +3, zum Vierten +1 usw.). Das jeweilige
 * Ergebnis ist durch 11 zu dividieren (5 : 11 = 0 Rest 5). Die sich aus der
 * Division ergebenden Reste sind zu summieren. Die letzte Ziffer dieser Summe
 * ist die Prüfziffer.</p><p>
 * Ausnahmen:</p><p>
 * 1) Eine ggf. in Stelle 1 vorhandene Ziffer 3, 4, 5 oder 6 wird als 0
 * gewertet. Der o. g. Prüfalgorithmus greift erst ab der ersten Stelle
 * ungleich 0. </p><p>
 * 2) Eine ggf. in Stelle 1 vorhandene Ziffer 9 wird als 0 gewertet und führt
 * dazu, dass auch die beiden nachfolgenden Ziffern in den Stellen 2 und 3 der
 * Kontonummer als 0 gewertet werden müssen. Der o. g. Prüfalgorithmus greift
 * in diesem Fall also erst ab Stelle 4 der 10stelligen Kontonummer. Die Stelle
 * 4 ist ungleich 0.</p><p>
 * Beispiele:</p>
 * <pre>
 * Stellennr.:             1  2  3  4  5  6  7  8  9  10
 * Kontonr.:                           1  3  8  3  0  1
 * Ktonr. umgesetzt:       0  0  0  0  1  3  8  3  0
 * Gewichtung:                         1  2  3  1  2
 *                        --------------------------
 *                                     1  6 24  3  0
 * Gewich- tungsfaktor                 1  2  3  1  2
 *                                   ---------------
 *                                     2 +8+27 +4 +2 = 21
 *                                          --
 *                                          11          1 = Prüfziffer
 *                                          R5
 * </pre>
 * <pre>
 * Stellennr.:             1  2  3  4  5  6  7  8  9  10
 * Kontonr.:               1  3  0  6  1  1  8  6  0   5
 * Gewichtung:             1  2  3  1  2  3  1  2  3
 *                        --------------------------
 *                         1  6  0  6  2  3  8 12  0
 * Gewichtungsfaktor       1  2  3  1  2  3  1  2  3
 *                        --------------------------
 *                         2 +8 +3 +7 +4 +6 +9+14 +3 = 45
 *                                             --
 *                                             11    5 = Prüfziffer
 *                                             R3
 * ￼
 * ￼</pre>
 * <pre>
 * Stellennr.:             1  2  3  4  5  6  7  8  9  10
 * Kontonr.:               3  3  0  7  1  1  8  6  0   8
 * Ktonr. umgesetzt:       0  3  0  7  1  1  8  6  0
 * Gewichtung:                1  2  3  1  2  3  1  2
 *                        --------------------------
 *                            3  0 21  1  2 24  6  0
 * Gewichtungsfaktor          1  2  3  1  2  3  1  2
 *                        --------------------------
 *                            4+ 2+24+ 2+ 4+27+ 7+ 2 = 28
 *                                 --       --
 *                                 11       11       8 = Prüfziffer
 *                                 R2       R5
 *
 * ￼
 * ￼
 *
 * Stellennr.:             1  2  3  4  5  6  7  8  9  10
 * Kontonr.:               9  3  0  7  1  1  8  6  0   3
 * Ktonr. umgesetzt:       0  0  0  7  1  1  8  6  0
 * Gewichtung:                      1  2  3  1  2  3
 *                                 -----------------
 *                                  7  2  3  8 12  0
 *  Gewichtungsfaktor               1  2  3  1  2  3
 *                                 -----------------
 *                                  8+ 4+ 6+ 9+14+ 3 = 33
 *                                              --
 *                                              11   3 = Prüfziffer
 *                                              R3
 *
 * </pre>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method24 extends AbstractMethod {
    /**
     * weighting.
     */
    private int[] weighting;
    /**
     * deefine logger.
     */
    private Logger log = Logger.getLogger(Method24.class);

    /**
     * test for method 24.
     *
     * @return boolean
     */
    @Override
    public boolean test() {
        if (this.getAccountNumberArray().length != ACCOUNT_NUMBER_LEGHT_10) {
            throw new AccountNumberLenghtException();
        }
        int[] number = this.getAccountNumberArray();
        weighting = new int[]{1, 2, 3, 1, 2, 3, 1, 2, 3};
        number = this.factor(number, weighting);
        int pz = this.add(number, weighting) % MODULUS_10;
        return this.checkPz(pz, number);
    }

    /**
     *
     * @param number    int[] AccountNumber
     * @param weighting weighting
     * @return int array
     */
    @Override
    protected int[] factor(int[] number, int[] weighting) {
        log.debug("Number: " + Arrays.toString(number));
        log.debug("weighting: " + Arrays.toString(weighting));

        if (number[0] == 3
                || number[0] == 4
                || number[0] == 5
                || number[0] == 6) {
            number[0] = 0;
        }

        if (number[0] == 9) {
            number[0] = 0;
            number[1] = 0;
            number[2] = 0;
        }
        boolean online = false;
        int factorI = 0;
        for (int i = 0; i < number.length - 1; i++) {
            int o = number[i];
            if (online || o != 0) {
                log.debug(number[i] + " * " + weighting[factorI]);
                online = true;
                number[i] *= weighting[factorI++];
                log.debug(number[i]);
            }
        }
        return number;
    }

    protected int add(int[] number, int[] weighting) {
        int pz = 0;
        log.debug("Number: " + Arrays.toString(number));
        log.debug("weighting: " + Arrays.toString(weighting));
        boolean online = false;
        int factorI = 0;
        for (int i = 0; i < number.length - 1; i++) {
            int o = number[i];
            if (online || o != 0) {
                log.debug(number[i] + " + " + weighting[factorI]);
                online = true;
                log.debug((number[i] + weighting[factorI]) % 11);
                pz += (number[i] + weighting[factorI++]) % 11;
                log.debug(pz);
            }
        }
        return pz;
    }

}
