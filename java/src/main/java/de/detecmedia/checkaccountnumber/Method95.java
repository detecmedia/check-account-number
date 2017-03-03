package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen 95.
 * <p>
 * <b>geändert zum 09.09.2013</b></p>
 *
 *
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 2, 3, 4</p>
 * <p>
 * Die Berechnung erfolgt wie bei Verfahren 06.</p>
 * <pre>
 * Ausnahmen:
 *  Kontonr.: 0000000001 bis 0001999999
 *  Kontonr.: 0009000000 bis 0025999999
 *  Kontonr.: 0396000000 bis 0499999999
 *  Kontonr.: 0700000000 bis 0799999999
 *  Kontonr.:0910000000 bis 0989999999
 *
 *  Für diese Kontonummernkreise ist keine Prüfziffer-
 *  berechnung möglich. Sie sind als richtig anzusehen.</pre>
 * <p>
 * Testkontonummern: 0068007003, 0847321750, 6450060494, 6454000003</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method95
        extends Method06 {

    @Override
    public boolean test() {
        if(this.getLong() >= 1L && this.getLong() <= 1999999L ||
                this.getLong() >= 9000000L && this.getLong() <= 25999999L ||
                this.getLong() >= 396000000L && this.getLong() <= 499999999L ||
                this.getLong() >= 700000000L && this.getLong() <= 799999999L ||
                this.getLong() >= 910000000L && this.getLong() <= 989999999L) {
            return true;
        }
        weighting = new int[]{2, 3, 4, 5, 6, 7, 2, 3, 4};
        return this.check(weighting);
    }

}
