package de.detecmedia.checkaccountnumber;

import org.apache.log4j.Logger;

/**
 * Kennzeichen B2.
 * <p>
 * gültig seit 06.09.2004</p>
 * <p>
 * Die Kontonummer ist einschließlich der Prüfziffer 10-stellig, ggf. ist die
 * Kontonummer für die Prüfzifferberechnung durch linksbündige Auffüllung
 * mit Nullen 10-stellig darzustellen.</p>
 * <p>
 * Variante 1:</p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8, 9, 2</p>
 * <p>
 * Kontonummern, die an der 1. Stelle von links der 10-stelligen Kontonummer den
 * Wert 0 bis 7 beinhalten, sind nach der Methode 02 zu rechnen.</p>
 * <p>
 * Testkontonummern (richtig): 0020012357, 0080012345, 0926801910,
 * 1002345674<br>
 * Testkontonummern (falsch): 0020012399, 0080012347, 0080012370, 0932100027,
 * 3310123454</p>
 * <p>
 * Variante 2:</p>
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2</p>
 * <p>
 * Kontonummern, die an der 1. Stelle von links der 10-stelligen Kontonummer den
 * Wert 8 oder 9 beinhalten, sind nach der Methode 00 zu rechnen.</p>
 * <p>
 * Testkontonummern (richtig): 8000990054, 9000481805</p>
 * <p>
 * Testkontonummern (falsch): 8000990057, 8011000126, 9000481800, 9980480111</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodB2
        extends AbstractMethod {

    private final Logger log = Logger.getLogger(MethodB2.class);

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        number = expand(number);
        if (variant1(number.clone())) {
            return true;
        }
        return this.variant2(number.clone());
    }

    /**
     * <p>
     * Variante 1. </p>
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8, 9, 2</p>
     * <p>
     * Kontonummern, die an der 1. Stelle von links der 10-stelligen Kontonummer
     * den Wert 0 bis 7 beinhalten, sind nach der Methode 02 zu rechnen.</p>
     * <p>
     * Testkontonummern (richtig): 0020012357, 0080012345, 0926801910,
     * 1002345674<br>
     * Testkontonummern (falsch): 0020012399, 0080012347, 0080012370,
     * 0932100027, 3310123454</p>
     *
     * @param number
     * @return
     */
    boolean variant1(int[] number) {
        if (number[0] == 0
                || number[0] == 1
                || number[0] == 2
                || number[0] == 3
                || number[0] == 4
                || number[0] == 5
                || number[0] == 6
                || number[0] == 7) {
            Method02 m = new Method02();
            m.setAccountNumberArray(number);
            return m.check(new int[]{2, 3, 4, 5, 6, 7, 8, 9, 2});
        }
        return false;
    }

    /**
     * <p>
     * Variante 2. </p>
     * <p>
     * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2</p>
     * <p>
     * Kontonummern, die an der 1. Stelle von links der 10-stelligen Kontonummer
     * den Wert 8 oder 9 beinhalten, sind nach der Methode 00 zu rechnen.</p>
     * <p>
     * Testkontonummern (richtig): 8000990054, 9000481805</p>
     * <p>
     * Testkontonummern (falsch): 8000990057, 8011000126, 9000481800,
     * 9980480111</p>
     *
     * @param number
     * @return
     */
    boolean variant2(int[] number) {
        if (number[0] == 8
                || number[0] == 9) {
            Method00 m = new Method00();
            m.setAccountNumberArray(number);
            return m.check(new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2});
                    
        }
        return false;
    }

}
