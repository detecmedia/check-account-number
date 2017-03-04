package de.detecmedia.checkaccountnumber;

import java.util.Arrays;

import org.apache.log4j.Logger;

/**
 * Kennzeichen D1.
 * <p>
 * gültig seit 08.09.2008</p>
 * <p>
 * zuletzt geändert zum 04.03.2013</p>
 * <p>
 * Modulus 10, Gewichtung 1, 2, 1, 2, 1, 2, 1, 2</p>
 * <p>
 * Die Kontonummer ist 10-stellig, ggf. ist die Kontonummer für die
 * Prüfzifferberechnung durch linksbündige Auffüllung mit Nullen 10-stellig
 * darzustellen. Die 10. Stelle der Konto- nummer ist die Prüfziffer.</p>
 * <p>
 * Kontonummern, die an der 1. Stelle von links der 10-stelligen Kontonummer den
 * Wert 8 beinhalten sind falsch.</p>
 * <p>
 * Kontonummern, die an der 1. Stelle von links der 10-stelligen Kontonummer
 * einen der Werte 0, 1, 2, 3, 4, 5, 6, 7 oder 9 beinhalten sind wie folgt zu
 * prüfen:</p>
 * <p>
 * Für die Berechnung der Prüfziffer werden die Stellen 2 bis 9 der
 * Kontonummer von links verwendet. Diese Stellen sind links um eine Zahl
 * (Konstante) gemäß der folgenden Tabelle zu ergänzen.</p>
 * <pre>
 * 1. Stelle von links der 10-|     Zahl (Konstante)
 * stelligen Kontonummer      |
 * ---------------------------+-------------------------
 *          0                 |     4363380
 *          1                 |     4363381
 *          2                 |     4363382
 *          3                 |     4363383
 *          4                 |     4363384
 *          5                 |     4363385
 *          6                 |     4363386
 *          7                 |     4363387
 *          9                 |     4363389
 * </pre>
 * <p>
 * <p>
 * Die Berechnung und mögliche Ergebnisse entsprechen der Methode 00.</p>
 * <pre>
 * Beispiel:
 * Kontonummer:                             3002000027
 * Stellen 2 bis 9:                          00200002
 * Ergänzt um Konstante (15 Stellen): 436338300200002
 *
 * 15 Stellen: 4  3  6  3  3  8  3  0  0  2  0  0  0  0  2
 * Gewichtung: 2  1  2  1  2  1  2  1  2  1  2  1  2  1  2
 *             -------------------------------------------
 * Produkt     8  3 12  3  6  8  6  0  0  2  0  0  0  0  4
 * Quersumme   8  3  3  3  6  8  6  0  0  2  0  0  0  0  4
 *
 * Summe = 43
 * 10 - 3 (Einerstelle) = 7 = Prüfziffer
 *
 * Testkontonummern (richtig):  0082012203, 1452683581, 2129642505, 3002000027,
 *                              4230001407, 5000065514, 6001526215, 7126502149,
 *                              9000430223
 *
 * Testkontonummern (falsch):   0000260986, 1062813622, 2256412314, 3012084101,
 *                              4006003027, 5814500990, 6128462594, 7000062035,
 *                              8003306026, 9000641509
 * </pre>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodD1
        extends AbstractMethod {

    private int[] accountNumberArray;

    private final Logger log = Logger.getLogger(MethodD1.class);

    @Override
    public boolean test() {
        int[] constante = new int[10];

        constante[0] = 4363380;
        constante[1] = 4363381;
        constante[2] = 4363382;
        constante[3] = 4363383;
        constante[4] = 4363384;
        constante[5] = 4363385;
        constante[6] = 4363386;
        constante[7] = 4363387;
        constante[8] = 0;
        constante[9] = 4363389;

        int[] number = this.getAccountNumberArray();
        number = expand(number);
        log.debug("number " + Arrays.toString(number));
        number = expand(number);
        String firstStr = String.valueOf(constante[number[0]]);
        this.setAccountNumber(firstStr.concat(this.accountNumber.substring(1)));

        log.debug("new accountnumner: " + Arrays.toString(this.getAccountNumberArray()));
        weighting = new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2};
        try {
            number = factor(this.getAccountNumberArray().clone(), weighting, 1, 15);
        } catch (java.lang.ArrayIndexOutOfBoundsException ex) {
            return false;
        }
        int pz = add(number, 0, 15);
        pz = modulus10(pz);
        log.debug("pz = " + pz);
        return checkPz(pz, this.getAccountNumberArray().clone(), 16);

    }

    @Override
    protected int[] getAccountNumberArray() {

        int lengthOfAccountNumber = accountNumber.length();
        int[] value = new int[lengthOfAccountNumber];
        log.debug("length of accountNumber: " + lengthOfAccountNumber);
        for (int i = 0; i < value.length; i++) {
            log.debug("Char at Pos " + i + " is " + accountNumber.charAt(i));
            value[i] = accountNumber.charAt(i) - '0';
        }
        this.accountNumberArray = value;

        return this.accountNumberArray;
    }

}
