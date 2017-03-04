package de.detecmedia.checkaccountnumber;

import org.apache.log4j.*;
import de.detecmedia.checkaccountnumber.exception.AccountNumberLenghtException;

/**
 * Kennzeichen 13.
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1</p>
 * <p>
 * Die Berechnung erfolgt wie bei Verfahren 00. Die für die Berechnung
 * relevante sechsstellige Grundnummer befindet sich in den Stellen 2 bis 7, die
 * Prüfziffer in Stelle 8 (von links nach rechts gezählt). Die zweistellige
 * Unterkontonummer (Stellen 9 und 10) darf nicht in das Prüfzifferberechnungs-
 * verfahren einbezogen werden. Ist die Unterkontonummer »00», kommt es vor,
 * dass sie nicht angegeben ist. Ergibt die erste Berechnung einen
 * Prüfzifferfehler, wird empfohlen, die Prüfzifferberechnung ein zweites Mal
 * durchzuführen und dabei die »gedachte« Unterkontonummer 00 an die Stellen 9
 * und 10 zu setzen und die vorhandene Kontonummer vorher um zwei Stellen nach
 * links zu verschieben.
 * </p>
 *
 * @author Markus Potthast
 */
public class Method13 extends Method00 {

    private Logger log = Logger.getLogger(Method13.class);

    @Override
    public boolean test() {

        weighting = new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2, 1};

        int[] number = this.getAccountNumberArray();
        if (number.length < 8) {
            throw new AccountNumberLenghtException();
        }

        number = expand(number);

        number = factor(number, weighting, 2, 7);
        int pz = add(number, 1, 7);
        pz = modulus10(pz);
        return checkPz(pz, number, 8);
    }

}
