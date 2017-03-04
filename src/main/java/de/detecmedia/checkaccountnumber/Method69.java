package de.detecmedia.checkaccountnumber;

import de.detecmedia.checkaccountnumber.*;

/**
 * Kennzeichen 69. TODO: do later
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8</p>
 * <p>
 * Für den Kontonummernkreis 9 300 000 000 bis 9 399 999 999 ist keine
 * Prüfzifferberechnung möglich = Kennzeichen 09.</p>
 * <p>
 * Für den Kontonummernkreis 9 700 000 000 bis 9 799 999 999 ist die
 * Prüfzifferberechnung nach Variante 2 vorzunehmen:</p>
 * <p>
 * Für alle anderen Kontonummern ist die Prüfziffer nach Variante 1 zu
 * ermitteln. Ergab die Berechnung nach Variante 1 einen Prüfzifferfehler, ist
 * die Prüfziffer nach Variante2 zu ermitteln.</p>
 * <p>
 * <b>Variante 1</b></p>
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8 Die Berechnung erfolgt wie bei
 * Verfahren 28.</p>
 * <p>
 * <b>Variante 2</b></p>
 * <p>
 * Die Position der einzelnen Ziffern von rechts nach links innerhalb der
 * Kontonummer gibt die Zeile1 bis 4 der Transforma- tionstabelle an. Aus ihr
 * sind die Übersetzungswerte zu sum- mieren. Die Einerstelle wird von 10
 * subtrahiert und stellt die Prüfziffer dar.</p>
 * <p>
 * Beispiel:</p>
 * <pre>
 * Kontonr.:   9 7 2 1 1 3 4 8 6 P
 * Gewichtung: 1 4 3 2 1 4 3 2 1
 * (P = Prüfziffer)
 * (Transf.-Zeile)
 * </pre>
 * <p>
 * Transformationstabelle:</p>
 * <pre>
 * Ziffer:   0 1 2 3 4 5 6 7 8 9
 * Zeile 1:  0 1 5 9 3 7 4 8 2 6
 * Zeile 2:  0 1 7 6 9 8 3 2 5 4
 * Zeile 3:  0 1 8 4 6 2 9 5 7 3
 * Zeile 4:  0 1 2 3 4 5 6 7 8 9
 * </pre>
 * <p>
 * Von rechts nach links:
 * </p>
 * <pre>
 * Ziffer 6 wird 4 aus Transformationszeile 1
 * Ziffer 8 wird 5 aus Zeile 2
 * Ziffer 4 wird 6 aus Zeile 3
 * Ziffer 3 wird 3 aus Zeile 4
 * Ziffer 1 wird 1 aus Zeile 1
 * Ziffer 1 wird 1 aus Zeile 2
 * Ziffer 2 wird 8 aus Zeile 3
 * Ziffer 7 wird 7 aus Zeile 4
 * Ziffer 9 wird 6 aus Zeile 1
 * __ Summe 41 ==
 * </pre>
 * <p>
 * Die Einerstelle wird vom Wert 10 subtrahiert. Das Ergebnis ist die
 * Prüfziffer, in unserem Beispiel also 10 - 1 = Prüfziffer 9, die Kontonummer
 * lautet: 9 7 2 1 1 3 4 8 6 9.</p>
 * <p>
 * Testkontonummern:<br>
 * 1234567900 (Variante 1)<br>
 * 1234567006 (Variante 2)</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method69
        extends AbstractMethod {

    @Override
    public boolean test() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
