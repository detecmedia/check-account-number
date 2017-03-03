package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.*;

/**
 * Kennzeichen 50.
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7</p><p>
 * Die für die Berechnung relevante Grundnummer befindet sich in den Stellen 1
 * bis 6, die Prüfziffer in Stelle 7 (von links nach rechts gezählt). Die
 * Stellen 1 bis 6 werden mit den Ziffern 7, 6, 5, 4, 3, 2 multipliziert. Die
 * restliche Berechnung und Ergebnisse entsprechen dem Verfahren 06. Die
 * dreistellige Unternummer (Stellen8 bis 10) darf nicht in das
 * Prüfzifferberechnungs- verfahren einbezogen werden. Ist die Unternummer
 * »000«, so kommt es vor, dass diese nicht angegeben ist. Ergibt die erste
 * Berechnung einen Prüfzifferfehler, wird empfohlen, die Prüfzifferberechnung
 * ein zweites Mal durchzuführen und dabei die »gedachte« Unternummer 000 an
 * die Stellen 8 bis 10 zu setzen und die vorhandene Kontonummer vorher um drei
 * Stellen nach links zu verschieben.</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   x x x x x x P x x x
 * Gewichtung: 7 6 5 4 3 2
 * </pre>
 * <p>
 * Testkontonummern: 4000005001, 4444442001
 * </p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method50 extends Method06 {

    @Override
    public boolean test() {
        weighting = new int[]{2, 3, 4, 5, 6, 7};
        int[] number = getAccountNumberArray();
        number = factor(number, weighting, 1, 6);
        int pz = add(number, 0, 6);
        pz = modulus11(pz);
        return checkPz(pz, number, 7);
    }

}
