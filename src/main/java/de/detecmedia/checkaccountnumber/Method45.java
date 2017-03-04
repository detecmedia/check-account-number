package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen 45.
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2 </p><p>
 * Die Berechnung erfolgt wie bei Verfahren 00 Ausnahme: Kontonummern, die an
 * Stelle 1 (von links) eine 0 enthalten, und Kontonummern, die an Stelle 5 eine
 * 1 enthalten, beinhalten keine Prüfziffer.</p>
 * <p>
 * Testkontonummern: 3545343232, 4013410024</p>
 * <p>
 * <p>
 * Keine Prüfziffer enthalten:<br>
 * 0994681254, 0000012340 (da 1. Stelle = 0)<br>
 * 1000199999, 0100114240 (da 5. Stelle = 1)</p>
 * <p>
 * TODO: Recherchen wie verfahren wird mit Kontonummern ohne Prüfziffer.
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method45 extends Method00 {

    @Override
    public boolean test() {
        int[] number = expand(this.getAccountNumberArray());
        if (number[0] == 0 || number[4] == 1) {
            return true;
        }
        weighting = new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2};
        return check(weighting);
    }

}
