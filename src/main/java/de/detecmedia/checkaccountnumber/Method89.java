package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.exception.AccountNumberLenghtException;

import static de.detecmedia.checkaccountnumber.constants.AccountNumberPlace.P_10_TH;
import static de.detecmedia.checkaccountnumber.constants.AccountNumberPlace.P_4_TH;
import static de.detecmedia.checkaccountnumber.constants.AccountNumberPlace.P_5_TH;
import static de.detecmedia.checkaccountnumber.constants.Length.L_10;
import static de.detecmedia.checkaccountnumber.constants.Length.L_6;
import static de.detecmedia.checkaccountnumber.constants.Length.L_7;
import static de.detecmedia.checkaccountnumber.constants.Length.L_8;
import static de.detecmedia.checkaccountnumber.constants.Length.L_9;
import static de.detecmedia.checkaccountnumber.converter.Weighting.Weighting;

/**
 * Kennzeichen 89.
 * <p>
 * 8- und 9-stellige Kontonummern sind mit dem Berechnungs- verfahren 10 zu
 * prüfen.</p>
 * <p>
 * 7-stellige Kontonummern sind wie folgt zu prüfen:</p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7</p>
 * <p>
 * Die Kontonummer ist durch linksbündige Nullenauffüllung 10- stellig
 * darzustellen. Die für die Berechnung relevante 6- stellige Stammnummer (x)
 * befindet sich in den Stellen 4 bis 9, die Prüfziffer in Stelle 10 der
 * Kontonummer. Die einzelnen Stellen der Stammnummer sind von rechts nach links
 * mit den Ziffern 2, 3, 4, 5, 6, 7 zu multiplizieren. Die jeweiligen Produkte
 * werden addiert, nachdem jeweils aus den 2-stelligen Produkten Quersummen
 * gebildet wurden. Die Summe ist durch 11 zu dividieren. Die weiteren
 * Berechnungen und Ergebnisse entsprechen dem Verfahren 06.</p>
 * <pre>
 * Stellennr.:       1 2 3 4 5 6 7 8 9 A (A=10)
 * 7-stell.Kontonr.: 0 0 0 x x x x x x P
 * Gewichtung:             7 6 5 4 3 2
 * </pre>
 * <p>
 * 1- bis 6- und 10-stellige Kontonummern sind nicht zu prüfen, da diese keine
 * Prüfziffer enthalten.</p>
 * <p>
 * Testkontonummern: 1098506, 32028008, 218433000</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method89
        extends AbstractMethod {

    /**
     * Test account number.
     *
     * @return boolean
     */
    @Override
    public boolean test() {
        int[] number = expand(this.getAccountNumberArray());
        int length = (this.getLong() + "").length();
        if (length <= L_6 || length >= L_10) {
            throw new AccountNumberLenghtException();
        }
        if (length == L_8 || length == L_9) {
            Method10 method10 = new Method10();
            method10.setAccountNumberArray(number);
            return method10.test();
        }
        if (length == L_7) {
            Method06 method06 = new Method06();
            number = method06.factor(
                    number,
                    Weighting("2,3,4,5,6,7").getWeighting(),
                    P_5_TH,
                    P_10_TH
            );
            int pz = add(number, P_4_TH, P_10_TH);
            pz = method06.modulus11(pz);
            return method06.checkPz(pz, number);
        }
        return false;
    }

}
