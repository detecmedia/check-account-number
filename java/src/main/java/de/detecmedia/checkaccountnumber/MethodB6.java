package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen B6.
 * <p>
 * gültig seit 05.09.2005</p>
 * <p>
 * geändert zum 05.09.2011</p>
 * <p>
 * Variante 1:</p>
 * <p>
 * Modulus 11, Gewichtung 2 ,3 ,4 ,5 ,6 ,7 ,8 ,9 ,3</p>
 * <p>
 * Kontonummern, die an der 1. Stelle der 10-stelligen Konto- nummer den Wert
 * 1-9 oder an den Stellen 1–5 die Werte 02691-02699 beinhalten, sind nach der
 * Methode 20 zu prüfen. Alle anderen Kontonummern sind nach der Variante 2 zu
 * prüfen.</p>
 * <p>
 * Testkontonummer (richtig): 9110000000, 0269876545 <br>
 * Testkontonummer (falsch): 9111000000, 0269456780</p>
 * <p>
 * Variante 2:</p>
 * <p>
 * Modulus 11, Gewichtung 2, 4, 8, 5, 10, 9, 7, 3, 6, 1, 2, 4 Die Berechnung
 * erfolgt nach der Methode 53. </p>
 * <pre>
 * Testkontonummer (richtig) mit BLZ 80053782: 487310018
 * Testkontonummer (falsch)  mit BLZ 80053762: 467310018
 * Testkontonummer (falsch)  mit BLZ 80053772: 477310018
 * </pre>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodB6
        extends AbstractMethod {

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        if (number.length <= 10) {
            number = expand(number);
            return variant1(number.clone());
        } else {
            return variant2(number.clone());
        }

    }

    /**
     * <p>
     * Variante 1. </p>
     * <p>
     * Modulus 11, Gewichtung 2 ,3 ,4 ,5 ,6 ,7 ,8 ,9 ,3</p>
     * <p>
     * Kontonummern, die an der 1. Stelle der 10-stelligen Konto- nummer den
     * Wert 1-9 oder an den Stellen 1–5 die Werte 02691-02699 beinhalten, sind
     * nach der Methode 20 zu prüfen. Alle anderen Kontonummern sind nach der
     * Variante 2 zu prüfen.</p>
     * <p>
     * Testkontonummer (richtig): 9110000000, 0269876545 <br>
     * Testkontonummer (falsch): 9111000000, 0269456780</p>
     *
     * @return
     */
    boolean variant1(int[] number) {
        number = expand(number);
        this.setAccountNumberArray(number);
        long numberLong = this.getLong();
        if (number[0] == 0 && !(numberLong >= 269100000 || numberLong <= 269900000)) {
            return false;
        }
        weighting = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 3};
        Method20 m = new Method20();
        m.setAccountNumberArray(number);
        return m.check(weighting);

    }

    /**
     * <p>
     * Variante 2. </p>
     * <p>
     * Modulus 11, Gewichtung 2, 4, 8, 5, 10, 9, 7, 3, 6, 1, 2, 4</p><p>
     * Die Berechnung erfolgt nach der Methode 53. </p>
     * <pre>
     * Testkontonummer (richtig) mit BLZ 80053782: 487310018
     * Testkontonummer (falsch)  mit BLZ 80053762: 467310018
     * Testkontonummer (falsch)  mit BLZ 80053772: 477310018
     * </pre>
     *
     * @param number
     * @return
     */
    boolean variant2(int[] number) {
        Method53 m = new Method53();
        m.setAccountNumberArray(number);
        return m.check(new int[]{2, 4, 8, 5, 10, 9, 7, 3, 6, 1, 2, 4});
    }

}
