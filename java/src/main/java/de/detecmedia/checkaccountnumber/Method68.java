package de.detecmedia.checkaccountnumber;

import org.apache.log4j.Logger;

/**
 * Kennzeichen 68.
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2</p>
 * <p>
 * Die Kontonummern sind 6- bis 10-stellig und enthalten keine führenden
 * Nullen. Die erste Stelle von rechts ist die Prüfziffer. Die Berechnung
 * erfolgt wie bei Verfahren 00, hierbei sind jedoch folgende Besonderheiten zu
 * beachten:</p>
 * <p>
 * Bei 10-stelligen Kontonummern erfolgt die Berechnung für die 2. bis 7.
 * Stelle. Stelle 7 muss eine »9« sein.</p>
 * <pre>
 * Stellennr.: A 9 8 7 6 5 4 3 2 1 (A=10)
 * Kontonr.:   8 8 8 9 6 5 4 3 2 P
 * Gewichtung:       1 2 1 2 1 2
 *                  ------------
 *                   9+3+5+8+3+4 = 32
 *                    (Q)
 * (Q = Quersumme)
 *
 * Die Einerstelle der Summe wird vom Wert 10 subtrahiert (10 - 2 = 8).
 *
 * </pre>
 * <p>
 * Die Prüfziffer ist in diesem Fall die 8 und die vollständige Kontonummer
 * lautet: 8 8 8 9 6 5 4 3 2 8 6- bis 9-stellige Kontonummern sind in zwei
 * Varianten prüfbar.</p>
 * <p>
 * <b>Variante 1:</b> voll prüfbar</p>
 * <pre>
 * Kontonr.:   9 8 7 6 5 4 3 2 P
 * Gewichtung: 1 2 1 2 1 2 1 2
 *             ---------------
 *             9+7+7+3+5+8+3+4 = 46
 *              (Q) (Q)
 * (Q = Quersumme)
 * </pre>
 * <p>
 * Die Einerstelle der Summe wird vom Wert 10 subtrahiert (10 - 6 = 4).</p>
 * <p>
 * Die Prüfziffer ist in diesem Fall die 4 und die vollständige Kontonummer
 * lautet: 9 8 7 6 5 4 3 2 4</p>
 * <p>
 * Ergibt die Berechnung nach Variante 1 einen Prüfzifferfehler, muss Variante
 * 2 zu einer korrekten Prüfziffer führen.</p>
 * <p>
 * <b>Variante 2:</b> Stellen 7 und 8 werden nicht geprüft.</p>
 * <pre>
 * Kontonr.:   9 8 7 6 5 4 3 2 P
 * Gewichtung: 1 2 1 2 1 2
 *             -----------
 *             9+3+5+8+3+4 = 32
 *              (Q)
 * (Q = Quersumme)
 * </pre>
 * <p>
 * Die Einerstelle der Summe wird vom Wert 10 subtrahiert (10 - 2 = 8).</p>
 * <p>
 * Die Prüfziffer ist in diesem Fall die 8 und die vollständige Kontonummer
 * lautet: 9 8 7 6 5 4 3 2 8</p>
 * <p>
 * 9-stellige Kontonummern im Nummernbereich 400 000 000 bis 499 999 999 sind
 * nicht prüfbar, da diese Nummern keine Prüfziffer enthalten.</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method68 extends Method00 {

    private final Logger log = Logger.getLogger(Method68.class);

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();

        if (variant0(number.clone()) && number.length == 10  && number[3] == 9 && number[0] != 0) {
            return true;
        }
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
     * Die Kontonummern sind 6- bis 10-stellig und enthalten keine führenden
     * Nullen. Die erste Stelle von rechts ist die Prüfziffer. Die Berechnung
     * erfolgt wie bei Verfahren 00, hierbei sind jedoch folgende Besonderheiten
     * zu beachten:</p>
     * <p>
     * Bei 10-stelligen Kontonummern erfolgt die Berechnung für die 2. bis 7.
     * Stelle. Stelle 7 muss eine »9« sein.</p>
     * <pre>
     * Stellennr.: A 9 8 7 6 5 4 3 2 1 (A=10)
     * Kontonr.:   8 8 8 9 6 5 4 3 2 P
     * Gewichtung:       1 2 1 2 1 2
     *                  ------------
     *                   9+3+5+8+3+4 = 32
     *                    (Q)
     * (Q = Quersumme)
     *
     * Die Einerstelle der Summe wird vom Wert 10 subtrahiert (10 - 2 = 8).
     *
     * </pre>
     * <p>
     * Die Prüfziffer ist in diesem Fall die 8 und die vollständige
     * Kontonummer lautet: 8 8 8 9 6 5 4 3 2 8 6- bis 9-stellige Kontonummern
     * sind in zwei Varianten prüfbar.</p>
     *
     * @param number
     * @return
     */
    boolean variant0(int[] number) {
        number = expand(number);
        weighting = new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2};
        number = factor(number, weighting,4,9);
        int pz = add(number,3,9);
        pz = modulus10(pz);

        return checkPz(pz, number);

    }

    /**
     *
     *
     * <p>
     * <b>Variante 1:</b> voll prüfbar</p>
     * <pre>
     * Kontonr.:   9 8 7 6 5 4 3 2 P
     * Gewichtung: 1 2 1 2 1 2 1 2
     *             ---------------
     *             9+7+7+3+5+8+3+4 = 46
     *              (Q) (Q)
     * (Q = Quersumme)
     * </pre>
     * <p>
     * Die Einerstelle der Summe wird vom Wert 10 subtrahiert (10 - 6 = 4).</p>
     * <p>
     * Die Prüfziffer ist in diesem Fall die 4 und die vollständige
     * Kontonummer lautet: 9 8 7 6 5 4 3 2 4</p>
     * <p>
     * Ergibt die Berechnung nach Variante 1 einen Prüfzifferfehler, muss
     * Variante 2 zu einer korrekten Prüfziffer führen.</p>
     *
     */
    boolean variant1(int[] number) {
        number = expand(number);
        weighting = new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2};
        number = factor(number, weighting);
        int pz = add(number);
        pz = modulus10(pz);

        return checkPz(pz, number);

    }

    /**
     * <p>
     * <b>Variante 2.</b></p><p>
     * Stellen 7 und 8 werden nicht geprüft.</p>
     * <pre>
     * Stellen     1 2 3 4 5 6 7 8 9 10
     * Kontonr.:     9 8 7 6 5 4 3 2 P
     * Gewichtung:   1     2 1 2 1 2
     *               -----------
     *               9+   3+5+8+3+4 = 32
     *                   (Q)
     * (Q = Quersumme)
     * </pre>
     * <p>
     * Die Einerstelle der Summe wird vom Wert 10 subtrahiert (10 - 2 = 8).</p>
     * <p>
     * Die Prüfziffer ist in diesem Fall die 8 und die vollständige
     * Kontonummer lautet: 9 8 7 6 5 4 3 2 8</p>
     * <p>
     * 9-stellige Kontonummern im Nummernbereich 400 000 000 bis 499 999 999
     * sind nicht prüfbar, da diese Nummern keine Prüfziffer enthalten.</p>
     *
     * @return
     */
    boolean variant2(int[] number) {
        number = expand(number);
        weighting = new int[]{2, 1, 2, 1, 2, 0, 0, 1, 2, 1, 2};
        number = factor(number, weighting);
        int pz = add(number);
        pz = modulus10(pz);

        return checkPz(pz, number);
    }

}
