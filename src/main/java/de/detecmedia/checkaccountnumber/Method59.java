package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen 59.
 * <p>
 * <b>geändert seit 03.12.2001</b></p>
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2</p>
 * <p>
 * Die Berechnung erfolgt wie bei Verfahren 00; es ist jedoch zu beachten, dass
 * Kontonummern, die kleiner als 9-stellig sind, nicht in die
 * Prüfzifferberechnung einbezogen und als richtig behandelt werden.</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method59 extends Method00 {

    private int[] weighting;

    @Override
    public boolean test() {
        weighting = new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2};
        int[] number = this.getAccountNumberArray();
        if (number.length < 9) {
            return true;
        }
        return check(weighting);
    }

}
