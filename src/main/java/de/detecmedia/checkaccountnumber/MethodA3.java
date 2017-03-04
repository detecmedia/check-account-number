package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen A3.
 * <p>
 * <b>gültig seit 08.09.2003</b></p>
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
 * nach Variante1 zu einem Prüfzifferfehler, so ist nach Variante 2 zu
 * prüfen.</p>
 * <p>
 * Testkontonummern (richtig): 1234567897, 0123456782 <br>
 * Testkontonummern (falsch): 9876543210, 1234567890, 6543217890, 0543216789</p>
 * <p>
 * Variante 2:</p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8, 9, 10 Gewichtung und Berechnung
 * erfolgen nach der Methode 10. </p>
 * <p>
 * Testkontonummern (richtig): 9876543210, 1234567890, 0123456789 <br>
 * Testkontonummern (falsch): 6543217890, 0543216789</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodA3
        extends AbstractMethod {
    /**
     * Wiehting for varitant 1.
     */
    private static final int[] VARIANT_1_WEIGHTING =
            new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2};
    /**
     * weightig for variant 2.
     */
    private static final int[] VARIANT_2_WEIGHTING =
            new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10};

    /**
     * test method A3.
     *
     * @return boolean
     */
    @Override
    public boolean test() {
        int[] number = expand(this.getAccountNumberArray());
        if (variant1(number)) {
            return true;
        }
        number = expand(this.getAccountNumberArray());
        return variant2(number);
    }

    /**
     * Variante 1.
     * use Method 00
     *
     * @param number number array
     * @return boolean
     */
    final boolean variant1(final int[] number) {

        Method00 method00 = new Method00();
        method00.setAccountNumberArray(number);
        return method00.check(VARIANT_1_WEIGHTING);
    }

    /**
     * variante 2.
     * use mehtod 10
     *
     * @param number number array
     * @return boolean
     */
    final boolean variant2(final int[] number) {

        Method10 method10 = new Method10();
        method10.setAccountNumberArray(number);
        return method10.check(VARIANT_2_WEIGHTING);
    }

}
