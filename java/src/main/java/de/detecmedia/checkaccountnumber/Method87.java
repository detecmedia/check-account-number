package de.detecmedia.checkaccountnumber;

import org.apache.log4j.Logger;

/**
 * Kennzeichen 87.
 * <p>
 * Die Kontonummer ist durch linksbündige Nullenauffüllung 10- stellig
 * darzustellen. Der zur Prüfzifferberechnung heranzuziehende Teil befindet
 * sich bei der Methode A in den Stellen 4 bis 9 der Kontonummer und bei den
 * Methoden B und C in Stellen 5 - 9, die Prüfziffer in Stelle 10 der
 * Kontonummer. Ergibt die erste Berechnung der Prüfziffer nach der Methode A
 * einen Prüfzifferfehler, so sind weitere Berechnungen mit den anderen
 * Methoden vorzunehmen.</p>
 * <p>
 * Ausnahme:</p>
 * <p>
 * Ist nach linksbündiger Auffüllung mit Nullen auf 10 Stellen die 3. Stelle
 * der Kontonummer = 9 (Sachkonten), so erfolgt die Berechnung gemäß der
 * Ausnahme in Methode 51 mit den gleichen Ergebnissen und Testkontonummern.</p>
 *
 * <p>
 * Methode A:</p>
 * <pre>
 * Für die Berechnung werden folgende Felder verwendet:
 * i          = Hilfsvariable (Laufvariable)
 * C2         = Hilfsvariable (Kennung, ob gerade oder un- gerade Stelle bearbeitet wird)
 * D2         = Hilfsvariable
 * A5         = Hilfsvariable (Summenfeld), kann negativ werden
 * P          = Hilfsvariable (zur Zwischenspeicherung der Prüfziffer)
 * KONTO      = 10-stelliges Kontonummernfeld mit KONTO (i) = in Bearbeitung befindliche Stelle; der Wert an jeder Stelle kann zweistellig werden
 * TAB1; TAB2 = Tabellen mit Prüfziffern:
 * </pre>
 *
 * <pre>
 * Tabelle TAB1
 * Stelle   Inhalt
 * 0        0
 * 1        4
 * 2        3
 * 3        2
 * 4        6
 *
 * Tabelle TAB2
 * Stelle   Inhalt
 * 0        7
 * 1        1
 * 2        5
 * 3        9
 * 4        8
 * ￼
 * </pre>
 * <p>
 * Testkontonummern: 0000000406, 0000051768, 0010701590, 0010720185</p>
 * <p>
 * Führt die Berechnung nach Methode A zu einem Prüfzifferfehler, ist die
 * Berechnung nach Methode B vorzunehmen.</p>
 * <p>
 * Methode B:</p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6</p>
 * <p>
 * Die für die Berechnung relevanten Stellen werden von rechts nach links mit
 * den Ziffern 2, 3, 4, 5, 6 multipliziert. Die weitere Berechnung und die
 * möglichen Ergebnisse entsprechen dem Verfahren 33.</p>
 * <pre>
 * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
 * Kontonr.:   x x x x x x x x x P
 * Gewichtung:         6 5 4 3 2
 * </pre>
 *
 * <p>
 * Führt die Berechnung nach Methode B wiederum zu einem Prüfzifferfehlen, ist
 * eine weitere Berechnung nach Methode C vorzunehmen.</p>
 * <p>
 * Methode C:</p>
 * <p>
 * Modulus 7, Gewichtung 2, 3, 4, 5, 6</p>
 * <p>
 * Die Stellen 5 bis 9 der Kontonummer werden von rechts nach links mit den
 * Gewichten multipliziert. Die jeweiligen Produkte werden addiert. Die Summe
 * ist durch 7 zu dividieren. Der verbleibende Rest wird vom Divisor (7)
 * subtrahiert. Das Ergebnis ist die Prüfziffer. Verbleibt nach der Division
 * kein Rest, ist die Prüfziffer = 0.</p>
 * <p>
 * Testkontonummern Methode B und C: 0000100005, 0000393814, 0000950360,
 * 3199500501</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method87 extends AbstractMethod {

    private Logger log = Logger.getLogger(Method87.class);

    @Override
    public boolean test() {
        int[] number = this.getAccountNumberArray();
        number = expand(number);
        if (methodA(number)) {
            return true;
        }
        number = this.getAccountNumberArray();
        number = expand(number);
        if (methodB(number)) {
            return true;
        }
        number = this.getAccountNumberArray();
        number = expand(number);
        if (exception(number)) {
            return true;
        }

        return false;
    }

    /**
     * <p>
     * Ausnahme. </p>
     * <p>
     * Ist nach linksbündiger Auffüllung mit Nullen auf 10 Stellen die 3.
     * Stelle der Kontonummer = 9 (Sachkonten), so erfolgt die Berechnung gemäß
     * der Ausnahme in Methode 51 mit den gleichen Ergebnissen und
     * Testkontonummern.</p>
     *
     * @param number
     * @return
     */
    boolean exception(int[] number) {
        number = expand(number);
        if (number[2] == 9) {
            Method51 method51 = new Method51();
            method51.setAccountNumberArray(number);
            return method51.test();
        }
        return false;
    }

    /**
     * <p>
     * Die Kontonummer ist durch linksbündige Nullenauffüllung 10- stellig
     * darzustellen. Der zur Prüfzifferberechnung heranzuziehende Teil befindet
     * sich bei der Methode A in den Stellen 4 bis 9 der Kontonummer und bei den
     * Methoden B und C in Stellen 5 - 9, die Prüfziffer in Stelle 10 der
     * Kontonummer. Ergibt die erste Berechnung der Prüfziffer nach der Methode
     * A einen Prüfzifferfehler, so sind weitere Berechnungen mit den anderen
     * Methoden vorzunehmen.</p>
     * <p>
     * Methode A:</p>
     * <pre>
     * Für die Berechnung werden folgende Felder verwendet:
     * i          = Hilfsvariable (Laufvariable)
     * C2         = Hilfsvariable (Kennung, ob gerade oder un- gerade Stelle bearbeitet wird)
     * D2         = Hilfsvariable
     * A5         = Hilfsvariable (Summenfeld), kann negativ werden
     * P          = Hilfsvariable (zur Zwischenspeicherung der Prüfziffer)
     * KONTO      = 10-stelliges Kontonummernfeld mit KONTO (i) = in Bearbeitung befindliche Stelle; der Wert an jeder Stelle kann zweistellig werden
     * TAB1; TAB2 = Tabellen mit Prüfziffern:
     * </pre>
     *
     * <pre>
     * Tabelle TAB1
     * Stelle   Inhalt
     * 0        0
     * 1        4
     * 2        3
     * 3        2
     * 4        6
     *
     * Tabelle TAB2
     * Stelle   Inhalt
     * 0        7
     * 1        1
     * 2        5
     * 3        9
     * 4        8
     * ￼
     * </pre>
     * <p>
     * Testkontonummern: 0000000406, 0000051768, 0010701590, 0010720185</p>
     * <p>
     * Führt die Berechnung nach Methode A zu einem Prüfzifferfehler, ist die
     * Berechnung nach Methode B vorzunehmen.</p>
     *
     * @param number
     * @return
     */
    boolean methodA(int[] number) {
        int[] tab1 = {0, 4, 3, 2, 6};
        int[] tab2 = {7, 1, 5, 9, 8};
        int[] konto = new int[11];
        int numberI = 0;
        for (int i = 1; i < 11; i++) {
            konto[i] = number[numberI++];
        }

        int i = 4;
        while (konto[i] == 0) {
            i++;
        }
        int c2 = i % 2;
        int d2 = 0;
        int a5 = 0;

        while (i < 10) {
            switch (konto[i]) {
                case 0:
                    konto[i] = 5;
                    break;
                case 1:
                    konto[i] = 6;
                    break;
                case 5:
                    konto[i] = 10;
                    break;
                case 6:
                    konto[i] = 1;
                    break;
            }

            if (c2 == d2) {
                if (konto[i] > 5) {
                    if (c2 == 0 && d2 == 0) {
                        c2 = d2 = 1;
                        a5 = a5 + 6 - (konto[i] - 6);
                    } else {
                        c2 = d2 = 0;
                        a5 = a5 + konto[i];
                    }
                } else {
                    if (c2 == 0 && d2 == 0) {
                        c2 = 1;
                        a5 = a5 + konto[i];
                    } else {
                        c2 = 0;
                        a5 = a5 + konto[i];
                    }
                }
            } else {
                if (konto[i] > 5) {
                    if (c2 == 0) {
                        c2 = 1;
                        d2 = 0;
                        a5 = a5 - 6 + (konto[i] - 6);
                    } else {
                        c2 = 0;
                        d2 = 1;
                        a5 = a5 - konto[i];
                    }
                } else {
                    if (c2 == 0) {
                        c2 = 1;
                        a5 = a5 - konto[i];
                    } else {
                        c2 = 0;
                        a5 = a5 - konto[i];
                    }
                }
            }
            i++;
        }
        int p;
        while (a5 < 0 || a5 > 4) {
            if (a5 > 4) {
                a5 = a5 - 5;
            } else {
                a5 = a5 + 5;
            }
        }
        if (d2 == 0) {
            p = tab1[a5];
        } else {
            p = tab2[a5];
        }
        if (p == konto[10]) {
            return true;

        } else {
            if (konto[4] == 0) {
                if (p > 4) {
                    p = p - 5;
                } else {
                    p = p + 5;
                }
                if (p == konto[10]) {
                    return true;

                }
            }
        }

        return false;
    }

    /**
     * <p>
     * Methode B:</p>
     * <p>
     * Modulus 11, Gewichtung 2, 3, 4, 5, 6</p>
     * <p>
     * Die für die Berechnung relevanten Stellen werden von rechts nach links
     * mit den Ziffern 2, 3, 4, 5, 6 multipliziert. Die weitere Berechnung und
     * die möglichen Ergebnisse entsprechen dem Verfahren 33.</p>
     * <pre>
     * Stellennr.: 1 2 3 4 5 6 7 8 9 A (A=10)
     * Kontonr.:   x x x x x x x x x P
     * Gewichtung:         6 5 4 3 2
     * </pre>
     *
     * <p>
     * Führt die Berechnung nach Methode B wiederum zu einem Prüfzifferfehlen,
     * ist eine weitere Berechnung nach Methode C vorzunehmen.</p>
     *
     * @param number
     * @return
     */
    boolean methodB(int[] number) {
        weighting = new int[]{2, 3, 4, 5, 6};
        Method33 method33 = new Method33();
        method33.setAccountNumberArray(number);
        number = method33.factor(number, weighting, 5, 9);
        int pz = method33.add(number, 4, 9);
        pz = method33.modulus11(pz);
        return checkPz(pz, number);
    }

    /**
     * <p>
     * Methode C. </p>
     * <p>
     * Modulus 7, Gewichtung 2, 3, 4, 5, 6</p>
     * <p>
     * Die Stellen 5 bis 9 der Kontonummer werden von rechts nach links mit den
     * Gewichten multipliziert. Die jeweiligen Produkte werden addiert. Die
     * Summe ist durch 7 zu dividieren. Der verbleibende Rest wird vom Divisor
     * (7) subtrahiert. Das Ergebnis ist die Prüfziffer. Verbleibt nach der
     * Division kein Rest, ist die Prüfziffer = 0.</p>
     * <p>
     * Testkontonummern Methode B und C: 0000100005, 0000393814, 0000950360,
     * 3199500501</p>
     *
     * @param number
     * @return
     */
    boolean methodC(int[] number) {
        weighting = new int[]{2, 3, 4, 5, 6};
        number = factor(number, weighting, 5, 9);
        int pz = add(number, 4, 9);
        pz = modulus7(pz);
        return checkPz(pz, number);
    }

    @Override
    protected int add(int[] number, int start, int end) {
        log.debug(start + " to " + end);
        int pz = 0;
        for (int i = start--; i < end; i++) {

            int o = number[i];

            log.debug("+" + o);
            pz += o;
        }
        log.debug("after add: " + pz);
        return pz;
    }

}
