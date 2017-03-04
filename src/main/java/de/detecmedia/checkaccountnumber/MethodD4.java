package de.detecmedia.checkaccountnumber;

import java.util.Arrays;

import org.apache.log4j.Logger;

/**
 * Kennzeichen D4.
 * <p>
 * gültig seit 07.06.2010</p>
 * <p>
 * geändert zum 06.06.2011</p>
 * <p>
 * Modulus 10, Gewichtung 1, 2, 1, 2, 1, 2, 1, 2</p>
 * <p>
 * Die Kontonummer ist 10-stellig, ggf. ist die Kontonummer für die
 * Prüfziffernberechnung durch linksbündiges Auffüllung mit Nullen 10-stellig
 * darzustellen. Die 10. Stelle der Konto- nummer ist die Prüfziffer.</p>
 * <p>
 * Kontonummern, die an der 1. Stelle von links der 10-stelligen Kontonummer den
 * Wert 0 beinhalten, sind falsch. Kontonummern, die an der 1. Stelle von links
 * der 10-stelligen Kontonummer einen der Werte 1, 2, 3, 4, 5, 6, 7, 8 oder 9
 * beinhalten, sind wie folgt zu prüfen:</p>
 * <p>
 * Für die Berechnung der Prüfziffer werden die Stellen 1 bis 9 der
 * Kontonummer von links verwendet. Diese Stellen sind links um die Zahl
 * (Konstante) „428259“ zu ergänzen.</p>
 * <p>
 * Die Berechnung und mögliche Ergebnisse entsprechen der Methode 00.</p>
 * <pre>Beispiel:
 * Kontonummer:                             3000005012
 * Stellen 1 bis 9:                         300000501
 * Ergänzt um Konstante (15 Stellen): 428259300000501
 *
 * 15 Stellen   4  2  8  2  5  9  3  0  0  0  0  0  5  0  1
 * Gewichtung   2  1  2  1  2  1  2  1  2  1  2  1  2  1  2
 *             --------------------------------------------
 * Produkt      8  2 16  2 10  9  6  0  0  0  0  0 10  0  2
 * Quersumme    8+ 2+ 7+ 2+ 1+ 9+ 6+ 0+ 0+ 0+ 0+ 0+ 1+ 0+ 2 = 38
 *
 * 10 - 8 (Einerstelle) = 2 = Prüfziffer
 *
 * Testkontonummern (richtig):  1112048219, 2024601814,3000005012, 4143406984,
 *                              5926485111, 6286304975, 7900256617, 8102228628,
 *                              9002364588
 *
 * Testkontonummern (falsch):   0359432843, 1000062023, 2204271250, 3051681017,
 *                              4000123456, 5212744564, 6286420010, 7859103459,
 *                              8003306026, 9916524534
 * </pre>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodD4
        extends AbstractMethod {

    private Logger log = Logger.getLogger(MethodD4.class);

    @Override
    public boolean test() {
        int[] number = expand(this.getAccountNumberArray());
        if (number[0] == 0) {
            return false;
        }
        log.debug("number -> " + Arrays.toString(number));
        weighting = new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2};

        number = move(number);
        number = factor(number, weighting, 1, number.length - 1);
        int pz = add(number, 0, number.length - 1);
        pz = modulus10(pz);

        return checkPz(pz, number);
    }

    protected int[] move(int[] number) {
        int[] constante = new int[]{4, 2, 8, 2, 5, 9};
        int[] newNumber = new int[constante.length + number.length];
        for (int i = 0; i < newNumber.length; i++) {
            if (i < constante.length) {
                newNumber[i] = constante[i];
            } else {
                newNumber[i] = number[i - constante.length];
            }
        }
        log.debug("new Number = " + Arrays.toString(newNumber));
        return newNumber;
    }

}
