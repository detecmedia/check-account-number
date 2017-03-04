package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen 96.
 * <p>
 * Variante 1</p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8, 9, 1</p>
 * <p>
 * Die Prüfziffernrechnung ist nach Kennzeichen 19 durchzuführen.</p>
 * <p>
 * Führt die Berechnung nach Variante1 zu einem Prüfzifferfehler, so ist die
 * Berechnung nach Variante2 vorzunehmen.</p>
 * <p>
 * Gültige Kontonummern (Darstellung 10-stellig, einschl. Prüfziffer):
 * 0000254100, 9421000009</p>
 * <p>
 * Variante 2</p>
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2</p>
 * <p>
 * Die Prüfziffernrechnung ist nach Kennzeichen 00 durchzuführen.</p>
 * <p>
 * Gültige Kontonummern (Darstellung 10-stellig, einschl. Prüfziffer):
 * 0000000208, 0101115152, 0301204301</p>
 * <p>
 * Variante 3</p>
 * <p>
 * Führen die Berechnungen nach Variante1 und 2 zu Prüfzifferfehlern, so ist
 * zu prüfen, ob die Kontonummer zwischen 0001300000 und 0099399999 liegt.</p>
 * <p>
 * Trifft dies zu, so gilt die Prüfziffer als richtig; trifft dies nicht zu, so
 * ist die Prüfziffer falsch.</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method96
        extends AbstractMethod {
    private int[] weighting;

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        number = expand(number);
        if (variant1(number)) {
            return true;
        }
        number = this.getAccountNumberArray();
        number = expand(number);
        if (variant2(number)) {
            return true;
        }
        number = this.getAccountNumberArray();
        number = expand(number);
        if (variant3(number)) {
            return true;
        }
        return false;
    }

    /**
     * <p>
     * Variante 1. </p>
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8, 9, 1</p>
     * <p>
     * Die Prüfziffernrechnung ist nach Kennzeichen 19 durchzuführen.</p>
     * <p>
     * Führt die Berechnung nach Variante1 zu einem Prüfzifferfehler, so ist
     * die Berechnung nach Variante2 vorzunehmen.</p>
     * <p>
     * Gültige Kontonummern (Darstellung 10-stellig, einschl. Prüfziffer):
     * 0000254100, 9421000009</p>
     *
     * @param number
     * @return
     */
    boolean variant1(int[] number) {
        weighting = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 1};
        Method19 method19 = new Method19();
        method19.setAccountNumberArray(number);
        return method19.check(weighting);
    }

    /**
     * <p>
     * Variante 2</p>
     * <p>
     * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2</p>
     * <p>
     * Die Prüfziffernrechnung ist nach Kennzeichen 00 durchzuführen.</p>
     * <p>
     * Gültige Kontonummern (Darstellung 10-stellig, einschl. Prüfziffer):
     * 0000000208, 0101115152, 0301204301</p>
     *
     * @param number
     * @return
     */
    boolean variant2(int[] number) {
        weighting = new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2};
        Method00 method00 = new Method00();
        method00.setAccountNumberArray(number);
        return method00.check(weighting);
    }

    /**
     * <p>
     * Variante 3</p>
     * <p>
     * Führen die Berechnungen nach Variante1 und 2 zu Prüfzifferfehlern, so
     * ist zu prüfen, ob die Kontonummer zwischen 0001300000 und 0099399999
     * liegt.</p>
     * <p>
     * Trifft dies zu, so gilt die Prüfziffer als richtig; trifft dies nicht
     * zu, so ist die Prüfziffer falsch.</p>
     *
     * @param number
     * @return
     */
    boolean variant3(int[] number) {
        this.setAccountNumberArray(number);
        return this.getLong() >= 1300000L && this.getLong() <= 99399999L;
    }

}
