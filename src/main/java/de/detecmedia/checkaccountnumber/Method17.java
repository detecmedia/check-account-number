package de.detecmedia.checkaccountnumber;
// TODO: implements code

import de.detecmedia.checkaccountnumber.exception.InvalidAcountNumberException;

import java.util.Arrays;

import org.apache.log4j.Logger;

/**
 * Kennzeichen 17.
 * <p>
 * Modulus 11, Gewichtung 1, 2, 1, 2, 1, 2</p>
 * <p>
 * Die Kontonummer ist 10-stellig mit folgendem Aufbau; KSSSSSSPUU</p>
 * <pre>
 * K = Kontoartziffer
 * S = Stammnummer
 * P = Prüfziffer
 * U = Unterkontonummer</pre>
 * <p>
 * Die für die Berechnung relevante 6-stellige Stammnummer (Kundennummer)
 * befindet sich in den Stellen 2 bis 7 der Kontonummer, die Prüfziffer in der
 * Stelle 8. Die einzelnen Stellen der Stammnummer (S) sind von links nach
 * rechts mit den Ziffern 1, 2, 1, 2, 1, 2 zu multiplizieren. Die jeweiligen
 * Produkte sind zu addieren, nachdem aus eventuell zweistelligen Produkten der
 * 2., 4. und 6. Stelle der Stammnummer die Quersumme gebildet wurde. Von der
 * Summe ist der Wert "1" zu subtrahieren. Das Ergebnis ist dann durch 11 zu
 * dividieren. Der verbleibende Rest wird von 10 subtrahiert. Das Ergebnis ist
 * die Prüfziffer. Verbleibt nach der Division durch 11 kein Rest, ist die
 * Prüfziffer 0.</p>
 * <p>
 * Beispiel:</p>
 * <pre>
 * Stellennr.:        K S S S S S S P U U
 * Kontonummer:       0 4 4 6 7 8 6 0 4 0
 * Gewichtung:          1 2 1 2 1 2
 *                      -----------------
 *                      4+ 8+ 6+ 5+ 8+ 3 = 34
 *                               Q     Q
 * Q = Quersumme nur der jeweiligen Stellen lt. Beschreibung
 * 34 - 1 = 33
 * 33:11=3, Rest 0
 * 0 = Prüfziffer
 * </pre>
 * <p>
 * Testkontonummer: 0446786040</p>
 * <p>
 * TODO: factor richtig rum drehen hier wird von rechts nach links gerechnet.
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method17 extends AbstractMethod {

    public Logger log = Logger.getLogger(Method17.class);

    @Override
    public boolean test() {
        weighting = new int[]{2, 1, 2, 1, 2, 1};
        return check(weighting);

    }

    protected boolean check(int[] weighting) {
        int[] number = this.getAccountNumberArray();
        number = expand(number);
        log.debug("number: " + Arrays.toString(number));
        int pz = 0;
        number = factor(number, weighting, 2, 7);
        pz = add(number, 1, 7);
        pz = this.modulus11((pz - 1));
        return checkPz(pz, number, 8);
    }

    @Override
    protected int modulus11(int number) {
        int checkDigit;
        number %= 11;

        log.debug("%11: " + number);
        if (number == 0) {
            log.debug("pz 0: " + number);
            return 0;
        }

        checkDigit = 10 - number;
        log.debug("pz all: " + checkDigit);
        return checkDigit;
    }

}
