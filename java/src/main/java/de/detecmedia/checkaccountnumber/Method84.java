package de.detecmedia.checkaccountnumber;

import org.apache.log4j.Logger;

/**
 * Kennzeichen 84.
 * <p>
 * <b>zuletzt geändert zum 03.06.2013</b></p>
 * <p>
 * Die Kontonummer ist durch linksbündige Nullenauffüllung immer 10-stellig
 * darzustellen. Die 10. Stelle ist per Definition die Prüfziffer.</p>
 * <p>
 * Es ist zu beachten, dass nur die Stellen 5 bis 9 in das
 * Prüfzifferberechnungsverfahren einbezogen werden.</p>
 * <p>
 * Methode A</p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6</p>
 * <p>
 * Die Berechnung und mögliche Ergebnisse entsprechen dem Verfahren 06.</p>
 * <pre>
 *Stelle-Nr.:    1 2 3 4 5 6 7 8 9 10
 * Kontonummer:  X X X X K K K K K P
 * Gewichtung            6 5 4 3 2
 * </pre>
 * <p>
 * Testkontonummern richtig: 240699, 350982, 461059<br>
 * Testkontonummern falsch: 240965, 350980, 461053
 * </p>
 * <p>
 * Führt die Berechnung nach Methode A zu einem Prüfziffer- fehler, ist die
 * Berechnung nach Methode B vorzunehmen.</p>
 * <p>
 * Methode B</p>
 * <p>
 * Modulus 7, Gewichtung 2, 3, 4, 5, 6</p>
 * <p>
 * Die Berechnung und mögliche Ergebnisse entsprechen dem Verfahren 06. Dabei
 * ist zu beachten, dass als Divisor 7 zu verwenden ist.</p>
 * <pre>
 * Stelle-Nr.:  1 2 3 4 5 6 7 8 9 10
 * Kontonummer: X X X X K K K K K P
 * Gewichtung:          6 5 4 3 2
 * </pre>
 * <p>
 * Testkontonummern richtig: 240692, 350985, 461052<br>
 * Testkontonummern falsch: 240965, 350980, 461053</p>
 * <p>
 * Ergibt auch die Berechnung der Prüfziffer nach Methode B einen
 * Prüfzifferfehler, ist eine weitere Berechnung mit der Methode C
 * vorzunehmen.</p>
 * <p>
 * Methode C</p>
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2</p>
 * <p>
 * Die Berechnung und mögliche Ergebnisse entsprechen dem Verfahren 06.</p>
 * <pre>
 * Stelle-Nr.:  1 2 3 4 5 6 7 8 9 10
 * Kontonummer: X X X X K K K K K P
 * Gewichtung:          2 1 2 1 2
 * </pre>
 * <p>
 * Testkontonummern richtig: 240961, 350984, 461054 <br>Testkontonummern falsch:
 * 240965, 350980, 461053</p>
 * <p>
 * Ausnahme:</p>
 * <p>
 * Ist nach linksbündiger Auffüllung mit Nullen auf 10 Stellen die 3. Stelle
 * der Kontonummer = 9 (Sachkonten), so erfolgt die Berechnung gemäß der
 * Ausnahme in Methode 51 mit den gleichen Ergebnissen und Testkontonummern.</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method84 extends Method51 {

    private Logger log = Logger.getLogger(Method84.class);

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        if (methodA(number)) {
            return true;
        }
        if (methodB(number)) {
            return true;
        }
        if (methodC(number)) {
            return true;
        }
        return false;
    }

    /**
     * <p>
     * Methode A</p>
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6</p>
     * <p>
     * Die Berechnung und mögliche Ergebnisse entsprechen dem Verfahren 06.</p>
     * <pre>
     *Stelle-Nr.:    1 2 3 4 5 6 7 8 9 10
     * Kontonummer:  X X X X K K K K K P
     * Gewichtung            6 5 4 3 2
     * </pre>
     * <p>
     * Testkontonummern richtig: 240699, 350982, 461059<br>
     * Testkontonummern falsch: 240965, 350980, 461053
     * </p>
     * <p>
     * Führt die Berechnung nach Methode A zu einem Prüfziffer- fehler, ist
     * die Berechnung nach Methode B vorzunehmen.</p>
     * <p>
     * @see Method06
     * @param number
     * @return
     */
    @Override
    boolean methodA(int[] number) {
        number = expand(number);
        weighting = new int[]{2, 3, 4, 5, 6};
        Method06 method06 = new Method06();
        number = method06.factor(number, weighting, 5, 9);
        int pz = method06.add(number, 4, 9);
        pz = method06.modulus11(pz);
        return method06.checkPz(pz, number);
    }

    /**
     * <p>
     * Methode B. </p>
     * <p>
     * Modulus 7, Gewichtung 2, 3, 4, 5, 6</p>
     * <p>
     * Die Berechnung und mögliche Ergebnisse entsprechen dem Verfahren 06.
     * Dabei ist zu beachten, dass als Divisor 7 zu verwenden ist.</p>
     * <pre>
     * Stelle-Nr.:  1 2 3 4 5 6 7 8 9 10
     * Kontonummer: X X X X K K K K K P
     * Gewichtung:          6 5 4 3 2
     * </pre>
     * <p>
     * Testkontonummern richtig: 240692, 350985, 461052<br>
     * Testkontonummern falsch: 240965, 350980, 461053</p>
     * <p>
     * Ergibt auch die Berechnung der Prüfziffer nach Methode B einen
     * Prüfzifferfehler, ist eine weitere Berechnung mit der Methode C
     * vorzunehmen.</p>
     *
     * @param number
     * @return
     */
    @Override
    boolean methodB(int[] number) {
        number = expand(number);
        weighting = new int[]{2, 3, 4, 5, 6};
        Method06 method06 = new Method06();
        number = method06.factor(number, weighting, 5, 9);
        int pz = method06.add(number, 4, 9);
        pz = method06.modulus7(pz);
        return method06.checkPz(pz, number);
    }

    /**
     * <p>
     * Methode C. </p>
     * <p>
     * Modulus 10, Gewichtung 2, 1, 2, 1, 2</p>
     * <p>
     * Die Berechnung und mögliche Ergebnisse entsprechen dem Verfahren 06.</p>
     * <pre>
     * Stelle-Nr.:  1 2 3 4 5 6 7 8 9 10
     * Kontonummer: X X X X K K K K K P
     * Gewichtung:          2 1 2 1 2
     * </pre>
     * <p>
     * Testkontonummern richtig: 240961, 350984, 461054 <br>
     * Testkontonummern falsch: 240965, 350980, 461053</p>
     * <p>
     * Ausnahme:</p>
     * <p>
     * Ist nach linksbündiger Auffüllung mit Nullen auf 10 Stellen die 3.
     * Stelle der Kontonummer = 9 (Sachkonten), so erfolgt die Berechnung gemäß
     * der Ausnahme in Methode 51 mit den gleichen Ergebnissen und
     * Testkontonummern.</p>
     *
     * @param number
     * @return
     */
    @Override
    boolean methodC(int[] number) {
        number = expand(number);
        weighting = new int[]{2, 1, 2, 1, 2};
        int[] tmp = number.clone();
        Method06 method06 = new Method06();
        method06.setAccountNumberArray(number);
        number = method06.factor(number, weighting, 5, 9);
        int pz = method06.add(number, 4, 9);
        log.debug("after add: " + pz);
        pz = method06.modulus10(pz);

        if (method06.checkPz(pz, number)) {
            return true;
        }

        number = tmp.clone(); // reset AccountNumber
        if (number[2] == 9) {
            if (this.methodDvariant1(number)) {
                return true;
            }
            number = tmp.clone(); // reset AccountNumber
            if (this.methodDvariant2(number)) {
                return true;
            }
        }
        return false;
    }

}
