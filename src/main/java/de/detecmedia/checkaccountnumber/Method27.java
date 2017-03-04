package de.detecmedia.checkaccountnumber;

import org.apache.log4j.Logger;

/**
 * Kennzeichen 27.
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 1, 2 (modifiziert)</p><p>
 * Die Berechnung erfolgt wie bei Verfahren 00, jedoch nur für die Kontonummern
 * von 1 bis 999 999 999. Ab Konto 1 000 000 000 kommt das Prüfziffernverfahren
 * M10H (iterierte Transformation) zum Einsatz.</p><p>
 * Es folgt die Beschreibung der iterierten Transformation:</p><p>
 * Die Position der einzelnen Ziffern von rechts nach links innerhalb der
 * Kontonummer gibt die Zeile1 bis 4 der Transformationstabelle noch an. Aus ihr
 * sind die Übersetzungswerte zu summieren. Die Einerstelle wird von 10
 * subtrahiert. Die Differenz stellt die Prüfziffer dar.</p><p>
 * Beispiel:</p>
 * <pre>
 * Kontonummer
 * 2 8 4 7 1 6 9 4 8 P       (P = Prüfziffer)
 * 1 4 3 2 1 4 3 2 1         (Transf.-Zeile)
 *
 *
 * Transformationstabelle:
 * Ziffer:    0 1 2 3 4 5 6 7 8 9
 * Zeile 1:   0 1 5 9 3 7 4 8 2 6
 * Zeile 2:   0 1 7 6 9 8 3 2 5 4
 * Zeile 3:   0 1 8 4 6 2 9 5 7 3
 * Zeile 4:   0 1 2 3 4 5 6 7 8 9
 *
 * ￼
 * Von rechts nach links:
 * Ziffer 8 wird 2 aus Transformationszeile 1
 * Ziffer 4 wird 9 aus Zeile 2
 * Ziffer 9 wird 3 aus Zeile 3
 * Ziffer 6 wird 6 aus Zeile 4
 * Ziffer 1 wird 1 aus Zeile 1
 * Ziffer 7 wird 2 aus Zeile 2
 * Ziffer 4 wird 6 aus Zeile 3
 * Ziffer 8 wird 8 aus Zeile 4
 * Ziffer 2 wird 5 aus Zeile 1
 *              --
 * Summe        42
 *             ===
 * </pre><p>
 * Die Einerstelle wird vom Wert 10 subtrahiert. Das Ergebnis ist die
 * Prüfziffer, in unserem Beispiel also 10 – 2 = Prüfziffer 8, die Kontonummer
 * lautet somit 2847169488.</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method27 extends Method00 {

    public Logger log = Logger.getLogger(Method27.class);

    @Override
    public boolean test() throws NumberFormatException {
        if (this.getLong() < 1000000000L) {
            return super.test();
        }

        int[] number = this.getAccountNumberArray();

        int[][] transformation = new int[4][];
        transformation[0] = new int[]{0, 1, 5, 9, 3, 7, 4, 8, 2, 6};
        transformation[1] = new int[]{0, 1, 7, 6, 9, 8, 3, 2, 5, 4};
        transformation[2] = new int[]{0, 1, 8, 4, 6, 2, 9, 5, 7, 3};
        transformation[3] = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        int pz = 0;
        int transI = 0;
        for (int i = number.length - 2; i > -1; i--) {
            pz += transformation[transI++][number[i]];
            if (transI == 4) {
                transI = 0;
            }
        }
        log.debug(pz);
        pz = 10 - pz % 10;
        return checkPz(pz, number);
    }

}
