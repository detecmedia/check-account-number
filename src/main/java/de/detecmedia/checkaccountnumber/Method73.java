package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen 73.
 * <p>
 * <b>geändert zum 06.12.2004</b></p>
 * <p>
 * Die Kontonummer ist durch linksbündiges Auffüllen mit Nullen 10-stellig
 * darzustellen. Die 10. Stelle der Kontonummer ist die Prüfziffer.</p>
 * <p>
 * Variante 1:</p>
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1</p>
 * <p>
 * Die Stellen 4 bis 9 der Kontonummer werden von rechts nach links mit den
 * Ziffern 2, 1, 2, 1, 2, 1 multipliziert. Die Berechnung und Ergebnisse
 * entsprechen dem Verfahren 00.</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   X X X X X X X X X P
 * Gewichtung:       1 2 1 2 1 2
 * </pre>
 * <p>
 * Testkontonummern: richtig: 0003503398, 0001340967 falsch: 0003503391,
 * 0001340966</p>
 * <p>
 * Führt die Berechnung nach Variante 1 zu einem Prüfzifferfehler, ist eine
 * weitere Berechnung nach Variante 2 vorzunehmen:</p>
 * <p>
 * Variante 2:</p>
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2</p>
 * <p>
 * Das Berechnungsverfahren entspricht Variante 1, es ist jedoch zu beachten,
 * dass nur die Stellen 5 bis 9 in das Prüfziffernberechnungsverfahren
 * einbezogen werden.</p>
 * <p>
 * Testkontonummern: richtig: 0003503391, 0001340968 falsch: 0003503392,
 * 0001340966</p>
 * <p>
 * Führt die Berechnung auch nach Variante 2 zu einem Prüfzifferfehler, ist
 * die Berechnung nach Variante 3 vorzunehmen:</p>
 * <p>
 * Variante 3</p>
 * <p>
 * Modulus 7, Gewichtung 2, 1, 2, 1, 2</p>
 * <p>
 * Das Berechnungsverfahren entspricht Variante 2. Die Summe der
 * Produkt-Quersummen ist jedoch durch 7 zu dividieren. Der verbleibende Rest
 * wird vom Divisor (7) subtrahiert. Das Ergebnis ist die Prüfziffer. Verbleibt
 * nach der Division kein Rest, ist die Prüfziffer = 0</p>
 * <p>
 * Testkontonummern: richtig: 0003503392, 0001340966, 123456 falsch: 121212,
 * 987654321</p>
 * <p>
 * Ausnahme:</p>
 * <p>
 * Ist nach linksbündiger Auffüllung mit Nullen auf 10 Stellen die 3. Stelle
 * der Kontonummer = 9 (Sachkonten), so erfolgt die Berechnung gemäß der
 * Ausnahme in Methode 51 mit den gleichen Ergebnissen und Testkontonummern.</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method73
        extends AbstractMethod {
    private int[] weighting;

    @Override
    public boolean test() {
        int[] number = expand(this.getAccountNumberArray());
        if (variant1(number)) {
            return true;
        }
        number = expand(this.getAccountNumberArray()); // reset AccountNumber
        if (variant2(number)) {
            return true;
        }
        number = expand(this.getAccountNumberArray()); // reset AccountNumber
        if (variant3(number)) {
            return true;
        }
        number = expand(this.getAccountNumberArray()); // reset AccountNumber
        if (number[2] == 9) {
            Method51 method51 = new Method51();
            if (method51.methodDvariant1(number)) {
                return true;
            }
            number = expand(this.getAccountNumberArray()); // reset AccountNumber
            if (method51.methodDvariant2(number)) {
                return true;
            }
        }
        return false;

    }

    /**
     * <p>
     * Variante 1. </p>
     * <p>
     * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1</p>
     * <p>
     * Die Stellen 4 bis 9 der Kontonummer werden von rechts nach links mit den
     * Ziffern 2, 1, 2, 1, 2, 1 multipliziert. Die Berechnung und Ergebnisse
     * entsprechen dem Verfahren 00.</p>
     * <pre>
     * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
     * Kontonr.:   X X X X X X X X X P
     * Gewichtung:       1 2 1 2 1 2
     * </pre>
     * <p>
     * Testkontonummern: richtig: 0003503398, 0001340967 falsch: 0003503391,
     * 0001340966</p>
     * <p>
     * Führt die Berechnung nach Variante 1 zu einem Prüfzifferfehler, ist
     * eine weitere Berechnung nach Variante 2 vorzunehmen:</p>
     * <p>
     *
     * @param number
     * @return
     */
    boolean variant1(int[] number) {
        weighting = new int[]{2, 1, 2, 1, 2, 1};
        Method00 method00 = new Method00();
        method00.setAccountNumberArray(number);
        number = method00.factor(number, weighting, 4, 9);
        int pz = method00.add(number, 3, 9);
        pz = modulus10(pz);
        return method00.checkPz(pz, number);
    }

    /**
     * <p>
     * Variante 2. </p>
     * <p>
     * Modulus 10, Gewichtung 2, 1, 2, 1, 2</p>
     * <p>
     * Das Berechnungsverfahren entspricht Variante 1, es ist jedoch zu
     * beachten, dass nur die Stellen 5 bis 9 in das
     * Prüfziffernberechnungsverfahren einbezogen werden.</p>
     * <p>
     * Testkontonummern: richtig: 0003503391, 0001340968 falsch: 0003503392,
     * 0001340966</p>
     * <p>
     * Führt die Berechnung auch nach Variante 2 zu einem Prüfzifferfehler,
     * ist die Berechnung nach Variante 3 vorzunehmen:</p>
     * <p>
     *
     * @param number
     * @return
     */
    boolean variant2(int[] number) {
        weighting = new int[]{2, 1, 2, 1, 2};
        Method00 method00 = new Method00();
        method00.setAccountNumberArray(number);
        number = method00.factor(number, weighting, 5, 9);
        int pz = method00.add(number, 4, 9);
        pz = modulus10(pz);
        return method00.checkPz(pz, number);

    }

    /**
     * <p>
     * Variante 3. </p>
     * <p>
     * Modulus 7, Gewichtung 2, 1, 2, 1, 2</p>
     * <p>
     * Das Berechnungsverfahren entspricht Variante 2. Die Summe der
     * Produkt-Quersummen ist jedoch durch 7 zu dividieren. Der verbleibende
     * Rest wird vom Divisor (7) subtrahiert. Das Ergebnis ist die Prüfziffer.
     * Verbleibt nach der Division kein Rest, ist die Prüfziffer = 0</p>
     * <p>
     * Testkontonummern: richtig: 0003503392, 0001340966, 123456 falsch: 121212,
     * 987654321</p>
     *
     * @param number
     * @return
     */
    boolean variant3(int[] number) {
        weighting = new int[]{2, 1, 2, 1, 2};
        Method00 method00 = new Method00();
        method00.setAccountNumberArray(number);
        number = method00.factor(number, weighting, 5, 9);
        int pz = method00.add(number, 4, 9);
        pz = modulus7(pz);
        return method00.checkPz(pz, number);
    }

}
