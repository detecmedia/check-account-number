package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.exception.InvalidAcountNumberException;
import org.apache.log4j.Logger;

/**
 * Kennzeichen 85.
 * <p>
 * Die Kontonummer ist immer 10-stellig. Die für die Berechnung relevante
 * Kundennummer (K) befindet sich bei der Methode A in den Stellen 4 bis 9 der
 * Kontonummer und bei den Methoden B + C in den Stellen 5 bis 9, die
 * Prüfziffer in Stelle 10 der Kontonummer.</p>
 * <p>
 * Methode A:</p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7</p>
 * <p>
 * Die Berechnung und mögliche Ergebnisse entsprechen dem Verfahren 06.</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   x x x K K K K K K P
 * Gewichtung:       7 6 5 4 3 2
 * </pre>
 * <p>
 * Testkontonummern: 0001156071, 0001156136</p>
 * <p>
 * Ergibt die Berechnung der Prüfziffer nach der Methode A einen
 * Prüfzifferfehler, ist eine weitere Berechnung mit der Methode B
 * vorzunehmen.</p>
 * <p>
 * Methode B:</p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6</p>
 * <p>
 * Die Berechnung und mögliche Ergebnisse entsprechen dem Verfahren 33.</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A(A=10)
 * Kontonr.:   x x x x K K K K K P
 * Gewichtung:         6 5 4 3
 * 2</pre>
 * <p>
 * Testkontonummer: 0000156078</p>
 * <p>
 * Ergibt auch die Berechnung der Prüfziffer nach Methode B einen
 * Prüfzifferfehler, ist eine weitere Berechnung mit der Methode C
 * vorzunehmen.</p>
 * <p>
 * Methode C:</p>
 * <p>
 * Kontonummern, die bis zur Methode C gelangen und in der 10. Stelle eine 7, 8
 * oder 9 haben, sind ungültig.</p>
 * <p>
 * Modulus 7, Gewichtung 2, 3, 4, 5, 6</p>
 * <p>
 * Das Berechnungsverfahren entspricht Methode B.</p>
 * <p>
 * Die Summe der Produkte ist jedoch durch 7 zu dividieren. Der verbleibende
 * Rest wird vom Divisor (7) subtrahiert. Das Ergebnis ist die Prüfziffer.
 * Verbleibt kein Rest, ist die Prüfziffer 0.</p>
 * <p>
 * Testkontonummer: 0000156071</p>
 * <p>
 * Ausnahme:</p>
 * <p>
 * Sind die 3. und 4. Stelle der Kontonummer = 99, so ist folgende
 * Prüfzifferberechnung maßgebend:</p>
 * <p>
 * Modulus: 11, Gewichtung 2, 3, 4, 5, 6, 7, 8</p>
 * <p>
 * Die für die Berechnung relevanten Stellen 3 bis 9 der Kontonummer werden von
 * rechts nach links mit den Ziffern 2, 3, 4, 5, 6, 7, 8 multipliziert. Die
 * weitere Berechnung und möglichen Ergebnisse entsprechen dem Verfahren
 * 02.</p>
 * <p>
 * Testkontonummer: 3199100002</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method85
        extends AbstractMethod {

    private Logger log = Logger.getLogger(Method85.class);

    @Override
    public boolean test() {
        int[] numnber = this.getAccountNumberArray();
        if (methodA(numnber.clone())) {
            return true;
        }

        if (methodB(numnber.clone())) {
            return true;
        }

        if (methodC(numnber.clone())) {
            return true;
        }

        if (exception(numnber.clone())) {
            return true;
        }
        return false;
    }

    /**
     * <p>
     * Methode A:</p>
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7</p>
     * <p>
     * Die Berechnung und mögliche Ergebnisse entsprechen dem Verfahren 06.</p>
     * <pre>
     * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
     * Kontonr.:   x x x K K K K K K P
     * Gewichtung:       7 6 5 4 3 2
     * </pre>
     * <p>
     * Testkontonummern: 0001156071, 0001156136</p>
     * <p>
     * Ergibt die Berechnung der Prüfziffer nach der Methode A einen
     * Prüfzifferfehler, ist eine weitere Berechnung mit der Methode B
     * vorzunehmen.</p>
     *
     * @param number
     * @return
     */
    boolean methodA(int[] number) {
        weighting = new int[]{2, 3, 4, 5, 6, 7};
        Method06 method06 = new Method06();
        method06.setAccountNumber(accountNumber);
        number = method06.factor(number, weighting);
        int pz = method06.add(number);
        pz = method06.modulus11(pz);
        return method06.checkPz(pz, number);
    }

    /**
     * <p>
     * Methode B:</p>
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6</p>
     * <p>
     * Die Berechnung und mögliche Ergebnisse entsprechen dem Verfahren 33.</p>
     * <pre>
     * Stellennr.: 1 2 3 4 5 6 7 8 9 A(A=10)
     * Kontonr.:   x x x x K K K K K P
     * Gewichtung:         6 5 4 3 2
     * </pre>
     * <p>
     * Testkontonummer: 0000156078</p>
     * <p>
     * Ergibt auch die Berechnung der Prüfziffer nach Methode B einen
     * Prüfzifferfehler, ist eine weitere Berechnung mit der Methode C
     * vorzunehmen.</p>
     * <p>
     *
     * @param number
     * @return
     */
    boolean methodB(int[] number) {
        weighting = new int[]{2, 3, 4, 5, 6};
        Method33 method33 = new Method33();
        method33.setAccountNumberArray(number);
        return method33.check(weighting);
    }

    /**
     * <p>
     * Methode C:</p>
     * <p>
     * Kontonummern, die bis zur Methode C gelangen und in der 10. Stelle eine
     * 7, 8 oder 9 haben, sind ungültig.</p>
     * <p>
     * Modulus 7, Gewichtung 2, 3, 4, 5, 6</p>
     * <p>
     * Das Berechnungsverfahren entspricht Methode B.</p>
     * <p>
     * Die Summe der Produkte ist jedoch durch 7 zu dividieren. Der verbleibende
     * Rest wird vom Divisor (7) subtrahiert. Das Ergebnis ist die Prüfziffer.
     * Verbleibt kein Rest, ist die Prüfziffer 0.</p>
     * <p>
     * Testkontonummer: 0000156071</p>
     *
     * @param number
     * @return
     */
    boolean methodC(int[] number) {
        if (number[9] == 7 || number[9] == 8 || number[9] == 9) {
            throw new InvalidAcountNumberException();
        }
        weighting = new int[]{2, 3, 4, 5, 6};
        Method33 method33 = new Method33();
        number = method33.factor(number, weighting, 5, 9);
        int pz = method33.add(number, 4, 9);
        pz = method33.modulus7(pz);
        return method33.checkPz(pz, number);

    }

    /**
     * <p>
     * Ausnahme. </p>
     * <p>
     * Sind die 3. und 4. Stelle der Kontonummer = 99, so ist folgende
     * Prüfzifferberechnung maßgebend:</p>
     * <p>
     * Modulus: 11, Gewichtung 2, 3, 4, 5, 6, 7, 8</p>
     * <p>
     * Die für die Berechnung relevanten Stellen 3 bis 9 der Kontonummer werden
     * von rechts nach links mit den Ziffern 2, 3, 4, 5, 6, 7, 8 multipliziert.
     * Die weitere Berechnung und möglichen Ergebnisse entsprechen dem
     * Verfahren 02.</p>
     * <p>
     * Testkontonummer: 3199100002</p>
     *
     * @param number
     * @return
     */
    boolean exception(int[] number) {
        if (!(number[2] == 9 && number[3] == 9)) {
            return false;
        }
        weighting = new int[]{2, 3, 4, 5, 6, 7, 8};
        Method02 method02 = new Method02();
        method02.setAccountNumberArray(number);
        number = method02.factor(number, weighting, 3, 9);
        int pz = method02.add(number, 2, 9);
        pz = method02.modulus11(pz);

        return method02.checkPz(pz, number);
    }

}
