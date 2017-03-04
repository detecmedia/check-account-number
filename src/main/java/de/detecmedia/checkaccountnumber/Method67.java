package de.detecmedia.checkaccountnumber;

import org.apache.log4j.Logger;

/**
 * Kennzeichen 67.
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2</p>
 * <p>
 * Die Kontonummer ist 10-stellig. Die Berechnung erfolgt wie bei Verfahren 00.
 * Es ist jedoch zu beachten, dass die zweistellige Unterkontonummer (Stellen 9
 * und 10) nicht in das Prüfzifferberechnungsverfahren mit einbezogen werden
 * darf.</p>
 * <p>
 * Die für die Berechnung relevante siebenstellige Stammnummer befindet sich in
 * den Stellen 1 bis 7, die Prüfziffer in der Stelle 8.</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method67 extends Method00 {

    Logger log = Logger.getLogger(Method67.class);

    private int[] weighting;

    @Override
    public boolean test() {
        weighting = new int[]{2, 1, 2, 1, 2, 1, 2};
        int[] number = this.getAccountNumberArray();
        number = expand(number);
        number = factor(number, weighting, 1, 7);
        int pz = add(number, 0, 7);
        pz = modulus10(pz);
        return checkPz(pz, number, 8);
    }

}
