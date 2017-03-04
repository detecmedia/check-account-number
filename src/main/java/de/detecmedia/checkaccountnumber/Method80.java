package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen 80.
 * <p>
 * <b>geändert zum 08.06.2004</b></p>
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2</p>
 * <p>
 * Methode A</p>
 * <p>
 * Die Kontonummer ist durch linksbündige Nullenauffüllung 10- stellig
 * darzustellen. Die Berechnung und die möglichen Ergebnisse entsprechen dem
 * Verfahren 00; es ist jedoch zu beachten, dass nur die Stellen5 bis 9 in das
 * Prüfzifferberechnungsverfahren einbezogen werden. Die Stelle 10 der
 * Kontonummer ist die Prüfziffer.</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   x x x x x x x x x P
 * Gewichtung:         2 1 2 1 2
 * </pre>
 * <p>
 * Testkontonummer: 340968</p>
 * <p>
 * Führt die Berechnung nach Methode A zu einem Prüfziffe- fehler, ist die
 * Berechnung nach Methode B vorzunehmen.</p>
 * <p>
 * Methode B</p>
 * <p>
 * Modulus 7, Gewichtung 2, 1, 2, 1, 2</p>
 * <p>
 * Das Berechnungsverfahren entspricht Methode A. Die Summe der
 * Produkt-Quersummen ist jedoch durch 7 zu dividieren. Der verbleibende Rest
 * wird vom Divisor (7) subtrahiert. Das Ergebnis ist die Prüfziffer. Verbleibt
 * nach der Division kein Rest, ist die Prüfziffer = 0</p>
 * <p>
 * Testkontonummer: 340966</p>
 * <p>
 * Ausnahme:</p>
 * <p>
 * Ist nach linksbündiger Auffüllung mit Nullen auf 10 Stellen die 3. Stelle
 * der Kontonummer = 9 (Sachkonten), so erfolgt die Berechnung gemäß der
 * Ausnahme in Methode 51 mit den gleichen Ergebnissen und Testkontonummern.</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 * @see Method51
 */
public class Method80
        extends Method51 {

    private int[] weighting;

    @Override
    public boolean test() {
        weighting = new int[]{2, 1, 2, 1, 2};
        int[] number = expand(this.getAccountNumberArray());
        if (mehtodA(number)) {
            return true;
        }
        number = expand(this.getAccountNumberArray());
        return methodB(number);
    }

    /**
     * <p>
     * Methode A. </p>
     * <p>
     * Die Kontonummer ist durch linksbündige Nullenauffüllung 10- stellig
     * darzustellen. Die Berechnung und die möglichen Ergebnisse entsprechen
     * dem Verfahren 00; es ist jedoch zu beachten, dass nur die Stellen5 bis 9
     * in das Prüfzifferberechnungsverfahren einbezogen werden. Die Stelle 10
     * der Kontonummer ist die Prüfziffer.</p>
     * <pre>
     * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
     * Kontonr.:   x x x x x x x x x P
     * Gewichtung:         2 1 2 1 2
     * </pre>
     * <p>
     * Testkontonummer: 340968</p>
     * <p>
     * Führt die Berechnung nach Methode A zu einem Prüfziffe- fehler, ist die
     * Berechnung nach Methode B vorzunehmen.</p>
     *
     * @param number
     * @return
     */
    boolean mehtodA(int[] number) {
        weighting = new int[]{2, 1, 2, 1, 2};
        number = expand(number);
        Method00 method00 = new Method00();
        number = method00.factor(number, weighting, 5, 9);
        int pz = method00.add(number, 4, 9);
        pz = modulus10(pz);
        return checkPz(pz, number);
    }

    /**
     * <p>
     * Methode B</p>
     * <p>
     * Modulus 7, Gewichtung 2, 1, 2, 1, 2</p>
     * <p>
     * Das Berechnungsverfahren entspricht Methode A. Die Summe der
     * Produkt-Quersummen ist jedoch durch 7 zu dividieren. Der verbleibende
     * Rest wird vom Divisor (7) subtrahiert. Das Ergebnis ist die Prüfziffer.
     * Verbleibt nach der Division kein Rest, ist die Prüfziffer = 0</p>
     * <p>
     * Testkontonummer: 340966</p>
     *
     * @param number
     * @return
     */
    @Override
    boolean methodB(int[] number) {
        weighting = new int[]{2, 1, 2, 1, 2};
        number = expand(number);

        this.setAccountNumberArray(number);
        Method00 method00 = new Method00();
        number = method00.factor(number, weighting, 5, 9);
        int pz = method00.add(number, 4, 9);
        pz = this.modulus7(pz);
        number = expand(this.getAccountNumberArray()); // reset AccountNumber
        if (checkPz(pz, number)) {
            return true;
        }
        if (number[2] == 9) {
            if (this.methodDvariant1(number)) {
                return true;
            }
            number = expand(this.getAccountNumberArray()); // reset AccountNumber
            if (this.methodDvariant2(number)) {
                return true;
            }
        }
        return false;
    }

}
