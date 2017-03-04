package de.detecmedia.checkaccountnumber;

import org.apache.log4j.Logger;

/**
 * Kennzeichen 66.
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 0, 0, 7</p>
 * <p>
 * Aufbau der 9-stelligen Kontonummer (innerhalb des zwischenbetrieblich
 * 10-stelligen Feldes)</p>
 * <pre>Stelle 1
 * 2 3-4
 * =
 * = =
 * gehört nicht zur Kontonummer, muss daher 0 sein
 * Stammnummer
 * Unterkontonummer, wird bei der Prüf- zifferberechnung nicht berücksichtigt Stammnummer
 * Prüfziffer
 * 5-9
 * 10 =
 * =
 * </pre>
 * <p>
 * Der 9-stelligen Kontonummer wird für die Prüfzifferberechnung eine 0
 * vorangestellt. Die Prüfziffer steht in Stelle 10. Die für die Berechnung
 * relevante 6-stellige Stammnummer (Kundenummer) befindet sich in den Stellen 2
 * und 5 bis 9. Die zweistellige Unterkontonummer (Stellen3 und 4) wird nicht in
 * das Prüfzifferberechnungsverfahren mit einbezogen und daher mit 0 gewichtet.
 * Die einzelnen Stellen der Stammnummer sind von rechts nach links mit den
 * Ziffern 2, 3, 4, 5, 6, 0, 0, 7 zu multiplizieren. Die jeweiligen Produkte
 * werden addiert. Die Summe ist durch 11 zu dividieren. Bei einem verbleibenden
 * Rest von 0 ist die Prüfziffer 1. Bei einem Rest von 1 ist die Prüfziffer 0.
 * Verbleibt ein Rest von 2 bis 10, so wird dieser vom Divisor (11) subtrahiert.
 * Die Differenz ist dann die Prüfziffer.</p>
 * <p>
 * Zusammengefasst:</p>
 * <pre>
 * Summe dividiert durch 11 = x, Rest
 * Rest = 0             Prüfziffer = 1
 * Rest = 1             Prüfziffer = 0
 * Rest = 2 bis 10      Prüfziffer = 11 minus Rest
 *
 *
 * Stellennr.:  1  2  3  4  5  6  7  8  9  10
 * Kontonr.:    0  1  0  0  1  5  0  5  0  P
 * Gewichtung:  0  7  0  0  6  5  4  3  2
 *             --------------------------
 *              0+ 7+ 0+ 0+ 6+25+ 0+15+ 0 = 53
 * 53 : 11 = 4,     Rest 9,
 * 11 -  9 = 2,     Prüfziffer = 2
 * </pre>
 * <p>
 * Die vollständige Kontonummer lautet: 100150502</p>
 * <p>
 * Ausnahme:</p>
 * <p>
 * Ist die Stelle 2 der Kontonummer der Wert = 9, ist die Kontonummer nicht
 * prüfziffergesichert; es gilt die Methode 09 (keine Prüfzifferberechnung).
 * Beispiel der Kontonummer: 0983393104.</p>
 * <p>
 * Testkontonummern: 100154508, 101154508, 100154516, 101154516</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method66 extends AbstractMethod {

    private final Logger log = Logger.getLogger(Method66.class);

    @Override
    public boolean test() {
        weighting = new int[]{2, 3, 4, 5, 6, 0, 0, 7};
        int[] number = expand(this.getAccountNumberArray());
        number = factor(number, weighting);
        int pz = add(number);

        pz = modulus11(pz);
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

}
