package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.exception.AccountNumberLenghtException;

import java.util.Arrays;

import org.apache.log4j.Logger;

/**
 * Kennzeichen 26.
 * <p>
 * Modulus 11. Gewichtung 2, 3, 4, 5, 6, 7, 2</p><p>
 * Die Kontonummer ist 10-stellig. Sind Stelle 1 und 2 mit Nullen gefüllt ist
 * die Kontonummer um 2 Stellen nach links zu schieben und Stelle 9 und 10 mit
 * Nullen zu füllen. Die Berechnung erfolgt wie bei Verfahren 06 mit folgender
 * Modifizierung: für die Berechnung relevant sind die Stellen 1 - 7; die
 * Prüfziffer steht in Stelle 8. Bei den Stellen 9 und 10 handelt es sich um
 * eine Unterkontonummer, welche für die Berechnung nicht berücksichtigt
 * wird.</p><p>
 * Testkontonummern: 0520309001, 1111118111, 0005501024</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method26 extends Method06 {

    public Logger log = Logger.getLogger(Method26.class);

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        weighting = new int[]{2, 3, 4, 5, 6, 7, 2};

        log.debug("number: " + Arrays.toString(number));
        if (number.length != 10) {
            throw new AccountNumberLenghtException();
        }
        if (number[0] == 0 && number[1] == 0) {
            int[] tmp = new int[10];
            int tmpI = 0;
            for (int i = 2; i < number.length; i++) {
                tmp[tmpI++] = number[i];
            }
            tmp[8] = 0;
            tmp[9] = 0;
            number = tmp;
        }

        int pz = 0;

        log.debug("number: " + Arrays.toString(number));

        number = this.factor(number, weighting, 1, 7);

        log.debug("number: " + Arrays.toString(number));

        pz = this.add(number);

        log.debug("after add: " + pz);
        pz = this.modulus11(pz);
        return this.checkPz(pz, number, 8);
    }

    @Override
    protected int add(int[] number) {
        int pz = 0;
        for (int i = 0; i < 7; i++) {
            int o = number[i];
            pz += o;
        }
        return pz;
    }

}
