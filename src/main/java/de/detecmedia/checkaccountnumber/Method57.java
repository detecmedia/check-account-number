package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.exception.InvalidAcountNumberException;

import java.util.Arrays;

import org.apache.log4j.Logger;

/**
 * Kennzeichen 57.
 * <p>
 * <b>zuletzt geändert zum 09.09.2013</b></p>
 * <p>
 * Die Kontonummer ist einschließlich der Prüfziffer 10-stellig, ggf. ist die
 * Kontonummer für die Prüfzifferberechnung durch linksbündige Auffüllung
 * mit Nullen 10-stellig darzustellen.</p>
 * <p>
 * Die Berechnung der Prüfziffer und die möglichen Ergebnisse richten sich
 * nach dem jeweils bei der entsprechenden Variante angegebenen
 * Kontonummernkreis. Führt die Berechnung der Prüfziffer nach der
 * vorgegebenen Variante zu einem Prüfzifferfehler, so ist die Kontonummer
 * ungültig.</p>
 * <p>
 * Kontonummern, die mit 00 beginnen sind immer als falsch zu bewerten.</p>
 * <p>
 * <b>Variante 1:</b></p>
 * <p>
 * Modulus 10, Gewichtung 1, 2, 1, 2, 1, 2, 1, 2, 1</p>
 * <p>
 * Anzuwenden ist dieses Verfahren für Kontonummern, die mit den folgenden
 * Zahlen beginnen:</p>
 * <p>
 * 51, 55, 61, 64, 65, 66, 70, 73 bis 82, 88, 94 und 95</p>
 * <p>
 * Die Stellen 1 bis 9 der Kontonummer sind von links beginnend mit den
 * Gewichten zu multiplizieren. Die 10. Stelle ist die Prüfziffer. Die
 * Berechnung und mögliche Ergebnisse entsprechen der Methode 00
 * .</p>
 * <pre>
 * Stellen-Nr.: 1 2 3 4 5 6 7 8 9 10
 * Konto-Nr.: X X X X X X X X X P Gewichtung 1
 * 2 1 2 1 2 1 2 1
 *
 * </pre>
 * <p>
 * Ausnahme: Kontonummern, die mit den Zahlen 777777 oder 888888 beginnen sind
 * immer als richtig (= Methode 09; keine Prüfzifferberechnung) zu
 * bewerten.</p>
 * <p>
 * <b>Variante 2:</b></p>
 * <p>
 * Modulus 10, Gewichtung 1, 2, 1, 2, 1, 2, 1, 2, 1</p>
 * <p>
 * Anzuwenden ist dieses Verfahren für Kontonummern, die mit den folgenden
 * Zahlen beginnen:</p>
 * <p>
 * 32 bis 39, 41 bis 49, 52, 53, 54, 56 bis 60, 62, 63, 67, 68, 69, 71, 72, 83
 * bis 87, 89, 90, 92, 93, 96, 97 und 98</p>
 * <p>
 * Die Stellen 1, 2, 4, 5, 6, 7, 8, 9 und 10 der Kontonummer sind von links
 * beginnend mit den Gewichten zu multiplizieren. Die 3. Stelle ist die
 * Prüfziffer. Die Berechnung und mögliche Ergebnisse entsprechen der Methode
 * 00.</p>
 * <pre>
 * Stellen-Nr.:1 2 3 4 5 6 7 8 9 10
 * Konto-Nr.:  X X P X X X X X X X
 * Gewichtung: 1 2   1 2 1 2 1 2 1
 * </pre>
 * <p>
 * <b>Variante 3:</b></p>
 * <p>
 * Für die Kontonummern, die mit den folgenden Zahlen beginnen gilt die Methode
 * 09 (keine Prüfzifferberechnung):</p>
 * <p>
 * 40, 50, 91 und 99</p>
 * <p>
 * <b>Variante 4:</b></p>
 * <p>
 * Kontonummern die mit 01 bis 31 beginnen haben an der dritten bis vierten
 * Stelle immer einen Wert zwischen 01 und 12 und an der siebten bis neunten
 * Stelle immer einen Wert kleiner 500.</p>
 * <p>
 * Ausnahme: Die Kontonummer 0185125434 ist als richtig zu bewerten.</p>
 * <p>
 * Testkontonummern (richtig): 7500021766, 9400001734, 7800028282, 8100244186,
 * 3251080371, 3891234567, 7777778800, 5001050352, 5045090090, 1909700805,
 * 9322111030, 7400060823<br>
 * Testkontonummern (falsch): 5302707782, 6412121212, 1813499124, 2206735010</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method57
        extends AbstractMethod {

    private int[] weighting;

    private static Logger log = Logger.getLogger(Method57.class);

    @Override
    public boolean test() {
        int[] number = expand(this.getAccountNumberArray());
        if (number[0] == 0 && number[1] == 0) {
            log.debug("Begin with 00 = false");
            return false;
        }

        // 777777
        if (number[0] == 7 && number[1] == 7 && number[2] == 7 && number[3] == 7 && number[4] == 7 && number[5] == 7) {
            Method09 method09 = new Method09();
            log.debug("begin with 777777 = true ");
            return method09.test();
        }
        // 888888
        if (number[0] == 8 && number[1] == 8 && number[2] == 8 && number[3] == 8 && number[4] == 8 && number[5] == 8) {
            log.debug("begin with 888888 = true ");
            Method09 method09 = new Method09();
            return method09.test();
        }
        int firstNumber = Integer.parseInt(number[0] + "" + number[1]);
        if ((firstNumber == 51
                || firstNumber == 52
                || firstNumber == 61
                || firstNumber == 64
                || firstNumber == 65
                || firstNumber == 66
                || firstNumber == 70
                || (firstNumber >= 73 && firstNumber <= 82)
                || firstNumber == 88
                || firstNumber == 94
                || firstNumber == 95)) {
            number = this.getAccountNumberArray();
            log.debug("variante 1");
            return variante1(number);
        }

        if ((firstNumber >= 32 && firstNumber <= 39
                || firstNumber >= 41 && firstNumber <= 49
                || firstNumber >= 52 && firstNumber <= 54
                || firstNumber >= 56 && firstNumber <= 60
                || firstNumber >= 62 && firstNumber <= 63
                || firstNumber >= 67 && firstNumber <= 69
                || firstNumber >= 71 && firstNumber <= 72
                || firstNumber >= 83 && firstNumber <= 87
                || firstNumber >= 89 && firstNumber <= 90
                || firstNumber >= 92 && firstNumber <= 93
                || firstNumber >= 96 && firstNumber <= 98)) {
            number = this.getAccountNumberArray();
            log.debug("variante 2");
            return variante2(number);
        }

        if (firstNumber == 40 || firstNumber == 50 || firstNumber == 91 || firstNumber == 99) {
            number = this.getAccountNumberArray();
            log.debug("variante 3");
            return variante3(number);
        }
        number = this.getAccountNumberArray();
        log.debug("variante 4");
        return variante4(number);
    }

    /**
     * <p>
     * <b>Variante 1. </b></p>
     * <p>
     * Modulus 10, Gewichtung 1, 2, 1, 2, 1, 2, 1, 2, 1</p>
     * <p>
     * Anzuwenden ist dieses Verfahren für Kontonummern, die mit den folgenden
     * Zahlen beginnen:</p>
     * <p>
     * 51, 55, 61, 64, 65, 66, 70, 73 bis 82, 88, 94 und 95</p>
     * <p>
     * Die Stellen 1 bis 9 der Kontonummer sind von links beginnend mit den
     * Gewichten zu multiplizieren. Die 10. Stelle ist die Prüfziffer. Die
     * Berechnung und mögliche Ergebnisse entsprechen der Methode 00
     * .</p>
     * <pre>
     * Stellen-Nr.: 1 2 3 4 5 6 7 8 9 10
     * Konto-Nr.: X X X X X X X X X P Gewichtung 1
     * 2 1 2 1 2 1 2 1
     *
     * </pre>
     * <p>
     * Ausnahme: Kontonummern, die mit den Zahlen 777777 oder 888888 beginnen
     * sind immer als richtig (= Methode 09; keine Prüfzifferberechnung) zu
     * bewerten.</p>
     *
     * @param number
     * @return
     */
    boolean variante1(int[] number) {
        weighting = new int[]{1, 2, 1, 2, 1, 2, 1, 2, 1};
        int firstNumber = Integer.parseInt(number[0] + "" + number[1]);
        log.debug("firstNumber: " + firstNumber);
        if (!(firstNumber == 51
                || firstNumber == 52
                || firstNumber == 61
                || firstNumber == 64
                || firstNumber == 65
                || firstNumber == 66
                || firstNumber == 70
                || (firstNumber >= 73 && firstNumber <= 82)
                || firstNumber == 88
                || firstNumber == 94
                || firstNumber == 95)) {
            throw new InvalidAcountNumberException("Accountnumbe invalid");
        }
        log.debug("accoutnumber is valid");

        Method00 method00 = new Method00();
        method00.setAccountNumberArray(number);
        log.debug("accountNumber is: " + getAccountNumber());

        return method00.check(weighting);
    }

    /**
     * <b>Variante 2:</b></p>
     * <p>
     * Modulus 10, Gewichtung 1, 2, 1, 2, 1, 2, 1, 2, 1</p>
     * <p>
     * Anzuwenden ist dieses Verfahren für Kontonummern, die mit den folgenden
     * Zahlen beginnen:</p>
     * <p>
     * 32 bis 39, 41 bis 49, 52, 53, 54, 56 bis 60, 62, 63, 67, 68, 69, 71, 72,
     * 83 bis 87, 89, 90, 92, 93, 96, 97 und 98</p>
     * <p>
     * Die Stellen 1, 2, 4, 5, 6, 7, 8, 9 und 10 der Kontonummer sind von links
     * beginnend mit den Gewichten zu multiplizieren. Die 3. Stelle ist die
     * Prüfziffer. Die Berechnung und mögliche Ergebnisse entsprechen der
     * Methode 00.</p>
     * <pre>
     * Stellen-Nr.:1 2 3 4 5 6 7 8 9 10
     * Konto-Nr.:  X X P X X X X X X X
     * Gewichtung: 1 2   1 2 1 2 1 2 1
     * </pre>
     *
     * @param number
     * @return
     */
    boolean variante2(int[] number) {
        weighting = new int[]{1, 2, 1, 2, 1, 2, 1, 0, 2, 1};
        int firstNumber = Integer.parseInt(number[0] + "" + number[1]);
        log.debug("firstNumber: " + firstNumber);
        if (!(firstNumber >= 32 && firstNumber <= 39
                || firstNumber >= 41 && firstNumber <= 49
                || firstNumber >= 52 && firstNumber <= 54
                || firstNumber >= 56 && firstNumber <= 60
                || firstNumber >= 62 && firstNumber <= 63
                || firstNumber >= 67 && firstNumber <= 69
                || firstNumber >= 71 && firstNumber <= 72
                || firstNumber >= 83 && firstNumber <= 87
                || firstNumber >= 89 && firstNumber <= 90
                || firstNumber >= 92 && firstNumber <= 93
                || firstNumber >= 96 && firstNumber <= 98)) {
            throw new InvalidAcountNumberException("Accountnumbe invalid");
        }

        int tmp = number[2];
        log.debug("digit: " + tmp);
        Method00 method00 = new Method00();
        number = factor(number, weighting, 1, number.length);
        int pz = add(number, 0, number.length);
        log.debug("pz: " + pz);
        pz = method00.modulus10(pz);
        number[2] = tmp;
        return method00.checkPz(pz, number, 3);
    }

    /**
     * <b>Variante 3. </b></p>
     * <p>
     * Für die Kontonummern, die mit den folgenden Zahlen beginnen gilt die
     * Methode 09 (keine Prüfzifferberechnung):</p>
     * <p>
     * 40, 50, 91 und 99</p>
     *
     * @param number
     * @return
     */
    boolean variante3(int[] number) {
        int firstNumber = Integer.parseInt(number[0] + "" + number[1]);
        log.debug("firstNumber: " + firstNumber);
        if (firstNumber == 40 || firstNumber == 50 || firstNumber == 91 || firstNumber == 99) {
            Method09 method09 = new Method09();
            return method09.test();
        }
        return false;
    }

    /**
     * <b>Variante 4 . </b></p>
     * <p>
     * Kontonummern die mit 01 bis 31 beginnen haben an der dritten bis vierten
     * Stelle immer einen Wert zwischen 01 und 12 und an der siebten bis neunten
     * Stelle immer einen Wert kleiner 500.</p>
     * <p>
     * Ausnahme: Die Kontonummer 0185125434 ist als richtig zu bewerten.</p>
     * <p>
     *
     * @param number
     * @return
     */
    boolean variante4(int[] number) {
        int firstNumber = Integer.parseInt(number[0] + "" + number[1]);
        int secondNumber = Integer.parseInt(number[2] + "" + number[3]);
        int lastNumber = Integer.parseInt(number[6] + "" + number[7] + "" + number[8]);
        log.debug("number " + Arrays.toString(number));
        if (firstNumber > 0 && firstNumber <= 31 && secondNumber > 0 && secondNumber <= 12 && lastNumber < 500) {

            return true;
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < number.length; i++) {
            str.append(number[i]);
        }
        return str.toString().equals("0185125434");
    }

}
