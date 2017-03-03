package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen B1.
 * <p>
 * gültig seit 06.09.2004</p>
 * <p>
 * Die Kontonummer ist einschließlich der Prüfziffer 10-stellig, ggf. ist die
 * Kontonummer für die Prüfzifferberechnung durch linksbündige Auffüllung
 * mit Nullen 10-stellig darzustellen.</p>
 * <p>
 * Variante 1:</p>
 * <p>
 * Modulus 10, Gewichtung 7, 3, 1, 7, 3, 1, 7, 3, 1</p>
 * <p>
 * Gewichtung und Berechnung erfolgen nach der Methode 05. Führt die Berechnung
 * nach Variante1 zu einem Prüfzifferfehler, so ist nach Variante 2 zu
 * prüfen.</p>
 * <p>
 * Testkontonummern (richtig): 1434253150, 2746315471</p>
 * <p>
 * Testkontonummern (falsch): 7414398260, 8347251693 0123456789, 2345678901,
 * 5678901234</p>
 * <p>
 * Variante 2:</p>
 * <p>
 * Modulus 10, Gewichtung 3, 7, 1, 3, 7, 1, 3, 7, 1</p>
 * <p>
 * Gewichtung und Berechnung erfolgen nach der Methode 01.</p>
 * <p>
 * Testkontonummern (richtig): 7414398260, 8347251693</p>
 * <p>
 * Testkontonummern (falsch): 0123456789, 2345678901, 5678901234</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodB1
        extends AbstractMethod {

    @Override
    public boolean test() {
        int[] number  = this.getAccountNumberArray();
        number = expand(number);
        if(variant1(number.clone())) {
            return true;
        }
        return variant2(number.clone());
    }

    /**
     * <p>
     * Variante 1. </p>
     * <p>
     * Modulus 10, Gewichtung 7, 3, 1, 7, 3, 1, 7, 3, 1</p>
     * <p>
     * Gewichtung und Berechnung erfolgen nach der Methode 05. Führt die
     * Berechnung nach Variante1 zu einem Prüfzifferfehler, so ist nach
     * Variante 2 zu prüfen.</p>
     * <p>
     * Testkontonummern (richtig): 1434253150, 2746315471</p>
     * <p>
     * Testkontonummern (falsch): 7414398260, 8347251693 0123456789, 2345678901,
     * 5678901234</p>
     *
     * @param number
     * @return
     */
    boolean variant1(int[] number) {
        Method05 m = new Method05();
        m.setAccountNumberArray(number);
        return m.check(new int[]{7, 3, 1, 7, 3, 1, 7, 3, 1});
    }

    /**
     * <p>
     * Variante 2. </p>
     * <p>
     * Modulus 10, Gewichtung 3, 7, 1, 3, 7, 1, 3, 7, 1</p>
     * <p>
     * Gewichtung und Berechnung erfolgen nach der Methode 01.</p>
     * <p>
     * Testkontonummern (richtig): 7414398260, 8347251693</p>
     * <p>
     * Testkontonummern (falsch): 0123456789, 2345678901, 5678901234</p>
     *
     * @param number
     * @return
     */
    boolean variant2(int[] number) {
        Method01 m = new Method01();
        m.setAccountNumberArray(number);
        return m.check(new int[]{3, 7, 1, 3, 7, 1, 3, 7, 1});
    }

}
