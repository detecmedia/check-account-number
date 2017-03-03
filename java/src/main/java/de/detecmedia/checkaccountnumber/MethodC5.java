package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen C5.
 * <p>
 * gültig seit 03.09.2007</p>
 * <p>
 * Die Kontonummern sind einschließlich der Prüfziffer 6- oder 8- bis
 * 10-stellig, ggf. ist die Kontonummer für die Prüfziffer- berechnung durch
 * linksbündige Auffüllung mit Nullen 10- stellig darzustellen.</p>
 * <p>
 * Die Berechnung der Prüfziffer und die möglichen Ergebnisse richten sich
 * nach dem jeweils bei der entsprechenden Variante angegebenen
 * Kontonummernkreis. Entspricht eine Kontonummer keinem der vorgegebenen
 * Kontonummern- kreise oder führt die Berechnung der Prüfziffer nach der
 * vorgegebenen Variante zu einem Prüfzifferfehler, so ist die Kontonummer
 * ungültig.</p>
 * <pre>
 * S = Ziffer der Kontonummer, die in die Prüfzifferberechnung einbezogen wird
 * X = Weitere Ziffern der Kontonummer, die jedoch nicht in die Prüfzifferberechnung mit einbezogen werden
 * P = Prüfziffer
 * </pre>
 * <p>
 * Variante 1:</p>
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2</p>
 * <p>
 * Die Berechnung und mögliche Ergebnisse entsprechen der Methode 75.</p>
 * <p>
 * 6-stellige Kontonummern; 5. Stelle = 1-8</p>
 * <pre>
 * Kontonummernkreis 0000100000 bis 0000899999
 * Stellen-Nr.:          1 2 3 4 5 6 7 S 8 9 10
 * 6-stellige Konto-Nr.: 0 0 0 0 S S S S S S P
 *                             (1-8)
 * Testkontonummern (richtig): 0000301168, 0000302554
 * Testkontonummern (falsch): 0000302589, 0000507336
 * </pre>
 * <p>
 * 9-stellige Kontonummern; 2. Stelle = 1-8
 * </p>
 * <pre>
 * Kontonummernkreis 0100000000 bis 0899999999
 * Stellen-Nr.:          1 2 3 4 5 6 7 S 8 9 10
 * 9-stellige Konto-Nr.: 0 S S S S S S S S S P
 *                       (1-8)
 * Testkontonummern (richtig): 0300020050, 0300566000
 * Testkontonummern (falsch): 0302555000, 0302589000
 * </pre>
 * <p>
 * Variante 2:</p>
 * <p>
 * Modulus 10, iterierte Transformation</p>
 * <p>
 * Die Berechnung und mögliche Ergebnisse entsprechen der Methode 29.</p>
 * <p>
 * 10-stellige Kontonummern, 1. Stelle = 1, 4, 5, 6 oder 9</p>
 * <pre>
 * Kontonummernkreis 1000000000 bis 1999999999
 * Kontonummernkreis 4000000000 bis 6999999999
 * Kontonummernkreis 9000000000 bis 9999999999
 * Stellen-Nr.:           1 2 3 4 5 6 7 S 8 9 10
 * 10-stellige Konto-Nr.: S S S S S S S S S S P
 * Testkontonummern (richtig): 1000061378, 1000061412, 4450164064, 4863476104,
 * 5000000028, 5000000391, 6450008149, 6800001016, 9000100012, 9000210017
 *
 * Testkontonummern (falsch): 1000061457, 1000061498 4864446015, 4865038012,
 * 5000001028, 5000001075, 6450008150, 6542812818, 9000110012, 9000300310
 * </pre>
 * <p>
 * Variante 3:</p>
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2</p>
 * <p>
 * Die Berechnung und mögliche Ergebnisse entsprechen der Methode 00.</p>
 * <p>
 * 10-stellige Kontonummern, 1. Stelle = 3</p>
 * <pre>
 * Kontonummernkreis 3000000000 bis 3999999999
 * Stellen-Nr.:           1 2 3 4 5 6 7 S 8 9 10
 * 10-stellige Konto-Nr.: S S S S S S S S S S P
 *                       (3)
 * Testkontonummern (richtig): 3060188103, 3070402023
 *
 * Testkontonummern (falsch): 3081000783, 3081308871
 * </pre>
 * <p>
 * Variante 4:</p>
 * <p>
 * Für die folgenden Kontonummernkreise gilt die Methode 09 (keine
 * Prüfzifferberechnung).</p>
 * <p>
 * 8-stellige Kontonummern; 3. Stelle = 3, 4 oder 5</p>
 * <pre>
 * Kontonummernkreis 0030000000 bis 0059999999
 * </pre>
 * <p>
 * 0-stellige Kontonummern; 1.+ 2. Stelle = 70 oder 85</p>
 * <pre>
 * Kontonummernkreis 7000000000 bis 7099999999
 * Kontonummernkreis 8500000000 bis 8599999999
 * </pre>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodC5
        extends AbstractMethod {

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        number = expand(number);
        if(variant1(number.clone())){
            return true;
        }
        if(variant2(number.clone())){
            return true;
        }
        if(variant3(number.clone())){
            return true;
        }
        if(variant4(number.clone())){
            return true;
        }
        return false;
    }

    /**
     * <p>
     * Variante 1. </p>
     * <p>
     * Modulus 10, Gewichtung 2, 1, 2, 1, 2</p>
     * <p>
     * Die Berechnung und mögliche Ergebnisse entsprechen der Methode 75.</p>
     * <p>
     * 6-stellige Kontonummern; 5. Stelle = 1-8</p>
     * <pre>
     * Kontonummernkreis 0000100000 bis 0000899999
     * Stellen-Nr.:          1 2 3 4 5 6 7 S 8 9 10
     * 6-stellige Konto-Nr.: 0 0 0 0 S S S S S S P
     *                             (1-8)
     * Testkontonummern (richtig): 0000301168, 0000302554
     * Testkontonummern (falsch): 0000302589, 0000507336
     * </pre>
     * <p>
     * 9-stellige Kontonummern; 2. Stelle = 1-8
     * </p>
     * <pre>
     * Kontonummernkreis 0100000000 bis 0899999999
     * Stellen-Nr.:          1 2 3 4 5 6 7 S 8 9 10
     * 9-stellige Konto-Nr.: 0 S S S S S S S S S P
     *                       (1-8)
     * Testkontonummern (richtig): 0300020050, 0300566000
     * Testkontonummern (falsch): 0302555000, 0302589000
     * </pre>
     *
     * @return
     */
    boolean variant1(int[] number) {
        Method75 m = new Method75();
        m.setAccountNumberArray(number);
//        if (number[0] == 0 && number[1] == 0 && number[2] == 0) {
//            number = factor(number, weighting, 5, 9);
//            int pz = add(number, 4, 9);
//            pz = modulus10(pz);
//            if (checkPz(pz, number)) {
//                return true;
//            }
//        }
        weighting = new int[]{2, 1, 2, 1, 2,1,2, 1, 2, 1, 2};
        if (String.valueOf(m.getLong()).length() == 6
                && number[4] == 1
                || number[4] == 2
                || number[4] == 3
                || number[4] == 4
                || number[4] == 5
                || number[4] == 6
                || number[4] == 7
                || number[4] == 8) {
            int[] calc = factor(number.clone(), weighting, 5, 9);
            int pz = add(calc, 4, 9);
            pz = modulus10(pz);
            if (checkPz(pz, number)) {
                return true;
            }
        }
        if (String.valueOf(m.getLong()).length() == 9
                && number[4] == 1
                || number[4] == 2
                || number[4] == 3
                || number[4] == 4
                || number[4] == 5
                || number[4] == 6
                || number[4] == 7
                || number[4] == 8) {
            int[] calc = factor(number.clone(), weighting, 2, 9);
            int pz = add(calc, 1, 9);
            pz = modulus10(pz);
            if (checkPz(pz, number)) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     * Variante 2. </p>
     * <p>
     * Modulus 10, iterierte Transformation</p>
     * <p>
     * Die Berechnung und mögliche Ergebnisse entsprechen der Methode 29.</p>
     * <p>
     * 10-stellige Kontonummern, 1. Stelle = 1, 4, 5, 6 oder 9</p>
     * <pre>
     * Kontonummernkreis 1000000000 bis 1999999999
     * Kontonummernkreis 4000000000 bis 6999999999
     * Kontonummernkreis 9000000000 bis 9999999999
     * Stellen-Nr.:           1 2 3 4 5 6 7 S 8 9 10
     * 10-stellige Konto-Nr.: S S S S S S S S S S P
     * Testkontonummern (richtig): 1000061378, 1000061412, 4450164064, 4863476104,
     * 5000000028, 5000000391, 6450008149, 6800001016, 9000100012, 9000210017
     *
     * Testkontonummern (falsch): 1000061457, 1000061498 4864446015, 4865038012,
     * 5000001028, 5000001075, 6450008150, 6542812818, 9000110012, 9000300310
     * </pre>
     *
     * @param number
     * @return
     */
    boolean variant2(int[] number) {
        Method29 m = new Method29();
        number = expand(number);
        if (number[0] == 1
                || number[0] == 4
                || number[0] == 5
                || number[0] == 6
                || number[0] == 9) {
            m.setAccountNumberArray(number);
            return m.test();
        }
        return false;
    }

    /**
     * <p>
     * Variante 3. </p>
     * <p>
     * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2</p>
     * <p>
     * Die Berechnung und mögliche Ergebnisse entsprechen der Methode 00.</p>
     * <p>
     * 10-stellige Kontonummern, 1. Stelle = 3</p>
     * <pre>
     * Kontonummernkreis 3000000000 bis 3999999999
     * Stellen-Nr.:           1 2 3 4 5 6 7 S 8 9 10
     * 10-stellige Konto-Nr.: S S S S S S S S S S P
     *                       (3)
     * Testkontonummern (richtig): 3060188103, 3070402023
     *
     * Testkontonummern (falsch): 3081000783, 3081308871
     * </pre>
     *
     * @return
     */
    boolean variant3(int[] number) {
        number = expand(number);
        if (number[0] == 3) {
            Method00 m = new Method00();
            m.setAccountNumberArray(number);
            return m.test();
        }
        return false;
    }

    /**
     * <p>
     * Variante 4. </p>
     * <p>
     * Für die folgenden Kontonummernkreise gilt die Methode 09 (keine
     * Prüfzifferberechnung).</p>
     * <p>
     * 8-stellige Kontonummern; 3. Stelle = 3, 4 oder 5</p>
     * <pre>
     * Kontonummernkreis 0030000000 bis 0059999999
     * </pre>
     * <p>
     * 0-stellige Kontonummern; 1.+ 2. Stelle = 70 oder 85</p>
     * <pre>
     * Kontonummernkreis 7000000000 bis 7099999999
     * Kontonummernkreis 8500000000 bis 8599999999
     * </pre>
     *
     * @param number
     * @return
     */
    boolean variant4(int[] number) {
        number = expand(number);
        if (number[2] == 3 || number[2] == 4 || number[2] == 5) {
            Method09 m = new Method09();
            m.setAccountNumberArray(number);
            return m.test();
        }
        if (number[0] == 7 && number[1] == 0
                || number[0] == 8 && number[1] == 5) {
            Method09 m = new Method09();
            m.setAccountNumberArray(number);
            return m.test();
        }
        return false;
    }

}
