package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen B5.
 * <p>
 * gültig seit 06.06.2005</p>
 * <p>
 * Die Kontonummer ist einschließlich der Prüfziffer 10-stellig, ggf. ist die
 * Kontonummer für die Prüfzifferberechnung durch linksbündige Auffüllung
 * mit Nullen 10-stellig darzustellen.</p>
 * <p>
 * Variante 1:</p>
 * <p>
 * Modulus 10, Gewichtung 7, 3, 1 ,7 , 3, 1, 7, 3, 1</p>
 * <p>
 * Die Gewichtung entspricht der Methode (Kennzeichen) 05. Die Berechnung
 * entspricht der Methode (Kennzeichen) 01.</p>
 * <p>
 * Führt die Berechnung nach der Variante 1 zu einem Prüfzifferfehler, so sind
 * Kontonummern, die an der 1. Stelle von links der 10-stelligen Kontonummer den
 * Wert 8 oder 9 beinhalten, falsch. Alle anderen Kontonummern sind nach der
 * Variante 2 zu prüfen.</p>
 * <p>
 * Testkontonummern (richtig): 0159006955, 2000123451, 1151043216, 9000939033
 * <br>
 * Testkontonummern (falsch): 7414398260, 8347251693, 1151043211, 2345678901,
 * 5678901234, 9000293707</p>
 * <p>
 * Variante 2:</p>
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2</p>
 * <p>
 * Gewichtung und Berechnung erfolgen nach der Methode (Kennzeichen) 00.</p>
 * <p>
 * Testkontonummern (richtig): 0123456782, 0130098767, 1045000252<br>
 * Testkontonummern (falsch): 0159004165, 0023456787, 0056789018, 3045000333</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodB5
        extends AbstractMethod {

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        if (variant1(number.clone())) {
            return true;
        }
        return variant2(number.clone());
    }

    /**
     * <p>
     * Variante 1. </p>
     * <p>
     * Modulus 10, Gewichtung 7, 3, 1 ,7 , 3, 1, 7, 3, 1</p>
     * <p>
     * Die Gewichtung entspricht der Methode (Kennzeichen) 05. Die Berechnung
     * entspricht der Methode (Kennzeichen) 01.</p>
     * <p>
     * Führt die Berechnung nach der Variante 1 zu einem Prüfzifferfehler, so
     * sind Kontonummern, die an der 1. Stelle von links der 10-stelligen
     * Kontonummer den Wert 8 oder 9 beinhalten, falsch. Alle anderen
     * Kontonummern sind nach der Variante 2 zu prüfen.</p>
     * <p>
     * Testkontonummern (richtig): 0159006955, 2000123451, 1151043216,
     * 9000939033
     * <br>
     * Testkontonummern (falsch): 7414398260, 8347251693, 1151043211,
     * 2345678901, 5678901234, 9000293707</p>
     *
     * @return
     */
    boolean variant1(int[] number) {

        weighting = new int[]{7, 3, 1, 7, 3, 1, 7, 3, 1};
        Method01 m = new Method01();
        m.setAccountNumberArray(number);
        return m.check(weighting);

    }

    /**
     * <p>
     * Variante 2. </p>
     * <p>
     * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2</p>
     * <p>
     * Gewichtung und Berechnung erfolgen nach der Methode (Kennzeichen) 00.</p>
     * <p>
     * Testkontonummern (richtig): 0123456782, 0130098767, 1045000252<br>
     * Testkontonummern (falsch): 0159004165, 0023456787, 0056789018,
     * 3045000333</p>
     *
     * @param number
     * @return
     */
    boolean variant2(int[] number) {
        Method00 m = new Method00();
        m.setAccountNumberArray(number);
        return m.test();

    }

}
