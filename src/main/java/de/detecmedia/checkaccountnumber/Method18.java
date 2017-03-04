package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen 18.
 * <p>
 * Modulus 10, Gewichtung 3, 9, 7, 1, 3, 9, 7, 1, 3 </p><p>
 * Die Berechnung erfolgt wie bei Verfahren 01.</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method18 extends Method01 {

    @Override
    public boolean test() {
        weighting = new int[]{3, 9, 7, 1, 3, 9, 7, 1, 3};
        return this.check(weighting);
    }

}
