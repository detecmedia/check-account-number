package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen C1.
 * <p>
 * gültig seit 05.06.2006</p>
 * <p>
 * Die Kontonummer ist einschließlich der Prüfziffer 10-stellig, ggf. ist die
 * Kontonummer für die Prüfzifferberechnung durch linksbündige Auffüllung
 * mit Nullen 10-stellig darzustellen.</p>
 * <p>
 * Kontonummern, die an der 1. Stelle der 10-stelligen Kontonummer einen Wert
 * ungleich „5“ beinhalten, sind nach der Variante 1 zu prüfen. Kontonummern,
 * die an der 1. Stelle der 10-stelligen Kontonummer den Wert „5“ beinhalten,
 * sind nach der Variante 2 zu prüfen.</p>
 * <p>
 * Variante 1:</p>
 * <p>
 * Modulus 11, Gewichtung 1, 2, 1, 2, 1, 2</p>
 * <p>
 * Die Berechnung und mögliche Ergebnisse entsprechen der Methode 17. Führt
 * die Berechnung nach der Variante 1 zu einem Prüfzifferfehler, so ist die
 * Kontonummer falsch.</p>
 * <p>
 * Testkontonummern (richtig): 0446786040, 0478046940, 0701625830, 0701625840,
 * 0882095630 <br>
 * Testkontonummern (falsch): 0446786240, 0478046340, 0701625730, 0701625440,
 * 0882095130</p>
 * <p>
 * Variante 2:</p>
 * <p>
 * Modulus 11, Gewichtung 1, 2, 1, 2, 1, 2</p>
 * <pre>
 * Die Kontonummer ist 10-stellig mit folgendem Aufbau:
 * KNNNNNNNNP
 * K = Kontoartziffer
 * N = laufende Nummer
 * P = Prüfziffer</pre>
 * <p>
 * Für die Berechnung fließen die Stellen 1 bis 9 ein. Stelle 10 ist die
 * ermittelte Prüfziffer. Die Stellen 1 bis 9 sind von links nach rechts mit
 * den Ziffern 1, 2, 1, 2, 1, 2, 1, 2, 1 zu multiplizieren. Die jeweiligen
 * Produkte sind zu addieren, nachdem aus eventuell zweistelligen Produkten der
 * 2., 4., 6. und 8. Stelle die Quersumme gebildet wurde. Von der Summe ist der
 * Wert „1“ zu subtrahieren. Das Ergebnis ist dann durch 11 zu dividieren. Der
 * verbleibende Rest wird von 10 subtrahiert. Das Ergebnis ist die Prüfziffer.
 * Verbleibt nach der Division durch 11 kein Rest, ist die Prüfziffer 0.</p>
 * <pre>Beispiel:
 * Stellen-Nr.:  K N N N N N N N N P
 * Konto-Nr.:    5 4 3 2 1 1 2 3 4 9
 * Gewichtung:   1 2 1 2 1 2 1 2 1
 *               -----------------
 *               5+8+3+4+1+2+2+6+4 = 35
 * 35 - 1 = 34
 * 34 : 11 = 3, Rest 1
 * 10 - 1 = 9 (Prüfziffer)
 * </pre>
 * <p>
 * Testkontonummern richtig: 5432112349, 5543223456, 5654334563, 5765445670,
 * 5876556788 <br>
 * Testkontonummern falsch: 5432112341, 5543223458, 5654334565, 5765445672,
 * 5876556780</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodC1
        extends AbstractMethod {

    private int[] weighting;

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        if (variant1(number.clone()) && number[0] != 5) {
            return true;
        }
        if (variant2(number.clone()) && number[0] == 5) {
            return true;
        }
        return false;
    }

    /**
     * <p>
     * Variante 1. </p>
     * <p>
     * Modulus 11, Gewichtung 1, 2, 1, 2, 1, 2</p>
     * <p>
     * Die Berechnung und mögliche Ergebnisse entsprechen der Methode 17.
     * Führt die Berechnung nach der Variante 1 zu einem Prüfzifferfehler, so
     * ist die Kontonummer falsch.</p>
     * <p>
     * Testkontonummern (richtig): 0446786040, 0478046940, 0701625830,
     * 0701625840, 0882095630 <br>
     * Testkontonummern (falsch): 0446786240, 0478046340, 0701625730,
     * 0701625440, 0882095130</p>
     *
     * @return
     */
    boolean variant1(int[] number) {
        weighting = new int[]{2, 1, 2, 1, 2, 1, 2};
        Method17 m = new Method17();
        m.setAccountNumberArray(number);
        return m.check(weighting);
    }

    /**
     * <p>
     * Variante 2. </p>
     * <p>
     * Modulus 11, Gewichtung 1, 2, 1, 2, 1, 2</p>
     * <pre>
     * Die Kontonummer ist 10-stellig mit folgendem Aufbau:
     * KNNNNNNNNP
     * K = Kontoartziffer
     * N = laufende Nummer
     * P = Prüfziffer</pre>
     * <p>
     * Für die Berechnung fließen die Stellen 1 bis 9 ein. Stelle 10 ist die
     * ermittelte Prüfziffer. Die Stellen 1 bis 9 sind von links nach rechts
     * mit den Ziffern 1, 2, 1, 2, 1, 2, 1, 2, 1 zu multiplizieren. Die
     * jeweiligen Produkte sind zu addieren, nachdem aus eventuell zweistelligen
     * Produkten der 2., 4., 6. und 8. Stelle die Quersumme gebildet wurde. Von
     * der Summe ist der Wert „1“ zu subtrahieren. Das Ergebnis ist dann durch
     * 11 zu dividieren. Der verbleibende Rest wird von 10 subtrahiert. Das
     * Ergebnis ist die Prüfziffer. Verbleibt nach der Division durch 11 kein
     * Rest, ist die Prüfziffer 0.</p>
     * <pre>Beispiel:
     * Stellen-Nr.:  K N N N N N N N N P
     * Konto-Nr.:    5 4 3 2 1 1 2 3 4 9
     * Gewichtung:   1 2 1 2 1 2 1 2 1
     *               -----------------
     *               5+8+3+4+1+2+2+6+4 = 35
     * 35 - 1 = 34
     * 34 : 11 = 3, Rest 1
     * 10 - 1 = 9 (Prüfziffer)
     * </pre>
     * <p>
     * Testkontonummern richtig: 5432112349, 5543223456, 5654334563, 5765445670,
     * 5876556788 <br>
     * Testkontonummern falsch: 5432112341, 5543223458, 5654334565, 5765445672,
     * 5876556780</p>
     *
     * @param number
     * @return
     */
    boolean variant2(int[] number) {
        number = expand(number);
        weighting = new int[]{1, 2, 1, 2, 1, 2, 1, 2, 1};
        number = factor(number, weighting);
        int pz = add(number);
        pz -= 1;
        pz %= 11;
        pz = 10 - pz;

        return this.checkPz(pz, number);
    }

}
