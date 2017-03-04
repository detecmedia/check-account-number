package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.exception.InvalidException;

import java.util.Arrays;

import org.apache.log4j.Logger;

/**
 * Kennzeichen 76.
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5 ff.</p>
 * <p>
 * Die einzelnen Stellen der für die Berechnung der Prüfziffer relevanten 5-,
 * 6- oder 7-stelligen Stammnummer sind von rechts nach links mit den Ziffern 2,
 * 3, 4, 5 ff. zu multiplizieren. Die jeweiligen Produkte werden addiert. Die
 * Summe ist durch 11 zu dividieren. Der verbleibende Rest ist die Prüfziffer.
 * Ist der Rest 10, kann die Kontonummer nicht geprüft werden.</p>
 * <p>
 * Zusammensetzung der Kontonummer:
 * </p>
 * <pre>
 * S = Stammnummer               (5-, 6- oder 7-stellig; die letzte Stelle
 *                                dieser Nummer ist die Prüfziffer, sie wird
 *                                jedoch nicht in die Prüfzifferberechnung
 *                                einbezogen)
 * A = Kontoart (1-stellig)*)           werden nicht in die
 * P = Prüfziffer                       Prüfzifferberechnung
 * U = * Unterkontonummer (2-stellig)   einbezogen
 * *) Die Kontoart kann den Wert 0, 4, 6, 7, 8 oder 9 haben.
 * </pre>
 * <p>
 * Darstellung der Kontonummer:</p>
 * <pre>
 * Stellennr.:      1 2 3 4 5 6 7 8 9 A (A=10)
 * 5stell.Stammnr.: A 0 0 S S S S P U U
 * 6stell.Stammnr.: A 0 S S S S S P U U
 * 7stell.Stammnr.: A S S S S S S P U U
 * </pre>
 * <p>
 * Beispiel:<br>
 * Prüfzifferberechnung für eine 6-stellige Kontonummer, Kontoart ist "0".</p>
 * <pre>
 * Stellennr.: 1  2  3  4  5  6  7  8  9  A  (A=10)
 * Kontonr.:   0  0  1  2  3  4  5  6  0  0
 * Gewichtung:       6  5  4  3  2
 *                   -------------
 *                   6+10+12+12+10 = 50
 *
 * 50 : 11 = 4 Rest 6 = Prüfziffer
 * </pre> ￼
 *
 * <p>
 * Ausnahme:</p>
 * <p>
 * Ist die Unterkontonummer "00" kann es vorkommen, dass sie auf den
 * Zahlungsverkehrsbelegen oder in beleglosen Datensätzen nicht angegeben ist,
 * die Kontonummer jedoch um führende Nullen ergänzt wurde. Die Prüfziffer
 * ist dann an die 10. Stelle gerückt. Die Berechnung der Prüfziffer ist wie
 * folgt durchzuführen:</p>
 * <pre>
 * Beispiel:               (Kontoart = 0)
 * Stellennr.: 1  2  3  4  5  6  7  8  9  A (A=10)
 * Kontonr.:   0  0  0  0  1  2  3  4  5  6
 * Gewichtung:             6  5  4  3  2
 *                         -------------
 *                         6+10+12+12+10 = 50
 * 50 : 11 = 4 Rest 6 = Prüfziffer
 * ￼</pre>
 * <pre>
 * Testkontonummern:
 * 5-stellige Kontonr. (Kontoart = 0) 0006543200
 * 6-stellige Kontonr. (Kontoart = 9) 9012345600
 * 7-stellige Kontonr. (Kontoart = 7) 7876543100
 * </pre>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method76
        extends AbstractMethod {

    private Logger log = Logger.getLogger(Method76.class);

    @Override
    public boolean test() {

        weighting = new int[]{2, 3, 4, 5, 6, 7, 8, 9};
        int[] number = expand(this.getAccountNumberArray());
        number = factor(number, weighting, 1, 7);
        int pz = add(number, 1, 7);
        pz = modulus11(pz);
        if (checkPz(pz, number, 8)) {
            return true;
        }

        number = expand(this.getAccountNumberArray());
        log.debug("number: " + Arrays.toString(number));
        number = move(number, -2);
        log.debug("number: " + Arrays.toString(number));
        number = factor(number, weighting, 1, 7);
        pz = add(number, 1, 7);
        pz = modulus11(pz);
        return checkPz(pz, number, 8);

    }

    @Override
    protected int modulus11(int number) {
        int pz = number % 11;
        if (pz == 10) {
            throw new InvalidException("not invalid");
        }
        return pz;
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
