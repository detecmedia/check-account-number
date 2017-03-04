package de.detecmedia.checkaccountnumber;

import org.apache.log4j.Logger;

/**
 * Kennzeichen E0.
 * <p>
 * gültig seit 04.03.2013,</p>
 * <p>
 * Klarstellung zum 03.06.2013</p>
 * <p>
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2</p>
 * <p>
 * Die Stellen der Kontonummer sind von rechts nach links mit den Ziffern 2, 1,
 * 2, 1, 2 usw. zu multiplizieren. Die jeweiligen Produkte werden addiert,
 * nachdem jeweils aus den zweistelligen Produkten die Quersumme gebildet wurde
 * (z. B. Produkt 18 = Quersumme 9) plus den Wert 7. Nach der Addition bleiben
 * außer der Einerstelle alle anderen Stellen unberücksichtigt. Die Einerstelle
 * wird von dem Wert 10 subtrahiert. Das Ergebnis ist die Prüfziffer (10.
 * Stelle der Kontonummer). Ergibt sich nach der Subtraktion der Rest 10, ist
 * die Prüfziffer 0.</p>
 * <pre>Beispiel:
 * Stelle-Nr.  1  2  3  4  5  6  7  8  9 10
 * Kontonummer 1  2  3  4  5  6  8  0  1  3
 * Gewichtung  2  1  2  1  2  1  2  1  2  P
 *           ------------------------------
 * Produkt     2  2  6  4 10  6 16  0  2
 * Quersumme   2+ 2+ 6+ 4+ 1+ 6+ 7+ 0+ 2
 *
 * Summe = 30 + 7 = 37
 * 10 – 7 (Einerstelle) = 3 = Prüfziffer
 * </pre>
 * <p>
 * Testkontonummern (richtig):1234568013, 1534568010, 2610015, 8741013011
 * Testkontonummern (falsch):1234769013, 2710014, 9741015011</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodE0
        extends AbstractMethod {
    private final Logger log = Logger.getLogger(MethodE0.class);
    private int[] weighting;

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        number = expand(number);
        weighting = new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2};
        number = this.factor(number, weighting);
        int pz = add(number);
        log.debug("pz " + pz);
        pz += 7;
        pz %= 10;
        log.debug("pz after +7 " + pz);
        if (pz > 9) {
            pz = pz % 10;
        }
        log.debug(" pz : " + pz);
        return checkPz((10 - pz) % 10, number);

    }

}
