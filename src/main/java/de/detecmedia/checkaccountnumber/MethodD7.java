package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen D7.
 * <p>
 * gültig seit 06.06.2011</p>
 * <p>
 * ￼
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2</p>
 * <p>
 * Die Kontonummer ist einschließlich der Prüfziffer 10-stellig, ggf. ist die
 * Kontonummer für die Prüfzifferberechnung durch linksbündige Auffüllung
 * mit Nullen 10-stellig darzustellen.</p>
 * <p>
 * Die Stellen der Kontonummer sind von rechts nach links mit den Ziffern 2, 1,
 * 2, 1, 2, 1, 2, 1, 2 zu multiplizieren. Die jeweiligen Produkte werden
 * addiert, nachdem jeweils aus den zweistelligen Produkten die Quersumme
 * gebildet wurde (z. B. Produkt 18 = Quersumme 9). Nach der Addition bleiben
 * außer der Einerstelle alle anderen Stellen unberücksichtigt; diese
 * Einerstelle ist die Prüfziffer (Ergebnis = 27 / Prüfziffer = 7).</p>
 * <pre>
 * Beispiel:
 * Stelle-Nr.      1  2  3  4  5  6  7  8  9  10
 * Kontonummer     0  5  0  0  0  1  8  2  0  5
 * Gewichtung      2  1  2  1  2  1  2  1  2  P
 * --------------------------------------------
 * Produkt         0  5  0  0  0  1 16  2  0
 * Quersumme       0  5  0  0  0  1  7  2  0
 *
 * Summe = 15
 * Einerstelle = Prüfziffer = 5
 *
 * Testkontonummern richtig:   0500018205, 0230103715, 0301000434, 0330035104,
 *                             0420001202, 0134637709, 0201005939, 0602006999
 * Testkontonummern falsch:    0501006102, 0231307867, 0301005331, 0330034104,
 *                             0420001302, 0135638809, 0202005939, 0601006977
 * </pre>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodD7
        extends AbstractMethod {

    private int[] weighting;

    @Override
    public boolean test() {
        weighting = new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2};
        int[] number = this.getAccountNumberArray();
        number = expand(number);
        number = factor(number, weighting);
        int pz = add(number);
        pz %= 10;
        return checkPz(pz, number);
    }

}
