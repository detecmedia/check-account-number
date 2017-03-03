package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen C3.
 * <p>
 * gültig seit 05.03.2007</p>
 * <p>
 * Die Kontonummer ist einschließlich der Prüfziffer 10-stellig, ggf. ist die
 * Kontonummer für die Prüfzifferberechnung durch linksbündige Auffüllung
 * mit Nullen 10-stellig darzustellen.</p>
 * <p>
 * Die 10. Stelle der Kontonummer ist die Prüfziffer.</p>
 * <p>
 * Kontonummern, die an der 1. Stelle der 10-stelligen Kontonummer einen Wert
 * ungleich „9“ beinhalten, sind nach der Variante 1 zu prüfen. Kontonummern,
 * die an der 1. Stelle der 10-stelligen Kontonummer den Wert „9“ beinhalten,
 * sind nach der Variante 2 zu prüfen.</p>
 * <p>
 * Variante 1:</p>
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2</p>
 * <p>
 * Die Berechnung und mögliche Ergebnisse entsprechen der Methode 00.</p>
 * <p>
 * Testkontonummern (richtig): 9294182, 4431276, 19919 <br>
 * Testkontonummern (falsch): 17002, 123451, 122448</p>
 * <p>
 * Variante 2:</p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 0, 0, 0, 0</p>
 * <p>
 * Die Berechnung und mögliche Ergebnisse entsprechen der Methode 58.</p>
 * <p>
 * Testkontonummern (richtig): 9000420530, 9000010006, 9000577650<br>
 * Testkontonummern (falsch): 9000734028, 9000733227, 9000731120</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodC3
        extends AbstractMethod {

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        if(variant1(number.clone())) {
            return true;
        }
        if(variant2(number.clone())) {
            return true;
        }
        return false;
    }

    /**
     * <p>
     * Variante 1. </p>
     * <p>
     * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2</p>
     * <p>
     * Die Berechnung und mögliche Ergebnisse entsprechen der Methode 00.</p>
     * <p>
     * Testkontonummern (richtig): 9294182, 4431276, 19919 <br>
     * Testkontonummern (falsch): 17002, 123451, 122448</p>
     *
     * @return
     */
    boolean variant1(int[] number) {
        Method00 m = new Method00();
        m.setAccountNumberArray(number);
        return m.test();
    }

    /**
     * <p>
     * Variante 2. </p>
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 0, 0, 0, 0</p>
     * <p>
     * Die Berechnung und mögliche Ergebnisse entsprechen der Methode 58.</p>
     * <p>
     * Testkontonummern (richtig): 9000420530, 9000010006, 9000577650<br>
     * Testkontonummern (falsch): 9000734028, 9000733227, 9000731120</p>
     *
     * @param number
     * @return
     */
    boolean variant2(int[] number) {
        Method58 m = new Method58();
        m.setAccountNumberArray(number);
        return m.test();
    }

}
