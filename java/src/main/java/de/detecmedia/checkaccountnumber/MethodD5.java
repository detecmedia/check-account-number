package de.detecmedia.checkaccountnumber;

import java.util.Arrays;
import org.apache.log4j.Logger;

/**
 * Kennzeichen D5.
 * <p>
 * gültig seit 06.12.2010</p>
 * <ol>
 * <li>Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8, 0, 0</li>
 * <li>Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 0, 0, 0 </li>
 * <li>Modulus 7, Gewichtung 2, 3, 4, 5, 6, 7, 0, 0, 0 </li>
 * <li>Modulus 10, Gewichtung 2, 3, 4, 5, 6, 7, 0, 0, 0</li>
 * </ol>
 * <p>
 * Die Kontonummer ist einschließlich der Prüfziffer (P) 10-stellig, ggf. ist
 * die Kontonummer für die Prüfziffer- berechnung durch linksbündige
 * Auffüllung mit Nullen 10-stellig darzustellen.</p>
 * <p>
 * Konten mit der Ziffernfolge 99 an Stelle 3 und 4 (xx99xxxxxx) sind nur nach
 * Variante 1 zu prüfen. Alle übrigen Konten sind nacheinander nach den
 * Varianten 2, ggf. 3 und ggf. 4 zu prüfen.</p>
 * <p>
 * Variante 1:</p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8, 0, 0</p>
 * <p>
 * In die Prüfzifferberechnung werden nur die Stellen 3 bis 9 einbezogen. Die
 * Stelle 10 ist die Prüfziffer (P). Die weitere Berechnung erfolgt nach dem
 * Verfahren 06.</p>
 * <pre>
 * Beispiel:
 * Stelle-Nr.  1  2  3  4  5  6  7  8  9  10
 * Kontonummer 5  9  9  9  2  4  2  1  3  3
 * Gewichtung  0  0  8  7  6  5  4  3  2  P
 * -----------------------------------------
 * Produkt     0  0 72 63 12 20  8  3  6  = 184
 *
 * 184 : 11 = 16, Rest 8
 * 11- 8=3=P
 * Testkontonummern (richtig): 5999718138, 1799222116, 0099632004
 * Testkontonummern (falsch): 3299632008, 1999204293, 0399242139
 * </pre>
 * <p>
 * Variante 2:
 * </p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 0, 0, 0
 * </p>
 * <p>
 * n die Prüfzifferberechnung werden nur die Stellen 4 bis 9 einbezogen. Die
 * Stelle 10 ist die Prüfziffer (P). Die weitere Berechnung erfolgt nach dem
 * Verfahren 06.
 * </p>
 * <pre>
 * Beispiel:
 * Stelle-Nr.       1  2  3  4  5  6  7  8  9  10
 * Kontonummer      0  0  0  4  7  1  1  1  4  7
 * Gewischtung      0  0  0  7  6  5  4  3  2  P
 * ---------------------------------------------
 * Produkt          0  0  0 28 42  5  4  3  8  = 96
 *
 * 96 : 11 = 8, Rest 8
 * 11- 8 = 3 = P
 * Testkontonummern (richtig): 0004711173, 0007093330, 0000127787
 * Testkontonummern (falsch): 0004711172, 8623420004, 0001123458
 * </pre>
 * <p>
 * Führt die Berechnung zu einem Fehler, ist nach Variante 3 zu prüfen.
 * </p>
 * <p>
 * Variante 3:</p>
 * <p>
 * Modulus 7, Gewichtung 2, 3, 4, 5, 6, 7, 0, 0, 0</p>
 * <p>
 * Die Stellen 4 bis 9 der Kontonummer werden von rechts nach links mit den
 * Gewichten multipliziert. Die jeweiligen Produkte werden addiert. Die Summe
 * ist durch 7 zu dividieren. Der verbleibende Rest wird vom Divisor (7)
 * subtrahiert. Das Ergebnis ist die Prüfziffer (Stelle 10). Verbleibt nach der
 * Division durch 7 kein Rest, ist die Prüfziffer 0.
 * </p>
 * <pre>
 * Beispiel:
 * Stelle-Nr.       1  2  3  4  5  6  7  8  9  10
 * Kontonummer      0  0  0  4  7  1  1  1  7  4
 * Gewichtung       0  0  0  7  6  5  4  3  2  P
 * ----------------------------------------------
 * Produkt          0  0  0 28 42  5  4  3  1  4 = 96
 *
 * 96 : 7 = 13, Rest 5
 * 7-5=2=P
 *
 * Testkontonummern (richtig): 0004711172, 0007093335
 * Testkontonummern (falsch) : 8623410000, 0001123458
 * </pre>
 * <p>
 * Führt die Berechnung zu einem Fehler, ist nach Variante 4 zu prüfen.</p>
 * <p>
 * Variante 4:</p>
 * <p>
 * Modulus 10, Gewichtung 2, 3, 4, 5, 6, 7, 0, 0, 0</p>
 * <p>
 * Die Berechnung erfolgt analog zu Variante 3, jedoch ist als Divisor der Wert
 * 10 zu verwenden. Verbleibt nach der Division durch 10 kein Rest, ist die
 * Prüfziffer 0.
 * </p>
 * <pre>
 * Beispiel.
 * Stelle-Nr.       1  2  3  4  5  6  7  8  9  10
 * Kontonummer      0  0  0  4  7  1  1  1  7  4
 * Gewichtung       0  0  0  7  6  5  4  3  2  P
 * ----------------------------------------------
 * Produkt          0  0  0 28 42  5  4  3  1  4 = 96
 *
 * 96 : 10 = 9, Rest 6
 * 10- 6=4=P
 *
 * Testkontonummern (richtig): 0000100062, 0000100088
 * Testkontonummern (falsch): 0000100084, 0000100085
 * </pre>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodD5
        extends AbstractMethod {

    private final Logger log = Logger.getLogger(MethodD5.class);

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        if (variant1(number.clone())) {
            return true;
        }
        
        if (variant2(number.clone())) {
            return true;
        }
        
        if (variant3(number.clone())) {
            return true;
        }
        
        return variant4(number.clone());
    }

    /**
     * <p>
     * Variante 1:</p>
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8, 0, 0</p>
     * <p>
     * In die Prüfzifferberechnung werden nur die Stellen 3 bis 9 einbezogen.
     * Die Stelle 10 ist die Prüfziffer (P). Die weitere Berechnung erfolgt
     * nach dem Verfahren 06.</p>
     * <pre>
     * Beispiel:
     * Stelle-Nr.  1  2  3  4  5  6  7  8  9  10
     * Kontonummer 5  9  9  9  2  4  2  1  3  3
     * Gewichtung  0  0  8  7  6  5  4  3  2  P
     * -----------------------------------------
     * Produkt     0  0 72 63 12 20  8  3  6  = 184
     *
     * 184 : 11 = 16, Rest 8
     * 11- 8=3=P
     * Testkontonummern (richtig): 5999718138, 1799222116, 0099632004
     * Testkontonummern (falsch): 3299632008, 1999204293, 0399242139
     * </pre>
     *
     * @param number
     * @return
     */
    boolean variant1(int[] number) {
        Method06 method06 = new Method06();
        weighting = new int[]{2, 3, 4, 5, 6, 7, 8, 0, 0};
        method06.setAccountNumberArray(number);
        number = method06.factor(number, weighting, 3, 9);
        int pz = method06.add(number, 2, 9);
        pz = method06.modulus11(pz);
        return checkPz(pz, number);
    }

    /**
     * <p>
     * Variante 2.
     * </p>
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 0, 0, 0
     * </p>
     * <p>
     * n die Prüfzifferberechnung werden nur die Stellen 4 bis 9 einbezogen.
     * Die Stelle 10 ist die Prüfziffer (P). Die weitere Berechnung erfolgt
     * nach dem Verfahren 06.
     * </p>
     * <pre>
     * Beispiel:
     * Stelle-Nr.       1  2  3  4  5  6  7  8  9  10
     * Kontonummer      0  0  0  4  7  1  1  1  4  7
     * Gewischtung      0  0  0  7  6  5  4  3  2  P
     * ---------------------------------------------
     * Produkt          0  0  0 28 42  5  4  3  8  = 96
     *
     * 96 : 11 = 8, Rest 8
     * 11- 8 = 3 = P
     * Testkontonummern (richtig): 0004711173, 0007093330, 0000127787
     * Testkontonummern (falsch): 0004711172, 8623420004, 0001123458
     * </pre>
     * <p>
     * Führt die Berechnung zu einem
     *
     * @param number
     * @return
     */
    boolean variant2(int[] number) {
        Method06 method06 = new Method06();
        weighting = new int[]{2, 3, 4, 5, 6, 7, 0, 0, 0};
        method06.setAccountNumberArray(number);
        number = method06.factor(number, weighting, 4, 9);
        int pz = method06.add(number, 3, 9);
        pz = method06.modulus11(pz);
        return checkPz(pz, number);
    }

    /**
     * <p>
     * Variante 3. </p>
     * <p>
     * Modulus 7, Gewichtung 2, 3, 4, 5, 6, 7, 0, 0, 0</p>
     * <p>
     * Die Stellen 4 bis 9 der Kontonummer werden von rechts nach links mit den
     * Gewichten multipliziert. Die jeweiligen Produkte werden addiert. Die
     * Summe ist durch 7 zu dividieren. Der verbleibende Rest wird vom Divisor
     * (7) subtrahiert. Das Ergebnis ist die Prüfziffer (Stelle 10). Verbleibt
     * nach der Division durch 7 kein Rest, ist die Prüfziffer 0.
     * </p>
     * <pre>
     * Beispiel:
     * Stelle-Nr.       1  2  3  4  5  6  7  8  9  10
     * Kontonummer      0  0  0  4  7  1  1  1  7  4
     * Gewichtung       0  0  0  7  6  5  4  3  2  P
     * ----------------------------------------------
     * Produkt          0  0  0 28 42  5  4  3  1  4 = 96
     *
     * 96 : 7 = 13, Rest 5
     * 7-5=2=P
     *
     * Testkontonummern (richtig): 0004711172, 0007093335
     * Testkontonummern (falsch) : 8623410000, 0001123458
     * </pre>
     * <p>
     * Führt die Berechnung zu einem Fehler, ist nach Variante 4 zu
     * prüfen.</p>
     * <p>
     * @param number
     * @return
     */
    boolean variant3(int[] number) {

        log.debug("number -> " + Arrays.toString(number));
        number = expand(number);
        weighting = new int[]{2, 3, 4, 5, 6, 7, 0, 0, 0};
        number = factor(number, weighting, 4, 9);
        int pz = add(number, 3, 9);
        pz = modulus7(pz);
        return checkPz(pz, number);
    }

    /**
     * <p>
     * Variante 4.
     * </p>
     * <p>
     * Modulus 10, Gewichtung 2, 3, 4, 5, 6, 7, 0, 0, 0</p>
     * <p>
     * Die Berechnung erfolgt analog zu Variante 3, jedoch ist als Divisor der
     * Wert 10 zu verwenden. Verbleibt nach der Division durch 10 kein Rest, ist
     * die Prüfziffer 0.
     * </p>
     * <pre>
     * Beispiel.
     * Stelle-Nr.       1  2  3  4  5  6  7  8  9  10
     * Kontonummer      0  0  0  4  7  1  1  1  7  4
     * Gewichtung       0  0  0  7  6  5  4  3  2  P
     * ----------------------------------------------
     * Produkt          0+ 0+ 0+28+42+ 5+ 4+ 3+ 14 = 96
     *
     * 96 : 10 = 9, Rest 6
     * 10- 6=4=P
     *
     * Testkontonummern (richtig): 0000100062, 0000100088
     * Testkontonummern (falsch): 0000100084, 0000100085
     * </pre>
     *
     * @param number
     * @return
     */
    boolean variant4(int[] number) {

        log.debug("number -> " + Arrays.toString(number));
        weighting = new int[]{2, 3, 4, 5, 6, 7, 0, 0, 0};
        number = factor(number, weighting);
        int pz = add(number);
        pz = modulus10(pz);
        return checkPz(pz, number);
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

    /**
     * * 96 : 7 = 13, Rest 5 7-5=2=P
     *
     * @param pz
     * @return
     */
    @Override
    protected int modulus7(int pz) {
        log.debug("%7 " + (pz % 7));
        return 7 - (pz % 7);
    }

}
