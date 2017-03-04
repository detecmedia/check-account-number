package de.detecmedia.checkaccountnumber;

import org.apache.log4j.Logger;

/**
 * Kennzeichen D6.
 * <p>
 * gültig seit 07.03.2011</p>
 * <p>
 * Die Kontonummer ist einschließlich der Prüfziffer 10-stellig, ggf. ist die
 * Kontonummer für die Prüfzifferberechnung durch linksbündige Auffüllung
 * mit Nullen 10-stellig darzustellen.</p>
 * <p>
 * Variante 1:</p>
 * <p>
 * Die Berechnung entspricht der Methode 07.</p>
 * <p>
 * Führt die Berechnung nach Variante 1 zu einem Prüfziffer- fehler, so ist
 * nach Variante 2 zu prüfen.</p>
 * <p>
 * Testkontonummern richtig: 3409, 585327, 1650513 <br>
 * Testkontonummern falsch: 33394, 595795, 16400501</p>
 * <p>
 * Variante 2</p>
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2 Die Berechnung entspricht
 * der Methode 03.</p>
 * <p>
 * Führt die Berechnung nach Variante 2 zu einem Prüfziffer- fehler, so ist
 * nach Variante 3 zu prüfen.</p>
 * <p>
 * Testkontonummern richtig: 3601671056, 4402001046, 6100268241<br>
 * Testkontonummern falsch: 3615071237, 6039267013, 6039316014</p>
 * <p>
 * Variante 3</p>
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2 </p>
 * <p>
 * Die Berechnung entspricht der Methode 00.</p>
 * <p>
 * Führt auch die Berechnung nach Variante 3 zu einem Prüfzifferfehler, so ist
 * die Kontonummer falsch.</p>
 * <p>
 * Testkontonummern richtig: 7001000681, 9000111105, 9001291005<br>
 * Testkontonummern falsch: 7004017653, 9002720007, 9017483524 </p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodD6
        extends AbstractMethod {

    private final Logger log = Logger.getLogger(MethodD6.class);

    @Override
    public boolean test() {
        int[] number;

        number = expand(this.getAccountNumberArray());
        try {

            if (variant1(number.clone())) {
                return true;
            }
        } catch (Exception e) {
        }
        if (variant2(number.clone())) {
            return true;
        }

        number = expand(number.clone());
        if (variant3(number)) {
            return true;
        }
        return false;

    }

    /**
     * <p>
     * Variante 1. </p>
     * <p>
     * Die Berechnung entspricht der Methode 07.</p>
     * <p>
     * Führt die Berechnung nach Variante 1 zu einem Prüfziffer- fehler, so
     * ist nach Variante 2 zu prüfen.</p>
     * <p>
     * Testkontonummern richtig: 3409, 585327, 1650513 <br>
     * Testkontonummern falsch: 33394, 595795, 16400501</p>
     *
     * @param number
     * @return
     */
    boolean variant1(int[] number) {
        Method07 method07 = new Method07();
        method07.setAccountNumberArray(number);
        return method07.test();
    }

    /**
     * <p>
     * Variante 2. </p>
     * <p>
     * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2 Die Berechnung
     * entspricht der Methode 03.</p>
     * <p>
     * Führt die Berechnung nach Variante 2 zu einem Prüfziffer- fehler, so
     * ist nach Variante 3 zu prüfen.</p>
     * <p>
     * Testkontonummern richtig: 3601671056, 4402001046, 6100268241<br>
     * Testkontonummern falsch: 3615071237, 6039267013, 6039316014</p>
     *
     * @param number
     * @return
     */
    boolean variant2(int[] number) {
        weighting = new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2};
        Method03 method03 = new Method03();
        method03.setAccountNumberArray(number);
        return method03.check(weighting);

    }

    /**
     * <p>
     * Variante 3. </p>
     * <p>
     * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2 </p>
     * <p>
     * Die Berechnung entspricht der Methode 00.</p>
     * <p>
     * Führt auch die Berechnung nach Variante 3 zu einem Prüfzifferfehler, so
     * ist die Kontonummer falsch.</p>
     * <p>
     * Testkontonummern richtig: 7001000681, 9000111105, 9001291005<br>
     * Testkontonummern falsch: 7004017653, 9002720007, 9017483524 </p>
     *
     * @param number
     * @return
     */
    boolean variant3(int[] number) {
        weighting = new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2};
        Method00 method00 = new Method00();
        method00.setAccountNumberArray(number);
        return method00.check(weighting);

    }
}
