package de.detecmedia.checkaccountnumber;

import java.util.Arrays;
import org.apache.log4j.Logger;

/**
 * Kennzeichen 51.
 * <p>
 * <b>zuletzt geändert zum 03.06.2013</b></p>
 * <p>
 * Die Kontonummer ist durch linksbündige Nullenauffüllung immer 10-stellig
 * darzustellen. Die für die Berechnung relevante Kundennummer (K) befindet
 * sich bei den Methoden A und C in den Stellen 4 bis 9 der Kontonummer und bei
 * den Methoden B und D in den Stellen 5 bis 9, die Prüfziffer in Stelle 10 der
 * Kontonummer.</p>
 * <p>
 * <b>Methode A:</b></p><p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7</p><p>
 * Die Berechnung und mögliche Ergebnisse entsprechen dem Verfahren 06.</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A(A=10)
 * Kontonr.:   x x x K K K K K K P
 * Gewichtung:       7 6 5 4 3 2
 * </pre>
 * <p>
 * Testkontonummern richtig: 0001156071, 0001156136 <br>
 * Testkontonummern falsch: 0001156078, 0000156079</p>
 * <p>
 * Ergibt die Berechnung der Prüfziffer nach der Methode A einen
 * Prüfzifferfehler, ist eine weitere Berechnung mit der Methode B
 * vorzunehmen.</p>
 * <p>
 * <b>
 * Methode B:</b></p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6</p><p>
 * Die Berechnung und mögliche Ergebnisse entsprechen dem Verfahren 33.</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A(A=10)
 * Kontonr.:   x x x x K K K K K P
 * Gewichtung:         6 5 4 3 2
 * </pre>
 * <p>
 * Testkontonummern richtig: 0001156078, 0001234567 Testkontonummern falsch:
 * 0001234566, 0012345678</p>
 * <p>
 * Ergibt auch die Berechnung der Prüfziffer nach Methode B einen
 * Prüfzifferfehler, ist eine weitere Berechnung mit der Methode C
 * vorzunehmen.</p>
 * <p>
 * <b>Methode C:</b></p><p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1</p><p>
 * Die Berechnung und die möglichen Ergebnisse entsprechen dem Verfahren 00; es
 * ist jedoch zu beachten, dass nur die Stellen 4 bis 9 in das
 * Prüfzifferberechnungsverfahren einbezogen werden</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A(A=10)
 * Kontonr.:   x x x K K K K K K P
 * Gewichtung:       1 2 1 2 1 2</pre>
 * <p>
 * Testkontonummern richtig: 340968, 201178, 1009588 <br>
 * Testkontonummern falsch: 0023456783, 0076543211</p>
 * <p>
 * Ergibt auch die Berechnung der Prüfziffer nach Methode C einen
 * Prüfzifferfehler, ist eine weitere Berechnung mit der Methode D
 * vorzunehmen.</p>
 * <p>
 * <b>Methode D:</b></p>
 * <p>
 * Kontonummern, die bis zur Methode D gelangen und in der 10. Stelle eine 7, 8
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
 * Testkontonummern richtig: 0000156071, 101356073  <br>
 * Testkontonummern falsch: 0123412345, 67493647</p>
 * <p>
 * Ausnahme:<br>
 * Ist nach linksbündiger Auffüllung mit Nullen auf 10 Stellen die 3. Stelle
 * der Kontonummer = 9 (Sachkonten), so erfolgt die Berechnung wie folgt:</p>
 * <p>
 * Variante 1 zur Ausnahme</p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8</p><p>
 * Die für die Berechnung relevanten Stellen 3 bis 9 werden von rechts nach
 * links mit den Ziffern 2, 3, 4, 5, 6, 7, 8 multipliziert. Die Produkte werden
 * addiert. Die Summe ist durch 11 zu dividieren. Der verbleibende Rest wird vom
 * Divisor (11) subtrahiert. Das Ergebnis ist die Prüfziffer. Ergibt sich als
 * Rest 1 oder 0, ist die Prüfziffer 0.</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   x x 9 x x x x x x P
 * Gewichtung:     8 7 6 5 4 3 2</pre>
 * <p>
 * Testkontonummern richtig: 0199100002, 0099100010, 2599100002 <br>
 * falsch: 0199100004, 2599100003, 0099345678</p>
 * <p>
 * Führt die Variante 1 zur Ausnahme zu einem Prüfzifferfehler, ist eine
 * weitere Berechnung nach der Variante 2 vorzunehmen.</p>
 * <p>
 * Variante 2 zur Ausnahme</p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8, 9, 10</p>
 * <p>
 * Berechnung und Ergebnisse entsprechen der Variante 1 zur Ausnahme.</p>
 * <p>
 * Testkontonummern richtig: 0199100004, 2599100003, 3199204090 <br>
 * falsch: 0099345678, 0099100110, 0199100040</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 * @see Method06
 * @see Method33
 *
 */
public class Method51 extends AbstractMethod {

    private static final Logger log = Logger.getLogger(Method51.class);

    @Override
    public boolean test() {
        int[] number = expand(this.getAccountNumberArray());
        if (this.methodA(number)) {
            return true;
        }
        number = expand(this.getAccountNumberArray());
        if (this.methodB(number)) {
            return true;
        }
        number = expand(this.getAccountNumberArray());
        if (this.methodC(number)) {
            return true;
        }
        number = expand(this.getAccountNumberArray());
        return this.methodD(number);
    }

    /**
     * Methode A.
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7</p><p>
     * Die Berechnung und mögliche Ergebnisse entsprechen dem Verfahren 06.</p>
     * <pre>
     * Stellennr.: 1 2 3 4 5 6 7 8 9 A(A=10)
     * Kontonr.:   x x x K K K K K K P
     * Gewichtung:       7 6 5 4 3 2
     * </pre>
     * <p>
     * Testkontonummern richtig: 0001156071, 0001156136 <br>
     * Testkontonummern falsch: 0001156078, 0000156079</p>
     * <p>
     * Ergibt die Berechnung der Prüfziffer nach der Methode A einen
     * Prüfzifferfehler, ist eine weitere Berechnung mit der Methode B
     * vorzunehmen.</p>
     *
     * @param number int array from AccountNumnber
     * @return true or false
     */
    boolean methodA(int[] number) {
        log.debug("use mehtodA");
        weighting = new int[]{2, 3, 4, 5, 6, 7};
        log.debug("Number: " + Arrays.toString(number));
        Method06 method06 = new Method06();
        number = method06.factor(number, weighting, 4, 9);
        int pz = method06.add(number, 3, 9);
        pz = method06.modulus11(pz);
        return method06.checkPz(pz, number);
    }

    /**
     *
     * Methode B.
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6</p><p>
     * Die Berechnung und mögliche Ergebnisse entsprechen dem Verfahren 33.</p>
     * <pre>
     * Stellennr.: 1 2 3 4 5 6 7 8 9 A(A=10)
     * Kontonr.:   x x x x K K K K K P
     * Gewichtung:         6 5 4 3 2
     * </pre>
     * <p>
     * Testkontonummern richtig: 0001156078, 0001234567 <br>
     * Testkontonummern falsch: 0001234566, 0012345678</p>
     * <p>
     * Ergibt auch die Berechnung der Prüfziffer nach Methode B einen
     * Prüfzifferfehler, ist eine weitere Berechnung mit der Methode C
     * vorzunehmen.</p>
     *
     * @param number
     * @return
     */
    boolean methodB(int[] number) {
        log.debug("use mehtodA");
        weighting = new int[]{2, 3, 4, 5, 6};
        log.debug("Number: " + Arrays.toString(number));
        Method33 method33 = new Method33();
        number = method33.factor(number, weighting, 5, 9);
        int pz = method33.add(number, 4, 9);
        pz = method33.modulus11(pz);
        return method33.checkPz(pz, number);
    }

    /**
     * <b>Methode C. </b><<p>
     * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1</p><p>
     * Die Berechnung und die möglichen Ergebnisse entsprechen dem Verfahren
     * 00; es ist jedoch zu beachten, dass nur die Stellen 4 bis 9 in das
     * Prüfzifferberechnungsverfahren einbezogen werden</p>
     * <pre>
     * Stellennr.: 1 2 3 4 5 6 7 8 9 A(A=10)
     * Kontonr.:   x x x K K K K K K P
     * Gewichtung:       1 2 1 2 1 2</pre>
     * <p>
     * Testkontonummern richtig: 340968, 201178, 1009588 <br>
     * Testkontonummern falsch: 0023456783, 0076543211</p>
     * <p>
     * Ergibt auch die Berechnung der Prüfziffer nach Methode C einen
     * Prüfzifferfehler, ist eine weitere Berechnung mit der Methode D
     * vorzunehmen.</p>
     *
     * @param number
     * @return
     */
    boolean methodC(int[] number) {
        weighting = new int[]{2, 1, 2, 1, 2, 1};
        Method00 method00 = new Method00();
        number = expand(number);
        number = method00.factor(number, weighting, 4, 9);
        log.debug("number: " + Arrays.toString(number));
        int pz = method00.add(number, 3, 9);
        pz = method00.modulus10(pz);
        return method00.checkPz(pz, number);
    }

    /**
     * <b>Methode D. </b>
     * <p>
     * Kontonummern, die bis zur Methode D gelangen und in der 10. Stelle eine
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
     * Testkontonummern richtig: 0000156071, 101356073  <br>
     * Testkontonummern falsch: 0123412345, 67493647</p>
     * <p>
     * Ausnahme:<br>
     * Ist nach linksbündiger Auffüllung mit Nullen auf 10 Stellen die 3.
     * Stelle der Kontonummer = 9 (Sachkonten), so erfolgt die Berechnung wie
     * folgt:</p>
     * <p>
     * Variante 1 zur Ausnahme</p>
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8</p><p>
     * Die für die Berechnung relevanten Stellen 3 bis 9 werden von rechts nach
     * links mit den Ziffern 2, 3, 4, 5, 6, 7, 8 multipliziert. Die Produkte
     * werden addiert. Die Summe ist durch 11 zu dividieren. Der verbleibende
     * Rest wird vom Divisor (11) subtrahiert. Das Ergebnis ist die Prüfziffer.
     * Ergibt sich als Rest 1 oder 0, ist die Prüfziffer 0.</p>
     * <pre>
     * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
     * Kontonr.:   x x 9 x x x x x x P
     * Gewichtung:     8 7 6 5 4 3 2</pre>
     * <p>
     * Testkontonummern richtig: 0199100002, 0099100010, 2599100002 <br>
     * falsch: 0199100004, 2599100003, 0099345678</p>
     * <p>
     * Führt die Variante 1 zur Ausnahme zu einem Prüfzifferfehler, ist eine
     * weitere Berechnung nach der Variante 2 vorzunehmen.</p>
     * <p>
     * Variante 2 zur Ausnahme</p>
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8, 9, 10</p>
     * <p>
     * Berechnung und Ergebnisse entsprechen der Variante 1 zur Ausnahme.</p>
     * <p>
     * Testkontonummern richtig: 0199100004, 2599100003, 3199204090 <br>
     * falsch: 0099345678, 0099100110, 0199100040</p>
     *
     * @param number
     * @return
     */
    boolean methodD(int[] number) {
        number = expand(number);
        //Kontonummern, die bis zur Methode D gelangen und in der 10. Stelle eine * 7, 8 oder 9 haben, sind ungültig.
        if (number[9] == 7
                || number[9] == 8
                || number[9] == 9) {
            return false;
        }

        weighting = new int[]{2, 3, 4, 5, 6};
        log.debug("Number: " + Arrays.toString(number));

        Method33 method33 = new Method33();
        number = method33.factor(number, weighting, 5, 9);
        int pz = method33.add(number, 4, 9);
        pz = modulus7(pz);
        if (method33.checkPz(pz, number)) {
            return true;
        }
        number = expand(this.getAccountNumberArray()); // reset AccountNumber
        if (number[2] == 9) {
            if (this.methodDvariant1(number)) {
                return true;
            }
            number = expand(this.getAccountNumberArray()); // reset AccountNumber
            if (this.methodDvariant2(number)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Variante 1 zur Ausnahme.
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8</p><p>
     * Die für die Berechnung relevanten Stellen 3 bis 9 werden von rechts nach
     * links mit den Ziffern 2, 3, 4, 5, 6, 7, 8 multipliziert. Die Produkte
     * werden addiert. Die Summe ist durch 11 zu dividieren. Der verbleibende
     * Rest wird vom Divisor (11) subtrahiert. Das Ergebnis ist die Prüfziffer.
     * Ergibt sich als Rest 1 oder 0, ist die Prüfziffer 0.</p>
     * <pre>
     * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
     * Kontonr.:   x x 9 x x x x x x P
     * Gewichtung:     8 7 6 5 4 3 2</pre>
     * <p>
     * Testkontonummern richtig: 0199100002, 0099100010, 2599100002 <br>
     * falsch: 0199100004, 2599100003, 0099345678</p>
     * <p>
     * Führt die Variante 1 zur Ausnahme zu einem Prüfzifferfehler, ist eine
     * weitere Berechnung nach der Variante 2 vorzunehmen.</p>
     * <p>
     * @param number
     * @return
     */
    protected boolean methodDvariant1(int[] number) {
        weighting = new int[]{2, 3, 4, 5, 6, 7, 8};
        number = expand(this.getAccountNumberArray());
        number = this.factor(number, weighting, 3, 9);
        int pz = add(number, 2, 9);
        pz %= 11;
        pz = 11 - pz;
        pz %= 10;
        if (pz == 1) {
            pz = 0;
        }
        return checkPz(pz, number);
    }

    /**
     * Variante 2 zur Ausnahme.
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8, 9, 10</p>
     * <p>
     * Berechnung und Ergebnisse entsprechen der Variante 1 zur Ausnahme.</p>
     * <p>
     * Testkontonummern richtig: 0199100004, 2599100003, 3199204090 <br>
     * falsch: 0099345678, 0099100110, 0199100040</p>
     *
     * @param number
     * @return
     */
    protected boolean methodDvariant2(int[] number) {
        weighting = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10};
        Method01 method01 = new Method01();
        number = method01.factor(number, weighting);
        int pz = method01.add(number);
        pz = method01.modulus11(pz);
        return checkPz(pz, number);
    }

    @Override
    protected int add(int[] number, int start, int end) {
        log.debug(start + " to " + end);
        int pz = 0;
        for (int i = start--; i < end; i++) {
            log.debug("+" + number[i]);
            int o = number[i];
            pz += o;
        }
        log.debug("after add: " + pz);
        return pz;
    }

}
