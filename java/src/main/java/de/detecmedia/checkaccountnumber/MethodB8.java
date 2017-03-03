package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen B8.
 * <p>
 * gültig seit 05.09.2005</p>
 * <p>
 * geändert zum 06.06.2011</p>
 * <p>
 * Die Kontonummer ist einschließlich der Prüfziffer 10-stellig, ggf. ist die
 * Kontonummer für die Prüfzifferberechnung durch linksbündige Auffüllung
 * mit Nullen 10-stellig darzustellen. Die 10. Stelle der Kontonummer ist die
 * Prüfziffer.</p>
 * <p>
 * Variante 1:</p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8, 9, 3 (modifiziert)</p>
 * <p>
 * Die Berechnung und mögliche Ergebnisse entsprechen der Methode 20. Führt
 * die Berechnung nach Variante 1 zu einem Prüfzifferfehler, so ist nach
 * Variante 2 zu prüfen.</p>
 * <p>
 * Testkontonummern (richtig): 0734192657, 6932875274<br>
 * Testkontonummern (falsch): 3145863029, 2938692523, 0132572975, 5432198760,
 * 9070873333, 5011654366 9000412340, 9310305011</p>
 * <p>
 * Variante 2:</p>
 * <p>
 * Modulus 10, iterierte Transformation</p>
 * <p>
 * Die Berechnung und mögliche Ergebnisse entsprechen der Methode 29. Führt
 * die Berechnung nach Variante 2 zu einem Prüfzifferfehler, so ist nach
 * Variante 3 zu prüfen.</p>
 * <p>
 * Testkontonummern (richtig): 3145863029, 2938692523<br>
 * Testkontonummern (falsch): 0132572975, 5432198760, 9070873333, 9000412340,
 * 9310305011</p>
 * <p>
 * Variante 3:</p>
 * <p>
 * Für die folgenden Kontonummernkreise gilt die Methode 09 (keine
 * Prüfzifferberechnung).</p>
 * <ul>
 * <li>10-stellige Kontonummer; 1. + 2. Stelle = 51 - 59 Kontonummernkreis
 * 5100000000 – 5999999999</li>
 * <li>10-stellige Kontonummer; Stellen 1 - 3 = 901 - 910 Kontonummernkreis
 * 9010000000 – 9109999999</li>
 * </ul>
 *
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodB8
        extends AbstractMethod {

    @Override
    public boolean test() {
        
        if(variant1(this.getAccountNumberArray().clone())) {
            return true;
        }
        if(variant2(this.getAccountNumberArray().clone())) {
            return true;
        }
        return variant3(this.getAccountNumberArray().clone());
    }

    /**
     *<p>
 * Variante 1. </p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8, 9, 3 (modifiziert)</p>
 * <p>
 * Die Berechnung und mögliche Ergebnisse entsprechen der Methode 20. Führt
 * die Berechnung nach Variante 1 zu einem Prüfzifferfehler, so ist nach
 * Variante 2 zu prüfen.</p>
 * <p>
 * Testkontonummern (richtig): 0734192657, 6932875274<br>
 * Testkontonummern (falsch): 3145863029, 2938692523, 0132572975, 5432198760,
 * 9070873333, 5011654366 9000412340, 9310305011</p>
     * @return
     */
    boolean variant1(int[] number) {
        Method20 m = new Method20();
        m.setAccountNumberArray(number);
        return m.check(new int[]{2, 3, 4, 5, 6, 7, 8, 9, 3});
    }

    /**
     *<p>
 * Variante 2:</p>
 * <p>
 * Modulus 10, iterierte Transformation</p>
 * <p>
 * Die Berechnung und mögliche Ergebnisse entsprechen der Methode 29. Führt
 * die Berechnung nach Variante 2 zu einem Prüfzifferfehler, so ist nach
 * Variante 3 zu prüfen.</p>
 * <p>
 * Testkontonummern (richtig): 3145863029, 2938692523<br>
 * Testkontonummern (falsch): 0132572975, 5432198760, 9070873333, 9000412340,
 * 9310305011</p>
     * @param number
     * @return
     */
    boolean variant2(int[] number) {
        Method29 m = new Method29();
        m.setAccountNumberArray(number);
        return m.test();
       
    }

    /**
     * <p>
     * Variante 3:</p>
     * <p>
     * Für die folgenden Kontonummernkreise gilt die Methode 09 (keine
     * Prüfzifferberechnung).</p>
     * <ul>
     * <li>10-stellige Kontonummer; 1. + 2. Stelle = 51 - 59 Kontonummernkreis
     * 5100000000 – 5999999999</li>
     * <li>10-stellige Kontonummer; Stellen 1 - 3 = 901 - 910 Kontonummernkreis
     * 9010000000 – 9109999999</li>
     * </ul>
     *
     * @return
     */
    boolean variant3(int[] number) {
        Method09 m = new Method09();
        number = expand(number);
        m.setAccountNumberArray(number);
        long numberLong = m.getLong();
        if(numberLong >= 5100000000L && numberLong <= 5999999999L ) {
            return m.test();
        }
        if(numberLong >= 9010000000L && numberLong <= 9109999999L ) {
            return m.test();
        }
        return false;
    }

}
