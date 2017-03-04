package de.detecmedia.checkaccountnumber;

import java.util.Arrays;

import org.apache.log4j.Logger;

/**
 * Kennzeichen C0.
 * <p>
 * gültig seit 05.12.2005</p>
 * <p>
 * Die Kontonummer ist einschließlich der Prüfziffer 10-stellig, ggf. ist die
 * Kontonummer für die Prüfzifferberechnung durch linksbündige Auffüllung
 * mit Nullen 10-stellig darzustellen.</p>
 * <p>
 * Kontonummern mit zwei führenden Nullen sind nach Variante 1 zu prüfen.
 * Führt die Berechnung nach der Variante 1 zu einem Prüfzifferfehler, ist die
 * Berechnung nach Variante 2 vorzunehmen.</p>
 * <p>
 * Kontonummern mit weniger oder mehr als zwei führenden Nullen sind
 * ausschließlich nach der Variante 2 zu prüfen.</p>
 * <p>
 * Variante 1:</p>
 * <p>
 * Modulus 11, Gewichtung 2, 4, 8, 5, 10, 9, 7, 3, 6, 1, 2, 4</p>
 * <p>
 * Die Berechnung und mögliche Ergebnisse entsprechen der Methode 52.</p>
 * <p>
 * Testkontonummern (richtig) mit BLZ 130 511 72: 43001500, 48726458<br>
 * Testkontonummern (falsch) mit BLZ 130 511 72: 82335729, 29837521</p>
 * <p>
 * Variante 2:</p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8, 9, 3</p>
 * <p>
 * Die Berechnung und mögliche Ergebnisse entsprechen der Methode 20.</p>
 * <p>
 * Testkontonummern (richtig): 0082335729, 0734192657, 6932875274<br>
 * Testkontonummern (falsch): 0132572975, 3038752371</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 * @see Method52
 * @see Method20
 */
public class MethodC0
        extends AbstractMethod {

    private final Logger log = Logger.getLogger(MethodC0.class);

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        log.debug("number = " + Arrays.toString(number));

        if (variant1(number.clone())) {
            return true;
        }
        if (number.length == 10) {
            return variant2(number.clone());
        }
        return false;
    }

    /**
     * <p>
     * Variante 1:</p>
     * <p>
     * Modulus 11, Gewichtung 2, 4, 8, 5, 10, 9, 7, 3, 6, 1, 2, 4</p>
     * <p>
     * Die Berechnung und mögliche Ergebnisse entsprechen der Methode 52.</p>
     * <p>
     * Testkontonummern (richtig) mit BLZ 130 511 72: 43001500, 48726458<br>
     * Testkontonummern (falsch) mit BLZ 130 511 72: 82335729, 29837521</p>
     *
     * @return
     */
    boolean variant1(int[] number) {
        Method52 m = new Method52();
        m.setAccountNumberArray(number);
        return m.test();

    }

    /**
     * <p>
     * Variante 2:</p>
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8, 9, 3</p>
     * <p>
     * Die Berechnung und mögliche Ergebnisse entsprechen der Methode 20.</p>
     * <p>
     * Testkontonummern (richtig): 0082335729, 0734192657, 6932875274<br>
     * Testkontonummern (falsch): 0132572975, 3038752371</p>
     *
     * @param number
     * @return
     */
    boolean variant2(int[] number) {
        Method20 m = new Method20();
        m.setAccountNumberArray(number);
        return m.check(new int[]{2, 3, 4, 5, 6, 7, 8, 9, 3});

    }

}
