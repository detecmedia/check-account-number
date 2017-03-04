package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen 60.
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2</p>
 * <p>
 * Die Berechnung erfolgt wie bei Verfahren 00. Es ist jedoch zu beachten, dass
 * die zweistellige Unterkontonummer (Stellen 1 und 2) nicht in das
 * Prüfziffernverfahren mit einbezogen werden darf. Die für die Berechnung
 * relevante siebenstellige Grundnummer befindet sich in den Stellen 3 bis 9,
 * die Prüfziffer in der Stelle 10.</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method60 extends Method00 {

    private int[] weighting;

    @Override
    public boolean test() {
        weighting = new int[]{2, 1, 2, 1, 2, 1, 2};
        int[] number = this.getAccountNumberArray();
        number = expand(number);
        number = factor(number, weighting, 3, 9);
        int pz = add(number, 2, 9);
        pz = modulus10(pz);
        return checkPz(pz, number);

    }

}
