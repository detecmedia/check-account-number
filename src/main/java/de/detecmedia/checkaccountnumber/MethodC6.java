package de.detecmedia.checkaccountnumber;

import java.util.Arrays;

import org.apache.log4j.Logger;

/**
 * Kennzeichen C6.
 * <p>
 * gültig seit 03.09.2007,</p>
 * <p>
 * zuletzt geändert zum 04.03.2013</p>
 * <p>
 * Modulus 10, Gewichtung 1, 2, 1, 2, 1, 2, 1, 2</p>
 * <p>
 * Die Kontonummer ist 10-stellig, ggf. ist die Kontonummer für die
 * Prüfzifferberechnung durch linksbündige Auffüllung mit Nullen 10-stellig
 * darzustellen. Die 10. Stelle der Konto- nummer ist die Prüfziffer.</p>
 * <p>
 * Alle Kontonummern sind wie folgt zu prüfen:</p>
 * <p>
 * Für die Berechnung der Prüfziffer werden die Stellen 2 bis 9 der
 * Kontonummer von links verwendet. Diese Stellen sind links um eine Zahl
 * (Konstante) gemäß der folgenden Tabelle zu ergänzen.</p>
 * <p>
 * <pre>
 * 1. Stelle von links der 10-  |       Zahl (Konstante)
 * stelligen Kontonummer        |
 * -----------------------------+------------------------
 *          0                   |       4451970
 *          1                   |       4451981
 *          2                   |       4451992
 *          3                   |       4451993
 *          4                   |       4344992
 *          5                   |       4344990
 *          6                   |       4344991
 *          7                   |       5499570
 *          8                   |       4451994
 *          9                   |       5499579
 * </pre>
 * <p>
 * Die Berechnung und mögliche Ergebnisse entsprechen der Methode 00.
 * </p>
 * <pre>
 * Beispiel:
 * Kontonummer:                             7000005024
 * Stellen 2 bis 9:                          00000502
 * Ergänzt um Konstante (15 Stellen): 549957000000502
 *
 * 15Stellen  5  4  9  9  5  7  0  0  0  0  0  0  5  0  2  4(=P)
 * Gewichtung 2  1  2  1  2  1  2  1  2  1  2  1  2  1  2
 *            -------------------------------------------
 * Produkt   10  4 18  9 10  7  0  0  0  0  0  0 10  0  4
 * Quersumme 1+  4+ 9+ 9+ 1+ 7+ 0+ 0+ 0+ 0+ 0+ 0+ 1+ 0+ 4
 *
 * Summe = 36
 *
 * 10 - 6 (Einerstelle) = 4 = Prüfziffer
 * </pre>
 * <pre>
 * Testkontonummern (richtig):  0000065516, 0203178249, 1031405209, 1082012201,
 *                              2003455189, 2004001016, 3110150986, 3068459207,
 *                              5035105948, 5286102149, 4012660028, 4100235626,
 *                              6028426119, 6861001755, 7008199027, 7002000023,
 *                              8526080015, 8711072264, 9000430223, 9000781153
 *
 * Testkontonummern (falsch):   0525111212, 0091423614, 1082311275, 1000118821,
 *                              2004306518, 2016001206, 3462816371, 3622548632
 *                              4232300158, 4000456126, 5002684526, 5564123850,
 *                              6295473774, 6640806317, 7000062022, 7006003027,
 *                              8348300002, 8654216984, 9000641509, 9000260986
 * </pre>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodC6
        extends AbstractMethod {

    private int[] accountNumberArray;
    private final Logger log = Logger.getLogger(MethodC6.class);

    @Override
    public boolean test() {
        int[] constante = new int[10];
        constante[0] = 4451970;
        constante[1] = 4451981;
        constante[2] = 4451992;
        constante[3] = 4451993;
        constante[4] = 4344992;
        constante[5] = 4344990;
        constante[6] = 4344991;
        constante[7] = 5499570;
        constante[8] = 4451994;
        constante[9] = 5499579;

        int[] number = this.getAccountNumberArray();
        log.debug("number " + Arrays.toString(number));
        number = expand(number);
        String firstStr = String.valueOf(constante[number[0]]);
        this.setAccountNumber(firstStr.concat(this.accountNumber.substring(1)));

        log.debug("new accountnumner: " + Arrays.toString(this.getAccountNumberArray()));
        weighting = new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2};
        number = factor(this.getAccountNumberArray().clone(), weighting, 1, 15);
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
