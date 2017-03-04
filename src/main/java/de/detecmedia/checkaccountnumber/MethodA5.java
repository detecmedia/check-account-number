package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen A5.
 * <p>
 * <b>gültig seit 09.06.2003</b></p>
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
 * nach Variante 1 zu einem Prüfziffer- fehler, so sind 10-stellige Konten mit
 * einer 9 an Stelle 1 falsch, alle anderen Konten sind nach Variante 2 zu
 * prüfen.</p>
 * <p>
 * Testkontonummern (richtig): 9941510001, 9961230019 9380027210, 9932290910<br>
 * Testkontonummern (falsch): 9941510002, 9961230020</p>
 * <p>
 * Variante 2:</p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8, 9, 10 Gewichtung und Berechnung
 * erfolgen nach der Methode 10. </p>
 * <p>
 * Testkontonummern (richtig): 0000251437, 0007948344,0000159590, 0000051640<br>
 * Testkontonummern (falsch): 0000251438, 0007948345</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodA5
        extends AbstractMethod {

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        number = expand(number);
        if (variant1(number)) {
            return true;
        }
        number = this.getAccountNumberArray();
        number = expand(number);
        if (number[0] == 9) {
            return false;
        }
        number = this.getAccountNumberArray();
        number = expand(number);
        if (variant2(number)) {
            return true;
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
     * Berechnung nach Variante 1 zu einem Prüfziffer- fehler, so sind
     * 10-stellige Konten mit einer 9 an Stelle 1 falsch, alle anderen Konten
     * sind nach Variante 2 zu prüfen.</p>
     * <p>
     * Testkontonummern (richtig): 9941510001, 9961230019 9380027210,
     * 9932290910<br>
     * Testkontonummern (falsch): 9941510002, 9961230020</p>
     *
     * @param number
     * @return
     */
    boolean variant1(int[] number) {
        weighting = new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2};
        Method00 method00 = new Method00();
        method00.setAccountNumberArray(number);
        return method00.check(weighting);
    }

    /**
     * <p>
     * Variante 2:</p>
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8, 9, 10 Gewichtung und
     * Berechnung erfolgen nach der Methode 10. </p>
     * <p>
     * Testkontonummern (richtig): 0000251437, 0007948344,0000159590,
     * 0000051640<br>
     * Testkontonummern (falsch): 0000251438, 0007948345</p>
     *
     * @param number
     * @return
     */
    boolean variant2(int[] number) {
        Method10 method10 = new Method10();
        weighting = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10};
        method10.setAccountNumberArray(number);
        return method10.check(weighting);
    }

}
