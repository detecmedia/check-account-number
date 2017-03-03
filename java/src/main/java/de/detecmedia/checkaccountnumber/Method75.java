package de.detecmedia.checkaccountnumber;

import org.apache.log4j.Logger;

/**
 * Kennzeichen 75.
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2</p>
 * <p>
 * Die Kontonummer (6-, 7- oder 9-stellig) ist durch linksbündige
 * Nullenauffüllung 10-stellig darzustellen. Die für die Be- rechnung
 * relevante 5-stellige Stammnummer (S) wird von links nach rechts mit den
 * Ziffern 2, 1, 2, 1, 2 multipliziert. Die weitere Berechnung und die
 * Ergebnisse entsprechen dem Verfahren 00.</p>
 * <p>
 * Zusammensetzung der Kontonummer:</p>
 * ￼￼
 * <pre>
 * S = Stammnummer
 * X = Weitere Ziffern der Kontonummer, die jedoch nicht in
 *     die Prüfzifferberechnung mit einbezogen werden
 * P = Prüfziffer
 *
 * Stellennr.:      1 2 3 4 5 6 7 8 9 A (A = 10)
 * 6stell.Kontonr.: 0 0 0 0 S S S S S P
 * 7stell.Kontonr.: 0 0 0 X S S S S S P
 * 9stell.Kontonr.: 0 9 S S S S S P X X
 * 10stell.Kontonr.:0 S S S S S P X X X
 * </pre>
 * <p>
 * Anmerkungen:<br>
 * Bei 6- und 7-stelligen Kontonummern befindet sich die für die Berechnung
 * relevante Stammnummer in den Stellen 5 bis 9, die Prüfziffer in Stelle 10
 * der Kontonummer.</p>
 * <p>
 * Bei 9-stelligen Kontonummern befindet sich die für die Berechnung relevante
 * Stammnummer in den Stellen 2 bis 6, die Prüfziffer in der 7. Stelle der
 * Kontonummer. Ist die erste Stelle der 9-stelligen Kontonummer = 9 (2.Stelle
 * der »gedachten« Kontonummer), so befindet sich die für die Berechnung
 * relevante Stammnummer in den Stellen 3 bis 7, die Prüfziffer in der 8.
 * Stelle der Kontonummer.</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method75 extends Method00 {

    private Logger log = Logger.getLogger(Method75.class);

    @Override
    public boolean test() {
        weighting = new int[]{2, 1, 2, 1, 2};
        int[] number = expand(this.getAccountNumberArray());
        if (number[0] == 0 && number[1] == 0 && number[2] == 0) {
            number = factor(number, weighting, 5, 9);
            int pz = add(number, 4, 9);
            pz = modulus10(pz);
            if (checkPz(pz, number)) {
                return true;
            }
        }
        number = expand(this.getAccountNumberArray());
        if (number[1] == 9) {
            number = factor(number, weighting, 3, 7);
            int pz = add(number, 2, 7);
            pz = modulus10(pz);
            if (checkPz(pz, number, 8)) {
                return true;
            }
        }
        number = expand(this.getAccountNumberArray());
        if (number[0] == 0) {
            number = factor(number, weighting, 2, 6);
            int pz = add(number, 1, 6);
            pz = modulus10(pz);
            if (checkPz(pz, number, 7)) {
                return true;
            }
        }
        return false;
    }

}
