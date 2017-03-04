package de.detecmedia.checkaccountnumber;

import org.apache.log4j.Logger;

/**
 * Kennzeichen 29.
 * <p>
 * Modulus 10, iterierte Transformation</p><p>
 * Die einzelnen Ziffern der Kontonummer werden über eine Tabelle in andere
 * Werte transformiert. Jeder einzelnen Stelle der Kontonummer ist hierzu eine
 * der Zeilen 1 bis 4 der Transformationstabelle fest zugeordnet. Die
 * Transformationswerte werden addiert. Die Einerstelle der Summe wird von 10
 * subtrahiert. Das Ergebnis ist die Prüfziffer. (Ist das Ergebnis = 10, ist
 * die Prüfziffer = 0).</p><p>
 * Beispiel:</p>
 * <pre>
 * Kontonummer: 314586302P(P=Prüfziffer)</pre>
 * <p>
 * Die Kontonummer ist 10-stellig. Die 10.Stelle ist die Prüfziffer.</p>
 * ￼
 * <p>
 * Zugeordnete Zeile der </p>
 * <pre>
 * Transformationstabelle: 1 4 3 2 1 4 3 2 1
 *
 * Transformationstabelle:
 * Ziffer:     0 1 2 3 4 5 6 7 8 9
 * Zeile 1:    0 1 5 9 3 7 4 8 2 6
 * Zeile 2:    0 1 7 6 9 8 3 2 5 4
 * Zeile 3:    0 1 8 4 6 2 9 5 7 3
 * Zeile 4:    0 1 2 3 4 5 6 7 8 9
 *
 * Transformation von rechts nach
 * ￼
 * links:   Ziffer  2 wird 5
 *          "       0 wird 0
 *          "       3 wird 4
 *          "       6 wird 6
 *          "       8 wird 2
 *          "       5 wird 8
 *          "       4 wird 6
 *          "       1 wird 1
 *          "       3 wird 9
 * (T abelle: ("
 * ("
 * ("
 * (" (" (" (" ("
 * Zeile 1)
 * " 2)
 * " 3)
 * " 4)
 * " 1)
 * " 2)
 * " 3)
 * " 4)
 * " 1)
 * Summe:
 * Subtraktion : (10 - 1)
 * ___
 * 41 (Einerstelle = 1)
 * = 9 (= Prüfziffer) Kontonummer mit Prüfziffer: 3 1 4 5 8 6 3 0 2 9
 * </pre>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method29 extends AbstractMethod {

    private static Logger log = Logger.getLogger(Method29.class);

    @Override
    public boolean test() {
        int[][] transformation = new int[4][];
        transformation[0] = new int[]{0, 1, 5, 9, 3, 7, 4, 8, 2, 6};
        transformation[1] = new int[]{0, 1, 7, 6, 9, 8, 3, 2, 5, 4};
        transformation[2] = new int[]{0, 1, 8, 4, 6, 2, 9, 5, 7, 3};
        transformation[3] = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] number = this.getAccountNumberArray();
        int transI = 0;
        int pz = 0;
        for (int i = number.length - 2; i > -1; i--) {
            log.debug("ziffer " + number[i] + " wird zu " + transformation[transI][number[i]]);
            pz += transformation[transI++][number[i]];
            if (transI == 4) {
                transI = 0;
            }
        }
        log.debug("summe pz:" + pz);
        pz = 10 - (pz % 10);
        if (pz == 10) {
            pz = 0;
        }
        return checkPz(pz, number);
    }

}
