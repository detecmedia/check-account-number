package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.exception.InvalidException;

/**
 * Kennzeichen 93.
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6</p>
 * <p>
 * Variante 1</p>
 * <p>
 * Die Kontonummer ist 10-stellig. Die für die Berechnung relevante
 * Kundennummer (K) befindet sich entweder</p>
 * <p>
 * a) in den Stellen 1 bis 5, die Prüfziffer in Stelle 6 der Kontonummer
 * oder<br>
 * b) in den Stellen5 bis 9, die Prüfziffer in Stelle10 der Kontonummer.</p>
 * <p>
 * Die 2-stellige Unternummer (U) und die 2-stellige Kontoartnummer (A) werden
 * nicht in die Berechnung einbezogen. Sie befinden sich im Fall a) an Stelle 7
 * bis 10 (UUAA). Im Fall b) befinden sie sich an Stelle 1 bis 4 und müssen
 * "0000" lauten. Die 5-stellige Kundennummer wird von rechts nach links mit den
 * Gewichten multipliziert. Die weitere Berechnung und die möglichen Ergebnisse
 * entsprechen dem Verfahren 06.</p>
 * <pre>
 * Stellennr.:       1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:Fall a)  K K K K K P U U A A
 * Gewichtung:       6 5 4 3 2
 * Kontonr.:Fall b)  0 0 0 0 K K K K K P
 * Gewichtung:               6 5 4 3 2
 * </pre>
 * <p>
 * Führt die Berechnung nach Variante 1 zu einem Prüfziffer- fehler, so ist
 * die Berechnung nach Variante 2 vorzunehmen.</p>
 * <p>
 * Variante 2</p>
 * <p>
 * Modulus 7, Gewichtung 2, 3, 4, 5, 6</p>
 * <p>
 * Das Berechnungsverfahren entspricht Variante 1. Die Summe der Produkte ist
 * jedoch durch 7 zu dividieren. Der verbleibende Rest wird vom Divisor (7)
 * subtrahiert. Das Ergebnis ist dann die Prüfziffer. Verbleibt nach der
 * Division durch 7 kein Rest, lautet die Prüfziffer 0.</p>
 * <p>
 * Testkontonummern:</p>
 * <pre>
 * Modulus 11:          6714790000 bzw. 0000671479
 *
 * Modulus 7:           1277830000 bzw. 0000127783
 *                      1277910000 bzw. 0000127791
 *
 * Modulus 11 und 7:    3067540000 bzw. 0000306754
 * </pre>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method93
        extends Method06 {

    private int[] weighting;

    public static final int MODULUS11 = 1;
    public static final int MODULUS7 = 2;

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        number = expand(number);
        if (variant1(number)) {
            return true;
        }
        number = this.getAccountNumberArray();
        number = expand(number);
        if (number[0] == 0
                && number[1] == 0
                && number[2] == 0
                && number[3] == 0
                && variant2(number)) {
            return true;
        }
        return false;

    }

    boolean variant1(int[] number) {
        int[] tmp = number.clone();
        if (variantA(number, MODULUS11)) {
            return true;
        }
        number = tmp.clone();
        if (variantA(number, MODULUS7)) {
            return true;
        }

        number = tmp.clone();
        if (variantB(number, MODULUS11)) {
            return true;
        }
        number = tmp.clone();
        if (variantB(number, MODULUS7)) {
            return true;
        }
        return false;
    }

    boolean variant2(int[] number) {
        int[] tmp = number.clone();
        if (variantA(number, MODULUS7)) {
            return true;
        }
        number = tmp.clone();
        if (variantA(number, MODULUS11)) {
            return true;
        }
        number = tmp.clone();
        if (variantB(number, MODULUS7)) {
            return true;
        }
        number = tmp.clone();
        if (variantB(number, MODULUS11)) {
            return true;
        }
        return false;
    }

    boolean variantA(int[] number, int modulus) {
        weighting = new int[]{2, 3, 4, 5, 6};
        number = factor(number, weighting, 1, 5);
        int pz = add(number, 0, 5);
        if (modulus == MODULUS11) {
            pz = modulus11(pz);
        } else if (modulus == MODULUS7) {
            pz = modulus7(pz);
        } else {
            throw new InvalidException("Fehler ");
        }
        return checkPz(pz, number, 6);

    }

    boolean variantB(int[] number, int modulus) {
        weighting = new int[]{2, 3, 4, 5, 6};
        number = factor(number, weighting, 5, 9);
        int pz = add(number, 4, 9);
        if (modulus == MODULUS11) {
            pz = modulus11(pz);
        } else if (modulus == MODULUS7) {
            pz = modulus7(pz);
        } else {
            throw new InvalidException("Fehler ");
        }
        return checkPz(pz, number);

    }

}
