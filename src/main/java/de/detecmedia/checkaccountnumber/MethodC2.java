package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen C2.
 * <p>
 * gültig seit 05.06.2006</p>
 * <p>
 * Die Kontonummer ist einschließlich der Prüfziffer 10-stellig, ggf. ist die
 * Kontonummer für die Prüfzifferberechnung durch linksbündige Auffüllung
 * mit Nullen 10-stellig darzustellen.</p>
 * <p>
 * Die 10. Stelle der Kontonummer ist die Prüfziffer.</p>
 * <p>
 * Variante 1:</p>
 * <p>
 * Modulus 10, Gewichtung 3, 1, 3, 1, 3, 1, 3, 1, 3</p>
 * <p>
 * Die Berechnung und mögliche Ergebnisse entsprechen der Methode 22. Führt
 * die Berechnung nach Variante 1 zu einem Prüfzifferfehler, so ist nach
 * Variante 2 zu prüfen.</p>
 * <p>
 * Testkontonummern (richtig): 2394871426, 4218461950, 7352569148<br>
 * Testkontonummern (falsch): 5127485166, 8738142564, 0328705282, 9024675131</p>
 * <p>
 * Variante 2:</p>
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2</p>
 * <p>
 * Die Berechnung und mögliche Ergebnisse entsprechen der Methode 00.</p>
 * <p>
 * Testkontonummern (richtig): 5127485166, 8738142564 <br>
 * Testkontonummern (falsch): 0328705282, 9024675131</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodC2
        extends AbstractMethod {

    private int[] weighting;

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        number = expand(number);
        if (variant1(number.clone())) {
            return true;
        }
        if (variant2(number.clone())) {
            return true;
        }
        return false;
    }

    /**
     * <p>
     * Variante 1. </p>
     * <p>
     * Modulus 10, Gewichtung 3, 1, 3, 1, 3, 1, 3, 1, 3</p>
     * <p>
     * Die Berechnung und mögliche Ergebnisse entsprechen der Methode 22.
     * Führt die Berechnung nach Variante 1 zu einem Prüfzifferfehler, so ist
     * nach Variante 2 zu prüfen.</p>
     * <p>
     * Testkontonummern (richtig): 2394871426, 4218461950, 7352569148<br>
     * Testkontonummern (falsch): 5127485166, 8738142564, 0328705282,
     * 9024675131</p>
     *
     * @return
     */
    boolean variant1(int[] number) {
        Method22 m = new Method22();
        m.setAccountNumberArray(number);
        return m.test();

    }

    /**
     * <p>
     * Variante 2. </p>
     * <p>
     * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2</p>
     * <p>
     * Die Berechnung und mögliche Ergebnisse entsprechen der Methode 00.</p>
     * <p>
     * Testkontonummern (richtig): 5127485166, 8738142564 <br>
     * Testkontonummern (falsch): 0328705282, 9024675131</p>
     *
     * @param number
     * @return
     */
    boolean variant2(int[] number) {
        Method00 m = new Method00();
        m.setAccountNumberArray(number);
        weighting = new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2};
        return m.check(weighting);

    }
}
