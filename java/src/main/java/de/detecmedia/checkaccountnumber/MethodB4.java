package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen B4.
 * <p>
 * gültig seit 07.03.2005</p>
 * <p>
 * Die Kontonummer ist einschließlich der Prüfziffer 10-stellig, ggf. ist die
 * Kontonummer für die Prüfzifferberechnung durch linksbündige Auffüllung
 * mit Nullen 10-stellig darzustellen.</p>
 * <p>
 * Variante 1:</p>
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2</p>
 * <p>
 * Kontonummern, die an der 1. Stelle von links der 10-stelligen Kontonummer den
 * Wert 9 beinhalten, sind nach der Methode 00 zu rechnen.</p>
 * <p>
 * Testkontonummern (richtig): 9941510001, 9961230019 9380027210, 9932290910<br>
 * Testkontonummern (falsch): 9941510002, 9961230020</p>
 * <p>
 * Variante 2:</p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8, 9, 10</p>
 * <p>
 * Kontonummern, die an der 1. Stelle von links der 10-stelligen Kontonummer den
 * Wert 0 bis 8 beinhalten, sind nach der Methode 02 zu rechnen.</p>
 * <p>
 * Testkontonummern (richtig): 0000251437, 0007948344, 0000051640<br>
 * Testkontonummern (falsch): 0000251438, 0007948345, 0000159590</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodB4
        extends AbstractMethod {

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        number = expand(number);
        if(variant1(number.clone())) {
            return true;
        }
        return variant2(number.clone());
    }

    /**
     * <p>
     * Variante 1:</p>
     * <p>
     * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2</p>
     * <p>
     * Kontonummern, die an der 1. Stelle von links der 10-stelligen Kontonummer
     * den Wert 9 beinhalten, sind nach der Methode 00 zu rechnen.</p>
     * <p>
     * Testkontonummern (richtig): 9941510001, 9961230019 9380027210,
     * 9932290910<br>
     * Testkontonummern (falsch): 9941510002, 9961230020</p>
     *
     * @return
     */
    boolean variant1(int[] number) {
        number = expand(number);
        Method00 m = new Method00();
        m.setAccountNumberArray(number);
        return m.test();
        
    }

    /**
     * <p>
     * Variante 2:</p>
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8, 9, 10</p>
     * <p>
     * Kontonummern, die an der 1. Stelle von links der 10-stelligen Kontonummer
     * den Wert 0 bis 8 beinhalten, sind nach der Methode 02 zu rechnen.</p>
     * <p>
     * Testkontonummern (richtig): 0000251437, 0007948344, 0000051640<br>
     * Testkontonummern (falsch): 0000251438, 0007948345, 0000159590</p>
     *
     * @param number
     * @return
     */
    boolean variant2(int[] number) {
        Method02 m = new Method02();
        m.setAccountNumberArray(number);
        return m.test();
    }
}
