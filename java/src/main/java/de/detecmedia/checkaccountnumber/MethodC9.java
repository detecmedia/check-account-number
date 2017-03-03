package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.exception.InvalidAcountNumberException;

/**
 * Kennzeichen C9.
 * <p>
 * gültig seit 09.06.2008</p>
 * <p>
 * Die Kontonummer ist einschließlich der Prüfziffer 10-stellig, ggf. ist die
 * Kontonummer für die Prüfzifferberechnung durch linksbündige Auffüllung
 * mit Nullen 10-stellig darzustellen.</p>
 * <p>
 * Variante 1:</p>
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2</p>
 * <p>
 * Gewichtung und Berechnung erfolgen nach der Methode 00. Führt die Berechnung
 * nach Variante 1 zu einem Prüfzifferfehler, so ist nach Variante 2 zu
 * prüfen.</p>
 * <p>
 * Testkontonummern (richtig): 3456789019, 5678901231<br>
 * Testkontonummern (falsch): 3456789012, 0123456789, 1234567890, 9012345678</p>
 * <p>
 * Variante 2:</p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8, 9, 10 Gewichtung und Berechnung
 * erfolgen nach der Methode 07.</p>
 * <p>
 * Testkontonummer (richtig): 0123456789 <br>
 * Testkontonummer (falsch) : 1234567890, 9012345678</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodC9
        extends AbstractMethod {

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        if (variant1(number.clone())) {
            return true;
        }
        try {
            if (variant2(number.clone())) {
                return true;
            }
        } catch (InvalidAcountNumberException e) {
        }

        return false;
    }

    /**
     * <p>
     * Variante 1:</p>
     * <p>
     * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2</p>
     * <p>
     * Gewichtung und Berechnung erfolgen nach der Methode 00. Führt die
     * Berechnung nach Variante 1 zu einem Prüfzifferfehler, so ist nach
     * Variante 2 zu prüfen.</p>
     * <p>
     * Testkontonummern (richtig): 3456789019, 5678901231<br>
     * Testkontonummern (falsch): 3456789012, 0123456789, 1234567890,
     * 9012345678</p>
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
     * Variante 2:</p>
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8, 9, 10 Gewichtung und
     * Berechnung erfolgen nach der Methode 07.</p>
     * <p>
     * Testkontonummer (richtig): 0123456789 <br>
     * Testkontonummer (falsch) : 1234567890, 9012345678</p>
     *
     * @param number
     * @return
     */
    boolean variant2(int[] number) {
        Method07 m = new Method07();
        m.setAccountNumberArray(number);
        return m.test();
    }

}
