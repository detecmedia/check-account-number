package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen 62.
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2</p>
 * <p>
 * Die beiden ersten und die beiden letzten Stellen sind nicht zu
 * berücksichtigen. Die Stellen drei bis sieben sind von rechts nach links mit
 * den Ziffern 2, 1, 2, 1, 2 zu multiplizieren. Aus zweistelligen
 * Einzelergebnissen ist eine Quersumme zu bilden. Alle Ergebnisse sind dann zu
 * addieren. Die Differenz zum nächsten Zehner ergibt die Prüfziffer auf
 * Stelle acht. Ist die Differenz 10, ist die Prüfziffer 0.</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   5 0 2 9 0 7 6 P 0 1
 * Gewichtung:     2 1 2 1 2
 *               -----------
 *                 4+9+0+7+3 = 23
 *                        (Q)
 *                            Q = Quersumme)
 * </pre>
 * <p>
 * Die Einerstelle wird vom Wert 10 subtrahiert 10 - 3 = 7.</p>
 * <p>
 * Die Prüfziffer ist in diesem Fall die 7 und die vollständige Kontonummer
 * lautet: 5 0 2 9 0 7 6 7 0 1</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method62
        extends AbstractMethod {

    @Override
    public boolean test() {
        weighting = new int[]{2, 1, 2, 1, 2};
        int[] number = expand(this.getAccountNumberArray());
        number = factor(number, weighting, 3, 7);
        int pz = add(number, 2, 7);
        pz = modulus10(pz);
        return checkPz(pz, number, 8);

    }

}
