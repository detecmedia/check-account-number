package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen B7.
 * <p>
 * gültig seit 05.09.2005</p>
 * <p>
 * Die Kontonummer ist einschließlich der Prüfziffer 10-stellig, ggf. ist die
 * Kontonummer für die Prüfzifferberechnung durch linksbündige Auffüllung
 * mit Nullen 10-stellig darzustellen. Die 10. Stelle der Kontonummer ist die
 * Prüfziffer.</p>
 * <p>
 * Variante 1:</p>
 * <p>
 * Modulus 10, Gewichtung 3, 7, 1, 3, 7, 1, 3, 7, 1</p>
 * <p>
 * Kontonummern der Kontenkreise 0001000000 bis 0005999999 sowie 0700000000 bis
 * 0899999999 sind nach der Methode (Kennzeichen) 01 zu prüfen.</p>
 * <p>
 * Führt die Berechnung nach der Variante 1 zu einem Prüfzifferfehler, so ist
 * die Kontonummer falsch.</p>
 * <p>
 * Testkontonummern (richtig): 0700001529, 0730000019, 0001001008, 0001057887,
 * 0001007222, 0810011825, 0800107653, 0005922372<br>
 * Testkontonummern (falsch): 0001057886, 0003815570, 0005620516, 0740912243,
 * 0893524479</p>
 * <p>
 * Variante 2:</p>
 * <p>
 * Für alle anderen Kontonummern gilt die Methode 09 (keine
 * Prüfzifferberechnung).</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodB7
        extends AbstractMethod {


    private int[] weighting;
    private boolean checkVariant2 = true;

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        if (variant1(number.clone())) {
            return true;
        }
        if (checkVariant2) {
            return variant2(number.clone());
        }
        return false;
    }

    /**
     * <p>
     * Variante 1. </p>
     * <p>
     * Modulus 10, Gewichtung 3, 7, 1, 3, 7, 1, 3, 7, 1</p>
     * <p>
     * Kontonummern der Kontenkreise 0001000000 bis 0005999999 sowie 0700000000
     * bis 0899999999 sind nach der Methode (Kennzeichen) 01 zu prüfen.</p>
     * <p>
     * Führt die Berechnung nach der Variante 1 zu einem Prüfzifferfehler, so
     * ist die Kontonummer falsch.</p>
     * <p>
     * Testkontonummern (richtig): 0700001529, 0730000019, 0001001008,
     * 0001057887, 0001007222, 0810011825, 0800107653, 0005922372<br>
     * Testkontonummern (falsch): 0001057886, 0003815570, 0005620516,
     * 0740912243, 0893524479</p>
     *
     * @return
     */
    boolean variant1(int[] number) {
        Method01 m = new Method01();
        m.setAccountNumberArray(number);
        long numberLong = m.getLong();
        if ((numberLong >= 1000000L && numberLong <= 5999999) || (numberLong >= 700000000L && numberLong <= 899999999L)) {
            weighting = new int[]{3, 7, 1, 3, 7, 1, 3, 7, 1};
            if (m.check(weighting)) {
                return true;
            } else {
                this.checkVariant2 = false;
            }
        }
        return false;
    }

    /**
     * <p>
     * Variante 2:</p>
     * <p>
     * Für alle anderen Kontonummern gilt die Methode 09 (keine
     * Prüfzifferberechnung).</p>
     *
     * @param number
     * @return
     */
    boolean variant2(int[] number) {
        Method09 m = new Method09();
        return m.test();
    }

}
