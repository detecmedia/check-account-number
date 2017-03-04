package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen 63.
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1</p>
 * <p>
 * Aufbau der 9-stelligen Kontonummer (innerhalb des zwischenbetrieblichen
 * 10-stelligen Feldes)</p>
 * <pre>
 * Stelle          1 =  gehört nicht zur Kontonummer, muss daher »0« oder »blank« sein
 *               2-7 =  Grundnummer (Kundennummer; kann auch führende Nullen enthalten)
 *                 8 =  Prüfziffer
 *              9-10 =  Unterkontonummer
 * </pre>
 * <p>
 * Die für die Berechnung relevante 6-stellige Grundnummer (Kundennummer)
 * befindet sich in den Stellen 2 bis 7, die Prüfziffer in Stelle 8 der
 * Kontonummer. Die zweistellige Unterkontonummer (Stellen9 und 10) ist nicht in
 * das Prüfzifferverfahren mit einzubeziehen. Die einzelnen Stellen der
 * Grundnummer sind von rechts nach links mit den Ziffern 2, 1, 2, 1, 2, 1 zu
 * multiplizieren. Die jeweiligen Produkte werden addiert, nachdem jeweils aus
 * den zweistelligen Produkten die Quersumme gebildet wurde (z. B. Produkt 16 =
 * Quersumme 7). Nach der Addition bleiben außer der Einerstelle alle anderen
 * Stellen unberücksichtigt. Die Einerstelle wird von dem Wert 10 subtrahiert.
 * Das Ergebnis ist die Prüfziffer (Stelle 8). Hat die Einerstelle den Wert
 * »0«, ist die Prüfziffer »0«.</p>
 * <pre>
 * Stellennr.: 1  2  3  4  5  6  7  8  9  A  (A=10)
 * Kontonr.:   0  1  2  3  4  5  6  P  0  0
 * Gewichtung:    1  2  1  2  1  2
 *               -----------------
 *                1+ 4+ 3+ 8+ 5+12
 *                1+ 4+ 3+ 8+ 5+ 3 = 24
 *                              (Q)
 *
 * (Q = Quersumme)
 * </pre>
 * <p>
 * Die Einerstelle wird vom Wert 10 subtrahiert (10 - 4 = 6).</p>
 * <p>
 * Die Prüfziffer ist in dem Beispiel die 6 und die vollständige Kontonummer
 * lautet: 1 2 3 4 5 6 6 0 0</p>
 * <p>
 * Ausnahmen:</p>
 * <p>
 * Ist die Ziffer in Stelle 1 vor der sechsstelligen Grundnummer nicht »0« (oder
 * »blank«), ist das Ergebnis als falsch zu werten.</p>
 * <p>
 * Ist die Unterkontonummer »00«, kann es vorkommen, dass sie auf den
 * Zahlungsverkehrsbelegen nicht angegeben ist, die Kontonummer jedoch um
 * führende Nullen ergänzt wurde. In diesem Fall sind z. B. die Stellen 1 bis
 * 3 »000« (oder »blank«), die Prüfziffer ist an der Stelle 10 und die
 * Berechnung ist wie folgt durchzuführen:</p>
 * <pre>
 * Stellennr.: 1  2  3  4  5  6  7  8  9  A  (A=10)
 * Kontonr.:   0  0  0  1  2  3  4  5  6  6
 * Gewichtung: 0  0  0  1  2  1  2  1  2
 *            --------------------------
 *             0+ 0+ 0+ 1+ 4+ 3+ 8+ 5+12
 *                      1+ 4+ 3+ 8+ 5+ 3 = 24
 *                                    (Q)
 * (Q = Quersumme)
 * 10 - 4 = 6 Prüfziffer richtig
 * </pre>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method63 extends AbstractMethod {

    private int[] weighting;

    @Override
    public boolean test() {
        weighting = new int[]{2, 1, 2, 1, 2, 1};
        int[] number = expand(this.getAccountNumberArray());
        if (number[0] != 0) {
            return false;
        }

        if (number[0] == 0 && number[1] == 0 && number[2] == 0) {
            number = move(number, -2);
        }
        number = factor(number, weighting, 2, 7);
        int pz = add(number, 1, 7);
        pz = modulus10(pz);
        return checkPz(pz, number, 8);
    }

}
