package de.detecmedia.checkaccountnumber;

import org.apache.log4j.Logger;

/**
 * Kennzeichen 91.
 * <p>
 * <b>geändert zum 08.12.2003</b></p>
 * <ol><li>Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7</li>
 * <li>Modulus 11, Gewichtung 7, 6, 5, 4, 3, 2</li>
 * <li>Modulus 11, Gewichtung 2, 3, 4, 0, 5, 6, 7, 8, 9, A (A = 10) </li>
 * <li> Modulus 11, Gewichtung 2, 4, 8, 5, A, 9 (A = 10)</li></ol>
 * <p>
 * Gemeinsame Hinweise für die Berechnungsvarianten 1 bis 4:</p>
 * <p>
 * Die Kontonummer ist immer 10-stellig. Die einzelnen Stellen der Kontonummer
 * werden von links nach rechts von 1 bis 10 durchnummeriert. Die Stelle7 der
 * Kontonummer ist die Prüfziffer. Die für die Berechnung relevanten
 * Kundennummern (K) sind von rechts nach links mit den jeweiligen Gewichten zu
 * multiplizieren. Die restliche Berechnung und möglichen Ergebnisse
 * entsprechen dem Verfahren 06.</p>
 * <p>
 * Ergibt die Berechnung nach der ersten beschriebenen Variante einen
 * Prüfzifferfehler, so sind in der angegebenen Reihenfolge weitere
 * Berechnungen mit den anderen Varianten vorzunehmen, bis die Berechnung keinen
 * Prüfzifferfehler mehr ergibt. Kontonummern, die endgültig nicht zu einem
 * richtigen Ergebnis führen, sind nicht prüfbar.</p>
 * <p>
 * <b>Variante 1:</b></p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7</p>
 * <p>
 * Die Stellen8 bis 10 werden nicht in die Berechnung einbezogen.</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   K K K K K K P x x x
 * Gewichtung: 7 6 5 4 3 2
 * </pre>
 * <p>
 * Testkontonummern (richtig): 2974118000, 5281741000, 9952810000<br>
 * Testkontonummern (falsch): 8840017000, 8840023000, 8840041000</p> ￼
 * <p>
 * <b>Variante 2:</b></p>
 * <p>
 * Modulus 11, Gewichtung 7, 6, 5, 4, 3, 2</p>
 * <p>
 * Die Stellen8 bis 10 werden nicht in die Berechnung einbezogen.</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   K K K K K K P x x x
 * Gewichtung: 2 3 4 5 6 7
 * </pre>
 * <p>
 * Testkontonummern (richtig): 2974117000, 5281770000, 9952812000<br>
 * Testkontonummern (falsch): 8840014000, 8840026000, 8840045000</p>
 * <p>
 * <b>Variante 3:</b></p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 0, 5, 6, 7, 8, 9, A (A = 10) Die Stellen 1
 * bis 10 werden in die Berechnung einbezogen.</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   K K K K K K P x x x
 * Gewichtung:10 9 8 7 6 5 0 4 3 2
 * </pre>
 * <p>
 * Testkontonummern (richtig): 8840019000, 8840050000, 8840087000, 8840045000
 * Testkontonummern (falsch):8840011000, 8840025000, 8840062000</p>
 * <p>
 * <b>Variante 4:</b></p>
 * <p>
 * Modulus 11, Gewichtung 2, 4, 8, 5, A, 9 (A = 10)</p>
 * <p>
 * Die Stellen 8 bis 10 werden nicht in die Berechnung einbezogen.</p>
 * <pre>
 * Stellennr.: 1  2  3  4  5  6  7  8  9  A (A=10)
 * Kontonr.:   K  K  K  K  K  K  P  x  x  x
 * Gewichtung: 9 10  5  8  4  2
 * </pre>
 * <p>
 * Testkontonummern (richtig): 8840012000, 8840055000, 8840080000<br>
 * Testkontonummern (falsch): 8840010000, 8840057000</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method91 extends Method06 {

    private final Logger log = Logger.getLogger(Method91.class);

    private int[] weighting;

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        number = expand(number);
        if (variant1(number)) {
            return true;
        }
        number = this.getAccountNumberArray();
        number = expand(number);
        if (variant2(number)) {
            return true;
        }
        number = this.getAccountNumberArray();
        number = expand(number);
        if (variant3(number)) {
            return true;
        }
        number = this.getAccountNumberArray();
        number = expand(number);
        return variant4(number);

    }

    /**
     * <p>
     * <b>Variante 1. </b></p>
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7</p>
     * <p>
     * Die Stellen8 bis 10 werden nicht in die Berechnung einbezogen.</p>
     * <pre>
     * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
     * Kontonr.:   K K K K K K P x x x
     * Gewichtung: 7 6 5 4 3 2
     * </pre>
     * <p>
     * Testkontonummern (richtig): 2974118000, 5281741000, 9952810000<br>
     * Testkontonummern (falsch): 8840017000, 8840023000, 8840041000</p> ￼
     *
     * @param number
     * @return
     */
    boolean variant1(int[] number) {
        weighting = new int[]{2, 3, 4, 5, 6, 7};
        return calculate(number);
    }

    /**
     * <p>
     * <b>Variante 2. </b></p>
     * <p>
     * Modulus 11, Gewichtung 7, 6, 5, 4, 3, 2</p>
     * <p>
     * Die Stellen8 bis 10 werden nicht in die Berechnung einbezogen.</p>
     * <pre>
     * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
     * Kontonr.:   K K K K K K P x x x
     * Gewichtung: 2 3 4 5 6 7
     * </pre>
     * <p>
     * Testkontonummern (richtig): 2974117000, 5281770000, 9952812000<br>
     * Testkontonummern (falsch): 8840014000, 8840026000, 8840045000</p>
     *
     * @param number
     * @return
     */
    boolean variant2(int[] number) {
        weighting = new int[]{7, 6, 5, 4, 3, 2};
        return calculate(number);
    }

    /**
     * <p>
     * <b>Variante 3. </b></p>
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 0, 5, 6, 7, 8, 9, A (A = 10) Die Stellen
     * 1 bis 10 werden in die Berechnung einbezogen.</p>
     * <pre>
     * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
     * Kontonr.:   K K K K K K P x x x
     * Gewichtung:10 9 8 7 6 5 0 4 3 2
     * </pre>
     * <p>
     * Testkontonummern (richtig): 8840019000, 8840050000, 8840087000,
     * 8840045000 Testkontonummern (falsch):8840011000, 8840025000,
     * 8840062000</p>
     * <p>
     *
     * @param number
     * @return
     */
    boolean variant3(int[] number) {
        int A = 10;
        int tmp = number[6];
        weighting = new int[]{2, 3, 4, 0, 5, 6, 7, 8, 9, A};
        number = factor(number, weighting, 1, A);
        int pz = add(number, 0, A);
        pz = modulus11(pz);
        number[6] = tmp;
        return checkPz(pz, number, 7);

    }

    /**
     * <b>Variante 4:</b></p>
     * <p>
     * Modulus 11, Gewichtung 2, 4, 8, 5, A, 9 (A = 10)</p>
     * <p>
     * Die Stellen 8 bis 10 werden nicht in die Berechnung einbezogen.</p>
     * <pre>
     * Stellennr.: 1  2  3  4  5  6  7  8  9  A (A=10)
     * Kontonr.:   K  K  K  K  K  K  P  x  x  x
     * Gewichtung: 9 10  5  8  4  2
     * </pre>
     * <p>
     * Testkontonummern (richtig): 8840012000, 8840055000, 8840080000<br>
     * Testkontonummern (falsch): 8840010000, 8840057000</p>
     *
     * @param number
     * @return
     */
    boolean variant4(int[] number) {
        int A = 10;
        weighting = new int[]{2, 4, 8, 5, A, 9};
        return calculate(number);
    }

    private boolean calculate(int[] number) {
        number = factor(number, weighting, 1, 6);
        int pz = add(number, 0, 6);
        pz = modulus11(pz);
        return checkPz(pz, number, 7);
    }

}
