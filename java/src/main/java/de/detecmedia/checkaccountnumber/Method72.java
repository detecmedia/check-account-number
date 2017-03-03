package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen 72.
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1</p>
 * <p>
 * Die Kontonummer ist 10-stellig. Die Stellen4 bis 9 der Kundennummer (K)
 * werden von rechts nach links mit den Gewichten 2, 1, 2, 1, 2, 1
 * multipliziert. Die Berechnung und Ergebnisse entsprechen dem Verfahren 00.
 * Die 10. Stelle der Kontonummer ist die Prüfziffer. Es ist jedoch zu
 * beachten, dass die zweistellige Unterkontonummer (U = Stellen 1 und 2) und
 * die Artziffer (A = Stelle 3) nicht in das Prüfzifferverfahren mit einbezogen
 * werden.</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   U U A K K K K K K P
 * Gewichtung:       1 2 1 2 1 2
 * </pre>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method72 extends Method00 {

    @Override
    public boolean test() {
        int[] number = expand(this.getAccountNumberArray());
        weighting = new int[]{2, 1, 2, 1, 2, 1};
        number = factor(number, weighting, 4, 9);
        int pz = add(number, 3, 9);
        pz = modulus10(pz);
        return checkPz(pz, number);
    }

}
