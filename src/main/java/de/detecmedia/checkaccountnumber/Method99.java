package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen 99.
 * <p>
 * <b>gültig seit 04.03.2002</b></p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 2, 3, 4</p><p>
 * Die Berechnung erfolgt wie bei Verfahren 06.</p>
 * <pre>
 * Ausnahmen:
 *  Kontonr.:   0396000000 bis 0499999999
 *  Für diese Kontonummern ist keine Prüfzifferberechnung möglich.
 *  Sie sind als richtig anzusehen.
 * </pre>
 * <p>
 * Testkontonummern: 0068007003, 0847321750</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method99 extends Method06 {
    private int[] weighting;


    @Override
    public boolean test() {
        weighting = new int[]{2, 3, 4, 5, 6, 7, 2, 3, 4};
        if (this.getLong() >= 396000000L && this.getLong() <= 499999999L) {
            return true;
        }
        return this.check(weighting);
    }

}
