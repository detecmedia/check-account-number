package de.detecmedia.checkaccountnumber;

import java.util.Arrays;
import org.apache.log4j.Logger;

/**
 * Kennzeichen B9.
 * <p>
 * gültig seit 05.12.2005</p>
 * <p>
 * Die Kontonummer ist einschließlich der Prüfziffer 10-stellig, ggf. ist die
 * Kontonummer für die Prüfzifferberechnung durch linksbündige Auffüllung
 * mit Nullen 10-stellig darzustellen.</p>
 * <p>
 * Kontonummern mit weniger als zwei oder mehr als drei führenden Nullen sind
 * falsch. Die Kontonummern mit zwei führenden Nullen sind nach Variante 1, mit
 * drei führenden Nullen nach Variante 2 zu prüfen.</p>
 * <p>
 * Variante 1:</p>
 * <p>
 * Modulus (11,10), Gewichtung 1, 3, 2, 1, 3, 2, 1</p>
 * <p>
 * Die für die Berechnung relevanten Stellen der Kontonummer befinden sich -
 * von links nach rechts gelesen - in den Stellen 3-9 (die Prüfziffer ist in
 * Stelle 10). Sie sind – von rechts nach links – mit den zugehörigen
 * Gewichtungsfaktoren zu multiplizieren.</p>
 * <p>
 * Zum jeweiligen Produkt ist der zugehörige Gewichtungsfaktor zu addieren. Das
 * jeweilige Ergebnis ist durch 11 zu dividieren. Die sich aus der Division
 * ergebenden Reste sind zu summieren. Diese Summe ist durch 10 zu dividieren.
 * Der Rest ist die berechnete Prüfziffer.</p>
 * <p>
 * Führt die Berechnung zu einem Prüfzifferfehler, so ist die berechnete
 * Prüfziffer um 5 zu erhöhen und erneut zu prüfen. Ist die Prüfziffer
 * größer oder gleich 10, ist 10 abzuziehen und das Ergebnis ist dann die
 * Prüfziffer.</p>
 * <p>
 * Rechenbeispiel mit der Testkontonummer 0087920187:</p>
 * <pre>
 * 8x1= 8+1= 9   9:11=0 Rest 9
 * 7x2=14+2=16   16:11 = 1 Rest 5
 * 9x3=27+3=30   30:11 = 2 Rest 8
 * 2x1= 2+1= 3   3:11=0 Rest 3
 * 0x2= 0+2= 2   2:11=0 Rest 2
 * 1x3= 3+3= 6   6:11=0 Rest 6
 * 8x1= 8+1= 9   9:11=0 Summe der
 * Rest ￼ 9 Reste: 42
 *
 *
 * 42 : 10 = 4 Rest 2 (= falsche Prüfziffer)
 * ==<code>&gt;</code> 2 + 5 = 7 (= Prüfziffer)Testkontonummern (richtig):
 *                             87920187, 41203755, 81069577, 61287958,
 *                             58467232
 *
 * Testkontonummern (falsch): 88034023, 43025432,
 *                            86521362, 61256523,
 *                            54352684
 * </pre>
 * <p>
 * Variante 2:</p>
 * <p>
 * Modulus 11, Gewichtung 1, 2, 3, 4, 5, 6</p>
 * <p>
 * Die für die Berechnung relevanten Stellen der Kontonummer befinden sich -
 * von links nach rechts gelesen- in den Stellen 4-9 (die Prüfziffer ist in
 * Stelle 10). Sie sind von rechts nach links mit den zugehörigen
 * Gewichtungsfaktoren zu multiplizieren. Die Summe dieser Produkte ist zu
 * bilden, und das erzielte Ergebnis ist durch 11 zu dividieren. Der Rest ist
 * die berechnete Prüfziffer.</p>
 * <p>
 * Führt die Berechnung zu einem Prüfzifferfehler, so ist die berechnete
 * Prüfziffer um 5 zu erhöhen und erneut zu prüfen.</p>
 * <p>
 * Ist die Prüfziffer größer oder gleich 10, ist 10 abzuziehen und das
 * Ergebnis ist dann die Prüfziffer.</p>
 * <p>
 * Rechenbeispiel mit der Testkontonummer 7125633:</p>
 * <pre>
 * 7x6 =42
 * 1x5=5
 * 2x4=8
 * 5x3 =15
 * 6x2 =12
 * 3x1=3
 * ------
 * Summe = 85
 *
 * 85 : 11 = 7
 * 9:11=0 Rest 8 (= falsche Prüfziffer)
 *        ==<code>&gt;</code> 8 + 5 = 13 (= Prüfziffer größer 10)
 *        ==<code>&gt;</code> 13 - 10 = 3 (= Prüfziffer)
 * </pre>
 * <p>
 * Testkontonummern (richtig): 7125633, 1253657, 4353631 <br>
 * Testkontonummern (falsch): 2356412, 5435886, 9435414</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodB9
        extends AbstractMethod {

    private final Logger log = Logger.getLogger(MethodB9.class);

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        number = expand(number);
        if (number[0] != 0) {
            return false;
        }
        if (variant1(number.clone())) {
            return true;
        }
        if (number[1] == 0 && number[1] == 0 && number[2] == 0) {
            return variant2(number.clone());
        }
        return false;
    }

    /**
     * <p>
     * Variante 1. </p>
     * <p>
     * Modulus (11,10), Gewichtung 1, 3, 2, 1, 3, 2, 1</p>
     * <p>
     * Die für die Berechnung relevanten Stellen der Kontonummer befinden sich
     * - von links nach rechts gelesen - in den Stellen 3-9 (die Prüfziffer ist
     * in Stelle 10). Sie sind – von rechts nach links – mit den zugehörigen
     * Gewichtungsfaktoren zu multiplizieren.</p>
     * <p>
     * Zum jeweiligen Produkt ist der zugehörige Gewichtungsfaktor zu addieren.
     * Das jeweilige Ergebnis ist durch 11 zu dividieren. Die sich aus der
     * Division ergebenden Reste sind zu summieren. Diese Summe ist durch 10 zu
     * dividieren. Der Rest ist die berechnete Prüfziffer.</p>
     * <p>
     * Führt die Berechnung zu einem Prüfzifferfehler, so ist die berechnete
     * Prüfziffer um 5 zu erhöhen und erneut zu prüfen. Ist die Prüfziffer
     * größer oder gleich 10, ist 10 abzuziehen und das Ergebnis ist dann die
     * Prüfziffer.</p>
     * <p>
     * Rechenbeispiel mit der Testkontonummer 0087920187:</p>
     * <pre>
     * 8x1= 8+1= 9   9:11=0 Rest 9
     * 7x2=14+2=16   16:11 = 1 Rest 5
     * 9x3=27+3=30   30:11 = 2 Rest 8
     * 2x1= 2+1= 3   3:11=0 Rest 3
     * 0x2= 0+2= 2   2:11=0 Rest 2
     * 1x3= 3+3= 6   6:11=0 Rest 6
     * 8x1= 8+1= 9   9:11=0 Summe der
     * Rest ￼ 9 Reste: 42
     *
     *
     * 42 : 10 = 4 Rest 2 (= falsche Prüfziffer)
     * ==<code>&gt;</code> 2 + 5 = 7 (= Prüfziffer)
     * Testkontonummern (richtig):
     *                             87920187, 41203755, 81069577, 61287958,
     *                             58467232
     *
     * Testkontonummern (falsch): 88034023, 43025432,
     *                            86521362, 61256523,
     *                            54352684
     * </pre>
     *
     * @return
     */
    boolean variant1(int[] number) {
        number = expand(number);
        weighting = new int[]{1, 3, 2, 1, 3, 2, 1};
        int weightingI = weighting.length;
        for (int i = 2; i < number.length - 1; i++) {
            number[i] *= weighting[--weightingI];
            number[i] += weighting[weightingI];
            number[i] %= 11;
        }
        log.debug("result " + Arrays.toString(number));
        int pz = this.add(number);
        pz = pz % 10;
        if (checkPz(pz, number)) {
            return true;
        }
        pz += 5;
        return checkPz(pz, number);
    }

    /**
     * <p>
     * Variante 2. </p>
     * <p>
     * Modulus 11, Gewichtung 1, 2, 3, 4, 5, 6</p>
     * <p>
     * Die für die Berechnung relevanten Stellen der Kontonummer befinden sich
     * - von links nach rechts gelesen- in den Stellen 4-9 (die Prüfziffer ist
     * in Stelle 10). Sie sind von rechts nach links mit den zugehörigen
     * Gewichtungsfaktoren zu multiplizieren. Die Summe dieser Produkte ist zu
     * bilden, und das erzielte Ergebnis ist durch 11 zu dividieren. Der Rest
     * ist die berechnete Prüfziffer.</p>
     * <p>
     * Führt die Berechnung zu einem Prüfzifferfehler, so ist die berechnete
     * Prüfziffer um 5 zu erhöhen und erneut zu prüfen.</p>
     * <p>
     * Ist die Prüfziffer größer oder gleich 10, ist 10 abzuziehen und das
     * Ergebnis ist dann die Prüfziffer.</p>
     * <p>
     * Rechenbeispiel mit der Testkontonummer 7125633:</p>
     * <pre>
     * 7 x 6 = 42
     * 1 x 5 =  5
     * 2 x 4 =  8
     * 5 x 3 = 15
     * 6 x 2 = 12
     * 3 x 1 =  3
     * ------
     * Summe = 85
     *
     * 85 : 11 = 7
     * 9:11=0 Rest 8 (= falsche Prüfziffer)
     *        ==<code>&gt;</code> 8 + 5 = 13 (= Prüfziffer größer 10)
     *        ==<code>&gt;</code> 13 - 10 = 3 (= Prüfziffer)
     * </pre>
     * <p>
     * Testkontonummern (richtig): 7125633, 1253657, 4353631 <br>
     * Testkontonummern (falsch): 2356412, 5435886, 9435414</p>
     *
     * @param number
     * @return
     */
    boolean variant2(int[] number) {
        number = expand(number);
        weighting = new int[]{1, 2, 3, 4, 5, 6};
        int weightingI = weighting.length;
        int pz = 0;
        for (int i = 3; i < number.length - 1; i++) {
            number[i] *= weighting[--weightingI];
            pz += number[i];
        }

        log.debug("result " + Arrays.toString(number));
        log.debug("after add: " + pz);
        pz %= 11;
        log.debug("REST: "+pz);
        if(checkPz(pz, number)) {
            return true;
        }
        pz = (pz + 5) % 10;
        return checkPz(pz, number);
    }

}
