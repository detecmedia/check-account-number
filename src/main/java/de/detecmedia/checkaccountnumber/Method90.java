package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.exception.InvalidAcountNumberException;
import org.apache.log4j.Logger;

/**
 * Kennzeichen 90.
 * <p>
 * <b>Beschreibung zum 06.06.2005 überarbeitet</b></p>
 * <p>
 * <b>geändert zum 09.06.2014</b></p>
 * <p>
 * <b>Fehlerkorrektur zum 08.09.2014</b></p>
 * <p>
 * Die Kontonummer ist immer 10-stellig, ggf. ist die Kontonummer durch
 * linksbündige Auffüllung mit Nullen 10- stellig darzustellen. Die Stelle 10
 * der Kontonummer ist per Definition die Prüfziffer. Kontonummern, die nach
 * Durchführung der unten näher aufgeführten Berechnungs- methoden nicht zu
 * einem richtigen Ergebnis führen, sind nicht gültig.</p>
 * <p>
 * Die für die Berechnung relevante Kundennummer (K) befindet sich bei der
 * Methode A und G in den Stellen 4 bis 9 der Kontonummer und bei den Methoden B
 * bis E in den Stellen 5 bis 9.</p>
 * <p>
 * Ausnahme:</p>
 * <p>
 * Ist nach linksbündigem Auffüllen mit Nullen auf 10 Stellen die 3. Stelle
 * der Kontonummer = 9 (Sachkonten) befindet sich die für die Berechnung
 * relevante Sachkontonummer (S) in den Stellen 3 bis 9. Diese Kontonummern sind
 * ausschließlich nach Methode F zu prüfen.</p>
 * <p>
 * Kundenkonten</p>
 * <p>
 * Kundenkonten haben im Gegensatz zu Sachkonten an der Stelle 3 nicht die
 * Ziffer 9 stehen.</p>
 * <p>
 * Ergibt die Berechnung der Prüfziffer nach dem Verfahren A einen
 * Prüfzifferfehler, so sind weitere Berechnungen mit den Methoden B bis E und
 * G vorzunehmen. kundenkonto- nummern, die nach Durchführung aller
 * Berechnungs- methoden A bis E und G nicht zu einem richtigen Ergebnis
 * führen, ist nicht gültig.</p>
 * <p>
 * Methode A:</p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A(A=10)
 * Kontonr.:   x x x K K K K K K P
 * Gewichtung:       7 6 5 4 3 2</pre>
 * <p>
 * Die Berechnung und mögliche Ergebnisse entsprechen dem Verfahren 06.</p>
 * <p>
 * Testkontonummern:<br>
 * richtig: 0001975641, 0001988654<br>
 * falsch: 0001924592<br>
 * falsch: 0000654321 (testbar nach Methode C)</p>
 * <p>
 * Methode B</p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6</p>
 * <pre>Stellennr.: 1 2 3 4 5 6 7 8 9 A(A=10) Kontonr.: xxxxKKKKKP Gewichtung: 6 5 4 3 2</pre>
 * <p>
 * Die Berechnung und die möglichen Ergebnisse entsprechen dem Verfahren
 * 06.</p>
 * <p>
 * Testkontonummern:<br>
 * richtig: 0001863530, 0001784451<br>
 * falsch: 0000901568<br>
 * falsch: 0000997664 (testbar nach Methode C)<br> falsch: 0000863536 (testbar
 * nach Methode D)<br></p>
 * <p>
 * Methode C</p>
 * <p>
 * Modulus 7, Gewichtung 2, 3, 4, 5, 6</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   x x x x K K K K K P
 * Gewichtung:         6 5 4 3 2
 * </pre>
 * <p>
 * Die einzelnen Stellen der Kontonummer sind von rechts nach links mit den
 * Gewichten zu multiplizieren. Die jeweiligen Produkte werden addiert. Die
 * Summe der Produkte ist durch 7 zu dividieren. Der verbleibende Rest wird vom
 * Divisor (7) subtrahiert. Das Ergebnis ist die Prüfziffer. Verbleibt kein
 * Rest, ist die Prüfziffer 0.</p>
 * <p>
 * Kontonummern, die in der Stelle 10 die Werte 7, 8 oder 9 haben, sind nach
 * dieser Methode nicht gültig.</p>
 * <p>
 * Testkontonummern:<br>
 * richtig: 0000654321, 0000824491<br>
 * falsch: 0000820487<br>
 * falsch: 0000820484 (testbar nach Methode D) falsch: 0000654328 (testbar nach
 * Methode E)</p>
 * <p>
 * Methode D</p>
 * <p>
 * Modulus 9, Gewichtung 2, 3, 4, 5, 6</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   x x x x K K K K K P
 * Gewichtung:         6 5 4 3 2
 * </pre>
 * <p>
 * Die einzelnen Stellen der Kontonummer sind von rechts nach links mit den
 * Gewichten zu multiplizieren. Die jeweiligen Produkte werden addiert. Die
 * Summe der Produkte ist durch 9 zu dividieren. Der verbleibende Rest wird vom
 * Divisor (9) subtrahiert. Das Ergebnis ist die Prüfziffer. Verbleibt kein
 * Rest, ist die Prüfziffer 0.</p>
 * <p>
 * Kontonummern, die an der Stelle 10 den Wert 9 haben sind nach dieser Methode
 * nicht gültig.</p>
 * <p>
 * Testkontonummern:<br>
 * richtig: 0000677747, 0000840507<br>
 * falsch: 0000726393<br>
 * falsch: 0000677742 (testbar nach Methode E) falsch: 0000726390 (testbar nach
 * Methode G)</p>
 * <p>
 * Methode E</p>
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   x x x x K K K K K P
 * Gewichtung:         2 1 2 1 2
 * </pre>
 * <p>
 * Die einzelnen Stellen der Kontonummer sind von rechts nach links mit den
 * Gewichten zu multiplizieren. Die jeweiligen Produkte werden addiert. Die
 * Summe der Produkte ist durch 10 zu dividieren. Der verbleibende Rest wird vom
 * Divisor (10) subtrahiert. Das Ergebnis ist die Prüfziffer. Verbleibt kein
 * Rest, ist die Prüfziffer 0.</p>
 * <p>
 * Testkontonummern:<br>
 * richtig: 0000996663, 0000666034<br>
 * falsch: 0000924591<br>
 * falsch: 0000465431 (testbar nach Methode G)<br>
 * <p>
 * Methode G</p>
 * <p>
 * Modulus 7, Gewichtung 2, 1, 2, 1, 2, 1</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   x x x K K K K K K P
 * Gewichtung:       1 2 1 2 1 2
 * </pre>
 * <p>
 * Die einzelnen Stellen der Kontonummer sind von rechts nach links mit den
 * Gewichten zu multiplizieren. Die jeweiligen Produkte werden addiert. Die
 * Summe der Produkte ist durch 7 zu dividieren. Der verbleibende Rest wird vom
 * Divisor (7) subtrahiert. Das Ergebnis ist die Prüfziffer. Verbleibt kein
 * Rest, ist die Prüfziffer 0.</p>
 * <p>
 * Testkontonummern:<br>
 * richtig: 0004923250, 0003865960 falsch: 0003865964</p>
 * <p>
 * Sachkonten</p>
 * <p>
 * Sachkonten haben im Gegensatz zu Kundenkonten an der Stelle 3 die Ziffer 9
 * stehen.</p>
 * <p>
 * Methode F</p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A(A=10)
 * Kontonr.:   x x S S S S S S S P
 * Gewichtung:     8 7 6 5 4 3 2
 * </pre>
 * <p>
 * Die Berechnung und die möglichen Ergebnisse entsprechen dem Verfahren 06. Es
 * ist jedoch die vorgenannte Gewichtung zu beachten.</p>
 * <p>
 * Testkontonummern: richtig: 0099100002 falsch: 0099100007</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method90 extends AbstractMethod {

    private int[] weighting;

    private final Logger log = Logger.getLogger(Method90.class);

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        if (number[2] == 9 && mehtodF(number)) {
            return true;
        } else {
            if (mehtodA(number)) {
                return true;
            }
            if (mehtodB(number)) {
                return true;
            }
            try {
                if (mehtodC(number)) {
                    return true;
                }
            } catch (InvalidAcountNumberException ex) {

            }
            if (mehtodD(number)) {
                return true;
            }
            if (mehtodE(number)) {
                return true;
            }

            if (mehtodG(number)) {
                return true;
            }
        }

        return false;
    }

    /**
     * <p>
     * Methode A. </p>
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7</p>
     * <pre>
     * Stellennr.: 1 2 3 4 5 6 7 8 9 A(A=10)
     * Kontonr.:   x x x K K K K K K P
     * Gewichtung:       7 6 5 4 3 2</pre>
     * <p>
     * Die Berechnung und mögliche Ergebnisse entsprechen dem Verfahren 06.</p>
     * <p>
     * Testkontonummern:<br>
     * richtig: 0001975641, 0001988654<br>
     * falsch: 0001924592<br>
     * falsch: 0000654321 (testbar nach Methode C)</p>
     *
     * @param number
     * @return
     */
    boolean mehtodA(int[] number) {
        weighting = new int[]{2, 3, 4, 5, 6, 7};
        number = expand(number);
        Method06 method06 = new Method06();
        number = method06.factor(number, weighting, 3, 9);
        int pz = method06.add(number, 2, 9);
        pz = method06.modulus11(pz);
        return method06.checkPz(pz, number);

    }

    /**
     * <p>
     * Methode B. </p>
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6</p>
     * <pre>Stellennr.: 1 2 3 4 5 6 7 8 9 A(A=10)
     * Kontonr.:        x x x x K K K K K P
     * Gewichtung:              6 5 4 3 2</pre>
     * <p>
     * Die Berechnung und die möglichen Ergebnisse entsprechen dem Verfahren
     * 06.</p>
     * <p>
     * Testkontonummern:<br>
     * richtig: 0001863530, 0001784451<br>
     * falsch: 0000901568<br>
     * falsch: 0000997664 (testbar nach Methode C)<br> falsch: 0000863536
     * (testbar nach Methode D)<br></p>
     *
     * @param number
     * @return
     */
    boolean mehtodB(int[] number) {
        weighting = new int[]{2, 3, 4, 5, 6};
        number = expand(number);
        Method06 method06 = new Method06();
        number = method06.factor(number, weighting, 5, 9);
        int pz = method06.add(number, 4, 9);
        pz = method06.modulus11(pz);
        return method06.checkPz(pz, number);
    }

    /**
     * Methode C. </p>
     * <p>
     * Modulus 7, Gewichtung 2, 3, 4, 5, 6</p>
     * <pre>
     * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
     * Kontonr.:   x x x x K K K K K P
     * Gewichtung:         6 5 4 3 2
     * </pre>
     * <p>
     * Die einzelnen Stellen der Kontonummer sind von rechts nach links mit den
     * Gewichten zu multiplizieren. Die jeweiligen Produkte werden addiert. Die
     * Summe der Produkte ist durch 7 zu dividieren. Der verbleibende Rest wird
     * vom Divisor (7) subtrahiert. Das Ergebnis ist die Prüfziffer. Verbleibt
     * kein Rest, ist die Prüfziffer 0.</p>
     * <p>
     * Kontonummern, die in der Stelle 10 die Werte 7, 8 oder 9 haben, sind nach
     * dieser Methode nicht gültig.</p>
     * <p>
     * Testkontonummern:<br>
     * richtig: 0000654321, 0000824491<br>
     * falsch: 0000820487<br>
     * falsch: 0000820484 (testbar nach Methode D) falsch: 0000654328 (testbar
     * nach Methode E)</p>
     *
     * @param number
     * @return
     */
    boolean mehtodC(int[] number) {
        if (number[9] == 7 || number[9] == 8 || number[9] == 9) {
            throw new InvalidAcountNumberException();
        }
        weighting = new int[]{2, 3, 4, 5, 6};
        number = expand(number.clone());
        number = factor(number, weighting, 5, 9);
        int pz = add(number, 4, 9);
        pz = modulus7(pz);

        return checkPz(pz, number);
    }

    /**
     * <p>
     * Methode D</p>
     * <p>
     * Modulus 9, Gewichtung 2, 3, 4, 5, 6</p>
     * <pre>
     * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
     * Kontonr.:   x x x x K K K K K P
     * Gewichtung:         6 5 4 3 2
     * </pre>
     * <p>
     * Die einzelnen Stellen der Kontonummer sind von rechts nach links mit den
     * Gewichten zu multiplizieren. Die jeweiligen Produkte werden addiert. Die
     * Summe der Produkte ist durch 9 zu dividieren. Der verbleibende Rest wird
     * vom Divisor (9) subtrahiert. Das Ergebnis ist die Prüfziffer. Verbleibt
     * kein Rest, ist die Prüfziffer 0.</p>
     * <p>
     * Kontonummern, die an der Stelle 10 den Wert 9 haben sind nach dieser
     * Methode nicht gültig.</p>
     * <p>
     * Testkontonummern:<br>
     * richtig: 0000677747, 0000840507<br>
     * falsch: 0000726393<br>
     * falsch: 0000677742 (testbar nach Methode E) falsch: 0000726390 (testbar
     * nach Methode G)</p>
     * <p>
     *
     * @param number
     * @return
     */
    boolean mehtodD(int[] number) {
        number = expand(number);
        weighting = new int[]{2, 3, 4, 5, 6};
        number = factor(number, weighting, 5, 9);
        int pz = add(number, 4, 9);
        pz = modulus9(pz);
        return checkPz(pz, number, 10);
    }

    /**
     * <p>
     * Methode E. </p>
     * <p>
     * Modulus 10, Gewichtung 2, 1, 2, 1, 2</p>
     * <pre>
     * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
     * Kontonr.:   x x x x K K K K K P
     * Gewichtung:         2 1 2 1 2
     * </pre>
     * <p>
     * Die einzelnen Stellen der Kontonummer sind von rechts nach links mit den
     * Gewichten zu multiplizieren. Die jeweiligen Produkte werden addiert. Die
     * Summe der Produkte ist durch 10 zu dividieren. Der verbleibende Rest wird
     * vom Divisor (10) subtrahiert. Das Ergebnis ist die Prüfziffer. Verbleibt
     * kein Rest, ist die Prüfziffer 0.</p>
     * <p>
     * Testkontonummern:<br>
     * richtig: 0000996663, 0000666034<br>
     * falsch: 0000924591<br>
     * falsch: 0000465431 (testbar nach Methode G)<br>
     *
     * @param number
     * @return
     */
    boolean mehtodE(int[] number) {
        number = expand(number);
        weighting = new int[]{2, 1, 2, 1, 2};
        number = factor(number, weighting, 5, 9);
        int pz = add(number, 4, 9);
        pz = modulus10(pz);
        return checkPz(pz, number, 10);
    }

    /**
     * <p>
     * Methode F. </p>
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8</p>
     * <pre>
     * Stellennr.: 1 2 3 4 5 6 7 8 9 A(A=10)
     * Kontonr.:   x x S S S S S S S P
     * Gewichtung:     8 7 6 5 4 3 2
     * </pre>
     * <p>
     * Die Berechnung und die möglichen Ergebnisse entsprechen dem Verfahren
     * 06. Es ist jedoch die vorgenannte Gewichtung zu beachten.</p>
     * <p>
     * Testkontonummern: richtig: 0099100002 falsch: 0099100007</p>
     *
     * @param number
     * @return
     */
    boolean mehtodF(int[] number) {
        number = expand(number);
        weighting = new int[]{2, 3, 4, 5, 6, 7, 8};
        Method06 method06 = new Method06();
        number = method06.factor(number, weighting, 3, 9);
        int pz = method06.add(number, 2, 9);
        pz = method06.modulus11(pz);
        return method06.checkPz(pz, number);
    }

    /**
     * <p>
     * Methode G</p>
     * <p>
     * Modulus 7, Gewichtung 2, 1, 2, 1, 2, 1</p>
     * <pre>
     * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
     * Kontonr.:   x x x K K K K K K P
     * Gewichtung:       1 2 1 2 1 2
     * </pre>
     * <p>
     * Die einzelnen Stellen der Kontonummer sind von rechts nach links mit den
     * Gewichten zu multiplizieren. Die jeweiligen Produkte werden addiert. Die
     * Summe der Produkte ist durch 7 zu dividieren. Der verbleibende Rest wird
     * vom Divisor (7) subtrahiert. Das Ergebnis ist die Prüfziffer. Verbleibt
     * kein Rest, ist die Prüfziffer 0.</p>
     * <p>
     * Testkontonummern:<br>
     * richtig: 0004923250, 0003865960 falsch: 0003865964</p>
     * <p>
     * Sachkonten</p>
     * <p>
     * Sachkonten haben im Gegensatz zu Kundenkonten an der Stelle 3 die Ziffer
     * 9 stehen.</p>
     *
     * @param number
     * @return
     */
    boolean mehtodG(int[] number) {
        number = expand(number);
        weighting = new int[]{2, 1, 2, 1, 2, 1};
        number = this.factor(number, weighting, 4, 9);
        int pz = this.add(number, 3, 9);
        pz = this.modulus7(pz);
        return this.checkPz(pz, number);
    }

    /**
     * @param number
     * @param start
     * @param end
     * @return
     */
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

    private int modulus9(int pz) {
        pz = pz % 9;
        if (pz == 0) {
            return 0;
        }
        return 9 - pz;
    }

}
