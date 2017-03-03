package de.detecmedia.checkaccountnumber;

import org.apache.log4j.Logger;

/**
 * Kennzeichen 97.
 * <p>
 * Modulus 11:</p>
 * <p>
 * Die Kontonummer (5, 6, 7, 8, 9 o. 10-stellig) ist durch linksbündige
 * Nullenauffüllung 10-stellig darzustellen. Danach ist die 10. Stelle die
 * Prüfziffer.</p>
 * <p>
 * Die Kontonummer ist unter Weglassung der Prüfziffer (= Wert X) durch 11 zu
 * teilen. Das Ergebnis der Division ist ohne die Nachkomma-Stellen mit 11 zu
 * multiplizieren. Das Produkt ist vom 'Wert X' zu subtrahieren.</p>
 * <p>
 * Ist das Ergebnis <code>&lt;</code> 10, so entspricht das Ergebnis der
 * Prüfziffer.</p>
 * <p>
 * Ist das Ergebnis = 10, so ist die Prüfziffe r = 0</p>
 * <pre>
 * Beispiel: 2 4 0 1 0 0 1 9 (8-stellige Kontonummer)
 * 1) 2401001:11=218272,81
 * 2) 218272x11=2400992
 * 3) 2401001-2400992=9
 * </pre>
 *
 * @author Markus Potthast
 * @version 0.0.2
 */
public class Method97
        extends AbstractMethod {
    private final Logger log = Logger.getLogger(Method97.class);
    @Override
    public boolean test() {
        int[] number = expand(this.getAccountNumberArray());
        int[] move = move(number, 1);
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < move.length; i++) {
            int n = move[i];
            str.append(n);
        }
        long accountNumber = Long.parseLong(str.toString());
        log.debug("accountNumber: "+accountNumber);
        long tmp = accountNumber  / 11;
        tmp *= 11;
        int pz = (int) (accountNumber-tmp);
        if(pz == 10) {
            pz = 0;
        }
        log.debug("PZ: "+pz);
        return checkPz(pz, number);
    }

}
