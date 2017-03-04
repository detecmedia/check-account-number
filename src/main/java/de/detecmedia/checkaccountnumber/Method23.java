package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen 23.
 * <b>geändert zum 03.09.2001</b>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7</p>
 * <p>
 * Das Berechnungsverfahren entspricht dem des Kennzeichens16, wird jedoch nur
 * auf die ersten sechs Ziffern der Kontonummer angewandt.
 * </p><p>
 * Die Prüfziffer befindet sich an der 7. Stelle der Kontonummer. Die Stellen 8
 * bis 10 bleiben ungeprüft.</p>
 * <pre>
 * Stellennr.:     1 2 3 4 5 6 7 8 9 10
 * Kontonummer:    x x x x x x P x x x
 * Gewichtung:     7 6 5 4 3 2
 *
 * Summe geteilt durch 11 = x, Rest
 * Rest = 0         Prüfziffer = 0.
 * Rest = 1         Prüfziffer = 6. und 7. Stelle der
 *                               Kontonummer müssen identisch
 *                               sein
 * Rest = 2 bis 10  Prüfziffer = 11 minus Rest
 * </pre>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method23 extends Method16 {

    @Override
    public boolean test() {
        weighting = new int[]{2, 3, 4, 5, 6, 7};
        int[] number = this.factor(this.getAccountNumberArray(), weighting, 1, 6);
        int pz = add(number, 0, 6);
        pz = pz % 11;
        if (pz == 1 && (number[5] == number[6])) {
            return true;
        }
        pz = 11 - pz;
        return checkPz(pz, number, 7);
    }

}
