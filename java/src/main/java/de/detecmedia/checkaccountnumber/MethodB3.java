package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen B3.
 * <p>
 * gültig seit 06.12.2004</p>
 * <p>
 * Die Kontonummer ist einschließlich der Prüfziffer 10-stellig, ggf. ist die
 * Kontonummer für die Prüfzifferberechnung durch linksbündige Auffüllung
 * mit Nullen 10-stellig darzustellen.</p>
 * <p>
 * Variante 1:</p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7</p>
 * <p>
 * Die Kontonummer ist 10-stellig. Kontonummern, die an der 1. Stelle von links
 * der 10-stelligen Kontonummer den Wert 0 bis 8 beinhalten sind nach der
 * Methode 32 zu rechen.</p>
 * <p>
 * Testkontonummern (richtig): 1000000060, 0000000140, 0000000019, 1002798417,
 * 8409915001 <br>Testkontonummern (falsch): 0002799899, 1000000111</p>
 * <p>
 * Variante 2:</p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 2, 3, 4</p>
 * <p>
 * Kontonummern, die an der 1. Stelle von links der 10-stelligen Kontonummer den
 * Wert 9 beinhalten sind nach der Methode 06 zu rechen.</p>
 * <p>
 * Testkontonummern (richtig): 9635000101, 9730200100 <br>
 * Testkontonummern (falsch): 9635100101, 9730300100</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodB3
        extends AbstractMethod {

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        number = expand(number);
        if (variant1(number.clone())) {
            return true;
        }
        return this.variant2(number.clone());
    }

    /**
     * <p>
     * Variante 1:</p>
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7</p>
     * <p>
     * Die Kontonummer ist 10-stellig. Kontonummern, die an der 1. Stelle von
     * links der 10-stelligen Kontonummer den Wert 0 bis 8 beinhalten sind nach
     * der Methode 32 zu rechen.</p>
     * <p>
     * Testkontonummern (richtig): 1000000060, 0000000140, 0000000019,
     * 1002798417, 8409915001 <br>Testkontonummern (falsch): 0002799899,
     * 1000000111</p>
     *
     * @param number
     * @return
     */
    boolean variant1(int[] number) {
        if (number[0] == 0
                || number[0] == 1
                || number[0] == 2
                || number[0] == 3
                || number[0] == 4
                || number[0] == 5
                || number[0] == 6
                || number[0] == 7
                || number[0] == 8) {
            Method32 m = new Method32();
            m.setAccountNumberArray(number);
            return m.check(new int[]{2, 3, 4, 5, 6, 7,0,0,0});
        }
        return false;
    }

    /**
     * <p>
     * Variante 2:</p>
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 2, 3, 4</p>
     * <p>
     * Kontonummern, die an der 1. Stelle von links der 10-stelligen Kontonummer
     * den Wert 9 beinhalten sind nach der Methode 06 zu rechen.</p>
     * <p>
     * Testkontonummern (richtig): 9635000101, 9730200100 <br>
     * Testkontonummern (falsch): 9635100101, 9730300100</p>
     */
    boolean variant2(int[] number) {
        if (number[0] == 9) {
            Method06 m = new Method06();
            m.setAccountNumberArray(number);
            return m.check(new int[]{2, 3, 4, 5, 6, 7, 2, 3, 4});

        }
        return false;
    }

}
