package de.detecmedia.checkaccountnumber;

import org.apache.log4j.Logger;

/**
 * Kennzeichen A4.
 * <p>
 * <b>gültig seit 09.06.2003</b></p>
 * <p>
 * <b>redaktionelle Änderung zum 08.09.2003</b></p>
 * <ol>
 * <li>Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 0, 0, 0</li>
 * <li>Modulus 7, Gewichtung 2, 3, 4, 5, 6, 7, 0, 0, 0</li>
 * <li>Modulus 11, Gewichtung 2, 3, 4, 5, 6, 0, 0, 0, 0</li>
 * <li>Modulus 11, Gewichtung 2, 3, 4, 5, 6<br>
 * Modulus 7, Gewichtung 2, 3, 4, 5, 6</li>
 * </ol>
 * <p>
 * Die Kontonummer ist einschließlich der Prüfziffer 10-stellig, ggf. ist die
 * Kontonummer für die Prüfzifferberechnung durch linksbündige Auffüllung
 * mit Nullen 10-stellig darzustellen. Zur Prüfung einer Kontonummer sind die
 * folgenden Varianten zu rechnen. Dabei ist zu beachten, dass Kontonummern mit
 * der Ziffernfolge 99 an den Stellen 3 und 4 (XX99XXXXXX) nur nach Variante 3
 * und ggf. 4 zu prüfen sind. Alle anderen Kontonummern sind nacheinander nach
 * den Varianten 1, ggf. 2 und ggf. 4 zu prüfen.</p>
 * <p>
 * Variante 1:</p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 0, 0, 0</p>
 * <p>
 * In die Prüfzifferberechnung werden nur die Stellen 4 bis 9 einbezogen. Die
 * Stelle 10 ist die Prüfziffer. Die weitere Berechnung erfolgt nach dem
 * Verfahren 06.</p>
 * <pre>
 * Beispiel:
 * Kontonr.: 0004711173
 * Gewichtung: 0 0 0 7 6 5 4 3 2 P
 * Produkt: 0+ 0+ 0+28+42+ 5+ 4+ 3+14=96
 * 96:11 = 8, Rest8
 * 11 - 8 = 3 = P
 * </pre>
 * <p>
 * Testkontonummern (richtig): 0004711173, 0007093330 Testkontonummern (falsch):
 * 0004711172, 8623420004, 0001123458</p>
 * <p>
 * Führt die Berechnung zu einem Fehler, ist nach Variante 2 zu prüfen.</p>
 * <p>
 * Variante 2:</p>
 * <p>
 * Modulus 7, Gewichtung 2, 3, 4, 5, 6, 7, 0, 0, 0</p>
 * <p>
 * Die Stellen 4 bis 9 der Kontonummer werden von rechts nach links mit den
 * Gewichten multipliziert. Die jeweiligen Produkte werden addiert. Die Summe
 * ist durch 7 zu dividieren. Der verbleibende Rest wird vom Divisor (7)
 * subtrahiert. Das Ergebnis ist die Prüfziffer (Stelle 10). Verbleibt nach der
 * Division kein Rest, ist die Prüfziffer 0.</p>
 * <pre>
 * Beispiel:
 * Kontonr.: 0004711172
 * Gewichtung: 0 0 0 7 6 5 4 3 2 P
 * Produkt: 0+ 0+ 0+28+42+ 5+ 4+ 3+ 14 =96
 * 96:7 = 13, Rest5
 * 7-5 = 2=P
 * </pre>
 * <p>
 * Testkontonummern (richtig): 0004711172, 0007093335 <br>
 * Testkontonummern (falsch): 8623420000, 0001123458</p>
 * <p>
 * Führt die Berechnung zu einem Fehler, ist nach Variante 4 zu prüfen.</p>
 * <p>
 * Variante 3:</p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 0, 0, 0, 0</p>
 * <p>
 * In die Prüfzifferberechnung werden nur die Stellen 5 bis 9 einbezogen. Die
 * Stelle 10 ist die Prüfziffer. Die weitere Berechnung erfolgt nach dem
 * Verfahren 06.</p>
 * <pre>Beispiel:
 * 1199503010 Gewichtung: 0 0 0 0 6 5 4 3 2 P Produkt: 0+ 0+ 0+ 0+30+0+12+ 0+ 2 =44
 * 44:11 =4,Rest0=P
 * </pre>
 * <p>
 * Testkontonummern (richtig):1199503010, 8499421235 Testkontonummern (falsch):
 * 1299503117, 6099702031</p>
 * <p>
 * Führt die Berechnung zu einem Fehler, ist nach Variante 4 zu prüfen.</p>
 * <p>
 * Variante 4:</p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6</p>
 * <p>
 * Modulus 7, Gewichtung 2, 3, 4, 5, 6</p>
 * <p>
 * Die Gewichtung und Berechnung erfolgen nach Methode 93.</p>
 * <pre>
 * Testkontonummern (richtig):
 * 0000862342, 8997710000, 0664040000 (Modulus 7)
 * 0000905844, 5030101099 (Modulus 11)
 * 0001123458, 1299503117
 * Testkontonummern (falsch): 0000399443, 0000553313
 * </pre>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodA4 extends AbstractMethod {

    private final Logger log = Logger.getLogger(MethodA4.class);

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        number = expand(number);
        if (number[2] == 9 && number[3] == 9) {
            if (variant3(number)) {
                return true;
            }
            number = this.getAccountNumberArray();
            number = expand(number);
            if (variant4(number)) {
                return true;
            }
        }
        number = this.getAccountNumberArray();
        number = expand(number);
        if (variant1(number)) {
            return true;
        }
        number = this.getAccountNumberArray();
        number = expand(number);
        if (variant2(number)) {
            return true;
        }
        number = this.getAccountNumberArray();
        number = expand(number);
        if (variant4(number)) {
            return true;
        }

        return false;
    }

    /**
     * <p>
     * Variante 1:</p>
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 0, 0, 0</p>
     * <p>
     * In die Prüfzifferberechnung werden nur die Stellen 4 bis 9 einbezogen.
     * Die Stelle 10 ist die Prüfziffer. Die weitere Berechnung erfolgt nach
     * dem Verfahren 06.</p>
     * <pre>
     * Beispiel:
     * Kontonr.:   0  0  0  4  7  1  1  1  7  3
     * Gewichtung: 0  0  0  7  6  5  4  3  2  P
     *            -----------------------------
     * Produkt:    0+ 0+ 0+28+42+ 5+ 4+ 3+14 = 96
     * 96:11 = 8, Rest8
     * 11 - 8 = 3 = P
     * </pre>
     * <p>
     * Testkontonummern (richtig): 0004711173, 0007093330 Testkontonummern
     * (falsch): 0004711172, 8623420004, 0001123458</p>
     * <p>
     * Führt die Berechnung zu einem Fehler, ist nach Variante 2 zu
     * prüfen.</p>
     *
     * @param number
     * @return
     */
    boolean variant1(int[] number) {
        weighting = new int[]{2, 3, 4, 5, 6, 7, 0, 0, 0};
        Method06 method06 = new Method06();
        method06.setAccountNumberArray(number);
        return method06.check(weighting);

    }

    /**
     * <p>
     * Variante 2. </p>
     * <p>
     * Modulus 7, Gewichtung 2, 3, 4, 5, 6, 7, 0, 0, 0</p>
     * <p>
     * Die Stellen 4 bis 9 der Kontonummer werden von rechts nach links mit den
     * Gewichten multipliziert. Die jeweiligen Produkte werden addiert. Die
     * Summe ist durch 7 zu dividieren. Der verbleibende Rest wird vom Divisor
     * (7) subtrahiert. Das Ergebnis ist die Prüfziffer (Stelle 10). Verbleibt
     * nach der Division kein Rest, ist die Prüfziffer 0.</p>
     * <pre>
     * Beispiel:
     * Kontonr.:   0  0  0  4  7  1  1  1  7  2
     * Gewichtung: 0  0  0  7  6  5  4  3  2  P
     *           ------------------------------
     * Produkt:    0+ 0+ 0+28+42+ 5+ 4+ 3+ 14 = 96
     * 96:7 = 13, Rest 5
     * 7-5 = 2=P
     * </pre>
     * <p>
     * Testkontonummern (richtig): 0004711172, 0007093335 <br>
     * Testkontonummern (falsch): 8623420000, 0001123458</p>
     * <p>
     * Führt die Berechnung zu einem Fehler, ist nach Variante 4 zu
     * prüfen.</p>
     *
     * @param number
     * @return
     */
    boolean variant2(int[] number) {
        weighting = new int[]{2, 3, 4, 5, 6, 7, 0, 0, 0};
        number = expand(number);
        number = factor(number, weighting);
        int pz = add(number);
        pz = modulus7(pz);
        return checkPz(pz, number);
    }

    /**
     * <p>
     * Variante 3. </p>
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 0, 0, 0, 0</p>
     * <p>
     * In die Prüfzifferberechnung werden nur die Stellen 5 bis 9 einbezogen.
     * Die Stelle 10 ist die Prüfziffer. Die weitere Berechnung erfolgt nach
     * dem Verfahren 06.</p>
     * <pre>Beispiel:
     *               1  1  9  9  5  0  3  0  1  0
     * Gewichtung:   0  0  0  0  6  5  4  3  2  P
     *             ------------------------------
     * Produkt:      0+ 0+ 0+ 0+30+ 0+12+ 0+ 2 = 44
     * 44:11 =4,Rest 0 = P
     * </pre>
     * <p>
     * Testkontonummern (richtig):1199503010, 8499421235 Testkontonummern
     * (falsch): 1299503117, 6099702031</p>
     * <p>
     * Führt die Berechnung zu einem Fehler, ist nach Variante 4 zu
     * prüfen.</p>
     *
     * @param number
     * @return
     */
    boolean variant3(int[] number) {
        weighting = new int[]{2, 3, 4, 5, 6, 0, 0, 0, 0};
        Method06 method06 = new Method06();
        method06.setAccountNumberArray(number);
        return method06.check(weighting);

    }

    /**
     * <p>
     * Variante 4. </p>
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6</p>
     * <p>
     * Modulus 7, Gewichtung 2, 3, 4, 5, 6</p>
     * <p>
     * Die Gewichtung und Berechnung erfolgen nach Methode 93.</p>
     * <pre>
     * Testkontonummern (richtig):
     * 0000862342, 8997710000, 0664040000 (Modulus 7)
     * 0000905844, 5030101099 (Modulus 11)
     * 0001123458, 1299503117
     * Testkontonummern (falsch): 0000399443, 0000553313
     * </pre>
     *
     * @param number
     * @return
     */
    boolean variant4(int[] number) {
        Method93 method93 = new Method93();
        method93.setAccountNumberArray(number);
        return method93.test();
    }

    @Override
    protected int add(int[] number, int start, int end) {
        log.debug(start + " to " + end);
        int pz = 0;
        for (int i = start--; i < end; i++) {

            int o = number[i];

            log.debug("+" + o);
            pz += o;
        }
        log.debug("after add: " + pz);
        return pz;
    }

}
