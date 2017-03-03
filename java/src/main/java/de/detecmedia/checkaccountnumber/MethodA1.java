package de.detecmedia.checkaccountnumber;

import org.apache.log4j.Logger;

/**
 * Kennzeichen A1.
 * <p>
 * <b>geändert zum 09.06.2003</b></p>
 * <p>
 * Modulus 10, Gewichtung 2, 1, 2, 1, 2, 1, 2, 0, 0</p>
 * <p>
 * Die Kontonummern sind 8- oder 10-stellig. Kontonummern (ohne führende Nullen
 * gezählt) mit 9 oder weniger als 8 Stellen sind falsch. 8-stellige
 * Kontonummern sind für die Prüfzifferberechnung durch linksbündige
 * Auffüllung mit Nullen 10-stellig darzustellen. Die Berechnung erfolgt wie
 * beim Verfahren 00.</p>
 * <pre>
 * Beispiel:
 * Kontonr.:   0  0  1  0  0  3  0  9  9  7
 * Gewichtung: 0  0  2  1  2  1  2  1  2  P
 *            -----------------------------
 * Produkte:   0  0  2  0  0  3  0  9 18
 *            --------------------------
 * Quersummen: 0+ 0+ 2+ 0+ 0+ 3+ 0+ 9+ 9= 23
 *
 * 10-3 = 7
 * P = 7
 * </pre>
 * <p>
 * Testkontonummern (richtig): 0010030005, 0010030997, 1010030054<br>
 * Testkontonummern (falsch): 0110030005, 0010030998, 0000030005</p>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class MethodA1
        extends Method00 {

    private final Logger log = Logger.getLogger(MethodA1.class);

    @Override
    public boolean test() {
        log.debug("length: " + getLong() + "".length());
        if (String.valueOf(getLong()).length() < 8) {
            return false;
        }
        if (String.valueOf(getLong()).length() == 9) {
            return false;
        }
        weighting = new int[]{2, 1, 2, 1, 2, 1, 2, 0, 0};
        Method00 method00 = new Method00();
        method00.setAccountNumberArray(this.getAccountNumberArray());
        return method00.check(weighting);
    }

}
