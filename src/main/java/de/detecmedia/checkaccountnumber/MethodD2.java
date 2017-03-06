package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen D2.
 * <p>
 * gültig seit 08.12.2008</p>
 * <p>
 * Variante 1:</p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 2, 3, 4</p>
 * <p>
 * Die Berechnung, Ausnahmen und möglichen Ergebnisse entsprechen der Methode
 * 95. Führt die Berechnung nach Variante 1 zu einem Prüfzifferfehler, so ist
 * nach Variante 2 zu prüfen.</p>
 * <p>
 * Testkontonummern (richtig): 189912137, 235308215<br>
 * Testkontonummern (falsch): 4455667784, 1234567897, 51181008, 71214205
 * 6414241, 179751314</p>
 * <p>
 * Variante 2:</p>
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2</p>
 * <p>
 * Die Berechnung und möglichen Ergebnisse entsprechen der Methode 00. Führt
 * auch die Berechnung nach Variante 2 zu einem Prüfzifferfehler, so ist nach
 * Variante 3 zu prüfen.</p>
 * <p>
 * Testkontonummern (richtig): 4455667784, 1234567897<br>
 * Testkontonummern (falsch): 51181008, 71214205, 6414241, 179751314</p>
 * <p>
 * Variante 3:</p>
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2</p>
 * <p>
 * Die Berechnung, Ausnahmen und möglichen Ergebnisse entsprechen der Methode
 * 68. Führt auch die Berechnung nach Variante 3 zu einem Prüfzifferfehler, so
 * ist die Kontonummer falsch.</p>
 * <p>
 * Testkontonummern (richtig): 51181008, 71214205 <br>
 * Testkontonummern (falsch): 6414241, 179751314</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodD2
        extends AbstractMethod {

    private int[] weighting;

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        if (variant1(number.clone())) {
            return true;
        }
        if (variant2(number.clone())) {
            return true;
        }
        return variant3(number.clone());
    }

    /**
     * <p>
     * Variante 1:</p>
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 2, 3, 4</p>
     * <p>
     * Die Berechnung, Ausnahmen und möglichen Ergebnisse entsprechen der
     * Methode 95. Führt die Berechnung nach Variante 1 zu einem
     * Prüfzifferfehler, so ist nach Variante 2 zu prüfen.</p>
     * <p>
     * Testkontonummern (richtig): 189912137, 235308215<br>
     * Testkontonummern (falsch): 4455667784, 1234567897, 51181008, 71214205
     * 6414241, 179751314</p>
     *
     * @return
     */
    boolean variant1(int[] number) {
        Method95 m = new Method95();
        weighting = new int[]{2, 3, 4, 5, 6, 7, 2, 3, 4};
        m.setAccountNumberArray(number);
        return m.check(weighting);

    }

    /**
     * <p>
     * Variante 2:</p>
     * <p>
     * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2</p>
     * <p>
     * Die Berechnung und möglichen Ergebnisse entsprechen der Methode 00.
     * Führt auch die Berechnung nach Variante 2 zu einem Prüfzifferfehler, so
     * ist nach Variante 3 zu prüfen.</p>
     * <p>
     * Testkontonummern (richtig): 4455667784, 1234567897<br>
     * Testkontonummern (falsch): 51181008, 71214205, 6414241, 179751314</p>
     *
     * @param number
     * @return
     */
    boolean variant2(int[] number) {
        Method00 m = new Method00();
        m.setAccountNumberArray(number);
        return m.test();
    }

    /**
     * <p>
     * Variante 3:</p>
     * <p>
     * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2</p>
     * <p>
     * Die Berechnung, Ausnahmen und möglichen Ergebnisse entsprechen der
     * Methode 68. Führt auch die Berechnung nach Variante 3 zu einem
     * Prüfzifferfehler, so ist die Kontonummer falsch.</p>
     * <p>
     * Testkontonummern (richtig): 51181008, 71214205 <br>
     * Testkontonummern (falsch): 6414241, 179751314</p>
     *
     * @return
     */
    boolean variant3(int[] number) {
        Method68 m = new Method68();
        m.setAccountNumberArray(number);
        return m.test();
    }

}
